package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTakeLast<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f138260b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeLastObserver<T> extends ArrayDeque<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 7240042530241604978L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f138262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f138264d;

        TakeLastObserver(Observer observer, int i3) {
            this.f138261a = observer;
            this.f138262b = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138263c, disposable)) {
                this.f138263c = disposable;
                this.f138261a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138264d) {
                return;
            }
            this.f138264d = true;
            this.f138263c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138264d;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138262b == size()) {
                poll();
            }
            offer(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Observer observer = this.f138261a;
            while (!this.f138264d) {
                T tPoll = poll();
                if (tPoll == null) {
                    if (this.f138264d) {
                        return;
                    }
                    observer.onComplete();
                    return;
                }
                observer.h(tPoll);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138261a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new TakeLastObserver(observer, this.f138260b));
    }
}
