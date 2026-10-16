package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f135260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f135261d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Callable f135262f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Callable f135264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Collection f135266d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f135267f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f135268g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f135269h;

        PublisherBufferExactSubscriber(Subscriber subscriber, int i3, Callable callable) {
            this.f135263a = subscriber;
            this.f135265c = i3;
            this.f135264b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135267f.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135267f, subscription)) {
                this.f135267f = subscription;
                this.f135263a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135268g) {
                return;
            }
            Collection collection = this.f135266d;
            if (collection == null) {
                try {
                    collection = (Collection) ObjectHelper.d(this.f135264b.call(), "The bufferSupplier returned a null buffer");
                    this.f135266d = collection;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            collection.add(obj);
            int i3 = this.f135269h + 1;
            if (i3 != this.f135265c) {
                this.f135269h = i3;
                return;
            }
            this.f135269h = 0;
            this.f135266d = null;
            this.f135263a.h(collection);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135268g) {
                return;
            }
            this.f135268g = true;
            Collection collection = this.f135266d;
            if (collection != null && !collection.isEmpty()) {
                this.f135263a.h(collection);
            }
            this.f135263a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135268g) {
                RxJavaPlugins.s(th);
            } else {
                this.f135268g = true;
                this.f135263a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                this.f135267f.y(BackpressureHelper.d(j3, this.f135265c));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, Subscription, BooleanSupplier {
        private static final long serialVersionUID = -7370244972039324525L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Callable f135271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135273d;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Subscription f135276h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f135277i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f135278j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f135279k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f135280l;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicBoolean f135275g = new AtomicBoolean();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ArrayDeque f135274f = new ArrayDeque();

        PublisherBufferOverlappingSubscriber(Subscriber subscriber, int i3, int i4, Callable callable) {
            this.f135270a = subscriber;
            this.f135272c = i3;
            this.f135273d = i4;
            this.f135271b = callable;
        }

        @Override // io.reactivex.functions.BooleanSupplier
        public boolean a() {
            return this.f135279k;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135279k = true;
            this.f135276h.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135276h, subscription)) {
                this.f135276h = subscription;
                this.f135270a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135277i) {
                return;
            }
            ArrayDeque arrayDeque = this.f135274f;
            int i3 = this.f135278j;
            int i4 = i3 + 1;
            if (i3 == 0) {
                try {
                    arrayDeque.offer((Collection) ObjectHelper.d(this.f135271b.call(), "The bufferSupplier returned a null buffer"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            Collection collection = (Collection) arrayDeque.peek();
            if (collection != null && collection.size() + 1 == this.f135272c) {
                arrayDeque.poll();
                collection.add(obj);
                this.f135280l++;
                this.f135270a.h(collection);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((Collection) it.next()).add(obj);
            }
            if (i4 == this.f135273d) {
                i4 = 0;
            }
            this.f135278j = i4;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135277i) {
                return;
            }
            this.f135277i = true;
            long j3 = this.f135280l;
            if (j3 != 0) {
                BackpressureHelper.e(this, j3);
            }
            QueueDrainHelper.g(this.f135270a, this.f135274f, this, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135277i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135277i = true;
            this.f135274f.clear();
            this.f135270a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (!SubscriptionHelper.h(j3) || QueueDrainHelper.i(j3, this.f135270a, this.f135274f, this, this)) {
                return;
            }
            if (this.f135275g.get() || !this.f135275g.compareAndSet(false, true)) {
                this.f135276h.y(BackpressureHelper.d(this.f135273d, j3));
            } else {
                this.f135276h.y(BackpressureHelper.c(this.f135272c, BackpressureHelper.d(this.f135273d, j3 - 1)));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Callable f135282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135284d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Collection f135285f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Subscription f135286g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f135287h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f135288i;

        PublisherBufferSkipSubscriber(Subscriber subscriber, int i3, int i4, Callable callable) {
            this.f135281a = subscriber;
            this.f135283c = i3;
            this.f135284d = i4;
            this.f135282b = callable;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135286g.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135286g, subscription)) {
                this.f135286g = subscription;
                this.f135281a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135287h) {
                return;
            }
            Collection collection = this.f135285f;
            int i3 = this.f135288i;
            int i4 = i3 + 1;
            if (i3 == 0) {
                try {
                    collection = (Collection) ObjectHelper.d(this.f135282b.call(), "The bufferSupplier returned a null buffer");
                    this.f135285f = collection;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                    return;
                }
            }
            if (collection != null) {
                collection.add(obj);
                if (collection.size() == this.f135283c) {
                    this.f135285f = null;
                    this.f135281a.h(collection);
                }
            }
            if (i4 == this.f135284d) {
                i4 = 0;
            }
            this.f135288i = i4;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135287h) {
                return;
            }
            this.f135287h = true;
            Collection collection = this.f135285f;
            this.f135285f = null;
            if (collection != null) {
                this.f135281a.h(collection);
            }
            this.f135281a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135287h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135287h = true;
            this.f135285f = null;
            this.f135281a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                if (get() != 0 || !compareAndSet(0, 1)) {
                    this.f135286g.y(BackpressureHelper.d(this.f135284d, j3));
                    return;
                }
                this.f135286g.y(BackpressureHelper.c(BackpressureHelper.d(j3, this.f135283c), BackpressureHelper.d(this.f135284d - this.f135283c, j3 - 1)));
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        int i3 = this.f135260c;
        int i4 = this.f135261d;
        if (i3 == i4) {
            this.f135196b.w(new PublisherBufferExactSubscriber(subscriber, i3, this.f135262f));
        } else if (i4 > i3) {
            this.f135196b.w(new PublisherBufferSkipSubscriber(subscriber, this.f135260c, this.f135261d, this.f135262f));
        } else {
            this.f135196b.w(new PublisherBufferOverlappingSubscriber(subscriber, this.f135260c, this.f135261d, this.f135262f));
        }
    }
}
