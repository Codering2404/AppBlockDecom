package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableElementAtSingle<T> extends Single<T> implements FuseToObservable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f137643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f137644c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f137645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f137647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f137648d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f137649f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f137650g;

        ElementAtObserver(SingleObserver singleObserver, long j3, Object obj) {
            this.f137645a = singleObserver;
            this.f137646b = j3;
            this.f137647c = obj;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137648d, disposable)) {
                this.f137648d = disposable;
                this.f137645a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137648d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137648d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137650g) {
                return;
            }
            long j3 = this.f137649f;
            if (j3 != this.f137646b) {
                this.f137649f = j3 + 1;
                return;
            }
            this.f137650g = true;
            this.f137648d.dispose();
            this.f137645a.onSuccess(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137650g) {
                return;
            }
            this.f137650g = true;
            Object obj = this.f137647c;
            if (obj != null) {
                this.f137645a.onSuccess(obj);
            } else {
                this.f137645a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137650g) {
                RxJavaPlugins.s(th);
            } else {
                this.f137650g = true;
                this.f137645a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    public void c(SingleObserver singleObserver) {
        this.f137642a.b(new ElementAtObserver(singleObserver, this.f137643b, this.f137644c));
    }
}
