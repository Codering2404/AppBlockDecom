package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableDelay extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f135054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f135055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f135056d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f135057f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Delay extends AtomicReference<Disposable> implements CompletableObserver, Runnable, Disposable {
        private static final long serialVersionUID = 465972761105851022L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f135059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f135060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler f135061d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f135062f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Throwable f135063g;

        Delay(CompletableObserver completableObserver, long j3, TimeUnit timeUnit, Scheduler scheduler, boolean z2) {
            this.f135058a = completableObserver;
            this.f135059b = j3;
            this.f135060c = timeUnit;
            this.f135061d = scheduler;
            this.f135062f = z2;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f135058a.a(this);
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
            DisposableHelper.c(this, this.f135061d.f(this, this.f135059b, this.f135060c));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135063g = th;
            DisposableHelper.c(this, this.f135061d.f(this, this.f135062f ? this.f135059b : 0L, this.f135060c));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f135063g;
            this.f135063g = null;
            if (th != null) {
                this.f135058a.onError(th);
            } else {
                this.f135058a.onComplete();
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135053a.b(new Delay(completableObserver, this.f135054b, this.f135055c, this.f135056d, this.f135057f));
    }
}
