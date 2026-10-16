package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DisposableObserver<T> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139244a = new AtomicReference();

    @Override // io.reactivex.Observer
    public final void a(Disposable disposable) {
        if (EndConsumerHelper.c(this.f139244a, disposable, getClass())) {
            b();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.a(this.f139244a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return this.f139244a.get() == DisposableHelper.DISPOSED;
    }

    protected void b() {
    }
}
