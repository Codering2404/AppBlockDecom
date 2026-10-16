package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableCountSingle<T> extends Single<Long> implements FuseToFlowable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f135490a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CountSubscriber implements FlowableSubscriber<Object>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f135491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f135492b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f135493c;

        CountSubscriber(SingleObserver singleObserver) {
            this.f135491a = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135492b.cancel();
            this.f135492b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135492b == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135492b, subscription)) {
                this.f135492b = subscription;
                this.f135491a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135493c++;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135492b = SubscriptionHelper.CANCELLED;
            this.f135491a.onSuccess(Long.valueOf(this.f135493c));
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135492b = SubscriptionHelper.CANCELLED;
            this.f135491a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f135490a.w(new CountSubscriber(singleObserver));
    }
}
