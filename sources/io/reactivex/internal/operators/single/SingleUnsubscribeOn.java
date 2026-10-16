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
public final class SingleUnsubscribeOn<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f138945b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler f138947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138948c;

        UnsubscribeOnSingleObserver(SingleObserver singleObserver, Scheduler scheduler) {
            this.f138946a = singleObserver;
            this.f138947b = scheduler;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f138946a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            Disposable andSet = getAndSet(disposableHelper);
            if (andSet != disposableHelper) {
                this.f138948c = andSet;
                this.f138947b.d(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138946a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138946a.onSuccess(obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f138948c.dispose();
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138944a.b(new UnsubscribeOnSingleObserver(singleObserver, this.f138945b));
    }
}
