package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableScanSeed<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BiFunction f138132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable f138133c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScanSeedObserver<T, R> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f138135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f138136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f138137d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138138f;

        ScanSeedObserver(Observer observer, BiFunction biFunction, Object obj) {
            this.f138134a = observer;
            this.f138135b = biFunction;
            this.f138136c = obj;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138137d, disposable)) {
                this.f138137d = disposable;
                this.f138134a.a(this);
                this.f138134a.h(this.f138136c);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138137d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138137d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138138f) {
                return;
            }
            try {
                Object objD = ObjectHelper.d(this.f138135b.apply(this.f138136c, obj), "The accumulator returned a null value");
                this.f138136c = objD;
                this.f138134a.h(objD);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138137d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138138f) {
                return;
            }
            this.f138138f = true;
            this.f138134a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138138f) {
                RxJavaPlugins.s(th);
            } else {
                this.f138138f = true;
                this.f138134a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        try {
            this.f137267a.b(new ScanSeedObserver(observer, this.f138132b, ObjectHelper.d(this.f138133c.call(), "The seed supplied is null")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, observer);
        }
    }
}
