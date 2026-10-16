package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableLastSingle<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f137888b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LastObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f137889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f137890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f137892d;

        LastObserver(SingleObserver singleObserver, Object obj) {
            this.f137889a = singleObserver;
            this.f137890b = obj;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137891c, disposable)) {
                this.f137891c = disposable;
                this.f137889a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137891c.dispose();
            this.f137891c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137891c == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137892d = obj;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137891c = DisposableHelper.DISPOSED;
            Object obj = this.f137892d;
            if (obj != null) {
                this.f137892d = null;
                this.f137889a.onSuccess(obj);
                return;
            }
            Object obj2 = this.f137890b;
            if (obj2 != null) {
                this.f137889a.onSuccess(obj2);
            } else {
                this.f137889a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137891c = DisposableHelper.DISPOSED;
            this.f137892d = null;
            this.f137889a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f137887a.b(new LastObserver(singleObserver, this.f137888b));
    }
}
