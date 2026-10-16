package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeTimer extends Maybe<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f137013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final TimeUnit f137014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Scheduler f137015c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        private static final long serialVersionUID = 2875964065294031672L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f137016a;

        TimerDisposable(MaybeObserver maybeObserver) {
            this.f137016a = maybeObserver;
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
            this.f137016a.onSuccess(0L);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(maybeObserver);
        maybeObserver.a(timerDisposable);
        timerDisposable.a(this.f137015c.f(timerDisposable, this.f137013a, this.f137014b));
    }
}
