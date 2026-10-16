package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableMergeIterable extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterable f135122a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeCompletableObserver extends AtomicBoolean implements CompletableObserver {
        private static final long serialVersionUID = -7730517613164279224L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompositeDisposable f135123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompletableObserver f135124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f135125c;

        MergeCompletableObserver(CompletableObserver completableObserver, CompositeDisposable compositeDisposable, AtomicInteger atomicInteger) {
            this.f135124b = completableObserver;
            this.f135123a = compositeDisposable;
            this.f135125c = atomicInteger;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135123a.b(disposable);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f135125c.decrementAndGet() == 0 && compareAndSet(false, true)) {
                this.f135124b.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135123a.dispose();
            if (compareAndSet(false, true)) {
                this.f135124b.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.a(compositeDisposable);
        try {
            Iterator it = (Iterator) ObjectHelper.d(this.f135122a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            MergeCompletableObserver mergeCompletableObserver = new MergeCompletableObserver(completableObserver, compositeDisposable, atomicInteger);
            while (!compositeDisposable.e()) {
                try {
                    if (!it.hasNext()) {
                        mergeCompletableObserver.onComplete();
                        return;
                    }
                    if (compositeDisposable.e()) {
                        return;
                    }
                    try {
                        CompletableSource completableSource = (CompletableSource) ObjectHelper.d(it.next(), "The iterator returned a null CompletableSource");
                        if (compositeDisposable.e()) {
                            return;
                        }
                        atomicInteger.getAndIncrement();
                        completableSource.b(mergeCompletableObserver);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        compositeDisposable.dispose();
                        mergeCompletableObserver.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    compositeDisposable.dispose();
                    mergeCompletableObserver.onError(th2);
                    return;
                }
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            completableObserver.onError(th3);
        }
    }
}
