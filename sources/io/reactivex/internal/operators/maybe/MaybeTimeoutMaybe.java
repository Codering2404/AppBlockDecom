package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeTimeoutMaybe<T, U> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource f136997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final MaybeSource f136998c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutFallbackMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136999a;

        TimeoutFallbackMaybeObserver(MaybeObserver maybeObserver) {
            this.f136999a = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136999a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136999a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136999a.onSuccess(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutMainMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -5955289211445418871L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f137000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TimeoutOtherMaybeObserver f137001b = new TimeoutOtherMaybeObserver(this);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final MaybeSource f137002c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final TimeoutFallbackMaybeObserver f137003d;

        TimeoutMainMaybeObserver(MaybeObserver maybeObserver, MaybeSource maybeSource) {
            this.f137000a = maybeObserver;
            this.f137002c = maybeSource;
            this.f137003d = maybeSource != null ? new TimeoutFallbackMaybeObserver(maybeObserver) : null;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        public void b() {
            if (DisposableHelper.a(this)) {
                MaybeSource maybeSource = this.f137002c;
                if (maybeSource == null) {
                    this.f137000a.onError(new TimeoutException());
                } else {
                    maybeSource.b(this.f137003d);
                }
            }
        }

        public void c(Throwable th) {
            if (DisposableHelper.a(this)) {
                this.f137000a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            DisposableHelper.a(this.f137001b);
            TimeoutFallbackMaybeObserver timeoutFallbackMaybeObserver = this.f137003d;
            if (timeoutFallbackMaybeObserver != null) {
                DisposableHelper.a(timeoutFallbackMaybeObserver);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            DisposableHelper.a(this.f137001b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f137000a.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            DisposableHelper.a(this.f137001b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f137000a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            DisposableHelper.a(this.f137001b);
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (getAndSet(disposableHelper) != disposableHelper) {
                this.f137000a.onSuccess(obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutOtherMaybeObserver<T, U> extends AtomicReference<Disposable> implements MaybeObserver<Object> {
        private static final long serialVersionUID = 8663801314800248617L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TimeoutMainMaybeObserver f137004a;

        TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver timeoutMainMaybeObserver) {
            this.f137004a = timeoutMainMaybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f137004a.b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f137004a.c(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f137004a.b();
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.f136998c);
        maybeObserver.a(timeoutMainMaybeObserver);
        this.f136997b.b(timeoutMainMaybeObserver.f137001b);
        this.f136730a.b(timeoutMainMaybeObserver);
    }
}
