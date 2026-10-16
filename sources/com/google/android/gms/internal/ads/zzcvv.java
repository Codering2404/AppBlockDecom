package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcvv implements zzimu {
    private final zzcvs zza;

    private zzcvv(zzcvs zzcvsVar) {
        this.zza = zzcvsVar;
    }

    public static zzcvv zzc(zzcvs zzcvsVar) {
        return new zzcvv(zzcvsVar);
    }

    public static zzfkg zzd(zzcvs zzcvsVar) {
        zzfkg zzfkgVarZzd = zzcvsVar.zzd();
        zzinc.zzb(zzfkgVarZzd);
        return zzfkgVarZzd;
    }

    public final zzfkg zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
