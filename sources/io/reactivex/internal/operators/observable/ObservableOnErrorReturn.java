package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableOnErrorReturn<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137959b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnErrorReturnObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137962c;

        OnErrorReturnObserver(Observer observer, Function function) {
            this.f137960a = observer;
            this.f137961b = function;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137962c, disposable)) {
                this.f137962c = disposable;
                this.f137960a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137962c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137962c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137960a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137960a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                Object objApply = this.f137961b.apply(th);
                if (objApply != null) {
                    this.f137960a.h(objApply);
                    this.f137960a.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f137960a.onError(nullPointerException);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f137960a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new OnErrorReturnObserver(observer, this.f137959b));
    }
}
