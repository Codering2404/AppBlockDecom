package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleTimer extends Single<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f138936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TimeUnit f138937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Scheduler f138938c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 8465401857522493082L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138939a;

        TimerDisposable(SingleObserver singleObserver) {
            this.f138939a = singleObserver;
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
            this.f138939a.onSuccess(0L);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.a(timerDisposable);
        timerDisposable.a(this.f138938c.f(timerDisposable, this.f138936a, this.f138937b));
    }
}
