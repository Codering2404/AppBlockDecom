package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableAnySingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f135250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f135251b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AnySubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f135252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f135253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f135254c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f135255d;

        AnySubscriber(SingleObserver singleObserver, Predicate predicate) {
            this.f135252a = singleObserver;
            this.f135253b = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135254c.cancel();
            this.f135254c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135254c == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135254c, subscription)) {
                this.f135254c = subscription;
                this.f135252a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135255d) {
                return;
            }
            try {
                if (this.f135253b.test(obj)) {
                    this.f135255d = true;
                    this.f135254c.cancel();
                    this.f135254c = SubscriptionHelper.CANCELLED;
                    this.f135252a.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135254c.cancel();
                this.f135254c = SubscriptionHelper.CANCELLED;
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135255d) {
                return;
            }
            this.f135255d = true;
            this.f135254c = SubscriptionHelper.CANCELLED;
            this.f135252a.onSuccess(Boolean.FALSE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135255d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135255d = true;
            this.f135254c = SubscriptionHelper.CANCELLED;
            this.f135252a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f135250a.w(new AnySubscriber(singleObserver, this.f135251b));
    }
}
