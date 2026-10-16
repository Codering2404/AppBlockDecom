package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ConnectableObservable<T> extends Observable<T> {
    public abstract void A(Consumer consumer);
}
