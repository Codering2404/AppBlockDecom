package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ConnectableFlowable<T> extends Flowable<T> {
    public abstract void A(Consumer consumer);
}
