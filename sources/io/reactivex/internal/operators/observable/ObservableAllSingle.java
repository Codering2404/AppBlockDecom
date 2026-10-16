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
public final class ObservableAllSingle<T> extends Single<Boolean> implements FuseToObservable<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f137300b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AllObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f137301a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f137302b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137303c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f137304d;

        AllObserver(SingleObserver singleObserver, Predicate predicate) {
            this.f137301a = singleObserver;
            this.f137302b = predicate;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137303c, disposable)) {
                this.f137303c = disposable;
                this.f137301a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137303c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137303c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137304d) {
                return;
            }
            try {
                if (this.f137302b.test(obj)) {
                    return;
                }
                this.f137304d = true;
                this.f137303c.dispose();
                this.f137301a.onSuccess(Boolean.FALSE);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137303c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137304d) {
                return;
            }
            this.f137304d = true;
            this.f137301a.onSuccess(Boolean.TRUE);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137304d) {
                RxJavaPlugins.s(th);
            } else {
                this.f137304d = true;
                this.f137301a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f137299a.b(new AllObserver(singleObserver, this.f137300b));
    }
}
