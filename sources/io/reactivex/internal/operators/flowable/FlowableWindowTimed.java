package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableWindowTimed<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f136637d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TimeUnit f136638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Scheduler f136639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final long f136640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f136641i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f136642j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowExactBoundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final long f136643i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final TimeUnit f136644j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final Scheduler f136645k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final int f136646l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final boolean f136647m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final long f136648n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final Scheduler.Worker f136649o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        long f136650p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        long f136651q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Subscription f136652r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        UnicastProcessor f136653s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        volatile boolean f136654t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final SequentialDisposable f136655u;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class ConsumerIndexHolder implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final long f136656a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final WindowExactBoundedSubscriber f136657b;

            ConsumerIndexHolder(long j3, WindowExactBoundedSubscriber windowExactBoundedSubscriber) {
                this.f136656a = j3;
                this.f136657b = windowExactBoundedSubscriber;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowExactBoundedSubscriber windowExactBoundedSubscriber = this.f136657b;
                if (((QueueDrainSubscriber) windowExactBoundedSubscriber).f139155f) {
                    windowExactBoundedSubscriber.f136654t = true;
                    windowExactBoundedSubscriber.dispose();
                } else {
                    ((QueueDrainSubscriber) windowExactBoundedSubscriber).f139154d.offer(this);
                }
                if (windowExactBoundedSubscriber.j()) {
                    windowExactBoundedSubscriber.s();
                }
            }
        }

        WindowExactBoundedSubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler scheduler, int i3, long j4, boolean z2) {
            super(subscriber, new MpscLinkedQueue());
            this.f136655u = new SequentialDisposable();
            this.f136643i = j3;
            this.f136644j = timeUnit;
            this.f136645k = scheduler;
            this.f136646l = i3;
            this.f136648n = j4;
            this.f136647m = z2;
            if (z2) {
                this.f136649o = scheduler.b();
            } else {
                this.f136649o = null;
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f139155f = true;
        }

        public void dispose() {
            DisposableHelper.a(this.f136655u);
            Scheduler.Worker worker = this.f136649o;
            if (worker != null) {
                worker.dispose();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            Disposable disposableG;
            if (SubscriptionHelper.i(this.f136652r, subscription)) {
                this.f136652r = subscription;
                Subscriber subscriber = this.f139153c;
                subscriber.g(this);
                if (this.f139155f) {
                    return;
                }
                UnicastProcessor unicastProcessorD = UnicastProcessor.D(this.f136646l);
                this.f136653s = unicastProcessorD;
                long jA = a();
                if (jA == 0) {
                    this.f139155f = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver initial window due to lack of requests."));
                    return;
                }
                subscriber.h(unicastProcessorD);
                if (jA != Long.MAX_VALUE) {
                    i(1L);
                }
                ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f136651q, this);
                if (this.f136647m) {
                    Scheduler.Worker worker = this.f136649o;
                    long j3 = this.f136643i;
                    disposableG = worker.d(consumerIndexHolder, j3, j3, this.f136644j);
                } else {
                    Scheduler scheduler = this.f136645k;
                    long j4 = this.f136643i;
                    disposableG = scheduler.g(consumerIndexHolder, j4, j4, this.f136644j);
                }
                if (this.f136655u.a(disposableG)) {
                    subscription.y(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136654t) {
                return;
            }
            if (k()) {
                UnicastProcessor unicastProcessor = this.f136653s;
                unicastProcessor.h(obj);
                long j3 = this.f136650p + 1;
                if (j3 >= this.f136648n) {
                    this.f136651q++;
                    this.f136650p = 0L;
                    unicastProcessor.onComplete();
                    long jA = a();
                    if (jA == 0) {
                        this.f136653s = null;
                        this.f136652r.cancel();
                        this.f139153c.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                        dispose();
                        return;
                    }
                    UnicastProcessor unicastProcessorD = UnicastProcessor.D(this.f136646l);
                    this.f136653s = unicastProcessorD;
                    this.f139153c.h(unicastProcessorD);
                    if (jA != Long.MAX_VALUE) {
                        i(1L);
                    }
                    if (this.f136647m) {
                        this.f136655u.get().dispose();
                        Scheduler.Worker worker = this.f136649o;
                        ConsumerIndexHolder consumerIndexHolder = new ConsumerIndexHolder(this.f136651q, this);
                        long j4 = this.f136643i;
                        this.f136655u.a(worker.d(consumerIndexHolder, j4, j4, this.f136644j));
                    }
                } else {
                    this.f136650p = j3;
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f139154d.offer(NotificationLite.l(obj));
                if (!j()) {
                    return;
                }
            }
            s();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f139156g = true;
            if (j()) {
                s();
            }
            this.f139153c.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f139157h = th;
            this.f139156g = true;
            if (j()) {
                s();
            }
            this.f139153c.onError(th);
            dispose();
        }

        void s() {
            SimplePlainQueue simplePlainQueue = this.f139154d;
            Subscriber subscriber = this.f139153c;
            UnicastProcessor unicastProcessorD = this.f136653s;
            int iB = 1;
            while (!this.f136654t) {
                boolean z2 = this.f139156g;
                Object objPoll = simplePlainQueue.poll();
                boolean z3 = objPoll == null;
                boolean z4 = objPoll instanceof ConsumerIndexHolder;
                if (z2 && (z3 || z4)) {
                    this.f136653s = null;
                    simplePlainQueue.clear();
                    Throwable th = this.f139157h;
                    if (th != null) {
                        unicastProcessorD.onError(th);
                    } else {
                        unicastProcessorD.onComplete();
                    }
                    dispose();
                    return;
                }
                if (z3) {
                    iB = b(-iB);
                    if (iB == 0) {
                        return;
                    }
                } else {
                    int i3 = iB;
                    if (z4) {
                        ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) objPoll;
                        if (this.f136647m || this.f136651q == consumerIndexHolder.f136656a) {
                            unicastProcessorD.onComplete();
                            this.f136650p = 0L;
                            unicastProcessorD = UnicastProcessor.D(this.f136646l);
                            this.f136653s = unicastProcessorD;
                            long jA = a();
                            if (jA == 0) {
                                this.f136653s = null;
                                this.f139154d.clear();
                                this.f136652r.cancel();
                                subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                                dispose();
                                return;
                            }
                            subscriber.h(unicastProcessorD);
                            if (jA != Long.MAX_VALUE) {
                                i(1L);
                            }
                        }
                    } else {
                        unicastProcessorD.h(NotificationLite.i(objPoll));
                        long j3 = this.f136650p + 1;
                        if (j3 >= this.f136648n) {
                            this.f136651q++;
                            this.f136650p = 0L;
                            unicastProcessorD.onComplete();
                            long jA2 = a();
                            if (jA2 == 0) {
                                this.f136653s = null;
                                this.f136652r.cancel();
                                this.f139153c.onError(new MissingBackpressureException("Could not deliver window due to lack of requests"));
                                dispose();
                                return;
                            }
                            unicastProcessorD = UnicastProcessor.D(this.f136646l);
                            this.f136653s = unicastProcessorD;
                            this.f139153c.h(unicastProcessorD);
                            if (jA2 != Long.MAX_VALUE) {
                                i(1L);
                            }
                            if (this.f136647m) {
                                this.f136655u.get().dispose();
                                Scheduler.Worker worker = this.f136649o;
                                ConsumerIndexHolder consumerIndexHolder2 = new ConsumerIndexHolder(this.f136651q, this);
                                long j4 = this.f136643i;
                                this.f136655u.a(worker.d(consumerIndexHolder2, j4, j4, this.f136644j));
                            }
                        } else {
                            this.f136650p = j3;
                        }
                    }
                    iB = i3;
                }
            }
            this.f136652r.cancel();
            simplePlainQueue.clear();
            dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            n(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowExactUnboundedSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements FlowableSubscriber<T>, Subscription, Runnable {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final Object f136658q = new Object();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final long f136659i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final TimeUnit f136660j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final Scheduler f136661k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final int f136662l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Subscription f136663m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        UnicastProcessor f136664n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final SequentialDisposable f136665o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        volatile boolean f136666p;

        WindowExactUnboundedSubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler scheduler, int i3) {
            super(subscriber, new MpscLinkedQueue());
            this.f136665o = new SequentialDisposable();
            this.f136659i = j3;
            this.f136660j = timeUnit;
            this.f136661k = scheduler;
            this.f136662l = i3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f139155f = true;
        }

        public void dispose() {
            DisposableHelper.a(this.f136665o);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136663m, subscription)) {
                this.f136663m = subscription;
                this.f136664n = UnicastProcessor.D(this.f136662l);
                Subscriber subscriber = this.f139153c;
                subscriber.g(this);
                long jA = a();
                if (jA == 0) {
                    this.f139155f = true;
                    subscription.cancel();
                    subscriber.onError(new MissingBackpressureException("Could not deliver first window due to lack of requests."));
                    return;
                }
                subscriber.h(this.f136664n);
                if (jA != Long.MAX_VALUE) {
                    i(1L);
                }
                if (!this.f139155f) {
                    SequentialDisposable sequentialDisposable = this.f136665o;
                    Scheduler scheduler = this.f136661k;
                    long j3 = this.f136659i;
                    if (sequentialDisposable.a(scheduler.g(this, j3, j3, this.f136660j))) {
                        subscription.y(Long.MAX_VALUE);
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136666p) {
                return;
            }
            if (k()) {
                this.f136664n.h(obj);
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f139154d.offer(NotificationLite.l(obj));
                if (!j()) {
                    return;
                }
            }
            q();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f139156g = true;
            if (j()) {
                q();
            }
            this.f139153c.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f139157h = th;
            this.f139156g = true;
            if (j()) {
                q();
            }
            this.f139153c.onError(th);
            dispose();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.f136664n = null;
            r0.clear();
            dispose();
            r0 = r10.f139157h;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        
            if (r0 == null) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void q() {
            /*
                r10 = this;
                io.reactivex.internal.fuseable.SimplePlainQueue r0 = r10.f139154d
                org.reactivestreams.Subscriber r1 = r10.f139153c
                io.reactivex.processors.UnicastProcessor r2 = r10.f136664n
                r3 = 1
            L7:
                boolean r4 = r10.f136666p
                boolean r5 = r10.f139156g
                java.lang.Object r6 = r0.poll()
                r7 = 0
                if (r5 == 0) goto L2c
                if (r6 == 0) goto L18
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.f136658q
                if (r6 != r5) goto L2c
            L18:
                r10.f136664n = r7
                r0.clear()
                r10.dispose()
                java.lang.Throwable r0 = r10.f139157h
                if (r0 == 0) goto L28
                r2.onError(r0)
                return
            L28:
                r2.onComplete()
                return
            L2c:
                if (r6 != 0) goto L36
                int r3 = -r3
                int r3 = r10.b(r3)
                if (r3 != 0) goto L7
                return
            L36:
                java.lang.Object r5 = io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.f136658q
                if (r6 != r5) goto L83
                r2.onComplete()
                if (r4 != 0) goto L7d
                int r2 = r10.f136662l
                io.reactivex.processors.UnicastProcessor r2 = io.reactivex.processors.UnicastProcessor.D(r2)
                r10.f136664n = r2
                long r4 = r10.a()
                r8 = 0
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 == 0) goto L63
                r1.h(r2)
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 == 0) goto L7
                r4 = 1
                r10.i(r4)
                goto L7
            L63:
                r10.f136664n = r7
                io.reactivex.internal.fuseable.SimplePlainQueue r0 = r10.f139154d
                r0.clear()
                org.reactivestreams.Subscription r0 = r10.f136663m
                r0.cancel()
                r10.dispose()
                io.reactivex.exceptions.MissingBackpressureException r0 = new io.reactivex.exceptions.MissingBackpressureException
                java.lang.String r2 = "Could not deliver first window due to lack of requests."
                r0.<init>(r2)
                r1.onError(r0)
                return
            L7d:
                org.reactivestreams.Subscription r4 = r10.f136663m
                r4.cancel()
                goto L7
            L83:
                java.lang.Object r4 = io.reactivex.internal.util.NotificationLite.i(r6)
                r2.h(r4)
                goto L7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableWindowTimed.WindowExactUnboundedSubscriber.q():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f139155f) {
                this.f136666p = true;
                dispose();
            }
            this.f139154d.offer(f136658q);
            if (j()) {
                q();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            n(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowSkipSubscriber<T> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription, Runnable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final long f136667i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final long f136668j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final TimeUnit f136669k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final Scheduler.Worker f136670l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final int f136671m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final List f136672n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Subscription f136673o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        volatile boolean f136674p;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class Completion implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final UnicastProcessor f136675a;

            Completion(UnicastProcessor unicastProcessor) {
                this.f136675a = unicastProcessor;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindowSkipSubscriber.this.q(this.f136675a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class SubjectWork<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final UnicastProcessor f136677a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final boolean f136678b;

            SubjectWork(UnicastProcessor unicastProcessor, boolean z2) {
                this.f136677a = unicastProcessor;
                this.f136678b = z2;
            }
        }

        WindowSkipSubscriber(Subscriber subscriber, long j3, long j4, TimeUnit timeUnit, Scheduler.Worker worker, int i3) {
            super(subscriber, new MpscLinkedQueue());
            this.f136667i = j3;
            this.f136668j = j4;
            this.f136669k = timeUnit;
            this.f136670l = worker;
            this.f136671m = i3;
            this.f136672n = new LinkedList();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f139155f = true;
        }

        public void dispose() {
            this.f136670l.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136673o, subscription)) {
                this.f136673o = subscription;
                this.f139153c.g(this);
                if (!this.f139155f) {
                    long jA = a();
                    if (jA == 0) {
                        subscription.cancel();
                        this.f139153c.onError(new MissingBackpressureException("Could not emit the first window due to lack of requests"));
                        return;
                    }
                    UnicastProcessor unicastProcessorD = UnicastProcessor.D(this.f136671m);
                    this.f136672n.add(unicastProcessorD);
                    this.f139153c.h(unicastProcessorD);
                    if (jA != Long.MAX_VALUE) {
                        i(1L);
                    }
                    this.f136670l.c(new Completion(unicastProcessorD), this.f136667i, this.f136669k);
                    Scheduler.Worker worker = this.f136670l;
                    long j3 = this.f136668j;
                    worker.d(this, j3, j3, this.f136669k);
                    subscription.y(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (k()) {
                Iterator it = this.f136672n.iterator();
                while (it.hasNext()) {
                    ((UnicastProcessor) it.next()).h(obj);
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                this.f139154d.offer(obj);
                if (!j()) {
                    return;
                }
            }
            r();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f139156g = true;
            if (j()) {
                r();
            }
            this.f139153c.onComplete();
            dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f139157h = th;
            this.f139156g = true;
            if (j()) {
                r();
            }
            this.f139153c.onError(th);
            dispose();
        }

        void q(UnicastProcessor unicastProcessor) {
            this.f139154d.offer(new SubjectWork(unicastProcessor, false));
            if (j()) {
                r();
            }
        }

        void r() {
            SimplePlainQueue simplePlainQueue = this.f139154d;
            Subscriber subscriber = this.f139153c;
            List list = this.f136672n;
            int iB = 1;
            while (!this.f136674p) {
                boolean z2 = this.f139156g;
                Object objPoll = simplePlainQueue.poll();
                boolean z3 = objPoll == null;
                boolean z4 = objPoll instanceof SubjectWork;
                if (z2 && (z3 || z4)) {
                    simplePlainQueue.clear();
                    Throwable th = this.f139157h;
                    if (th != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((UnicastProcessor) it.next()).onError(th);
                        }
                    } else {
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            ((UnicastProcessor) it2.next()).onComplete();
                        }
                    }
                    list.clear();
                    dispose();
                    return;
                }
                if (z3) {
                    iB = b(-iB);
                    if (iB == 0) {
                        return;
                    }
                } else if (z4) {
                    SubjectWork subjectWork = (SubjectWork) objPoll;
                    if (!subjectWork.f136678b) {
                        list.remove(subjectWork.f136677a);
                        subjectWork.f136677a.onComplete();
                        if (list.isEmpty() && this.f139155f) {
                            this.f136674p = true;
                        }
                    } else if (!this.f139155f) {
                        long jA = a();
                        if (jA != 0) {
                            UnicastProcessor unicastProcessorD = UnicastProcessor.D(this.f136671m);
                            list.add(unicastProcessorD);
                            subscriber.h(unicastProcessorD);
                            if (jA != Long.MAX_VALUE) {
                                i(1L);
                            }
                            this.f136670l.c(new Completion(unicastProcessorD), this.f136667i, this.f136669k);
                        } else {
                            subscriber.onError(new MissingBackpressureException("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        ((UnicastProcessor) it3.next()).h(objPoll);
                    }
                }
            }
            this.f136673o.cancel();
            dispose();
            simplePlainQueue.clear();
            list.clear();
        }

        @Override // java.lang.Runnable
        public void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastProcessor.D(this.f136671m), true);
            if (!this.f139155f) {
                this.f139154d.offer(subjectWork);
            }
            if (j()) {
                r();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            n(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        long j3 = this.f136636c;
        long j4 = this.f136637d;
        if (j3 != j4) {
            this.f135196b.w(new WindowSkipSubscriber(serializedSubscriber, j3, j4, this.f136638f, this.f136639g.b(), this.f136641i));
            return;
        }
        long j5 = this.f136640h;
        if (j5 == Long.MAX_VALUE) {
            this.f135196b.w(new WindowExactUnboundedSubscriber(serializedSubscriber, this.f136636c, this.f136638f, this.f136639g, this.f136641i));
        } else {
            this.f135196b.w(new WindowExactBoundedSubscriber(serializedSubscriber, j3, this.f136638f, this.f136639g, this.f136641i, j5, this.f136642j));
        }
    }
}
