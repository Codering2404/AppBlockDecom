package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleSubscribeOn<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f138915b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SequentialDisposable f138917b = new SequentialDisposable();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SingleSource f138918c;

        SubscribeOnObserver(SingleObserver singleObserver, SingleSource singleSource) {
            this.f138916a = singleObserver;
            this.f138918c = singleSource;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            this.f138917b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138916a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138916a.onSuccess(obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f138918c.b(this);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.f138914a);
        singleObserver.a(subscribeOnObserver);
        subscribeOnObserver.f138917b.a(this.f138915b.d(subscribeOnObserver));
    }
}
