package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleTakeUntil<T, U> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f138920b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeUntilMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -622603812305745221L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TakeUntilOtherSubscriber f138922b = new TakeUntilOtherSubscriber(this);

        TakeUntilMainObserver(SingleObserver singleObserver) {
            this.f138921a = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        void b(Throwable th) {
            Disposable andSet;
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || (andSet = getAndSet(disposableHelper)) == disposableHelper) {
                RxJavaPlugins.s(th);
                return;
            }
            if (andSet != null) {
                andSet.dispose();
            }
            this.f138921a.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            this.f138922b.a();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138922b.a();
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || getAndSet(disposableHelper) == disposableHelper) {
                RxJavaPlugins.s(th);
            } else {
                this.f138921a.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138922b.a();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f138921a.onSuccess(obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeUntilOtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 5170026210238877381L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TakeUntilMainObserver f138923a;

        TakeUntilOtherSubscriber(TakeUntilMainObserver takeUntilMainObserver) {
            this.f138923a = takeUntilMainObserver;
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (SubscriptionHelper.a(this)) {
                this.f138923a.b(new CancellationException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f138923a.b(new CancellationException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f138923a.b(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(singleObserver);
        singleObserver.a(takeUntilMainObserver);
        this.f138920b.i(takeUntilMainObserver.f138922b);
        this.f138919a.b(takeUntilMainObserver);
    }
}
