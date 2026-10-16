package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDetach<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DetachObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Observer f137592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f137593b;

        DetachObserver(Observer observer) {
            this.f137592a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137593b, disposable)) {
                this.f137593b = disposable;
                this.f137592a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Disposable disposable = this.f137593b;
            this.f137593b = EmptyComponent.INSTANCE;
            this.f137592a = EmptyComponent.b();
            disposable.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137593b.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137592a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Observer observer = this.f137592a;
            this.f137593b = EmptyComponent.INSTANCE;
            this.f137592a = EmptyComponent.b();
            observer.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Observer observer = this.f137592a;
            this.f137593b = EmptyComponent.INSTANCE;
            this.f137592a = EmptyComponent.b();
            observer.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new DetachObserver(observer));
    }
}
