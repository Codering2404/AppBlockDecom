package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138255b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138256a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f138257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f138259d;

        TakeObserver(Observer observer, long j3) {
            this.f138256a = observer;
            this.f138259d = j3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138258c, disposable)) {
                this.f138258c = disposable;
                if (this.f138259d != 0) {
                    this.f138256a.a(this);
                    return;
                }
                this.f138257b = true;
                disposable.dispose();
                EmptyDisposable.c(this.f138256a);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138258c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138258c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138257b) {
                return;
            }
            long j3 = this.f138259d;
            long j4 = j3 - 1;
            this.f138259d = j4;
            if (j3 > 0) {
                boolean z2 = j4 == 0;
                this.f138256a.h(obj);
                if (z2) {
                    onComplete();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138257b) {
                return;
            }
            this.f138257b = true;
            this.f138258c.dispose();
            this.f138256a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138257b) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138257b = true;
            this.f138258c.dispose();
            this.f138256a.onError(th);
        }
    }

    public ObservableTake(ObservableSource observableSource, long j3) {
        super(observableSource);
        this.f138255b = j3;
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new TakeObserver(observer, this.f138255b));
    }
}
