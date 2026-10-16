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
public final class FlowableAllSingle<T> extends Single<Boolean> implements FuseToFlowable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f135230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f135231b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AllSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f135232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f135233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f135234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f135235d;

        AllSubscriber(SingleObserver singleObserver, Predicate predicate) {
            this.f135232a = singleObserver;
            this.f135233b = predicate;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135234c.cancel();
            this.f135234c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135234c == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135234c, subscription)) {
                this.f135234c = subscription;
                this.f135232a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135235d) {
                return;
            }
            try {
                if (this.f135233b.test(obj)) {
                    return;
                }
                this.f135235d = true;
                this.f135234c.cancel();
                this.f135234c = SubscriptionHelper.CANCELLED;
                this.f135232a.onSuccess(Boolean.FALSE);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135234c.cancel();
                this.f135234c = SubscriptionHelper.CANCELLED;
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135235d) {
                return;
            }
            this.f135235d = true;
            this.f135234c = SubscriptionHelper.CANCELLED;
            this.f135232a.onSuccess(Boolean.TRUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135235d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135235d = true;
            this.f135234c = SubscriptionHelper.CANCELLED;
            this.f135232a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f135230a.w(new AllSubscriber(singleObserver, this.f135231b));
    }
}
