package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableAndThenPublisher<R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final CompletableSource f137056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f137057c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AndThenPublisherSubscriber<R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, CompletableObserver, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f137058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Publisher f137059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f137061d = new AtomicLong();

        AndThenPublisherSubscriber(Subscriber subscriber, Publisher publisher) {
            this.f137058a = subscriber;
            this.f137059b = publisher;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137060c, disposable)) {
                this.f137060c = disposable;
                this.f137058a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f137060c.dispose();
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this, this.f137061d, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f137058a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Publisher publisher = this.f137059b;
            if (publisher == null) {
                this.f137058a.onComplete();
            } else {
                this.f137059b = null;
                publisher.i(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f137058a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this, this.f137061d, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f137056b.b(new AndThenPublisherSubscriber(subscriber, this.f137057c));
    }
}
