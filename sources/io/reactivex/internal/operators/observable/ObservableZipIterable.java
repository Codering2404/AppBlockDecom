package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableZipIterable<T, U, V> extends Observable<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observable f138547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable f138548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f138549c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipIterableObserver<T, U, V> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138550a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator f138551b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BiFunction f138552c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f138553d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138554f;

        ZipIterableObserver(Observer observer, Iterator it, BiFunction biFunction) {
            this.f138550a = observer;
            this.f138551b = it;
            this.f138552c = biFunction;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138553d, disposable)) {
                this.f138553d = disposable;
                this.f138550a.a(this);
            }
        }

        void b(Throwable th) {
            this.f138554f = true;
            this.f138553d.dispose();
            this.f138550a.onError(th);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138553d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138553d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138554f) {
                return;
            }
            try {
                try {
                    this.f138550a.h(ObjectHelper.d(this.f138552c.apply(obj, ObjectHelper.d(this.f138551b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f138551b.hasNext()) {
                            return;
                        }
                        this.f138554f = true;
                        this.f138553d.dispose();
                        this.f138550a.onComplete();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        b(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    b(th2);
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                b(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138554f) {
                return;
            }
            this.f138554f = true;
            this.f138550a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138554f) {
                RxJavaPlugins.s(th);
            } else {
                this.f138554f = true;
                this.f138550a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        try {
            Iterator it = (Iterator) ObjectHelper.d(this.f138548b.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f138547a.b(new ZipIterableObserver(observer, it, this.f138549c));
                } else {
                    EmptyDisposable.c(observer);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.i(th, observer);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptyDisposable.i(th2, observer);
        }
    }
}
