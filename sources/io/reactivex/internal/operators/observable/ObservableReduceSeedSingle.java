package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableReduceSeedSingle<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f137999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f138000c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReduceSeedObserver<T, R> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f138002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f138003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f138004d;

        ReduceSeedObserver(SingleObserver singleObserver, BiFunction biFunction, Object obj) {
            this.f138001a = singleObserver;
            this.f138003c = obj;
            this.f138002b = biFunction;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138004d, disposable)) {
                this.f138004d = disposable;
                this.f138001a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138004d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138004d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            Object obj2 = this.f138003c;
            if (obj2 != null) {
                try {
                    this.f138003c = ObjectHelper.d(this.f138002b.apply(obj2, obj), "The reducer returned a null value");
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f138004d.dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Object obj = this.f138003c;
            if (obj != null) {
                this.f138003c = null;
                this.f138001a.onSuccess(obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138003c == null) {
                RxJavaPlugins.s(th);
            } else {
                this.f138003c = null;
                this.f138001a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f137998a.b(new ReduceSeedObserver(singleObserver, this.f138000c, this.f137999b));
    }
}
