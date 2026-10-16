package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzelt implements zzels {
    public final zzels zza;
    private final zzgta zzb;

    public zzelt(zzels zzelsVar, zzgta zzgtaVar) {
        this.zza = zzelsVar;
        this.zzb = zzgtaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final boolean zza(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        return this.zza.zza(zzfkqVar, zzfkfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final ListenableFuture zzb(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        return zzhbw.zzk(this.zza.zzb(zzfkqVar, zzfkfVar), this.zzb, zzcfr.zza);
    }
}
