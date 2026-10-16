package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable f137898d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f137901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Callable f137902d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f137903f;

        MapNotificationObserver(Observer observer, Function function, Function function2, Callable callable) {
            this.f137899a = observer;
            this.f137900b = function;
            this.f137901c = function2;
            this.f137902d = callable;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137903f, disposable)) {
                this.f137903f = disposable;
                this.f137899a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137903f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137903f.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            try {
                this.f137899a.h((ObservableSource) ObjectHelper.d(this.f137900b.apply(obj), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137899a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            try {
                this.f137899a.h((ObservableSource) ObjectHelper.d(this.f137902d.call(), "The onComplete ObservableSource returned is null"));
                this.f137899a.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137899a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                this.f137899a.h((ObservableSource) ObjectHelper.d(this.f137901c.apply(th), "The onError ObservableSource returned is null"));
                this.f137899a.onComplete();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f137899a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new MapNotificationObserver(observer, this.f137896b, this.f137897c, this.f137898d));
    }
}
