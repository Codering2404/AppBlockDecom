package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableCollectSingle<T, U> extends Single<U> implements FuseToObservable<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f137443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiConsumer f137444c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CollectObserver<T, U> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f137445a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiConsumer f137446b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object f137447c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f137448d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f137449f;

        CollectObserver(SingleObserver singleObserver, Object obj, BiConsumer biConsumer) {
            this.f137445a = singleObserver;
            this.f137446b = biConsumer;
            this.f137447c = obj;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137448d, disposable)) {
                this.f137448d = disposable;
                this.f137445a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137448d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137448d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137449f) {
                return;
            }
            try {
                this.f137446b.accept(this.f137447c, obj);
            } catch (Throwable th) {
                this.f137448d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137449f) {
                return;
            }
            this.f137449f = true;
            this.f137445a.onSuccess(this.f137447c);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137449f) {
                RxJavaPlugins.s(th);
            } else {
                this.f137449f = true;
                this.f137445a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        try {
            this.f137442a.b(new CollectObserver(singleObserver, ObjectHelper.d(this.f137443b.call(), "The initialSupplier returned a null value"), this.f137444c));
        } catch (Throwable th) {
            EmptyDisposable.j(th, singleObserver);
        }
    }
}
