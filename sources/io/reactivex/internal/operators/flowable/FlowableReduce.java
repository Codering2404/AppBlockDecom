package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableReduce<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f136112c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReduceSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4663883003264602070L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BiFunction f136113c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f136114d;

        ReduceSubscriber(Subscriber subscriber, BiFunction biFunction) {
            super(subscriber);
            this.f136113c = biFunction;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f136114d.cancel();
            this.f136114d = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136114d, subscription)) {
                this.f136114d = subscription;
                this.f139174a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136114d == SubscriptionHelper.CANCELLED) {
                return;
            }
            Object obj2 = this.f139175b;
            if (obj2 == null) {
                this.f139175b = obj;
                return;
            }
            try {
                this.f139175b = ObjectHelper.d(this.f136113c.apply(obj2, obj), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136114d.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = this.f136114d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                return;
            }
            this.f136114d = subscriptionHelper;
            Object obj = this.f139175b;
            if (obj != null) {
                e(obj);
            } else {
                this.f139174a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscription subscription = this.f136114d;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                RxJavaPlugins.s(th);
            } else {
                this.f136114d = subscriptionHelper;
                this.f139174a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new ReduceSubscriber(subscriber, this.f136112c));
    }
}
