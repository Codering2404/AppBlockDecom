package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f138383b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1015244841293359600L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler f138385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138386c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class DisposeTask implements Runnable {
            DisposeTask() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeObserver.this.f138386c.dispose();
            }
        }

        UnsubscribeObserver(Observer observer, Scheduler scheduler) {
            this.f138384a = observer;
            this.f138385b = scheduler;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138386c, disposable)) {
                this.f138386c = disposable;
                this.f138384a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.f138385b.d(new DisposeTask());
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (get()) {
                return;
            }
            this.f138384a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (get()) {
                return;
            }
            this.f138384a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.s(th);
            } else {
                this.f138384a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new UnsubscribeObserver(observer, this.f138383b));
    }
}
