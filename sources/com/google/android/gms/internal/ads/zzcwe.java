package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcwe implements zzimu {
    private final zzcvs zza;
    private final zzind zzb;

    private zzcwe(zzcvs zzcvsVar, zzind zzindVar) {
        this.zza = zzcvsVar;
        this.zzb = zzindVar;
    }

    public static zzcwe zza(zzcvs zzcvsVar, zzind zzindVar) {
        return new zzcwe(zzcvsVar, zzindVar);
    }

    public static zzdkq zzc(zzcvs zzcvsVar, zzcxg zzcxgVar) {
        return new zzdkq(zzcxgVar, zzcfr.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return zzc(this.zza, (zzcxg) this.zzb.zzb());
    }
}
