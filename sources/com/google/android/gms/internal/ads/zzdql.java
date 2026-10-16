package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdql implements zzimu {
    private final zzdqe zza;

    private zzdql(zzdqe zzdqeVar) {
        this.zza = zzdqeVar;
    }

    public static zzdql zzc(zzdqe zzdqeVar) {
        return new zzdql(zzdqeVar);
    }

    public static zzdpt zzd(zzdqe zzdqeVar) {
        zzdpt zzdptVarZza = zzdqeVar.zza();
        zzinc.zzb(zzdptVarZza);
        return zzdptVarZza;
    }

    public final zzdpt zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
