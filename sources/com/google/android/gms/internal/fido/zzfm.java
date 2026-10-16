package com.google.android.gms.internal.fido;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfm implements Closeable {
    private static final ThreadLocal zza = new zzfl();
    private int zzb = 0;

    public static int zza() {
        return ((zzfm) zza.get()).zzb;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        int i3 = this.zzb;
        if (i3 <= 0) {
            throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
        }
        this.zzb = i3 - 1;
    }
}
