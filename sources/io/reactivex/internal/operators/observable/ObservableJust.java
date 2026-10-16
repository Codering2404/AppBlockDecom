package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableJust<T> extends Observable<T> implements ScalarCallable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f137882a;

    public ObservableJust(Object obj) {
        this.f137882a = obj;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f137882a;
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(observer, this.f137882a);
        observer.a(scalarDisposable);
        scalarDisposable.run();
    }
}
