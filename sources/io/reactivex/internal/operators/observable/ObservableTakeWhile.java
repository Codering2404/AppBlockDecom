package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTakeWhile<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f138295b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeWhileObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f138297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138298c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138299d;

        TakeWhileObserver(Observer observer, Predicate predicate) {
            this.f138296a = observer;
            this.f138297b = predicate;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138298c, disposable)) {
                this.f138298c = disposable;
                this.f138296a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138298c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138298c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138299d) {
                return;
            }
            try {
                if (this.f138297b.test(obj)) {
                    this.f138296a.h(obj);
                    return;
                }
                this.f138299d = true;
                this.f138298c.dispose();
                this.f138296a.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138298c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138299d) {
                return;
            }
            this.f138299d = true;
            this.f138296a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138299d) {
                RxJavaPlugins.s(th);
            } else {
                this.f138299d = true;
                this.f138296a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new TakeWhileObserver(observer, this.f138295b));
    }
}
