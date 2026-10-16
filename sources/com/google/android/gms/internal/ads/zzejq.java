package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzejq implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzejq(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzejq zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzejq(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzejp zzb() {
        return new zzejp((zzejd) this.zza.zzb(), ((zzeji) this.zzb).zzb());
    }
}
