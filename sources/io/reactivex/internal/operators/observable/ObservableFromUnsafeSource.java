package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFromUnsafeSource<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137751a;

    public ObservableFromUnsafeSource(ObservableSource observableSource) {
        this.f137751a = observableSource;
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137751a.b(observer);
    }
}
