package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.BasicQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableRange extends Flowable<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f136098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f136099c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseRangeSubscription extends BasicQueueSubscription<Integer> {
        private static final long serialVersionUID = -2252972430506210021L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f136100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f136101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f136102c;

        BaseRangeSubscription(int i3, int i4) {
            this.f136101b = i3;
            this.f136100a = i4;
        }

        abstract void a();

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer poll() {
            int i3 = this.f136101b;
            if (i3 == this.f136100a) {
                return null;
            }
            this.f136101b = i3 + 1;
            return Integer.valueOf(i3);
        }

        abstract void c(long j3);

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.f136102c = true;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.f136101b = this.f136100a;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.f136101b == this.f136100a;
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
        final ConditionalSubscriber f136103d;

        RangeConditionalSubscription(ConditionalSubscriber conditionalSubscriber, int i3, int i4) {
            super(i3, i4);
            this.f136103d = conditionalSubscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void a() {
            int i3 = this.f136100a;
            ConditionalSubscriber conditionalSubscriber = this.f136103d;
            for (int i4 = this.f136101b; i4 != i3; i4++) {
                if (this.f136102c) {
                    return;
                }
                conditionalSubscriber.o(Integer.valueOf(i4));
            }
            if (this.f136102c) {
                return;
            }
            conditionalSubscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
        
            r9.f136101b = r1;
            r10 = addAndGet(-r5);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c(long r10) {
            /*
                r9 = this;
                int r0 = r9.f136100a
                int r1 = r9.f136101b
                io.reactivex.internal.fuseable.ConditionalSubscriber r2 = r9.f136103d
                r3 = 0
            L8:
                r5 = r3
            L9:
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 == 0) goto L24
                if (r1 == r0) goto L24
                boolean r7 = r9.f136102c
                if (r7 == 0) goto L14
                goto L41
            L14:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                boolean r7 = r2.o(r7)
                if (r7 == 0) goto L21
                r7 = 1
                long r5 = r5 + r7
            L21:
                int r1 = r1 + 1
                goto L9
            L24:
                if (r1 != r0) goto L2e
                boolean r10 = r9.f136102c
                if (r10 != 0) goto L41
                r2.onComplete()
                return
            L2e:
                long r10 = r9.get()
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 != 0) goto L9
                r9.f136101b = r1
                long r10 = -r5
                long r10 = r9.addAndGet(r10)
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r5 != 0) goto L8
            L41:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRange.RangeConditionalSubscription.c(long):void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RangeSubscription extends BaseRangeSubscription {
        private static final long serialVersionUID = 2587302975077663557L;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Subscriber f136104d;

        RangeSubscription(Subscriber subscriber, int i3, int i4) {
            super(i3, i4);
            this.f136104d = subscriber;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        void a() {
            int i3 = this.f136100a;
            Subscriber subscriber = this.f136104d;
            for (int i4 = this.f136101b; i4 != i3; i4++) {
                if (this.f136102c) {
                    return;
                }
                subscriber.h(Integer.valueOf(i4));
            }
            if (this.f136102c) {
                return;
            }
            subscriber.onComplete();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
        
            r9.f136101b = r1;
            r10 = addAndGet(-r5);
         */
        @Override // io.reactivex.internal.operators.flowable.FlowableRange.BaseRangeSubscription
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c(long r10) {
            /*
                r9 = this;
                int r0 = r9.f136100a
                int r1 = r9.f136101b
                org.reactivestreams.Subscriber r2 = r9.f136104d
                r3 = 0
            L8:
                r5 = r3
            L9:
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 == 0) goto L21
                if (r1 == r0) goto L21
                boolean r7 = r9.f136102c
                if (r7 == 0) goto L14
                goto L3e
            L14:
                java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
                r2.h(r7)
                r7 = 1
                long r5 = r5 + r7
                int r1 = r1 + 1
                goto L9
            L21:
                if (r1 != r0) goto L2b
                boolean r10 = r9.f136102c
                if (r10 != 0) goto L3e
                r2.onComplete()
                return
            L2b:
                long r10 = r9.get()
                int r7 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
                if (r7 != 0) goto L9
                r9.f136101b = r1
                long r10 = -r5
                long r10 = r9.addAndGet(r10)
                int r5 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r5 != 0) goto L8
            L3e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableRange.RangeSubscription.c(long):void");
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            subscriber.g(new RangeConditionalSubscription((ConditionalSubscriber) subscriber, this.f136098b, this.f136099c));
        } else {
            subscriber.g(new RangeSubscription(subscriber, this.f136098b, this.f136099c));
        }
    }
}
