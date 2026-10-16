package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTimeout<T, U, V> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f138334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ObservableSource f138335d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutConsumer extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TimeoutSelectorSupport f138336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138337b;

        TimeoutConsumer(long j3, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.f138337b = j3;
            this.f138336a = timeoutSelectorSupport;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            Disposable disposable = (Disposable) get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                disposable.dispose();
                lazySet(disposableHelper);
                this.f138336a.c(this.f138337b);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper) {
                lazySet(disposableHelper);
                this.f138336a.c(this.f138337b);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper) {
                RxJavaPlugins.s(th);
            } else {
                lazySet(disposableHelper);
                this.f138336a.b(this.f138337b, th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutFallbackObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = -7508389464265974549L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SequentialDisposable f138340c = new SequentialDisposable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f138341d = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f138342f = new AtomicReference();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ObservableSource f138343g;

        TimeoutFallbackObserver(Observer observer, Function function, ObservableSource observableSource) {
            this.f138338a = observer;
            this.f138339b = function;
            this.f138343g = observableSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f138342f, disposable);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.TimeoutSelectorSupport
        public void b(long j3, Throwable th) {
            if (!this.f138341d.compareAndSet(j3, Long.MAX_VALUE)) {
                RxJavaPlugins.s(th);
            } else {
                DisposableHelper.a(this);
                this.f138338a.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void c(long j3) {
            if (this.f138341d.compareAndSet(j3, Long.MAX_VALUE)) {
                DisposableHelper.a(this.f138342f);
                ObservableSource observableSource = this.f138343g;
                this.f138343g = null;
                observableSource.b(new ObservableTimeoutTimed.FallbackObserver(this.f138338a, this));
            }
        }

        void d(ObservableSource observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.f138340c.a(timeoutConsumer)) {
                    observableSource.b(timeoutConsumer);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138342f);
            DisposableHelper.a(this);
            this.f138340c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            long j3 = this.f138341d.get();
            if (j3 != Long.MAX_VALUE) {
                long j4 = 1 + j3;
                if (this.f138341d.compareAndSet(j3, j4)) {
                    Disposable disposable = this.f138340c.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f138338a.h(obj);
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f138339b.apply(obj), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j4, this);
                        if (this.f138340c.a(timeoutConsumer)) {
                            observableSource.b(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        ((Disposable) this.f138342f.get()).dispose();
                        this.f138341d.getAndSet(Long.MAX_VALUE);
                        this.f138338a.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138341d.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f138340c.dispose();
                this.f138338a.onComplete();
                this.f138340c.dispose();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138341d.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138340c.dispose();
            this.f138338a.onError(th);
            this.f138340c.dispose();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutObserver<T> extends AtomicLong implements Observer<T>, Disposable, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SequentialDisposable f138346c = new SequentialDisposable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f138347d = new AtomicReference();

        TimeoutObserver(Observer observer, Function function) {
            this.f138344a = observer;
            this.f138345b = function;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f138347d, disposable);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeout.TimeoutSelectorSupport
        public void b(long j3, Throwable th) {
            if (!compareAndSet(j3, Long.MAX_VALUE)) {
                RxJavaPlugins.s(th);
            } else {
                DisposableHelper.a(this.f138347d);
                this.f138344a.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.TimeoutSupport
        public void c(long j3) {
            if (compareAndSet(j3, Long.MAX_VALUE)) {
                DisposableHelper.a(this.f138347d);
                this.f138344a.onError(new TimeoutException());
            }
        }

        void d(ObservableSource observableSource) {
            if (observableSource != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.f138346c.a(timeoutConsumer)) {
                    observableSource.b(timeoutConsumer);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138347d);
            this.f138346c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b((Disposable) this.f138347d.get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            long j3 = get();
            if (j3 != Long.MAX_VALUE) {
                long j4 = 1 + j3;
                if (compareAndSet(j3, j4)) {
                    Disposable disposable = this.f138346c.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f138344a.h(obj);
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f138345b.apply(obj), "The itemTimeoutIndicator returned a null ObservableSource.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j4, this);
                        if (this.f138346c.a(timeoutConsumer)) {
                            observableSource.b(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        ((Disposable) this.f138347d.get()).dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.f138344a.onError(th);
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f138346c.dispose();
                this.f138344a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.s(th);
            } else {
                this.f138346c.dispose();
                this.f138344a.onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface TimeoutSelectorSupport extends ObservableTimeoutTimed.TimeoutSupport {
        void b(long j3, Throwable th);
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        if (this.f138335d == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(observer, this.f138334c);
            observer.a(timeoutObserver);
            timeoutObserver.d(this.f138333b);
            this.f137267a.b(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(observer, this.f138334c, this.f138335d);
        observer.a(timeoutFallbackObserver);
        timeoutFallbackObserver.d(this.f138333b);
        this.f137267a.b(timeoutFallbackObserver);
    }
}
