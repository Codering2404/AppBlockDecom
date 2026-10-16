package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableMergeDelayErrorIterable extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterable f135121a;

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        completableObserver.a(compositeDisposable);
        try {
            Iterator it = (Iterator) ObjectHelper.d(this.f135121a.iterator(), "The source iterator returned is null");
            AtomicInteger atomicInteger = new AtomicInteger(1);
            AtomicThrowable atomicThrowable = new AtomicThrowable();
            while (!compositeDisposable.e()) {
                try {
                    if (it.hasNext()) {
                        if (compositeDisposable.e()) {
                            return;
                        }
                        try {
                            CompletableSource completableSource = (CompletableSource) ObjectHelper.d(it.next(), "The iterator returned a null CompletableSource");
                            if (compositeDisposable.e()) {
                                return;
                            }
                            atomicInteger.getAndIncrement();
                            completableSource.b(new CompletableMergeDelayErrorArray.MergeInnerCompletableObserver(completableObserver, compositeDisposable, atomicThrowable, atomicInteger));
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            atomicThrowable.a(th);
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    atomicThrowable.a(th2);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    Throwable thB = atomicThrowable.b();
                    if (thB == null) {
                        completableObserver.onComplete();
                        return;
                    } else {
                        completableObserver.onError(thB);
                        return;
                    }
                }
                return;
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            completableObserver.onError(th3);
        }
    }
}
