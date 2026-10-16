package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableObserveOn extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f135128b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserveOnCompletableObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler f135130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Throwable f135131c;

        ObserveOnCompletableObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f135129a = completableObserver;
            this.f135130b = scheduler;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f135129a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            DisposableHelper.c(this, this.f135130b.d(this));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135131c = th;
            DisposableHelper.c(this, this.f135130b.d(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f135131c;
            if (th == null) {
                this.f135129a.onComplete();
            } else {
                this.f135131c = null;
                this.f135129a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135127a.b(new ObserveOnCompletableObserver(completableObserver, this.f135128b));
    }
}
