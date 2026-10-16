package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOperator;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleLift<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SingleOperator f138892b;

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        try {
            this.f138891a.b((SingleObserver) ObjectHelper.d(this.f138892b.a(singleObserver), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.j(th, singleObserver);
        }
    }
}
