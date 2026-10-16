package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableTimeout extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f135163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f135164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f135165d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final CompletableSource f135166f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class DisposeTask implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f135167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompositeDisposable f135168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompletableObserver f135169c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class DisposeObserver implements CompletableObserver {
            DisposeObserver() {
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposeTask.this.f135168b.b(disposable);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                DisposeTask.this.f135168b.dispose();
                DisposeTask.this.f135169c.onComplete();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                DisposeTask.this.f135168b.dispose();
                DisposeTask.this.f135169c.onError(th);
            }
        }

        DisposeTask(AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, CompletableObserver completableObserver) {
            this.f135167a = atomicBoolean;
            this.f135168b = compositeDisposable;
            this.f135169c = completableObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f135167a.compareAndSet(false, true)) {
                this.f135168b.d();
                CompletableSource completableSource = CompletableTimeout.this.f135166f;
                if (completableSource != null) {
                    completableSource.b(new DisposeObserver());
                    return;
                }
                CompletableObserver completableObserver = this.f135169c;
                CompletableTimeout completableTimeout = CompletableTimeout.this;
                completableObserver.onError(new TimeoutException(ExceptionHelper.d(completableTimeout.f135163b, completableTimeout.f135164c)));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeOutObserver implements CompletableObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CompositeDisposable f135172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f135173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CompletableObserver f135174c;

        TimeOutObserver(CompositeDisposable compositeDisposable, AtomicBoolean atomicBoolean, CompletableObserver completableObserver) {
            this.f135172a = compositeDisposable;
            this.f135173b = atomicBoolean;
            this.f135174c = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135172a.b(disposable);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f135173b.compareAndSet(false, true)) {
                this.f135172a.dispose();
                this.f135174c.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (!this.f135173b.compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
            } else {
                this.f135172a.dispose();
                this.f135174c.onError(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.a(compositeDisposable);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        compositeDisposable.b(this.f135165d.f(new DisposeTask(atomicBoolean, compositeDisposable, completableObserver), this.f135163b, this.f135164c));
        this.f135162a.b(new TimeOutObserver(compositeDisposable, atomicBoolean, completableObserver));
    }
}
