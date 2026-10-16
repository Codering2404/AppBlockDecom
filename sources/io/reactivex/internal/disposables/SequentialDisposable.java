package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class SequentialDisposable extends AtomicReference<Disposable> implements Disposable {
    private static final long serialVersionUID = -754898800686245608L;

    public SequentialDisposable() {
    }

    public boolean a(Disposable disposable) {
        return DisposableHelper.c(this, disposable);
    }

    public boolean b(Disposable disposable) {
        return DisposableHelper.f(this, disposable);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return DisposableHelper.b(get());
    }

    public SequentialDisposable(Disposable disposable) {
        lazySet(disposable);
    }
}
