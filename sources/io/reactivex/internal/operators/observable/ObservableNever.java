package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableNever extends Observable<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Observable f137936a = new ObservableNever();

    private ObservableNever() {
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        observer.a(EmptyDisposable.NEVER);
    }
}
