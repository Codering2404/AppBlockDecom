package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Disposable f134973c;

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (DisposableHelper.i(this.f134973c, disposable)) {
            this.f134973c = disposable;
            this.f134971a.a(this);
        }
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.f134973c.dispose();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Object obj = this.f134972b;
        if (obj == null) {
            b();
        } else {
            this.f134972b = null;
            c(obj);
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.f134972b = null;
        g(th);
    }
}
