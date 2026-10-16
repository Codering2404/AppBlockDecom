package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableEmpty extends Observable<Object> implements ScalarCallable<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Observable f137651a = new ObservableEmpty();

    private ObservableEmpty() {
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        EmptyDisposable.c(observer);
    }
}
