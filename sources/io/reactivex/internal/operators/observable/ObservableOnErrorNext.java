package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableOnErrorNext<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137952c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnErrorNextObserver<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SequentialDisposable f137956d = new SequentialDisposable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f137957f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f137958g;

        OnErrorNextObserver(Observer observer, Function function, boolean z2) {
            this.f137953a = observer;
            this.f137954b = function;
            this.f137955c = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f137956d.a(disposable);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137958g) {
                return;
            }
            this.f137953a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137958g) {
                return;
            }
            this.f137958g = true;
            this.f137957f = true;
            this.f137953a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137957f) {
                if (this.f137958g) {
                    RxJavaPlugins.s(th);
                    return;
                } else {
                    this.f137953a.onError(th);
                    return;
                }
            }
            this.f137957f = true;
            if (this.f137955c && !(th instanceof Exception)) {
                this.f137953a.onError(th);
                return;
            }
            try {
                ObservableSource observableSource = (ObservableSource) this.f137954b.apply(th);
                if (observableSource != null) {
                    observableSource.b(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.f137953a.onError(nullPointerException);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f137953a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        OnErrorNextObserver onErrorNextObserver = new OnErrorNextObserver(observer, this.f137951b, this.f137952c);
        observer.a(onErrorNextObserver.f137956d);
        this.f137267a.b(onErrorNextObserver);
    }
}
