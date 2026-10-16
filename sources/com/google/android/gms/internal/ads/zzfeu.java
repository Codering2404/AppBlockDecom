package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfeu implements zzimu {
    private final zzfep zza;

    private zzfeu(zzfep zzfepVar) {
        this.zza = zzfepVar;
    }

    public static zzfeu zzc(zzfep zzfepVar) {
        return new zzfeu(zzfepVar);
    }

    public static String zzd(zzfep zzfepVar) {
        String strZze = zzfepVar.zze();
        zzinc.zzb(strZze);
        return strZze;
    }

    public final String zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
