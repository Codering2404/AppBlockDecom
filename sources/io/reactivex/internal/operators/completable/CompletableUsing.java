package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
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
public final class CompletableUsing<R> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f135188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f135189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f135190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f135191d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -674404550052917487L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f135193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f135194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f135195d;

        UsingObserver(CompletableObserver completableObserver, Object obj, Consumer consumer, boolean z2) {
            super(obj);
            this.f135192a = completableObserver;
            this.f135193b = consumer;
            this.f135194c = z2;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f135195d, disposable)) {
                this.f135195d = disposable;
                this.f135192a.a(this);
            }
        }

        void b() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f135193b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135195d.dispose();
            this.f135195d = DisposableHelper.DISPOSED;
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135195d.e();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f135195d = DisposableHelper.DISPOSED;
            if (this.f135194c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f135193b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f135192a.onError(th);
                    return;
                }
            }
            this.f135192a.onComplete();
            if (this.f135194c) {
                return;
            }
            b();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135195d = DisposableHelper.DISPOSED;
            if (this.f135194c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f135193b.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.f135192a.onError(th);
            if (this.f135194c) {
                return;
            }
            b();
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        try {
            Object objCall = this.f135188a.call();
            try {
                ((CompletableSource) ObjectHelper.d(this.f135189b.apply(objCall), "The completableFunction returned a null CompletableSource")).b(new UsingObserver(completableObserver, objCall, this.f135190c, this.f135191d));
            } catch (Throwable th) {
                Exceptions.b(th);
                if (this.f135191d) {
                    try {
                        this.f135190c.accept(objCall);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        EmptyDisposable.g(new CompositeException(th, th2), completableObserver);
                        return;
                    }
                }
                EmptyDisposable.g(th, completableObserver);
                if (this.f135191d) {
                    return;
                }
                try {
                    this.f135190c.accept(objCall);
                } catch (Throwable th3) {
                    Exceptions.b(th3);
                    RxJavaPlugins.s(th3);
                }
            }
        } catch (Throwable th4) {
            Exceptions.b(th4);
            EmptyDisposable.g(th4, completableObserver);
        }
    }
}
