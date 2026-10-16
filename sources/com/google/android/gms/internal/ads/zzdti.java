package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdti implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdti(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzdti zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzdti(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdth zzb() {
        return new zzdth(zzfoa.zzc(), ((zzdtd) this.zza).zzb(), (zzdzg) this.zzb.zzb());
    }
}
