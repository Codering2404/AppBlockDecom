package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzevr implements zzfck {
    private final Executor zza;
    private final zzcfd zzb;

    zzevr(Executor executor, zzcfd zzcfdVar) {
        this.zza = executor;
        this.zzb = zzcfdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzdO)).booleanValue()) {
            return zzhbw.zza(new zzevs(null));
        }
        zzcfd zzcfdVar = this.zzb;
        return zzhbw.zzk(zzcfdVar.zzq(), zzevq.zza, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 10;
    }
}
