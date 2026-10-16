package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTakeLastOne<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeLastOneObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f138266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f138267c;

        TakeLastOneObserver(Observer observer) {
            this.f138265a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138266b, disposable)) {
                this.f138266b = disposable;
                this.f138265a.a(this);
            }
        }

        void b() {
            Object obj = this.f138267c;
            if (obj != null) {
                this.f138267c = null;
                this.f138265a.h(obj);
            }
            this.f138265a.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138267c = null;
            this.f138266b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138266b.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138267c = obj;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138267c = null;
            this.f138265a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new TakeLastOneObserver(observer));
    }
}
