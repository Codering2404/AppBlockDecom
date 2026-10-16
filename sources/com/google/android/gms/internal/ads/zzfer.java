package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfer implements zzimu {
    private final zzfep zza;

    private zzfer(zzfep zzfepVar) {
        this.zza = zzfepVar;
    }

    public static zzfer zzc(zzfep zzfepVar) {
        return new zzfer(zzfepVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Integer zzb() {
        return Integer.valueOf(this.zza.zzf());
    }
}
