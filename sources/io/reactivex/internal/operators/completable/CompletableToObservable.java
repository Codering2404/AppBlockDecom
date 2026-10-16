package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableToObservable<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135180a;

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f135180a.b(new ObserverCompletableObserver(observer));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserverCompletableObserver extends BasicQueueDisposable<Void> implements CompletableObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f135181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f135182b;

        ObserverCompletableObserver(Observer observer) {
            this.f135181a = observer;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f135182b, disposable)) {
                this.f135182b = disposable;
                this.f135181a.a(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void poll() {
            return null;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135182b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135182b.e();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return true;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return i3 & 2;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f135181a.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135181a.onError(th);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
        }
    }
}
