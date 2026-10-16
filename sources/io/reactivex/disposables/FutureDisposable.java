package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    private static final long serialVersionUID = 6545242830671168775L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f134890a;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.f134890a);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        Future<?> future = get();
        return future == null || future.isDone();
    }
}
