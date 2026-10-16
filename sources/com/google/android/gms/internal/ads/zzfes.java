package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfes implements zzimu {
    private final zzfep zza;

    private zzfes(zzfep zzfepVar) {
        this.zza = zzfepVar;
    }

    public static zzfes zzc(zzfep zzfepVar) {
        return new zzfes(zzfepVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Boolean zzb() {
        return Boolean.valueOf(this.zza.zzh());
    }
}
