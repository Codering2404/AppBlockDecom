package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTimeoutTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f138349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f138350d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ObservableSource f138351f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FallbackObserver<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f138353b;

        FallbackObserver(Observer observer, AtomicReference atomicReference) {
            this.f138352a = observer;
            this.f138353b = atomicReference;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.c(this.f138353b, disposable);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138352a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138352a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138352a.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f138356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f138357d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final SequentialDisposable f138358f = new SequentialDisposable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicLong f138359g = new AtomicLong();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference f138360h = new AtomicReference();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ObservableSource f138361i;

        TimeoutFallbackObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler.Worker worker, ObservableSource observableSource) {
            this.f138354a = observer;
            this.f138355b = j3;
            this.f138356c = timeUnit;
            this.f138357d = worker;
            this.f138361i = observableSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f138360h, disposable);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void c(long j3) {
            if (this.f138359g.compareAndSet(j3, Long.MAX_VALUE)) {
                DisposableHelper.a(this.f138360h);
                ObservableSource observableSource = this.f138361i;
                this.f138361i = null;
                observableSource.b(new FallbackObserver(this.f138354a, this));
                this.f138357d.dispose();
            }
        }

        void d(long j3) {
            this.f138358f.a(this.f138357d.c(new TimeoutTask(j3, this), this.f138355b, this.f138356c));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138360h);
            DisposableHelper.a(this);
            this.f138357d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            long j3 = this.f138359g.get();
            if (j3 != Long.MAX_VALUE) {
                long j4 = 1 + j3;
                if (this.f138359g.compareAndSet(j3, j4)) {
                    this.f138358f.get().dispose();
                    this.f138354a.h(obj);
                    d(j4);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138359g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f138358f.dispose();
                this.f138354a.onComplete();
                this.f138357d.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138359g.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138358f.dispose();
            this.f138354a.onError(th);
            this.f138357d.dispose();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138363b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f138364c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f138365d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final SequentialDisposable f138366f = new SequentialDisposable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f138367g = new AtomicReference();

        TimeoutObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f138362a = observer;
            this.f138363b = j3;
            this.f138364c = timeUnit;
            this.f138365d = worker;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f138367g, disposable);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void c(long j3) {
            if (compareAndSet(j3, Long.MAX_VALUE)) {
                DisposableHelper.a(this.f138367g);
                this.f138362a.onError(new TimeoutException(ExceptionHelper.d(this.f138363b, this.f138364c)));
                this.f138365d.dispose();
            }
        }

        void d(long j3) {
            this.f138366f.a(this.f138365d.c(new TimeoutTask(j3, this), this.f138363b, this.f138364c));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138367g);
            this.f138365d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b((Disposable) this.f138367g.get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            long j3 = get();
            if (j3 != Long.MAX_VALUE) {
                long j4 = 1 + j3;
                if (compareAndSet(j3, j4)) {
                    this.f138366f.get().dispose();
                    this.f138362a.h(obj);
                    d(j4);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f138366f.dispose();
                this.f138362a.onComplete();
                this.f138365d.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138366f.dispose();
            this.f138362a.onError(th);
            this.f138365d.dispose();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface TimeoutSupport {
        void c(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutTask implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TimeoutSupport f138368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138369b;

        TimeoutTask(long j3, TimeoutSupport timeoutSupport) {
            this.f138369b = j3;
            this.f138368a = timeoutSupport;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f138368a.c(this.f138369b);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        if (this.f138351f == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f138348b, this.f138349c, this.f138350d.b());
            observer.a(timeoutObserver);
            timeoutObserver.d(0L);
            this.f137267a.b(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f138348b, this.f138349c, this.f138350d.b(), this.f138351f);
        observer.a(timeoutFallbackObserver);
        timeoutFallbackObserver.d(0L);
        this.f137267a.b(timeoutFallbackObserver);
    }
}
