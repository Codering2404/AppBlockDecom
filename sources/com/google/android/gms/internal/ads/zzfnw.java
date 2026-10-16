package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfnw implements zzimu {
    public static zzfnw zza() {
        return zzfnv.zza;
    }

    public static zzhcg zzc() {
        zzhcg zzhcgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgK)).booleanValue()) {
            zzhcgVar = zzcfr.zzc;
        } else {
            zzhcgVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgJ)).booleanValue() ? zzcfr.zza : zzcfr.zzf;
        }
        zzinc.zzb(zzhcgVar);
        return zzhcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzc();
    }
}
