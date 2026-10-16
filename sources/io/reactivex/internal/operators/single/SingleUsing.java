package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleUsing<T, U> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f138949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f138951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f138952d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UsingSingleObserver<T, U> extends AtomicReference<Object> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5331524057054083935L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f138954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f138955c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f138956d;

        UsingSingleObserver(SingleObserver singleObserver, Object obj, boolean z2, Consumer consumer) {
            super(obj);
            this.f138953a = singleObserver;
            this.f138955c = z2;
            this.f138954b = consumer;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138956d, disposable)) {
                this.f138956d = disposable;
                this.f138953a.a(this);
            }
        }

        void b() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f138954b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138956d.dispose();
            this.f138956d = DisposableHelper.DISPOSED;
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138956d.e();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138956d = DisposableHelper.DISPOSED;
            if (this.f138955c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f138954b.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.f138953a.onError(th);
            if (this.f138955c) {
                return;
            }
            b();
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138956d = DisposableHelper.DISPOSED;
            if (this.f138955c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f138954b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f138953a.onError(th);
                    return;
                }
            }
            this.f138953a.onSuccess(obj);
            if (this.f138955c) {
                return;
            }
            b();
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        try {
            Object objCall = this.f138949a.call();
            try {
                ((SingleSource) ObjectHelper.d(this.f138950b.apply(objCall), "The singleFunction returned a null SingleSource")).b(new UsingSingleObserver(singleObserver, objCall, this.f138952d, this.f138951c));
            } catch (Throwable th) {
                th = th;
                Exceptions.b(th);
                if (this.f138952d) {
                    try {
                        this.f138951c.accept(objCall);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                EmptyDisposable.j(th, singleObserver);
                if (this.f138952d) {
                    return;
                }
                try {
                    this.f138951c.accept(objCall);
                } catch (Throwable th3) {
                    Exceptions.b(th3);
                    RxJavaPlugins.s(th3);
                }
            }
        } catch (Throwable th4) {
            Exceptions.b(th4);
            EmptyDisposable.j(th4, singleObserver);
        }
    }
}
