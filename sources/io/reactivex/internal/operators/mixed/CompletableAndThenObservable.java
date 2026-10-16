package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableAndThenObservable<R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f137052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f137053b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AndThenObservableObserver<R> extends AtomicReference<Disposable> implements Observer<R>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ObservableSource f137055b;

        AndThenObservableObserver(Observer observer, ObservableSource observableSource) {
            this.f137055b = observableSource;
            this.f137054a = observer;
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
            this.f137054a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ObservableSource observableSource = this.f137055b;
            if (observableSource == null) {
                this.f137054a.onComplete();
            } else {
                this.f137055b = null;
                observableSource.b(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137054a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(observer, this.f137053b);
        observer.a(andThenObservableObserver);
        this.f137052a.b(andThenObservableObserver);
    }
}
