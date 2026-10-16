package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFromArray<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f135749b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ArrayConditionalSubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ConditionalSubscriber f135750d;

        ArrayConditionalSubscription(ConditionalSubscriber conditionalSubscriber, Object[] objArr) {
            super(objArr);
            this.f135750d = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void a() {
            Object[] objArr = this.f135752a;
            int length = objArr.length;
            ConditionalSubscriber conditionalSubscriber = this.f135750d;
            for (int i3 = this.f135753b; i3 != length; i3++) {
                if (this.f135754c) {
                    return;
                }
                Object obj = objArr[i3];
                if (obj == null) {
                    conditionalSubscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                conditionalSubscriber.o(obj);
            }
            if (this.f135754c) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
        
            r10.f135753b = r2;
            r11 = addAndGet(-r6);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b(long r11) {
            /*
                r10 = this;
                java.lang.Object[] r0 = r10.f135752a
                int r1 = r0.length
                int r2 = r10.f135753b
                io.reactivex.internal.fuseable.ConditionalSubscriber r3 = r10.f135750d
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L30
                if (r2 == r1) goto L30
                boolean r8 = r10.f135754c
                if (r8 == 0) goto L15
                goto L4d
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L24
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L24:
                boolean r8 = r3.o(r8)
                if (r8 == 0) goto L2d
                r8 = 1
                long r6 = r6 + r8
            L2d:
                int r2 = r2 + 1
                goto La
            L30:
                if (r2 != r1) goto L3a
                boolean r11 = r10.f135754c
                if (r11 != 0) goto L4d
                r3.onComplete()
                return
            L3a:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.f135753b = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
            L4d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArrayConditionalSubscription.b(long):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ArraySubscription<T> extends BaseArraySubscription<T> {
        private static final long serialVersionUID = 2587302975077663557L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Subscriber f135751d;

        ArraySubscription(Subscriber subscriber, Object[] objArr) {
            super(objArr);
            this.f135751d = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        void a() {
            Object[] objArr = this.f135752a;
            int length = objArr.length;
            Subscriber subscriber = this.f135751d;
            for (int i3 = this.f135753b; i3 != length; i3++) {
                if (this.f135754c) {
                    return;
                }
                Object obj = objArr[i3];
                if (obj == null) {
                    subscriber.onError(new NullPointerException("array element is null"));
                    return;
                }
                subscriber.h(obj);
            }
            if (this.f135754c) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        
            r10.f135753b = r2;
            r11 = addAndGet(-r6);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableFromArray.BaseArraySubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void b(long r11) {
            /*
                r10 = this;
                java.lang.Object[] r0 = r10.f135752a
                int r1 = r0.length
                int r2 = r10.f135753b
                org.reactivestreams.Subscriber r3 = r10.f135751d
                r4 = 0
            L9:
                r6 = r4
            La:
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 == 0) goto L2d
                if (r2 == r1) goto L2d
                boolean r8 = r10.f135754c
                if (r8 == 0) goto L15
                goto L4a
            L15:
                r8 = r0[r2]
                if (r8 != 0) goto L24
                java.lang.NullPointerException r11 = new java.lang.NullPointerException
                java.lang.String r12 = "array element is null"
                r11.<init>(r12)
                r3.onError(r11)
                return
            L24:
                r3.h(r8)
                r8 = 1
                long r6 = r6 + r8
                int r2 = r2 + 1
                goto La
            L2d:
                if (r2 != r1) goto L37
                boolean r11 = r10.f135754c
                if (r11 != 0) goto L4a
                r3.onComplete()
                return
            L37:
                long r11 = r10.get()
                int r8 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r8 != 0) goto La
                r10.f135753b = r2
                long r11 = -r6
                long r11 = r10.addAndGet(r11)
                int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r6 != 0) goto L9
            L4a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFromArray.ArraySubscription.b(long):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseArraySubscription<T> extends BasicQueueSubscription<T> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object[] f135752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f135753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f135754c;

        BaseArraySubscription(Object[] objArr) {
            this.f135752a = objArr;
        }

        abstract void a();

        abstract void b(long j3);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.f135754c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.f135753b = this.f135752a.length;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.f135753b == this.f135752a.length;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int l(int i3) {
            return i3 & 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final Object poll() {
            int i3 = this.f135753b;
            Object[] objArr = this.f135752a;
            if (i3 == objArr.length) {
                return null;
            }
            this.f135753b = i3 + 1;
            return ObjectHelper.d(objArr[i3], "array element is null");
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

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.g(new ArrayConditionalSubscription((ConditionalSubscriber) subscriber, this.f135749b));
        } else {
            subscriber.g(new ArraySubscription(subscriber, this.f135749b));
        }
    }
}
