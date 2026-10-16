package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableMaterialize<T> extends AbstractObservableWithUpstream<T, Notification<T>> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MaterializeObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f137905b;

        MaterializeObserver(Observer observer) {
            this.f137904a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137905b, disposable)) {
                this.f137905b = disposable;
                this.f137904a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137905b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137905b.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137904a.h(Notification.c(obj));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137904a.h(Notification.a());
            this.f137904a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137904a.h(Notification.b(th));
            this.f137904a.onComplete();
        }
    }

    public ObservableMaterialize(ObservableSource observableSource) {
        super(observableSource);
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new MaterializeObserver(observer));
    }
}
