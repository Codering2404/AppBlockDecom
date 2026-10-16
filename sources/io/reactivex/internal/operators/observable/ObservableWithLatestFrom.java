package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BiFunction f138509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ObservableSource f138510c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -312246233408980075L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f138512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f138513c = new AtomicReference();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f138514d = new AtomicReference();

        WithLatestFromObserver(Observer observer, BiFunction biFunction) {
            this.f138511a = observer;
            this.f138512b = biFunction;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f138513c, disposable);
        }

        public void b(Throwable th) {
            DisposableHelper.a(this.f138513c);
            this.f138511a.onError(th);
        }

        public boolean c(Disposable disposable) {
            return DisposableHelper.g(this.f138514d, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138513c);
            DisposableHelper.a(this.f138514d);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b((Disposable) this.f138513c.get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            U u2 = get();
            if (u2 != null) {
                try {
                    this.f138511a.h(ObjectHelper.d(this.f138512b.apply(obj, u2), "The combiner returned a null value"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    dispose();
                    this.f138511a.onError(th);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this.f138514d);
            this.f138511a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f138514d);
            this.f138511a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(serializedObserver, this.f138509b);
        serializedObserver.a(withLatestFromObserver);
        this.f138510c.b(new WithLatestFromOtherObserver(withLatestFromObserver));
        this.f137267a.b(withLatestFromObserver);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class WithLatestFromOtherObserver implements Observer<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WithLatestFromObserver f138515a;

        WithLatestFromOtherObserver(WithLatestFromObserver withLatestFromObserver) {
            this.f138515a = withLatestFromObserver;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f138515a.c(disposable);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138515a.lazySet(obj);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138515a.b(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }
    }
}
