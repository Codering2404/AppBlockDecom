package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableAnySingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f137320b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f137321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f137322b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f137324d;

        AnyObserver(SingleObserver singleObserver, Predicate predicate) {
            this.f137321a = singleObserver;
            this.f137322b = predicate;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137323c, disposable)) {
                this.f137323c = disposable;
                this.f137321a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137323c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137323c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137324d) {
                return;
            }
            try {
                if (this.f137322b.test(obj)) {
                    this.f137324d = true;
                    this.f137323c.dispose();
                    this.f137321a.onSuccess(Boolean.TRUE);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137323c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137324d) {
                return;
            }
            this.f137324d = true;
            this.f137321a.onSuccess(Boolean.FALSE);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137324d) {
                RxJavaPlugins.s(th);
            } else {
                this.f137324d = true;
                this.f137321a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f137319a.b(new AnyObserver(singleObserver, this.f137320b));
    }
}
