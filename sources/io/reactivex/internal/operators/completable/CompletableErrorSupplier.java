package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableErrorSupplier extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f135084a;

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        try {
            th = (Throwable) ObjectHelper.d(this.f135084a.call(), "The error returned is null");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptyDisposable.g(th, completableObserver);
    }
}
