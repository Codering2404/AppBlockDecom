package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdfh implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzdfh(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzdfh zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzdfh(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdfg(((zzing) this.zza).zzb(), ((zzcyk) this.zzb).zza(), ((zzcyn) this.zzc).zza());
    }
}
