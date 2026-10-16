package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleError<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f138831a;

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        try {
            th = (Throwable) ObjectHelper.d(this.f138831a.call(), "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptyDisposable.j(th, singleObserver);
    }
}
