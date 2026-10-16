package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableLastMaybe<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f135917a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f135918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f135919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f135920c;

        LastSubscriber(MaybeObserver maybeObserver) {
            this.f135918a = maybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135919b.cancel();
            this.f135919b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135919b == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135919b, subscription)) {
                this.f135919b = subscription;
                this.f135918a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135920c = obj;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135919b = SubscriptionHelper.CANCELLED;
            Object obj = this.f135920c;
            if (obj == null) {
                this.f135918a.onComplete();
            } else {
                this.f135920c = null;
                this.f135918a.onSuccess(obj);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135919b = SubscriptionHelper.CANCELLED;
            this.f135920c = null;
            this.f135918a.onError(th);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f135917a.i(new LastSubscriber(maybeObserver));
    }
}
