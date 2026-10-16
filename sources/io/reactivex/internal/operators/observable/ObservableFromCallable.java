package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f137737a;

    @Override // java.util.concurrent.Callable
    public Object call() {
        return ObjectHelper.d(this.f137737a.call(), "The callable returned a null value");
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.a(deferredScalarDisposable);
        if (deferredScalarDisposable.e()) {
            return;
        }
        try {
            deferredScalarDisposable.c(ObjectHelper.d(this.f137737a.call(), "Callable returned null"));
        } catch (Throwable th) {
            Exceptions.b(th);
            if (deferredScalarDisposable.e()) {
                RxJavaPlugins.s(th);
            } else {
                observer.onError(th);
            }
        }
    }
}
