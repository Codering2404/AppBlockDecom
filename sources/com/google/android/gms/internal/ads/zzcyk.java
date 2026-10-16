package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcyk implements zzimu {
    private final zzcyj zza;

    private zzcyk(zzcyj zzcyjVar) {
        this.zza = zzcyjVar;
    }

    public static zzcyk zzc(zzcyj zzcyjVar) {
        return new zzcyk(zzcyjVar);
    }

    public static zzfkf zzd(zzcyj zzcyjVar) {
        zzfkf zzfkfVarZzb = zzcyjVar.zzb();
        zzinc.zzb(zzfkfVarZzb);
        return zzfkfVarZzb;
    }

    public final zzfkf zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
