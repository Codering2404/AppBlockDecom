package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableReduceWithSingle<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f136129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f136130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f136131c;

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        try {
            this.f136129a.i(new FlowableReduceSeedSingle.ReduceSeedObserver(singleObserver, this.f136131c, ObjectHelper.d(this.f136130b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.j(th, singleObserver);
        }
    }
}
