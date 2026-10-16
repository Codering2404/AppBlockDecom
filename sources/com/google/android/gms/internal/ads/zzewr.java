package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewr implements zzimu {
    private final zzind zza;

    private zzewr(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzewr zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzewr(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzewp zzb() {
        return new zzewp(zzfoa.zzc(), ((zzcns) this.zza).zza());
    }
}
