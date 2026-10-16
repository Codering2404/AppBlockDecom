package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.observers.SerializedObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSerialized<T> extends AbstractObservableWithUpstream<T, T> {
    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new SerializedObserver(observer));
    }
}
