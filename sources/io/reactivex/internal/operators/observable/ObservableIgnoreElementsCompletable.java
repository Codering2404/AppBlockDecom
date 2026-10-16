package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137815a;

    public ObservableIgnoreElementsCompletable(ObservableSource observableSource) {
        this.f137815a = observableSource;
    }

    @Override // io.reactivex.Completable
    public void c(CompletableObserver completableObserver) {
        this.f137815a.b(new IgnoreObservable(completableObserver));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IgnoreObservable<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f137816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f137817b;

        IgnoreObservable(CompletableObserver completableObserver) {
            this.f137816a = completableObserver;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f137817b = disposable;
            this.f137816a.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137817b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137817b.e();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137816a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137816a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
        }
    }
}
