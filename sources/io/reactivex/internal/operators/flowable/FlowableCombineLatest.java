package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableCombineLatest<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher[] f135393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Iterable f135394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f135395d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f135396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f135397g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f135399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CombineLatestInnerSubscriber[] f135400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SpscLinkedArrayQueue f135401d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Object[] f135402f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f135403g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f135404h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f135405i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f135406j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f135407k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final AtomicLong f135408l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        volatile boolean f135409m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final AtomicReference f135410n;

        CombineLatestCoordinator(Subscriber subscriber, Function function, int i3, int i4, boolean z2) {
            this.f135398a = subscriber;
            this.f135399b = function;
            CombineLatestInnerSubscriber[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                combineLatestInnerSubscriberArr[i5] = new CombineLatestInnerSubscriber(this, i5, i4);
            }
            this.f135400c = combineLatestInnerSubscriberArr;
            this.f135402f = new Object[i3];
            this.f135401d = new SpscLinkedArrayQueue(i4);
            this.f135408l = new AtomicLong();
            this.f135410n = new AtomicReference();
            this.f135403g = z2;
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.f135404h) {
                m();
            } else {
                k();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135407k = true;
            e();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f135401d.clear();
        }

        void e() {
            for (CombineLatestInnerSubscriber combineLatestInnerSubscriber : this.f135400c) {
                combineLatestInnerSubscriber.a();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f135401d.isEmpty();
        }

        boolean j(boolean z2, boolean z3, Subscriber subscriber, SpscLinkedArrayQueue spscLinkedArrayQueue) {
            if (this.f135407k) {
                e();
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.f135403g) {
                if (!z3) {
                    return false;
                }
                e();
                Throwable thB = ExceptionHelper.b(this.f135410n);
                if (thB == null || thB == ExceptionHelper.f139204a) {
                    subscriber.onComplete();
                } else {
                    subscriber.onError(thB);
                }
                return true;
            }
            Throwable thB2 = ExceptionHelper.b(this.f135410n);
            if (thB2 != null && thB2 != ExceptionHelper.f139204a) {
                e();
                spscLinkedArrayQueue.clear();
                subscriber.onError(thB2);
                return true;
            }
            if (!z3) {
                return false;
            }
            e();
            subscriber.onComplete();
            return true;
        }

        void k() {
            Subscriber subscriber = this.f135398a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135401d;
            int iAddAndGet = 1;
            do {
                long j3 = this.f135408l.get();
                long j4 = 0;
                while (j4 != j3) {
                    boolean z2 = this.f135409m;
                    Object objPoll = spscLinkedArrayQueue.poll();
                    boolean z3 = objPoll == null;
                    if (j(z2, z3, subscriber, spscLinkedArrayQueue)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    try {
                        subscriber.h(ObjectHelper.d(this.f135399b.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                        ((CombineLatestInnerSubscriber) objPoll).b();
                        j4++;
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        e();
                        ExceptionHelper.a(this.f135410n, th);
                        subscriber.onError(ExceptionHelper.b(this.f135410n));
                        return;
                    }
                }
                if (j4 == j3 && j(this.f135409m, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (j4 != 0 && j3 != Long.MAX_VALUE) {
                    this.f135408l.addAndGet(-j4);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 4) != 0) {
                return 0;
            }
            int i4 = i3 & 2;
            this.f135404h = i4 != 0;
            return i4;
        }

        void m() {
            Subscriber subscriber = this.f135398a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135401d;
            int iAddAndGet = 1;
            while (!this.f135407k) {
                Throwable th = (Throwable) this.f135410n.get();
                if (th != null) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(th);
                    return;
                }
                boolean z2 = this.f135409m;
                boolean zIsEmpty = spscLinkedArrayQueue.isEmpty();
                if (!zIsEmpty) {
                    subscriber.h(null);
                }
                if (z2 && zIsEmpty) {
                    subscriber.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void p(int i3) {
            int i4;
            synchronized (this) {
                try {
                    Object[] objArr = this.f135402f;
                    if (objArr[i3] != null && (i4 = this.f135406j + 1) != objArr.length) {
                        this.f135406j = i4;
                    } else {
                        this.f135409m = true;
                        c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f135401d.poll();
            if (objPoll == null) {
                return null;
            }
            Object objD = ObjectHelper.d(this.f135399b.apply((Object[]) this.f135401d.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) objPoll).b();
            return objD;
        }

        void q(int i3, Throwable th) {
            if (!ExceptionHelper.a(this.f135410n, th)) {
                RxJavaPlugins.s(th);
            } else {
                if (this.f135403g) {
                    p(i3);
                    return;
                }
                e();
                this.f135409m = true;
                c();
            }
        }

        void r(int i3, Object obj) {
            boolean z2;
            synchronized (this) {
                try {
                    Object[] objArr = this.f135402f;
                    int i4 = this.f135405i;
                    if (objArr[i3] == null) {
                        i4++;
                        this.f135405i = i4;
                    }
                    objArr[i3] = obj;
                    if (objArr.length == i4) {
                        this.f135401d.p(this.f135400c[i3], objArr.clone());
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z2) {
                this.f135400c[i3].b();
            } else {
                c();
            }
        }

        void s(Publisher[] publisherArr, int i3) {
            CombineLatestInnerSubscriber[] combineLatestInnerSubscriberArr = this.f135400c;
            for (int i4 = 0; i4 < i3 && !this.f135409m && !this.f135407k; i4++) {
                publisherArr[i4].i(combineLatestInnerSubscriberArr[i4]);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135408l, j3);
                c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -8730235182291002949L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CombineLatestCoordinator f135411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f135412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135414d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f135415f;

        CombineLatestInnerSubscriber(CombineLatestCoordinator combineLatestCoordinator, int i3, int i4) {
            this.f135411a = combineLatestCoordinator;
            this.f135412b = i3;
            this.f135413c = i4;
            this.f135414d = i4 - (i4 >> 2);
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        public void b() {
            int i3 = this.f135415f + 1;
            if (i3 != this.f135414d) {
                this.f135415f = i3;
            } else {
                this.f135415f = 0;
                get().y(i3);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, this.f135413c);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135411a.r(this.f135412b, obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135411a.p(this.f135412b);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135411a.q(this.f135412b, th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return FlowableCombineLatest.this.f135395d.apply(new Object[]{obj});
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        int length;
        Publisher[] publisherArr = this.f135393b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                Iterator it = (Iterator) ObjectHelper.d(this.f135394c.iterator(), "The iterator returned is null");
                length = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.d(it.next(), "The publisher returned by the iterator is null");
                            if (length == publisherArr.length) {
                                Publisher[] publisherArr2 = new Publisher[(length >> 2) + length];
                                System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                                publisherArr = publisherArr2;
                            }
                            publisherArr[length] = publisher;
                            length++;
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            EmptySubscription.b(th, subscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        EmptySubscription.b(th2, subscriber);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                EmptySubscription.b(th3, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        int i3 = length;
        if (i3 == 0) {
            EmptySubscription.a(subscriber);
        } else {
            if (i3 == 1) {
                publisherArr[0].i(new FlowableMap.MapSubscriber(subscriber, new SingletonArrayFunc()));
                return;
            }
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.f135395d, i3, this.f135396f, this.f135397g);
            subscriber.g(combineLatestCoordinator);
            combineLatestCoordinator.s(publisherArr, i3);
        }
    }
}
