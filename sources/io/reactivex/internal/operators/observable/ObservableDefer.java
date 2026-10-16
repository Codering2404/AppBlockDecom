package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDefer<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f137564a;

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        try {
            ((ObservableSource) ObjectHelper.d(this.f137564a.call(), "null ObservableSource supplied")).b(observer);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, observer);
        }
    }
}
