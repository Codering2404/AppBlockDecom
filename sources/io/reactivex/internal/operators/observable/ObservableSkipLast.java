package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSkipLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f138191b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3807491841935125653L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f138193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138194c;

        SkipLastObserver(Observer observer, int i3) {
            super(i3);
            this.f138192a = observer;
            this.f138193b = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138194c, disposable)) {
                this.f138194c = disposable;
                this.f138192a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138194c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138194c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138193b == size()) {
                this.f138192a.h(poll());
            }
            offer(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138192a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138192a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new SkipLastObserver(observer, this.f138191b));
    }
}
