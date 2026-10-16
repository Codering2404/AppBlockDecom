package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableIgnoreElements<T> extends AbstractObservableWithUpstream<T, T> {
    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new IgnoreObservable(observer));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f137814b;

        IgnoreObservable(Observer observer) {
            this.f137813a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f137814b = disposable;
            this.f137813a.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137814b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137814b.e();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137813a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137813a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
        }
    }
}
