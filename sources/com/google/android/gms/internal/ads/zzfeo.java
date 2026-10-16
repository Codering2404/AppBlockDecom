package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfeo implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzfeo(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzfeo zzc(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzfeo(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfem zzb() {
        return new zzfem(zzcrk.zza(), (ScheduledExecutorService) this.zza.zzb(), ((zzcns) this.zzb).zza());
    }
}
