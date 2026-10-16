package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleMap<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138894b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MapSingleObserver<T, R> implements SingleObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138896b;

        MapSingleObserver(SingleObserver singleObserver, Function function) {
            this.f138895a = singleObserver;
            this.f138896b = function;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            this.f138895a.a(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138895a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                this.f138895a.onSuccess(ObjectHelper.d(this.f138896b.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138893a.b(new MapSingleObserver(singleObserver, this.f138894b));
    }
}
