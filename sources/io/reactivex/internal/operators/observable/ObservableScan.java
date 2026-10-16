package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableScan<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BiFunction f138126b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScanObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f138128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138129c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f138130d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138131f;

        ScanObserver(Observer observer, BiFunction biFunction) {
            this.f138127a = observer;
            this.f138128b = biFunction;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138129c, disposable)) {
                this.f138129c = disposable;
                this.f138127a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138129c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138129c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138131f) {
                return;
            }
            Observer observer = this.f138127a;
            Object obj2 = this.f138130d;
            if (obj2 == null) {
                this.f138130d = obj;
                observer.h(obj);
                return;
            }
            try {
                Object objD = ObjectHelper.d(this.f138128b.apply(obj2, obj), "The value returned by the accumulator is null");
                this.f138130d = objD;
                observer.h(objD);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138129c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138131f) {
                return;
            }
            this.f138131f = true;
            this.f138127a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138131f) {
                RxJavaPlugins.s(th);
            } else {
                this.f138131f = true;
                this.f138127a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new ScanObserver(observer, this.f138126b));
    }
}
