package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFromFuture<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Future f137738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f137739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f137740c;

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.a(deferredScalarDisposable);
        if (deferredScalarDisposable.e()) {
            return;
        }
        try {
            TimeUnit timeUnit = this.f137740c;
            deferredScalarDisposable.c(ObjectHelper.d(timeUnit != null ? this.f137738a.get(this.f137739b, timeUnit) : this.f137738a.get(), "Future returned null"));
        } catch (Throwable th) {
            Exceptions.b(th);
            if (deferredScalarDisposable.e()) {
                return;
            }
            observer.onError(th);
        }
    }
}
