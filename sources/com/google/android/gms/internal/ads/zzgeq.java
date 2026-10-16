package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgeq implements zzgel {
    private final ScheduledExecutorService zza = Executors.newSingleThreadScheduledExecutor();

    zzgeq() {
    }

    @Override // com.google.android.gms.internal.ads.zzgel
    public final void zza(Runnable runnable, long j3) {
        this.zza.schedule(runnable, j3, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.internal.ads.zzgel
    public final void zzb() {
    }
}
