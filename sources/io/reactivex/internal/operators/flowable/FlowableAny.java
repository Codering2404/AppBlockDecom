package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableAny<T> extends AbstractFlowableWithUpstream<T, Boolean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Predicate f135246c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AnySubscriber<T> extends DeferredScalarSubscription<Boolean> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2311252482644620661L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Predicate f135247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f135248d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f135249f;

        AnySubscriber(Subscriber subscriber, Predicate predicate) {
            super(subscriber);
            this.f135247c = predicate;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f135248d.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135248d, subscription)) {
                this.f135248d = subscription;
                this.f139174a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135249f) {
                return;
            }
            try {
                if (this.f135247c.test(obj)) {
                    this.f135249f = true;
                    this.f135248d.cancel();
                    e(Boolean.TRUE);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135248d.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135249f) {
                return;
            }
            this.f135249f = true;
            e(Boolean.FALSE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135249f) {
                RxJavaPlugins.s(th);
            } else {
                this.f135249f = true;
                this.f139174a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new AnySubscriber(subscriber, this.f135246c));
    }
}
