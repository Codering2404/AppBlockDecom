package io.reactivex.internal.operators.maybe;

import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeTakeUntilPublisher<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f136993b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TakeUntilOtherMaybeObserver f136995b = new TakeUntilOtherMaybeObserver(this);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Subscription> implements FlowableSubscriber<U> {
            private static final long serialVersionUID = -1266041316834525931L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final TakeUntilMainMaybeObserver f136996a;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver takeUntilMainMaybeObserver) {
                this.f136996a = takeUntilMainMaybeObserver;
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void g(Subscription subscription) {
                SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
            }

            @Override // org.reactivestreams.Subscriber
            public void h(Object obj) {
                SubscriptionHelper.a(this);
                this.f136996a.b();
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                this.f136996a.b();
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                this.f136996a.c(th);
            }
        }

        TakeUntilMainMaybeObserver(MaybeObserver maybeObserver) {
            this.f136994a = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        void b() {
            if (DisposableHelper.a(this)) {
                this.f136994a.onComplete();
            }
        }

        void c(Throwable th) {
            if (DisposableHelper.a(this)) {
                this.f136994a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            SubscriptionHelper.a(this.f136995b);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            SubscriptionHelper.a(this.f136995b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f136994a.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            SubscriptionHelper.a(this.f136995b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f136994a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            SubscriptionHelper.a(this.f136995b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f136994a.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.a(takeUntilMainMaybeObserver);
        this.f136993b.i(takeUntilMainMaybeObserver.f136995b);
        this.f136730a.b(takeUntilMainMaybeObserver);
    }
}
