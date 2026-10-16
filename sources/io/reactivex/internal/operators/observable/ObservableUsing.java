package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableUsing<T, D> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f138388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f138390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f138391d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UsingObserver<T, D> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = 5904473792286235046L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f138393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Consumer f138394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f138395d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f138396f;

        UsingObserver(Observer observer, Object obj, Consumer consumer, boolean z2) {
            this.f138392a = observer;
            this.f138393b = obj;
            this.f138394c = consumer;
            this.f138395d = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138396f, disposable)) {
                this.f138396f = disposable;
                this.f138392a.a(this);
            }
        }

        void b() {
            if (compareAndSet(false, true)) {
                try {
                    this.f138394c.accept(this.f138393b);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            b();
            this.f138396f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138392a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (!this.f138395d) {
                this.f138392a.onComplete();
                this.f138396f.dispose();
                b();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.f138394c.accept(this.f138393b);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f138392a.onError(th);
                    return;
                }
            }
            this.f138396f.dispose();
            this.f138392a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f138395d) {
                this.f138392a.onError(th);
                this.f138396f.dispose();
                b();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.f138394c.accept(this.f138393b);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.f138396f.dispose();
            this.f138392a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        try {
            Object objCall = this.f138388a.call();
            try {
                ((ObservableSource) ObjectHelper.d(this.f138389b.apply(objCall), "The sourceSupplier returned a null ObservableSource")).b(new UsingObserver(observer, objCall, this.f138390c, this.f138391d));
            } catch (Throwable th) {
                Exceptions.b(th);
                try {
                    this.f138390c.accept(objCall);
                    EmptyDisposable.i(th, observer);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    EmptyDisposable.i(new CompositeException(th, th2), observer);
                }
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            EmptyDisposable.i(th3, observer);
        }
    }
}
