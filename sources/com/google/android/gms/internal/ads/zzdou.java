package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdou implements zzimu {
    private final zzdop zza;

    private zzdou(zzdop zzdopVar) {
        this.zza = zzdopVar;
    }

    public static zzdou zzc(zzdop zzdopVar) {
        return new zzdou(zzdopVar);
    }

    public static zzdux zzd(zzdop zzdopVar) {
        zzdux zzduxVarZzd = zzdopVar.zzd();
        zzinc.zzb(zzduxVarZzd);
        return zzduxVarZzd;
    }

    public final zzdux zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
