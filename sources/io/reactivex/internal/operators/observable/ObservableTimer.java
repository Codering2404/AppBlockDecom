package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTimer extends Observable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Scheduler f138370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f138372c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138373a;

        TimerObserver(Observer observer) {
            this.f138373a = observer;
        }

        public void a(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e()) {
                return;
            }
            this.f138373a.h(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.f138373a.onComplete();
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.a(timerObserver);
        timerObserver.a(this.f138370a.f(timerObserver, this.f138371b, this.f138372c));
    }
}
