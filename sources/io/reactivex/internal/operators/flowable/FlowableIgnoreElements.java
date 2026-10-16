package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableIgnoreElements<T> extends AbstractFlowableWithUpstream<T, T> {
    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new IgnoreElementsSubscriber(subscriber));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, QueueSubscription<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f135845b;

        IgnoreElementsSubscriber(Subscriber subscriber) {
            this.f135844a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135845b.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135845b, subscription)) {
                this.f135845b = subscription;
                this.f135844a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return i3 & 2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135844a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135844a.onError(th);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            return null;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
        }
    }
}
