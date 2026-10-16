package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f136302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f136303d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleElementSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5526049321428043809L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f136304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f136305d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f136306f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f136307g;

        SingleElementSubscriber(Subscriber subscriber, Object obj, boolean z2) {
            super(subscriber);
            this.f136304c = obj;
            this.f136305d = z2;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f136306f.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136306f, subscription)) {
                this.f136306f = subscription;
                this.f139174a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136307g) {
                return;
            }
            if (this.f139175b == null) {
                this.f139175b = obj;
                return;
            }
            this.f136307g = true;
            this.f136306f.cancel();
            this.f139174a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136307g) {
                return;
            }
            this.f136307g = true;
            Object obj = this.f139175b;
            this.f139175b = null;
            if (obj == null) {
                obj = this.f136304c;
            }
            if (obj != null) {
                e(obj);
            } else if (this.f136305d) {
                this.f139174a.onError(new NoSuchElementException());
            } else {
                this.f139174a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136307g) {
                RxJavaPlugins.s(th);
            } else {
                this.f136307g = true;
                this.f139174a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new SingleElementSubscriber(subscriber, this.f136302c, this.f136303d));
    }
}
