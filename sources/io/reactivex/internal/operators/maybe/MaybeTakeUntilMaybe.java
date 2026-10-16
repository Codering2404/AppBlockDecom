package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeTakeUntilMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource f136989b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeUntilMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2187421758664251153L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TakeUntilOtherMaybeObserver f136991b = new TakeUntilOtherMaybeObserver(this);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class TakeUntilOtherMaybeObserver<U> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -1266041316834525931L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final TakeUntilMainMaybeObserver f136992a;

            TakeUntilOtherMaybeObserver(TakeUntilMainMaybeObserver takeUntilMainMaybeObserver) {
                this.f136992a = takeUntilMainMaybeObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f136992a.b();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f136992a.c(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                this.f136992a.b();
            }
        }

        TakeUntilMainMaybeObserver(MaybeObserver maybeObserver) {
            this.f136990a = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        void b() {
            if (DisposableHelper.a(this)) {
                this.f136990a.onComplete();
            }
        }

        void c(Throwable th) {
            if (DisposableHelper.a(this)) {
                this.f136990a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            DisposableHelper.a(this.f136991b);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            DisposableHelper.a(this.f136991b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f136990a.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            DisposableHelper.a(this.f136991b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f136990a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            DisposableHelper.a(this.f136991b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f136990a.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        TakeUntilMainMaybeObserver takeUntilMainMaybeObserver = new TakeUntilMainMaybeObserver(maybeObserver);
        maybeObserver.a(takeUntilMainMaybeObserver);
        this.f136989b.b(takeUntilMainMaybeObserver.f136991b);
        this.f136730a.b(takeUntilMainMaybeObserver);
    }
}
