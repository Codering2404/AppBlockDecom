package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleObserveOn<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f138900b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler f138902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f138903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Throwable f138904d;

        ObserveOnSingleObserver(SingleObserver singleObserver, Scheduler scheduler) {
            this.f138901a = singleObserver;
            this.f138902b = scheduler;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f138901a.a(this);
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

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138904d = th;
            DisposableHelper.c(this, this.f138902b.d(this));
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138903c = obj;
            DisposableHelper.c(this, this.f138902b.d(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f138904d;
            if (th != null) {
                this.f138901a.onError(th);
            } else {
                this.f138901a.onSuccess(this.f138903c);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138899a.b(new ObserveOnSingleObserver(singleObserver, this.f138900b));
    }
}
