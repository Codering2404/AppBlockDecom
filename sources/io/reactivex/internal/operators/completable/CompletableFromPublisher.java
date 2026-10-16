package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableFromPublisher<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f135089a;

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135089a.i(new FromPublisherSubscriber(completableObserver));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FromPublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f135091b;

        FromPublisherSubscriber(CompletableObserver completableObserver) {
            this.f135090a = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135091b.cancel();
            this.f135091b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135091b == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135091b, subscription)) {
                this.f135091b = subscription;
                this.f135090a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135090a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135090a.onError(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
        }
    }
}
