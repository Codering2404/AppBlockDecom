package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableFromObservable<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f135087a;

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135087a.b(new CompletableFromObservableObserver(completableObserver));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CompletableFromObservableObserver<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135088a;

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f135088a = completableObserver;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f135088a.a(disposable);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f135088a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f135088a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
        }
    }
}
