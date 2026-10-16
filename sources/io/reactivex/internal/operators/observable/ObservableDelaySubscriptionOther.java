package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f137581b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class DelayObserver implements Observer<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SequentialDisposable f137582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Observer f137583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f137584c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OnComplete implements Observer<T> {
            OnComplete() {
            }

            @Override // io.reactivex.Observer
            public void a(Disposable disposable) {
                DelayObserver.this.f137582a.b(disposable);
            }

            @Override // io.reactivex.Observer
            public void h(Object obj) {
                DelayObserver.this.f137583b.h(obj);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                DelayObserver.this.f137583b.onComplete();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                DelayObserver.this.f137583b.onError(th);
            }
        }

        DelayObserver(SequentialDisposable sequentialDisposable, Observer observer) {
            this.f137582a = sequentialDisposable;
            this.f137583b = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f137582a.b(disposable);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137584c) {
                return;
            }
            this.f137584c = true;
            ObservableDelaySubscriptionOther.this.f137580a.b(new OnComplete());
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137584c) {
                RxJavaPlugins.s(th);
            } else {
                this.f137584c = true;
                this.f137583b.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.a(sequentialDisposable);
        this.f137581b.b(new DelayObserver(sequentialDisposable, observer));
    }
}
