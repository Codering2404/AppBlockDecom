package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelFromPublisher<T> extends ParallelFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f138604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f138605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f138606c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelDispatcher<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4470634016609963609L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber[] f138607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicLongArray f138608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long[] f138609c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f138610d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f138611f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Subscription f138612g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        SimpleQueue f138613h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Throwable f138614i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f138615j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f138616k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f138617l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final AtomicInteger f138618m = new AtomicInteger();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f138619n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f138620o;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class RailSubscription implements Subscription {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final int f138621a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final int f138622b;

            RailSubscription(int i3, int i4) {
                this.f138621a = i3;
                this.f138622b = i4;
            }

            @Override // org.reactivestreams.Subscription
            public void cancel() {
                if (ParallelDispatcher.this.f138608b.compareAndSet(this.f138621a + this.f138622b, 0L, 1L)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i3 = this.f138622b;
                    parallelDispatcher.a(i3 + i3);
                }
            }

            @Override // org.reactivestreams.Subscription
            public void y(long j3) {
                long j4;
                if (SubscriptionHelper.h(j3)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.f138608b;
                    do {
                        j4 = atomicLongArray.get(this.f138621a);
                        if (j4 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f138621a, j4, BackpressureHelper.c(j4, j3)));
                    if (ParallelDispatcher.this.f138618m.get() == this.f138622b) {
                        ParallelDispatcher.this.b();
                    }
                }
            }
        }

        ParallelDispatcher(Subscriber[] subscriberArr, int i3) {
            this.f138607a = subscriberArr;
            this.f138610d = i3;
            this.f138611f = i3 - (i3 >> 2);
            int length = subscriberArr.length;
            int i4 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i4 + 1);
            this.f138608b = atomicLongArray;
            atomicLongArray.lazySet(i4, length);
            this.f138609c = new long[length];
        }

        void a(int i3) {
            if (this.f138608b.decrementAndGet(i3) == 0) {
                this.f138617l = true;
                this.f138612g.cancel();
                if (getAndIncrement() == 0) {
                    this.f138613h.clear();
                }
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.f138620o == 1) {
                d();
            } else {
                c();
            }
        }

        void c() {
            Throwable th;
            SimpleQueue simpleQueue = this.f138613h;
            Subscriber[] subscriberArr = this.f138607a;
            AtomicLongArray atomicLongArray = this.f138608b;
            long[] jArr = this.f138609c;
            int length = jArr.length;
            int i3 = this.f138616k;
            int i4 = this.f138619n;
            int iAddAndGet = 1;
            while (true) {
                int i5 = 0;
                int i6 = 0;
                while (!this.f138617l) {
                    boolean z2 = this.f138615j;
                    if (z2 && (th = this.f138614i) != null) {
                        simpleQueue.clear();
                        int length2 = subscriberArr.length;
                        while (i5 < length2) {
                            subscriberArr[i5].onError(th);
                            i5++;
                        }
                        return;
                    }
                    boolean zIsEmpty = simpleQueue.isEmpty();
                    if (z2 && zIsEmpty) {
                        int length3 = subscriberArr.length;
                        while (i5 < length3) {
                            subscriberArr[i5].onComplete();
                            i5++;
                        }
                        return;
                    }
                    if (!zIsEmpty) {
                        long j3 = atomicLongArray.get(i3);
                        long j4 = jArr[i3];
                        if (j3 == j4 || atomicLongArray.get(length + i3) != 0) {
                            i6++;
                        } else {
                            try {
                                Object objPoll = simpleQueue.poll();
                                if (objPoll != null) {
                                    subscriberArr[i3].h(objPoll);
                                    jArr[i3] = j4 + 1;
                                    i4++;
                                    if (i4 == this.f138611f) {
                                        this.f138612g.y(i4);
                                        i4 = 0;
                                    }
                                    i6 = 0;
                                }
                            } catch (Throwable th2) {
                                Exceptions.b(th2);
                                this.f138612g.cancel();
                                int length4 = subscriberArr.length;
                                while (i5 < length4) {
                                    subscriberArr[i5].onError(th2);
                                    i5++;
                                }
                                return;
                            }
                        }
                        i3++;
                        if (i3 == length) {
                            i3 = 0;
                        }
                        if (i6 == length) {
                        }
                    }
                    int i7 = get();
                    if (i7 == iAddAndGet) {
                        this.f138616k = i3;
                        this.f138619n = i4;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i7;
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        void d() {
            SimpleQueue simpleQueue = this.f138613h;
            Subscriber[] subscriberArr = this.f138607a;
            AtomicLongArray atomicLongArray = this.f138608b;
            long[] jArr = this.f138609c;
            int length = jArr.length;
            int i3 = this.f138616k;
            int iAddAndGet = 1;
            while (true) {
                int i4 = 0;
                int i5 = 0;
                while (!this.f138617l) {
                    if (simpleQueue.isEmpty()) {
                        int length2 = subscriberArr.length;
                        while (i4 < length2) {
                            subscriberArr[i4].onComplete();
                            i4++;
                        }
                        return;
                    }
                    long j3 = atomicLongArray.get(i3);
                    long j4 = jArr[i3];
                    if (j3 == j4 || atomicLongArray.get(length + i3) != 0) {
                        i5++;
                    } else {
                        try {
                            Object objPoll = simpleQueue.poll();
                            if (objPoll == null) {
                                int length3 = subscriberArr.length;
                                while (i4 < length3) {
                                    subscriberArr[i4].onComplete();
                                    i4++;
                                }
                                return;
                            }
                            subscriberArr[i3].h(objPoll);
                            jArr[i3] = j4 + 1;
                            i5 = 0;
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.f138612g.cancel();
                            int length4 = subscriberArr.length;
                            while (i4 < length4) {
                                subscriberArr[i4].onError(th);
                                i4++;
                            }
                            return;
                        }
                    }
                    i3++;
                    if (i3 == length) {
                        i3 = 0;
                    }
                    if (i5 == length) {
                        int i6 = get();
                        if (i6 == iAddAndGet) {
                            this.f138616k = i3;
                            iAddAndGet = addAndGet(-iAddAndGet);
                            if (iAddAndGet == 0) {
                                return;
                            }
                        } else {
                            iAddAndGet = i6;
                        }
                    }
                }
                simpleQueue.clear();
                return;
            }
        }

        void e() {
            Subscriber[] subscriberArr = this.f138607a;
            int length = subscriberArr.length;
            int i3 = 0;
            while (i3 < length && !this.f138617l) {
                int i4 = i3 + 1;
                this.f138618m.lazySet(i4);
                subscriberArr[i3].g(new RailSubscription(i3, length));
                i3 = i4;
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138612g, subscription)) {
                this.f138612g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(7);
                    if (iL == 1) {
                        this.f138620o = iL;
                        this.f138613h = queueSubscription;
                        this.f138615j = true;
                        e();
                        b();
                        return;
                    }
                    if (iL == 2) {
                        this.f138620o = iL;
                        this.f138613h = queueSubscription;
                        e();
                        subscription.y(this.f138610d);
                        return;
                    }
                }
                this.f138613h = new SpscArrayQueue(this.f138610d);
                e();
                subscription.y(this.f138610d);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f138620o != 0 || this.f138613h.offer(obj)) {
                b();
            } else {
                this.f138612g.cancel();
                onError(new MissingBackpressureException("Queue is full?"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f138615j = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f138614i = th;
            this.f138615j = true;
            b();
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138605b;
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            this.f138604a.i(new ParallelDispatcher(subscriberArr, this.f138606c));
        }
    }
}
