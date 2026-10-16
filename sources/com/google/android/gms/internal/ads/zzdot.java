package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdot implements zzimu {
    private final zzind zza;

    private zzdot(zzdop zzdopVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdot zzc(zzdop zzdopVar, zzind zzindVar) {
        return new zzdot(zzdopVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdqb zzb() {
        zzdon zzdonVar = (zzdon) this.zza.zzb();
        zzinc.zzb(zzdonVar);
        return zzdonVar;
    }
}
