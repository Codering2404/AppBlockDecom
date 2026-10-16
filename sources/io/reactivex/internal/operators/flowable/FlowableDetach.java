package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Subscriber f135563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f135564b;

        DetachSubscriber(Subscriber subscriber) {
            this.f135563a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Subscription subscription = this.f135564b;
            this.f135564b = EmptyComponent.INSTANCE;
            this.f135563a = EmptyComponent.c();
            subscription.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135564b, subscription)) {
                this.f135564b = subscription;
                this.f135563a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135563a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscriber subscriber = this.f135563a;
            this.f135564b = EmptyComponent.INSTANCE;
            this.f135563a = EmptyComponent.c();
            subscriber.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscriber subscriber = this.f135563a;
            this.f135564b = EmptyComponent.INSTANCE;
            this.f135563a = EmptyComponent.c();
            subscriber.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f135564b.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new DetachSubscriber(subscriber));
    }
}
