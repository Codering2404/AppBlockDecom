package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class DisposeOnCancel implements Future<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Disposable f139006a;

    DisposeOnCancel(Disposable disposable) {
        this.f139006a = disposable;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        this.f139006a.dispose();
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        return null;
    }
}
