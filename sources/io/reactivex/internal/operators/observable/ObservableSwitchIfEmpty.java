package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSwitchIfEmpty<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138231b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchIfEmptyObserver<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ObservableSource f138233b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138235d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SequentialDisposable f138234c = new SequentialDisposable();

        SwitchIfEmptyObserver(Observer observer, ObservableSource observableSource) {
            this.f138232a = observer;
            this.f138233b = observableSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f138234c.b(disposable);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138235d) {
                this.f138235d = false;
            }
            this.f138232a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f138235d) {
                this.f138232a.onComplete();
            } else {
                this.f138235d = false;
                this.f138233b.b(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138232a.onError(th);
        }
    }

    public ObservableSwitchIfEmpty(ObservableSource observableSource, ObservableSource observableSource2) {
        super(observableSource);
        this.f138231b = observableSource2;
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SwitchIfEmptyObserver switchIfEmptyObserver = new SwitchIfEmptyObserver(observer, this.f138231b);
        observer.a(switchIfEmptyObserver.f138234c);
        this.f137267a.b(switchIfEmptyObserver);
    }
}
