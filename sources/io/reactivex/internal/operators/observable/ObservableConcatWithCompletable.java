package io.reactivex.internal.operators.observable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableConcatWithCompletable<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final CompletableSource f137515b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, CompletableObserver, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CompletableSource f137517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f137518c;

        ConcatWithObserver(Observer observer, CompletableSource completableSource) {
            this.f137516a = observer;
            this.f137517b = completableSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (!DisposableHelper.g(this, disposable) || this.f137518c) {
                return;
            }
            this.f137516a.a(this);
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
            this.f137516a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137518c) {
                this.f137516a.onComplete();
                return;
            }
            this.f137518c = true;
            DisposableHelper.c(this, null);
            CompletableSource completableSource = this.f137517b;
            this.f137517b = null;
            completableSource.b(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137516a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new ConcatWithObserver(observer, this.f137515b));
    }
}
