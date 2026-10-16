package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleOnErrorReturn<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f138907c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class OnErrorReturn implements SingleObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SingleObserver f138908a;

        OnErrorReturn(SingleObserver singleObserver) {
            this.f138908a = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            this.f138908a.a(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            Object objApply;
            SingleOnErrorReturn singleOnErrorReturn = SingleOnErrorReturn.this;
            Function function = singleOnErrorReturn.f138906b;
            if (function != null) {
                try {
                    objApply = function.apply(th);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f138908a.onError(new CompositeException(th, th2));
                    return;
                }
            } else {
                objApply = singleOnErrorReturn.f138907c;
            }
            if (objApply != null) {
                this.f138908a.onSuccess(objApply);
                return;
            }
            NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
            nullPointerException.initCause(th);
            this.f138908a.onError(nullPointerException);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138908a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138905a.b(new OnErrorReturn(singleObserver));
    }
}
