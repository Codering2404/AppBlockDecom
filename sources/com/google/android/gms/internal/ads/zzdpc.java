package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdpc implements zzimu {
    private final zzind zza;

    private zzdpc(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdpc zzc(zzind zzindVar) {
        return new zzdpc(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdpb zzb() {
        return new zzdpb(((zzdql) this.zza).zza());
    }
}
