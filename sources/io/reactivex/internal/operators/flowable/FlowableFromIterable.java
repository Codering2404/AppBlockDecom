package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.Iterator;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFromIterable<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable f135759b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseRangeSubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Iterator f135760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile boolean f135761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f135762c;

        BaseRangeSubscription(Iterator it) {
            this.f135760a = it;
        }

        abstract void a();

        abstract void b(long j3);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.f135761b = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.f135760a = null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            Iterator it = this.f135760a;
            return it == null || !it.hasNext();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int l(int i3) {
            return i3 & 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final Object poll() {
            Iterator it = this.f135760a;
            if (it == null) {
                return null;
            }
            if (!this.f135762c) {
                this.f135762c = true;
            } else if (!it.hasNext()) {
                return null;
            }
            return ObjectHelper.d(this.f135760a.next(), "Iterator.next() returned a null value");
        }

        @Override // org.reactivestreams.Subscription
        public final void y(long j3) {
            if (SubscriptionHelper.h(j3) && BackpressureHelper.a(this, j3) == 0) {
                if (j3 == Long.MAX_VALUE) {
                    a();
                } else {
                    b(j3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IteratorConditionalSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ConditionalSubscriber f135763d;

        IteratorConditionalSubscription(ConditionalSubscriber conditionalSubscriber, Iterator it) {
            super(it);
            this.f135763d = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void a() {
            Iterator it = this.f135760a;
            ConditionalSubscriber conditionalSubscriber = this.f135763d;
            while (!this.f135761b) {
                try {
                    Object next = it.next();
                    if (this.f135761b) {
                        return;
                    }
                    if (next == null) {
                        conditionalSubscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    conditionalSubscriber.o(next);
                    if (this.f135761b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f135761b) {
                                return;
                            }
                            conditionalSubscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        conditionalSubscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    conditionalSubscriber.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x005b, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b(long r9) {
            /*
                r8 = this;
                java.util.Iterator r0 = r8.f135760a
                io.reactivex.internal.fuseable.ConditionalSubscriber r1 = r8.f135763d
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L53
                boolean r6 = r8.f135761b
                if (r6 == 0) goto L10
                goto L64
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L4b
                boolean r7 = r8.f135761b
                if (r7 == 0) goto L19
                goto L64
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                boolean r6 = r1.o(r6)
                boolean r7 = r8.f135761b
                if (r7 == 0) goto L2f
                goto L64
            L2f:
                boolean r7 = r0.hasNext()     // Catch: java.lang.Throwable -> L43
                if (r7 != 0) goto L3d
                boolean r9 = r8.f135761b
                if (r9 != 0) goto L64
                r1.onComplete()
                return
            L3d:
                if (r6 == 0) goto L7
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L43:
                r9 = move-exception
                io.reactivex.exceptions.Exceptions.b(r9)
                r1.onError(r9)
                return
            L4b:
                r9 = move-exception
                io.reactivex.exceptions.Exceptions.b(r9)
                r1.onError(r9)
                return
            L53:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
            L64:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorConditionalSubscription.b(long):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IteratorSubscription<T> extends BaseRangeSubscription<T> {
        private static final long serialVersionUID = -6022804456014692607L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Subscriber f135764d;

        IteratorSubscription(Subscriber subscriber, Iterator it) {
            super(it);
            this.f135764d = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        void a() {
            Iterator it = this.f135760a;
            Subscriber subscriber = this.f135764d;
            while (!this.f135761b) {
                try {
                    Object next = it.next();
                    if (this.f135761b) {
                        return;
                    }
                    if (next == null) {
                        subscriber.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    subscriber.h(next);
                    if (this.f135761b) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (this.f135761b) {
                                return;
                            }
                            subscriber.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        subscriber.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    subscriber.onError(th2);
                    return;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0058, code lost:
        
            r9 = addAndGet(-r4);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromIterable.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b(long r9) {
            /*
                r8 = this;
                java.util.Iterator r0 = r8.f135760a
                org.reactivestreams.Subscriber r1 = r8.f135764d
                r2 = 0
            L6:
                r4 = r2
            L7:
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 == 0) goto L50
                boolean r6 = r8.f135761b
                if (r6 == 0) goto L10
                goto L61
            L10:
                java.lang.Object r6 = r0.next()     // Catch: java.lang.Throwable -> L48
                boolean r7 = r8.f135761b
                if (r7 == 0) goto L19
                goto L61
            L19:
                if (r6 != 0) goto L26
                java.lang.NullPointerException r9 = new java.lang.NullPointerException
                java.lang.String r10 = "Iterator.next() returned a null value"
                r9.<init>(r10)
                r1.onError(r9)
                return
            L26:
                r1.h(r6)
                boolean r6 = r8.f135761b
                if (r6 == 0) goto L2e
                goto L61
            L2e:
                boolean r6 = r0.hasNext()     // Catch: java.lang.Throwable -> L40
                if (r6 != 0) goto L3c
                boolean r9 = r8.f135761b
                if (r9 != 0) goto L61
                r1.onComplete()
                return
            L3c:
                r6 = 1
                long r4 = r4 + r6
                goto L7
            L40:
                r9 = move-exception
                io.reactivex.exceptions.Exceptions.b(r9)
                r1.onError(r9)
                return
            L48:
                r9 = move-exception
                io.reactivex.exceptions.Exceptions.b(r9)
                r1.onError(r9)
                return
            L50:
                long r9 = r8.get()
                int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
                if (r6 != 0) goto L7
                long r9 = -r4
                long r9 = r8.addAndGet(r9)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 != 0) goto L6
            L61:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromIterable.IteratorSubscription.b(long):void");
        }
    }

    public FlowableFromIterable(Iterable iterable) {
        this.f135759b = iterable;
    }

    public static void A(Subscriber subscriber, Iterator it) {
        try {
            if (!it.hasNext()) {
                EmptySubscription.a(subscriber);
            } else if (subscriber instanceof ConditionalSubscriber) {
                subscriber.g(new IteratorConditionalSubscription((ConditionalSubscriber) subscriber, it));
            } else {
                subscriber.g(new IteratorSubscription(subscriber, it));
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        try {
            A(subscriber, this.f135759b.iterator());
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
