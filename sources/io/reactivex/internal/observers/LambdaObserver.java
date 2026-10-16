package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Consumer f134993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f134994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Action f134995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Consumer f134996d;

    public LambdaObserver(Consumer consumer, Consumer consumer2, Action action, Consumer consumer3) {
        this.f134993a = consumer;
        this.f134994b = consumer2;
        this.f134995c = action;
        this.f134996d = consumer3;
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (DisposableHelper.g(this, disposable)) {
            try {
                this.f134996d.accept(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                disposable.dispose();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        if (e()) {
            return;
        }
        try {
            this.f134993a.accept(obj);
        } catch (Throwable th) {
            Exceptions.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (e()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f134995c.run();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (e()) {
            RxJavaPlugins.s(th);
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.f134994b.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(th, th2));
        }
    }
}
