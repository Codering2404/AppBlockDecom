package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableAll<T> extends AbstractObservableWithUpstream<T, Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f137294b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AllObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f137296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f137298d;

        AllObserver(Observer observer, Predicate predicate) {
            this.f137295a = observer;
            this.f137296b = predicate;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137297c, disposable)) {
                this.f137297c = disposable;
                this.f137295a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137297c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137297c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137298d) {
                return;
            }
            try {
                if (this.f137296b.test(obj)) {
                    return;
                }
                this.f137298d = true;
                this.f137297c.dispose();
                this.f137295a.h(Boolean.FALSE);
                this.f137295a.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137297c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137298d) {
                return;
            }
            this.f137298d = true;
            this.f137295a.h(Boolean.TRUE);
            this.f137295a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137298d) {
                RxJavaPlugins.s(th);
            } else {
                this.f137298d = true;
                this.f137295a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new AllObserver(observer, this.f137294b));
    }
}
