package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdwr implements zzimu {
    private final zzind zza;

    private zzdwr(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdwr zzc(zzind zzindVar) {
        return new zzdwr(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdwq zzb() {
        return new zzdwq((zzcku) this.zza.zzb());
    }
}
