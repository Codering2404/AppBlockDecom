package com.google.android.libraries.places.internal;

import java.lang.Thread;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxw implements Thread.UncaughtExceptionHandler {
    zzbxw(zzbzf zzbzfVar) {
        Objects.requireNonNull(zzbzfVar);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        throw new zzbns(zzbnp.b(th).e("Uncaught exception in the SynchronizationContext. Re-thrown."), null);
    }
}
