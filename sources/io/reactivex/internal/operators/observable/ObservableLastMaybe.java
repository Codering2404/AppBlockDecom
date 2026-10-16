package io.reactivex.internal.operators.observable;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableLastMaybe<T> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137883a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LastObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f137884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f137885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f137886c;

        LastObserver(MaybeObserver maybeObserver) {
            this.f137884a = maybeObserver;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137885b, disposable)) {
                this.f137885b = disposable;
                this.f137884a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137885b.dispose();
            this.f137885b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137885b == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137886c = obj;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137885b = DisposableHelper.DISPOSED;
            Object obj = this.f137886c;
            if (obj == null) {
                this.f137884a.onComplete();
            } else {
                this.f137886c = null;
                this.f137884a.onSuccess(obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137885b = DisposableHelper.DISPOSED;
            this.f137886c = null;
            this.f137884a.onError(th);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f137883a.b(new LastObserver(maybeObserver));
    }
}
