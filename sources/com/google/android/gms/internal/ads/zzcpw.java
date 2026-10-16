package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcpw implements zzehq {
    private final zzefw zza;
    private final zzcox zzb;

    zzcpw(zzcox zzcoxVar, zzcpu zzcpuVar, zzefw zzefwVar) {
        this.zzb = zzcoxVar;
        this.zza = zzefwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final zzefx zza() {
        zzcox zzcoxVar = this.zzb;
        return zzefy.zza(zzcns.zzd(zzcoxVar.zzI()), zzcoi.zzd(zzcoxVar.zzI()), this.zza, zzcah.zza());
    }
}
