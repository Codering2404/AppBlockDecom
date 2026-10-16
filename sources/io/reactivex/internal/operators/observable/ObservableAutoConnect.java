package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableAutoConnect<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ConnectableObservable f137325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f137326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f137327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicInteger f137328d;

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137325a.b(observer);
        if (this.f137328d.incrementAndGet() == this.f137326b) {
            this.f137325a.A(this.f137327c);
        }
    }
}
