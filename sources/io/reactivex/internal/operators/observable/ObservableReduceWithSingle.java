package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableReduceWithSingle<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f138005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f138006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f138007c;

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        try {
            this.f138005a.b(new ObservableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f138007c, ObjectHelper.d(this.f138006b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.j(th, singleObserver);
        }
    }
}
