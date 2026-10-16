package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFlattenIterable<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137727b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlattenIterableObserver<T, R> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137730c;

        FlattenIterableObserver(Observer observer, Function function) {
            this.f137728a = observer;
            this.f137729b = function;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137730c, disposable)) {
                this.f137730c = disposable;
                this.f137728a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137730c.dispose();
            this.f137730c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137730c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137730c == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                Iterator<T> it = ((Iterable) this.f137729b.apply(obj)).iterator();
                Observer observer = this.f137728a;
                while (it.hasNext()) {
                    try {
                        try {
                            observer.h(ObjectHelper.d(it.next(), "The iterator returned a null value"));
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.f137730c.dispose();
                            onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        this.f137730c.dispose();
                        onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                this.f137730c.dispose();
                onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Disposable disposable = this.f137730c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                return;
            }
            this.f137730c = disposableHelper;
            this.f137728a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Disposable disposable = this.f137730c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.s(th);
            } else {
                this.f137730c = disposableHelper;
                this.f137728a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new FlattenIterableObserver(observer, this.f137727b));
    }
}
