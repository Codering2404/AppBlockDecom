package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableTimer extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f135175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TimeUnit f135176b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Scheduler f135177c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 3167244060586201109L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135178a;

        TimerDisposable(CompletableObserver completableObserver) {
            this.f135178a = completableObserver;
        }

        void a(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f135178a.onComplete();
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(completableObserver);
        completableObserver.a(timerDisposable);
        timerDisposable.a(this.f135177c.f(timerDisposable, this.f135175a, this.f135176b));
    }
}
