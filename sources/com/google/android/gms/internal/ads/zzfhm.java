package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfhm implements zzfhw {
    private zzdbz zza;

    @Override // com.google.android.gms.internal.ads.zzfhw
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzdbz zzd() {
        return this.zza;
    }

    public final synchronized ListenableFuture zzb(zzfhx zzfhxVar, zzfhv zzfhvVar, zzdbz zzdbzVar) {
        zzcyx zzcyxVarZza;
        try {
            if (zzdbzVar != null) {
                this.zza = zzdbzVar;
            } else {
                this.zza = (zzdbz) zzfhvVar.zza(zzfhxVar.zzb).zzh();
            }
            zzcyxVarZza = this.zza.zza();
        } catch (Throwable th) {
            throw th;
        }
        return zzcyxVarZza.zzc(zzcyxVarZza.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzfhw
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfhx zzfhxVar, zzfhv zzfhvVar, Object obj) {
        return zzb(zzfhxVar, zzfhvVar, null);
    }
}
