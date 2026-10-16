package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewu implements zzimu {
    private final zzind zza;

    private zzewu(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzewu zzc(zzind zzindVar) {
        return new zzewu(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzewt zzb() {
        return new zzewt((zzfhe) this.zza.zzb());
    }
}
