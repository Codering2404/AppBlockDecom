package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfem implements zzfck {
    final ScheduledExecutorService zza;

    public zzfem(zzbzf zzbzfVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return zzhbw.zzk(zzhbw.zzi(zzhbw.zza(new Bundle()), ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfe)).longValue(), TimeUnit.MILLISECONDS, this.zza), zzfel.zza, zzcfr.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 49;
    }
}
