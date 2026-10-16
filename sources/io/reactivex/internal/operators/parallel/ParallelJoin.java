package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelJoin<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ParallelFlowable f138624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f138625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f138626d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class JoinInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 8410034718427740355L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final JoinSubscriptionBase f138627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f138628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f138629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f138630d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile SimplePlainQueue f138631f;

        JoinInnerSubscriber(JoinSubscriptionBase joinSubscriptionBase, int i3) {
            this.f138627a = joinSubscriptionBase;
            this.f138628b = i3;
            this.f138629c = i3 - (i3 >> 2);
        }

        public boolean a() {
            return SubscriptionHelper.a(this);
        }

        SimplePlainQueue b() {
            SimplePlainQueue simplePlainQueue = this.f138631f;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f138628b);
            this.f138631f = spscArrayQueue;
            return spscArrayQueue;
        }

        public void c(long j3) {
            long j4 = this.f138630d + j3;
            if (j4 < this.f138629c) {
                this.f138630d = j4;
            } else {
                this.f138630d = 0L;
                get().y(j4);
            }
        }

        public void d() {
            long j3 = this.f138630d + 1;
            if (j3 != this.f138629c) {
                this.f138630d = j3;
            } else {
                this.f138630d = 0L;
                get().y(j3);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, this.f138628b);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f138627a.f(this, obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f138627a.d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f138627a.e(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class JoinSubscription<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = 6312374661811000451L;

        JoinSubscription(Subscriber subscriber, int i3, int i4) {
            super(subscriber, i3, i4);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            g();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void d() {
            this.f138637g.decrementAndGet();
            c();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void e(Throwable th) {
            if (this.f138634c.compareAndSet(null, th)) {
                a();
                c();
            } else if (th != this.f138634c.get()) {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        public void f(JoinInnerSubscriber joinInnerSubscriber, Object obj) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.f138635d.get() != 0) {
                    this.f138632a.h(obj);
                    if (this.f138635d.get() != Long.MAX_VALUE) {
                        this.f138635d.decrementAndGet();
                    }
                    joinInnerSubscriber.c(1L);
                } else if (!joinInnerSubscriber.b().offer(obj)) {
                    a();
                    MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Queue full?!");
                    if (this.f138634c.compareAndSet(null, missingBackpressureException)) {
                        this.f138632a.onError(missingBackpressureException);
                        return;
                    } else {
                        RxJavaPlugins.s(missingBackpressureException);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!joinInnerSubscriber.b().offer(obj)) {
                a();
                e(new MissingBackpressureException("Queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            g();
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
        
            r16 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
        
            if (r12 == false) goto L88;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        
            if (r15 == false) goto L89;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0064, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        
            if (r15 == false) goto L90;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void g() {
            /*
                Method dump skipped, instruction units count: 213
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscription.g():void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class JoinSubscriptionBase<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 3100232009247827843L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f138632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final JoinInnerSubscriber[] f138633b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f138636f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicThrowable f138634c = new AtomicThrowable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f138635d = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicInteger f138637g = new AtomicInteger();

        JoinSubscriptionBase(Subscriber subscriber, int i3, int i4) {
            this.f138632a = subscriber;
            JoinInnerSubscriber[] joinInnerSubscriberArr = new JoinInnerSubscriber[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                joinInnerSubscriberArr[i5] = new JoinInnerSubscriber(this, i4);
            }
            this.f138633b = joinInnerSubscriberArr;
            this.f138637g.lazySet(i3);
        }

        void a() {
            for (JoinInnerSubscriber joinInnerSubscriber : this.f138633b) {
                joinInnerSubscriber.a();
            }
        }

        void b() {
            for (JoinInnerSubscriber joinInnerSubscriber : this.f138633b) {
                joinInnerSubscriber.f138631f = null;
            }
        }

        abstract void c();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f138636f) {
                return;
            }
            this.f138636f = true;
            a();
            if (getAndIncrement() == 0) {
                b();
            }
        }

        abstract void d();

        abstract void e(Throwable th);

        abstract void f(JoinInnerSubscriber joinInnerSubscriber, Object obj);

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f138635d, j3);
                c();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class JoinSubscriptionDelayError<T> extends JoinSubscriptionBase<T> {
        private static final long serialVersionUID = -5737965195918321883L;

        JoinSubscriptionDelayError(Subscriber subscriber, int i3, int i4) {
            super(subscriber, i3, i4);
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            g();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void d() {
            this.f138637g.decrementAndGet();
            c();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void e(Throwable th) {
            this.f138634c.a(th);
            this.f138637g.decrementAndGet();
            c();
        }

        @Override // io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionBase
        void f(JoinInnerSubscriber joinInnerSubscriber, Object obj) {
            if (get() == 0 && compareAndSet(0, 1)) {
                if (this.f138635d.get() != 0) {
                    this.f138632a.h(obj);
                    if (this.f138635d.get() != Long.MAX_VALUE) {
                        this.f138635d.decrementAndGet();
                    }
                    joinInnerSubscriber.c(1L);
                } else if (!joinInnerSubscriber.b().offer(obj)) {
                    joinInnerSubscriber.a();
                    this.f138634c.a(new MissingBackpressureException("Queue full?!"));
                    this.f138637g.decrementAndGet();
                    g();
                    return;
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                if (!joinInnerSubscriber.b().offer(obj) && joinInnerSubscriber.a()) {
                    this.f138634c.a(new MissingBackpressureException("Queue full?!"));
                    this.f138637g.decrementAndGet();
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            g();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
        
            r16 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
        
            if (r12 == false) goto L85;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
        
            if (r15 == false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        
            if (r18.f138634c.get() == null) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
        
            r3.onError(r18.f138634c.b());
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
        
            r3.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0069, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
        
            if (r15 == false) goto L87;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void g() {
            /*
                Method dump skipped, instruction units count: 218
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelJoin.JoinSubscriptionDelayError.g():void");
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        JoinSubscriptionBase joinSubscriptionDelayError = this.f138626d ? new JoinSubscriptionDelayError(subscriber, this.f138624b.a(), this.f138625c) : new JoinSubscription(subscriber, this.f138624b.a(), this.f138625c);
        subscriber.g(joinSubscriptionDelayError);
        this.f138624b.b(joinSubscriptionDelayError.f138633b);
    }
}
