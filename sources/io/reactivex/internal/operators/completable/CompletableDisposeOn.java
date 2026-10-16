package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableDisposeOn extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f135068b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DisposeOnObserver implements CompletableObserver, Disposable, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler f135070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f135071c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f135072d;

        DisposeOnObserver(CompletableObserver completableObserver, Scheduler scheduler) {
            this.f135069a = completableObserver;
            this.f135070b = scheduler;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f135071c, disposable)) {
                this.f135071c = disposable;
                this.f135069a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135072d = true;
            this.f135070b.d(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135072d;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f135072d) {
                return;
            }
            this.f135069a.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.f135072d) {
                RxJavaPlugins.s(th);
            } else {
                this.f135069a.onError(th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f135071c.dispose();
            this.f135071c = DisposableHelper.DISPOSED;
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135067a.b(new DisposeOnObserver(completableObserver, this.f135068b));
    }
}
