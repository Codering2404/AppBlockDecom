package io.reactivex.observers;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DisposableMaybeObserver<T> implements MaybeObserver<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139243a;

    @Override // io.reactivex.MaybeObserver
    public final void a(Disposable disposable) {
        if (EndConsumerHelper.c(this.f139243a, disposable, getClass())) {
            b();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        DisposableHelper.a(this.f139243a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return this.f139243a.get() == DisposableHelper.DISPOSED;
    }

    protected void b() {
    }
}
