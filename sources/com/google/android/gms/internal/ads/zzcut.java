package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcut {
    private final zzdzl zza;
    private final zzfkq zzb;

    zzcut(zzdzl zzdzlVar, zzfkq zzfkqVar) {
        this.zza = zzdzlVar;
        this.zzb = zzfkqVar;
    }

    public final void zza(long j3, int i3) {
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zza(this.zzb.zzb.zzb);
        zzdzkVarZza.zzc("action", "ad_closed");
        zzdzkVarZza.zzc("show_time", String.valueOf(j3));
        zzdzkVarZza.zzc("ad_format", "app_open_ad");
        int i4 = i3 - 1;
        zzdzkVarZza.zzc("acr", i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h");
        zzdzkVarZza.zzd();
    }
}
