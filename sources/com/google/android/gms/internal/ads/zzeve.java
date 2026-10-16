package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeve {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzevd zzb;

    public final void zza(boolean z2) {
        this.zza.set(true);
    }

    public final boolean zzb() {
        return this.zza.get();
    }

    final void zzc(zzevd zzevdVar) {
        this.zzb = zzevdVar;
    }

    final zzevd zzd() {
        return this.zzb;
    }
}
