package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136320c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f136322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136323c;

        SkipSubscriber(Subscriber subscriber, long j3) {
            this.f136321a = subscriber;
            this.f136322b = j3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136323c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136323c, subscription)) {
                long j3 = this.f136322b;
                this.f136323c = subscription;
                this.f136321a.g(this);
                subscription.y(j3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            long j3 = this.f136322b;
            if (j3 != 0) {
                this.f136322b = j3 - 1;
            } else {
                this.f136321a.h(obj);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136321a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136321a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136323c.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new SkipSubscriber(subscriber, this.f136320c));
    }
}
