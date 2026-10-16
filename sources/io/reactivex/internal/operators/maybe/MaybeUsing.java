package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
public final class MaybeUsing<T, D> extends Maybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f137032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f137034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f137035d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UsingObserver<T, D> extends AtomicReference<Object> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -674404550052917487L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f137036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f137037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137038c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f137039d;

        UsingObserver(MaybeObserver maybeObserver, Object obj, Consumer consumer, boolean z2) {
            super(obj);
            this.f137036a = maybeObserver;
            this.f137037b = consumer;
            this.f137038c = z2;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137039d, disposable)) {
                this.f137039d = disposable;
                this.f137036a.a(this);
            }
        }

        void b() {
            Object andSet = getAndSet(this);
            if (andSet != this) {
                try {
                    this.f137037b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137039d.dispose();
            this.f137039d = DisposableHelper.DISPOSED;
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137039d.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f137039d = DisposableHelper.DISPOSED;
            if (this.f137038c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f137037b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f137036a.onError(th);
                    return;
                }
            }
            this.f137036a.onComplete();
            if (this.f137038c) {
                return;
            }
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f137039d = DisposableHelper.DISPOSED;
            if (this.f137038c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f137037b.accept(andSet);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.f137036a.onError(th);
            if (this.f137038c) {
                return;
            }
            b();
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f137039d = DisposableHelper.DISPOSED;
            if (this.f137038c) {
                Object andSet = getAndSet(this);
                if (andSet == this) {
                    return;
                }
                try {
                    this.f137037b.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f137036a.onError(th);
                    return;
                }
            }
            this.f137036a.onSuccess(obj);
            if (this.f137038c) {
                return;
            }
            b();
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        try {
            Object objCall = this.f137032a.call();
            try {
                ((MaybeSource) ObjectHelper.d(this.f137033b.apply(objCall), "The sourceSupplier returned a null MaybeSource")).b(new UsingObserver(maybeObserver, objCall, this.f137034c, this.f137035d));
            } catch (Throwable th) {
                Exceptions.b(th);
                if (this.f137035d) {
                    try {
                        this.f137034c.accept(objCall);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        EmptyDisposable.h(new CompositeException(th, th2), maybeObserver);
                        return;
                    }
                }
                EmptyDisposable.h(th, maybeObserver);
                if (this.f137035d) {
                    return;
                }
                try {
                    this.f137034c.accept(objCall);
                } catch (Throwable th3) {
                    Exceptions.b(th3);
                    RxJavaPlugins.s(th3);
                }
            }
        } catch (Throwable th4) {
            Exceptions.b(th4);
            EmptyDisposable.h(th4, maybeObserver);
        }
    }
}
