package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138187b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f138189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138190c;

        SkipObserver(Observer observer, long j3) {
            this.f138188a = observer;
            this.f138189b = j3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138190c, disposable)) {
                this.f138190c = disposable;
                this.f138188a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138190c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138190c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            long j3 = this.f138189b;
            if (j3 != 0) {
                this.f138189b = j3 - 1;
            } else {
                this.f138188a.h(obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138188a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138188a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new SkipObserver(observer, this.f138187b));
    }
}
