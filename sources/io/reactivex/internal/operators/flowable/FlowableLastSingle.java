package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableLastSingle<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f135921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f135922b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LastSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f135923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f135924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f135925c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f135926d;

        LastSubscriber(SingleObserver singleObserver, Object obj) {
            this.f135923a = singleObserver;
            this.f135924b = obj;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135925c.cancel();
            this.f135925c = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135925c == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135925c, subscription)) {
                this.f135925c = subscription;
                this.f135923a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135926d = obj;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135925c = SubscriptionHelper.CANCELLED;
            Object obj = this.f135926d;
            if (obj != null) {
                this.f135926d = null;
                this.f135923a.onSuccess(obj);
                return;
            }
            Object obj2 = this.f135924b;
            if (obj2 != null) {
                this.f135923a.onSuccess(obj2);
            } else {
                this.f135923a.onError(new NoSuchElementException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135925c = SubscriptionHelper.CANCELLED;
            this.f135926d = null;
            this.f135923a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f135921a.i(new LastSubscriber(singleObserver, this.f135922b));
    }
}
