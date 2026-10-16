package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableToListSingle<T, U extends Collection<? super T>> extends Single<U> implements FuseToObservable<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f138378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f138379b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Collection f138381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138382c;

        ToListObserver(SingleObserver singleObserver, Collection collection) {
            this.f138380a = singleObserver;
            this.f138381b = collection;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138382c, disposable)) {
                this.f138382c = disposable;
                this.f138380a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138382c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138382c.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138381b.add(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Collection collection = this.f138381b;
            this.f138381b = null;
            this.f138380a.onSuccess(collection);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138381b = null;
            this.f138380a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    public void c(SingleObserver singleObserver) {
        try {
            this.f138378a.b(new ToListObserver(singleObserver, (Collection) ObjectHelper.d(this.f138379b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.j(th, singleObserver);
        }
    }
}
