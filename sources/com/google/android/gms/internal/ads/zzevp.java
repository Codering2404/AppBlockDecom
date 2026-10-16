package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzevp implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzevp(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzevp zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzevp(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzevn(zzfoa.zzc(), ((zzdci) this.zza).zza(), ((zzcol) this.zzb).zzb());
    }
}
