package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdbb implements zzimu {
    private final zzind zza;

    private zzdbb(zzdba zzdbaVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdbb zza(zzdba zzdbaVar, zzind zzindVar) {
        return new zzdbb(zzdbaVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdae) this.zza.zzb(), zzcfr.zzh);
    }
}
