package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableSubscribeOn extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f135152b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscribeOnObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SequentialDisposable f135154b = new SequentialDisposable();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompletableSource f135155c;

        SubscribeOnObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f135153a = completableObserver;
            this.f135155c = completableSource;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            this.f135154b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f135153a.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135153a.onError(th);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f135155c.b(this);
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(completableObserver, this.f135151a);
        completableObserver.a(subscribeOnObserver);
        subscribeOnObserver.f135154b.a(this.f135152b.d(subscribeOnObserver));
    }
}
