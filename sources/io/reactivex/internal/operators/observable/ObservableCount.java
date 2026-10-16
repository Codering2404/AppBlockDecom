package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CountObserver implements Observer<Object>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f137528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f137529c;

        CountObserver(Observer observer) {
            this.f137527a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137528b, disposable)) {
                this.f137528b = disposable;
                this.f137527a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137528b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137528b.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137529c++;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137527a.h(Long.valueOf(this.f137529c));
            this.f137527a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137527a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new CountObserver(observer));
    }
}
