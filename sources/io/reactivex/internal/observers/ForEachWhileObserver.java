package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Predicate f134978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f134979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Action f134980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f134981d;

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        DisposableHelper.g(this, disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return DisposableHelper.b(get());
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        if (this.f134981d) {
            return;
        }
        try {
            if (this.f134978a.test(obj)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            Exceptions.b(th);
            dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.f134981d) {
            return;
        }
        this.f134981d = true;
        try {
            this.f134980c.run();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f134981d) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f134981d = true;
        try {
            this.f134979b.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(th, th2));
        }
    }
}
