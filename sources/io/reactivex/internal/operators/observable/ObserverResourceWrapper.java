package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -8612022020200669122L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Observer f138555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f138556b = new AtomicReference();

    public ObserverResourceWrapper(Observer observer) {
        this.f138555a = observer;
    }

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        if (DisposableHelper.g(this.f138556b, disposable)) {
            this.f138555a.a(this);
        }
    }

    public void b(Disposable disposable) {
        DisposableHelper.f(this, disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this.f138556b);
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f138556b.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        this.f138555a.h(obj);
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        dispose();
        this.f138555a.onComplete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        dispose();
        this.f138555a.onError(th);
    }
}
