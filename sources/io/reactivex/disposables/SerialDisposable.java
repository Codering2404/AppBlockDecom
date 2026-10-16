package io.reactivex.disposables;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SerialDisposable implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f134891a;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.a(this.f134891a);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return DisposableHelper.b((Disposable) this.f134891a.get());
    }
}
