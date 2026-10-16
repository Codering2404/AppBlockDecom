package io.reactivex.internal.operators.observable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFromPublisher<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f137748a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PublisherSubscriber<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f137750b;

        PublisherSubscriber(Observer observer) {
            this.f137749a = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137750b.cancel();
            this.f137750b = SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137750b == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f137750b, subscription)) {
                this.f137750b = subscription;
                this.f137749a.a(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f137749a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f137749a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f137749a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137748a.i(new PublisherSubscriber(observer));
    }
}
