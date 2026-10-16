package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.observers.DeferredScalarDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f137019a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        private static final long serialVersionUID = 7603343402964826922L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137020c;

        MaybeToObservableObserver(Observer observer) {
            super(observer);
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137020c, disposable)) {
                this.f137020c = disposable;
                this.f134971a.a(this);
            }
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            super.dispose();
            this.f137020c.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            g(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            c(obj);
        }
    }

    public static MaybeObserver A(Observer observer) {
        return new MaybeToObservableObserver(observer);
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137019a.b(A(observer));
    }
}
