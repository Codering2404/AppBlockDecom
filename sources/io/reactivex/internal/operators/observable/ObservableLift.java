package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableOperator;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableLift<R, T> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableOperator f137893b;

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        try {
            this.f137267a.b((Observer) ObjectHelper.d(this.f137893b.a(observer), "Operator " + this.f137893b + " returned a null Observer"));
        } catch (NullPointerException e3) {
            throw e3;
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
