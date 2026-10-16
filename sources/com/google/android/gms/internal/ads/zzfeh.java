package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfeh implements zzimu {
    private final zzind zza;

    private zzfeh(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar3;
    }

    public static zzfeh zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzfeh(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfef zzb() {
        return new zzfef(zzcri.zza(), zzfoa.zzc(), ((zzfeq) this.zza).zza());
    }
}
