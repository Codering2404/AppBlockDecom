package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleTimeout<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f138926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f138927d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final SingleSource f138928f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutMainObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Runnable, Disposable {
        private static final long serialVersionUID = 37497744973048446L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f138930b = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeoutFallbackObserver f138931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        SingleSource f138932d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f138933f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final TimeUnit f138934g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = 2071387740092105509L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final SingleObserver f138935a;

            TimeoutFallbackObserver(SingleObserver singleObserver) {
                this.f138935a = singleObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.f138935a.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                this.f138935a.onSuccess(obj);
            }
        }

        TimeoutMainObserver(SingleObserver singleObserver, SingleSource singleSource, long j3, TimeUnit timeUnit) {
            this.f138929a = singleObserver;
            this.f138932d = singleSource;
            this.f138933f = j3;
            this.f138934g = timeUnit;
            if (singleSource != null) {
                this.f138931c = new TimeoutFallbackObserver(singleObserver);
            } else {
                this.f138931c = null;
            }
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            DisposableHelper.a(this.f138930b);
            TimeoutFallbackObserver timeoutFallbackObserver = this.f138931c;
            if (timeoutFallbackObserver != null) {
                DisposableHelper.a(timeoutFallbackObserver);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || !compareAndSet(disposable, disposableHelper)) {
                RxJavaPlugins.s(th);
            } else {
                DisposableHelper.a(this.f138930b);
                this.f138929a.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || !compareAndSet(disposable, disposableHelper)) {
                return;
            }
            DisposableHelper.a(this.f138930b);
            this.f138929a.onSuccess(obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper || !compareAndSet(disposable, disposableHelper)) {
                return;
            }
            if (disposable != null) {
                disposable.dispose();
            }
            SingleSource singleSource = this.f138932d;
            if (singleSource == null) {
                this.f138929a.onError(new TimeoutException(ExceptionHelper.d(this.f138933f, this.f138934g)));
            } else {
                this.f138932d = null;
                singleSource.b(this.f138931c);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        TimeoutMainObserver timeoutMainObserver = new TimeoutMainObserver(singleObserver, this.f138928f, this.f138925b, this.f138926c);
        singleObserver.a(timeoutMainObserver);
        DisposableHelper.c(timeoutMainObserver.f138930b, this.f138927d.f(timeoutMainObserver, this.f138925b, this.f138926c));
        this.f138924a.b(timeoutMainObserver);
    }
}
