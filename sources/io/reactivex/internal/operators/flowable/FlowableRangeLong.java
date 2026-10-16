package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableRangeLong extends Flowable<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f136105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136106c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Long> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f136107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f136108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f136109c;

        BaseRangeSubscription(long j3, long j4) {
            this.f136108b = j3;
            this.f136107a = j4;
        }

        abstract void a();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Long poll() {
            long j3 = this.f136108b;
            if (j3 == this.f136107a) {
                return null;
            }
            this.f136108b = 1 + j3;
            return Long.valueOf(j3);
        }

        abstract void c(long j3);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.f136109c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.f136108b = this.f136107a;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.f136108b == this.f136107a;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int l(int i3) {
            return i3 & 1;
        }

        @Override // org.reactivestreams.Subscription
        public final void y(long j3) {
            if (SubscriptionHelper.h(j3) && BackpressureHelper.a(this, j3) == 0) {
                if (j3 == Long.MAX_VALUE) {
                    a();
                } else {
                    c(j3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RangeConditionalSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ConditionalSubscriber f136110d;

        RangeConditionalSubscription(ConditionalSubscriber conditionalSubscriber, long j3, long j4) {
            super(j3, j4);
            this.f136110d = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void a() {
            long j3 = this.f136107a;
            ConditionalSubscriber conditionalSubscriber = this.f136110d;
            for (long j4 = this.f136108b; j4 != j3; j4++) {
                if (this.f136109c) {
                    return;
                }
                conditionalSubscriber.o(Long.valueOf(j4));
            }
            if (this.f136109c) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
        
            r12.f136108b = r2;
            r13 = addAndGet(-r7);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c(long r13) {
            /*
                r12 = this;
                long r0 = r12.f136107a
                long r2 = r12.f136108b
                io.reactivex.internal.fuseable.ConditionalSubscriber r4 = r12.f136110d
                r5 = 0
            L8:
                r7 = r5
            L9:
                int r9 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
                if (r9 == 0) goto L25
                int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r9 == 0) goto L25
                boolean r9 = r12.f136109c
                if (r9 == 0) goto L16
                goto L44
            L16:
                java.lang.Long r9 = java.lang.Long.valueOf(r2)
                boolean r9 = r4.o(r9)
                r10 = 1
                if (r9 == 0) goto L23
                long r7 = r7 + r10
            L23:
                long r2 = r2 + r10
                goto L9
            L25:
                int r13 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r13 != 0) goto L31
                boolean r13 = r12.f136109c
                if (r13 != 0) goto L44
                r4.onComplete()
                return
            L31:
                long r13 = r12.get()
                int r9 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
                if (r9 != 0) goto L9
                r12.f136108b = r2
                long r13 = -r7
                long r13 = r12.addAndGet(r13)
                int r7 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r7 != 0) goto L8
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRangeLong.RangeConditionalSubscription.c(long):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Subscriber f136111d;

        RangeSubscription(Subscriber subscriber, long j3, long j4) {
            super(j3, j4);
            this.f136111d = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        void a() {
            long j3 = this.f136107a;
            Subscriber subscriber = this.f136111d;
            for (long j4 = this.f136108b; j4 != j3; j4++) {
                if (this.f136109c) {
                    return;
                }
                subscriber.h(Long.valueOf(j4));
            }
            if (this.f136109c) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0036, code lost:
        
            r11.f136108b = r2;
            r12 = addAndGet(-r7);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRangeLong.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c(long r12) {
            /*
                r11 = this;
                long r0 = r11.f136107a
                long r2 = r11.f136108b
                org.reactivestreams.Subscriber r4 = r11.f136111d
                r5 = 0
            L8:
                r7 = r5
            L9:
                int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r9 == 0) goto L22
                int r9 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r9 == 0) goto L22
                boolean r9 = r11.f136109c
                if (r9 == 0) goto L16
                goto L41
            L16:
                java.lang.Long r9 = java.lang.Long.valueOf(r2)
                r4.h(r9)
                r9 = 1
                long r7 = r7 + r9
                long r2 = r2 + r9
                goto L9
            L22:
                int r12 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r12 != 0) goto L2e
                boolean r12 = r11.f136109c
                if (r12 != 0) goto L41
                r4.onComplete()
                return
            L2e:
                long r12 = r11.get()
                int r9 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r9 != 0) goto L9
                r11.f136108b = r2
                long r12 = -r7
                long r12 = r11.addAndGet(r12)
                int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
                if (r7 != 0) goto L8
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRangeLong.RangeSubscription.c(long):void");
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.g(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.f136105b, this.f136106c));
        } else {
            subscriber.g(new RangeSubscription(subscriber, this.f136105b, this.f136106c));
        }
    }
}
