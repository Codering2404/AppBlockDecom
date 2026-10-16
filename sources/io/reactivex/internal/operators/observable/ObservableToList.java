package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableToList<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f138374b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ToListObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f138376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Collection f138377c;

        ToListObserver(Observer observer, Collection collection) {
            this.f138375a = observer;
            this.f138377c = collection;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138376b, disposable)) {
                this.f138376b = disposable;
                this.f138375a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138376b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138376b.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138377c.add(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Collection collection = this.f138377c;
            this.f138377c = null;
            this.f138375a.h(collection);
            this.f138375a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138377c = null;
            this.f138375a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        try {
            this.f137267a.b(new ToListObserver(observer, (Collection) ObjectHelper.d(this.f138374b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, observer);
        }
    }
}
