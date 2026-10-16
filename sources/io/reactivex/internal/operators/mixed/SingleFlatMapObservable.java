package io.reactivex.internal.operators.mixed;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleFlatMapObservable<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f137263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137264b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapObserver<T, R> extends AtomicReference<Disposable> implements Observer<R>, SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137266b;

        FlatMapObserver(Observer observer, Function function) {
            this.f137265a = observer;
            this.f137266b = function;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137265a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137265a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137265a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                ((ObservableSource) ObjectHelper.d(this.f137266b.apply(obj), "The mapper returned a null Publisher")).b(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137265a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        FlatMapObserver flatMapObserver = new FlatMapObserver(observer, this.f137264b);
        observer.a(flatMapObserver);
        this.f137263a.b(flatMapObserver);
    }
}
