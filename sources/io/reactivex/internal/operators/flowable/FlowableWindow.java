package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f136549d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f136550f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -2365647875069161133L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicBoolean f136553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f136554d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f136555f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Subscription f136556g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        UnicastProcessor f136557h;

        WindowExactSubscriber(Subscriber subscriber, long j3, int i3) {
            super(1);
            this.f136551a = subscriber;
            this.f136552b = j3;
            this.f136553c = new AtomicBoolean();
            this.f136554d = i3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136553c.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136556g, subscription)) {
                this.f136556g = subscription;
                this.f136551a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            long j3 = this.f136555f;
            UnicastProcessor unicastProcessorE = this.f136557h;
            if (j3 == 0) {
                getAndIncrement();
                unicastProcessorE = UnicastProcessor.E(this.f136554d, this);
                this.f136557h = unicastProcessorE;
                this.f136551a.h(unicastProcessorE);
            }
            long j4 = j3 + 1;
            unicastProcessorE.h(obj);
            if (j4 != this.f136552b) {
                this.f136555f = j4;
                return;
            }
            this.f136555f = 0L;
            this.f136557h = null;
            unicastProcessorE.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor unicastProcessor = this.f136557h;
            if (unicastProcessor != null) {
                this.f136557h = null;
                unicastProcessor.onComplete();
            }
            this.f136551a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor unicastProcessor = this.f136557h;
            if (unicastProcessor != null) {
                this.f136557h = null;
                unicastProcessor.onError(th);
            }
            this.f136551a.onError(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f136556g.cancel();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                this.f136556g.y(BackpressureHelper.d(this.f136552b, j3));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 2428527070996323976L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SpscLinkedArrayQueue f136559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f136560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f136561d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ArrayDeque f136562f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicBoolean f136563g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicBoolean f136564h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicLong f136565i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicInteger f136566j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final int f136567k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f136568l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f136569m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Subscription f136570n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        volatile boolean f136571o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Throwable f136572p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        volatile boolean f136573q;

        WindowOverlapSubscriber(Subscriber subscriber, long j3, long j4, int i3) {
            super(1);
            this.f136558a = subscriber;
            this.f136560c = j3;
            this.f136561d = j4;
            this.f136559b = new SpscLinkedArrayQueue(i3);
            this.f136562f = new ArrayDeque();
            this.f136563g = new AtomicBoolean();
            this.f136564h = new AtomicBoolean();
            this.f136565i = new AtomicLong();
            this.f136566j = new AtomicInteger();
            this.f136567k = i3;
        }

        boolean a(boolean z2, boolean z3, Subscriber subscriber, SpscLinkedArrayQueue spscLinkedArrayQueue) {
            if (this.f136573q) {
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            Throwable th = this.f136572p;
            if (th != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th);
                return true;
            }
            if (!z3) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        void b() {
            if (this.f136566j.getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f136558a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f136559b;
            int iAddAndGet = 1;
            do {
                long j3 = this.f136565i.get();
                long j4 = 0;
                while (j4 != j3) {
                    boolean z2 = this.f136571o;
                    UnicastProcessor unicastProcessor = (UnicastProcessor) spscLinkedArrayQueue.poll();
                    boolean z3 = unicastProcessor == null;
                    if (a(z2, z3, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.h(unicastProcessor);
                    j4++;
                }
                if (j4 == j3 && a(this.f136571o, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j4 != 0 && j3 != Long.MAX_VALUE) {
                    this.f136565i.addAndGet(-j4);
                }
                iAddAndGet = this.f136566j.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136573q = true;
            if (this.f136563g.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136570n, subscription)) {
                this.f136570n = subscription;
                this.f136558a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136571o) {
                return;
            }
            long j3 = this.f136568l;
            if (j3 == 0 && !this.f136573q) {
                getAndIncrement();
                UnicastProcessor unicastProcessorE = UnicastProcessor.E(this.f136567k, this);
                this.f136562f.offer(unicastProcessorE);
                this.f136559b.offer(unicastProcessorE);
                b();
            }
            long j4 = j3 + 1;
            Iterator it = this.f136562f.iterator();
            while (it.hasNext()) {
                ((Processor) it.next()).h(obj);
            }
            long j5 = this.f136569m + 1;
            if (j5 == this.f136560c) {
                this.f136569m = j5 - this.f136561d;
                Processor processor = (Processor) this.f136562f.poll();
                if (processor != null) {
                    processor.onComplete();
                }
            } else {
                this.f136569m = j5;
            }
            if (j4 == this.f136561d) {
                this.f136568l = 0L;
            } else {
                this.f136568l = j4;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136571o) {
                return;
            }
            Iterator it = this.f136562f.iterator();
            while (it.hasNext()) {
                ((Processor) it.next()).onComplete();
            }
            this.f136562f.clear();
            this.f136571o = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136571o) {
                RxJavaPlugins.s(th);
                return;
            }
            Iterator it = this.f136562f.iterator();
            while (it.hasNext()) {
                ((Processor) it.next()).onError(th);
            }
            this.f136562f.clear();
            this.f136572p = th;
            this.f136571o = true;
            b();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f136570n.cancel();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136565i, j3);
                if (this.f136564h.get() || !this.f136564h.compareAndSet(false, true)) {
                    this.f136570n.y(BackpressureHelper.d(this.f136561d, j3));
                } else {
                    this.f136570n.y(BackpressureHelper.c(this.f136560c, BackpressureHelper.d(this.f136561d, j3 - 1)));
                }
                b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8792836352386833856L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f136576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f136577d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicBoolean f136578f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f136579g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f136580h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Subscription f136581i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        UnicastProcessor f136582j;

        WindowSkipSubscriber(Subscriber subscriber, long j3, long j4, int i3) {
            super(1);
            this.f136574a = subscriber;
            this.f136575b = j3;
            this.f136576c = j4;
            this.f136577d = new AtomicBoolean();
            this.f136578f = new AtomicBoolean();
            this.f136579g = i3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136577d.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136581i, subscription)) {
                this.f136581i = subscription;
                this.f136574a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            long j3 = this.f136580h;
            UnicastProcessor unicastProcessorE = this.f136582j;
            if (j3 == 0) {
                getAndIncrement();
                unicastProcessorE = UnicastProcessor.E(this.f136579g, this);
                this.f136582j = unicastProcessorE;
                this.f136574a.h(unicastProcessorE);
            }
            long j4 = j3 + 1;
            if (unicastProcessorE != null) {
                unicastProcessorE.h(obj);
            }
            if (j4 == this.f136575b) {
                this.f136582j = null;
                unicastProcessorE.onComplete();
            }
            if (j4 == this.f136576c) {
                this.f136580h = 0L;
            } else {
                this.f136580h = j4;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            UnicastProcessor unicastProcessor = this.f136582j;
            if (unicastProcessor != null) {
                this.f136582j = null;
                unicastProcessor.onComplete();
            }
            this.f136574a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            UnicastProcessor unicastProcessor = this.f136582j;
            if (unicastProcessor != null) {
                this.f136582j = null;
                unicastProcessor.onError(th);
            }
            this.f136574a.onError(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.f136581i.cancel();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                if (this.f136578f.get() || !this.f136578f.compareAndSet(false, true)) {
                    this.f136581i.y(BackpressureHelper.d(this.f136576c, j3));
                } else {
                    this.f136581i.y(BackpressureHelper.c(BackpressureHelper.d(this.f136575b, j3), BackpressureHelper.d(this.f136576c - this.f136575b, j3 - 1)));
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        long j3 = this.f136549d;
        long j4 = this.f136548c;
        if (j3 == j4) {
            this.f135196b.w(new WindowExactSubscriber(subscriber, this.f136548c, this.f136550f));
        } else if (j3 > j4) {
            this.f135196b.w(new WindowSkipSubscriber(subscriber, this.f136548c, this.f136549d, this.f136550f));
        } else {
            this.f135196b.w(new WindowOverlapSubscriber(subscriber, this.f136548c, this.f136549d, this.f136550f));
        }
    }
}
