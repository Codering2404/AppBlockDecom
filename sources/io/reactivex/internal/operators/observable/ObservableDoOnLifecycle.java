package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.observers.DisposableLambdaObserver;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDoOnLifecycle<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Consumer f137623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Action f137624c;

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new DisposableLambdaObserver(observer, this.f137623b, this.f137624c));
    }
}
