package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SafeObserver<T> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observer f139254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Disposable f139255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f139256c;

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (DisposableHelper.i(this.f139255b, disposable)) {
            this.f139255b = disposable;
            try {
                this.f139254a.a(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f139256c = true;
                try {
                    disposable.dispose();
                    RxJavaPlugins.s(th);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    RxJavaPlugins.s(new CompositeException(th, th2));
                }
            }
        }
    }

    void b() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f139254a.a(EmptyDisposable.INSTANCE);
            try {
                this.f139254a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(nullPointerException, th2));
        }
    }

    void c() {
        this.f139256c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f139254a.a(EmptyDisposable.INSTANCE);
            try {
                this.f139254a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.f139255b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f139255b.e();
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        if (this.f139256c) {
            return;
        }
        if (this.f139255b == null) {
            c();
            return;
        }
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f139255b.dispose();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(new CompositeException(nullPointerException, th));
                return;
            }
        }
        try {
            this.f139254a.h(obj);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            try {
                this.f139255b.dispose();
                onError(th2);
            } catch (Throwable th3) {
                Exceptions.b(th3);
                onError(new CompositeException(th2, th3));
            }
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f139256c) {
            return;
        }
        this.f139256c = true;
        if (this.f139255b == null) {
            b();
            return;
        }
        try {
            this.f139254a.onComplete();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f139256c) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139256c = true;
        if (this.f139255b != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f139254a.onError(th);
                return;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.s(new CompositeException(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f139254a.a(EmptyDisposable.INSTANCE);
            try {
                this.f139254a.onError(new CompositeException(th, nullPointerException));
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(new CompositeException(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            Exceptions.b(th4);
            RxJavaPlugins.s(new CompositeException(th, nullPointerException, th4));
        }
    }
}
