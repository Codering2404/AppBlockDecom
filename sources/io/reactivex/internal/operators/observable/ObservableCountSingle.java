package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137530a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CountObserver implements Observer<Object>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f137531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f137532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f137533c;

        CountObserver(SingleObserver singleObserver) {
            this.f137531a = singleObserver;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137532b, disposable)) {
                this.f137532b = disposable;
                this.f137531a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137532b.dispose();
            this.f137532b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137532b.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137533c++;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137532b = DisposableHelper.DISPOSED;
            this.f137531a.onSuccess(Long.valueOf(this.f137533c));
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137532b = DisposableHelper.DISPOSED;
            this.f137531a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    public void c(SingleObserver singleObserver) {
        this.f137530a.b(new CountObserver(singleObserver));
    }
}
