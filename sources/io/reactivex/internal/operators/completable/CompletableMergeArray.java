package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableMergeArray extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource[] f135112a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InnerCompletableObserver extends AtomicInteger implements CompletableObserver {
        private static final long serialVersionUID = -8360547806504310570L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicBoolean f135114b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompositeDisposable f135115c;

        InnerCompletableObserver(CompletableObserver completableObserver, AtomicBoolean atomicBoolean, CompositeDisposable compositeDisposable, int i3) {
            this.f135113a = completableObserver;
            this.f135114b = atomicBoolean;
            this.f135115c = compositeDisposable;
            lazySet(i3);
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135115c.b(disposable);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (decrementAndGet() == 0 && this.f135114b.compareAndSet(false, true)) {
                this.f135113a.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135115c.dispose();
            if (this.f135114b.compareAndSet(false, true)) {
                this.f135113a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        InnerCompletableObserver innerCompletableObserver = new InnerCompletableObserver(completableObserver, new AtomicBoolean(), compositeDisposable, this.f135112a.length + 1);
        completableObserver.a(compositeDisposable);
        for (CompletableSource completableSource : this.f135112a) {
            if (compositeDisposable.e()) {
                return;
            }
            if (completableSource == null) {
                compositeDisposable.dispose();
                innerCompletableObserver.onError(new NullPointerException("A completable source is null"));
                return;
            }
            completableSource.b(innerCompletableObserver);
        }
        innerCompletableObserver.onComplete();
    }
}
