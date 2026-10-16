package io.reactivex.internal.operators.observable;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableConcatWithMaybe<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource f137519b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        MaybeSource f137521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f137522c;

        ConcatWithObserver(Observer observer, MaybeSource maybeSource) {
            this.f137520a = observer;
            this.f137521b = maybeSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (!DisposableHelper.g(this, disposable) || this.f137522c) {
                return;
            }
            this.f137520a.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137520a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137522c) {
                this.f137520a.onComplete();
                return;
            }
            this.f137522c = true;
            DisposableHelper.c(this, null);
            MaybeSource maybeSource = this.f137521b;
            this.f137521b = null;
            maybeSource.b(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137520a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f137520a.h(obj);
            this.f137520a.onComplete();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new ConcatWithObserver(observer, this.f137519b));
    }
}
