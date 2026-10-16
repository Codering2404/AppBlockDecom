package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdoa implements zzimu {
    private final zzdnx zza;

    private zzdoa(zzdnx zzdnxVar) {
        this.zza = zzdnxVar;
    }

    public static zzdoa zzc(zzdnx zzdnxVar) {
        return new zzdoa(zzdnxVar);
    }

    public static zzdqd zzd(zzdnx zzdnxVar) {
        zzdqd zzdqdVarZza = zzdnxVar.zza();
        zzinc.zzb(zzdqdVarZza);
        return zzdqdVarZza;
    }

    public final zzdqd zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
