package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observer f134974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f134975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Action f134976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Disposable f134977d;

    public DisposableLambdaObserver(Observer observer, Consumer consumer, Action action) {
        this.f134974a = observer;
        this.f134975b = consumer;
        this.f134976c = action;
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        try {
            this.f134975b.accept(disposable);
            if (DisposableHelper.i(this.f134977d, disposable)) {
                this.f134977d = disposable;
                this.f134974a.a(this);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            disposable.dispose();
            this.f134977d = DisposableHelper.DISPOSED;
            EmptyDisposable.i(th, this.f134974a);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Disposable disposable = this.f134977d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f134977d = disposableHelper;
            try {
                this.f134976c.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f134977d.e();
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        this.f134974a.h(obj);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Disposable disposable = this.f134977d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable != disposableHelper) {
            this.f134977d = disposableHelper;
            this.f134974a.onComplete();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Disposable disposable = this.f134977d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (disposable == disposableHelper) {
            RxJavaPlugins.s(th);
        } else {
            this.f134977d = disposableHelper;
            this.f134974a.onError(th);
        }
    }
}
