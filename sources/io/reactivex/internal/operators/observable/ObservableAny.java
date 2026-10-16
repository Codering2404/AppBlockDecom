package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableAny<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f137314b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AnyObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f137316b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137317c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f137318d;

        AnyObserver(Observer observer, Predicate predicate) {
            this.f137315a = observer;
            this.f137316b = predicate;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137317c, disposable)) {
                this.f137317c = disposable;
                this.f137315a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137317c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137317c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137318d) {
                return;
            }
            try {
                if (this.f137316b.test(obj)) {
                    this.f137318d = true;
                    this.f137317c.dispose();
                    this.f137315a.h(Boolean.TRUE);
                    this.f137315a.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137317c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137318d) {
                return;
            }
            this.f137318d = true;
            this.f137315a.h(Boolean.FALSE);
            this.f137315a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137318d) {
                RxJavaPlugins.s(th);
            } else {
                this.f137318d = true;
                this.f137315a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new AnyObserver(observer, this.f137314b));
    }
}
