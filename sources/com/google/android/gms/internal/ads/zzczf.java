package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzczf implements zzimu {
    private final zzind zza;

    private zzczf(zzcyz zzcyzVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzczf zza(zzcyz zzcyzVar, zzind zzindVar) {
        return new zzczf(zzcyzVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzczj) this.zza.zzb(), zzcfr.zzh);
    }
}
