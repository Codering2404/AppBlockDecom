package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableCollect<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f137435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiConsumer f137436c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiConsumer f137438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f137439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f137440d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f137441f;

        CollectObserver(Observer observer, Object obj, BiConsumer biConsumer) {
            this.f137437a = observer;
            this.f137438b = biConsumer;
            this.f137439c = obj;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137440d, disposable)) {
                this.f137440d = disposable;
                this.f137437a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137440d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137440d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137441f) {
                return;
            }
            try {
                this.f137438b.accept(this.f137439c, obj);
            } catch (Throwable th) {
                this.f137440d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137441f) {
                return;
            }
            this.f137441f = true;
            this.f137437a.h(this.f137439c);
            this.f137437a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137441f) {
                RxJavaPlugins.s(th);
            } else {
                this.f137441f = true;
                this.f137437a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        try {
            this.f137267a.b(new CollectObserver(observer, ObjectHelper.d(this.f137435b.call(), "The initialSupplier returned a null value"), this.f137436c));
        } catch (Throwable th) {
            EmptyDisposable.i(th, observer);
        }
    }
}
