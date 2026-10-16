package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableConcatWithSingle<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SingleSource f137523b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatWithObserver<T> extends AtomicReference<Disposable> implements Observer<T>, SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -1953724749712440952L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SingleSource f137525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f137526c;

        ConcatWithObserver(Observer observer, SingleSource singleSource) {
            this.f137524a = observer;
            this.f137525b = singleSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (!DisposableHelper.g(this, disposable) || this.f137526c) {
                return;
            }
            this.f137524a.a(this);
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
            this.f137524a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137526c = true;
            DisposableHelper.c(this, null);
            SingleSource singleSource = this.f137525b;
            this.f137525b = null;
            singleSource.b(this);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137524a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f137524a.h(obj);
            this.f137524a.onComplete();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new ConcatWithObserver(observer, this.f137523b));
    }
}
