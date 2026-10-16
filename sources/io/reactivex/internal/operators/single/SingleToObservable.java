package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleToObservable<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138942a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements SingleObserver<T> {
        private static final long serialVersionUID = 3786543492451018833L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138943c;

        SingleToObservableObserver(Observer observer) {
            super(observer);
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138943c, disposable)) {
                this.f138943c = disposable;
                this.f134971a.a(this);
            }
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            super.dispose();
            this.f138943c.dispose();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            g(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            c(obj);
        }
    }

    public SingleToObservable(SingleSource singleSource) {
        this.f138942a = singleSource;
    }

    public static SingleObserver A(Observer observer) {
        return new SingleToObservableObserver(observer);
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f138942a.b(A(observer));
    }
}
