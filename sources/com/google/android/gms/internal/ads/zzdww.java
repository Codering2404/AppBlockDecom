package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdww {
    private final zzdzl zza;

    zzdww(zzdzl zzdzlVar) {
        this.zza = zzdzlVar;
    }

    public final boolean zza(zzgat zzgatVar) {
        if (zzgatVar.zzj()) {
            zzdzk zzdzkVarZza = this.zza.zza();
            zzdzkVarZza.zzc("action", "aq_ad_closed");
            zzdzkVarZza.zzc("gqi", zzgatVar.zza());
            zzdzkVarZza.zzc("aq_ad_duration", String.valueOf(zzgatVar.zzb()));
            zzdzkVarZza.zzc("aq_ad_bounce_cnt", String.valueOf(zzgatVar.zzc()));
            zzdzkVarZza.zzc("aq_time_away", String.valueOf(zzgatVar.zzg()));
            return zzdzkVarZza.zze().equals(com.google.android.gms.ads.internal.util.client.zzt.SUCCESS);
        }
        zzdzk zzdzkVarZza2 = this.zza.zza();
        zzdzkVarZza2.zzc("action", "aq_ad_kill");
        zzdzkVarZza2.zzc("gqi", zzgatVar.zza());
        zzdzkVarZza2.zzc("aq_ad_duration", String.valueOf(zzgatVar.zzb()));
        zzdzkVarZza2.zzc("aq_ad_bounce_cnt", String.valueOf(zzgatVar.zzc()));
        zzdzkVarZza2.zzc("aq_time_away", String.valueOf(zzgatVar.zzg()));
        zzdzkVarZza2.zzc("aq_is_os_kill", String.valueOf(zzgatVar.zze()));
        return zzdzkVarZza2.zze().equals(com.google.android.gms.ads.internal.util.client.zzt.SUCCESS);
    }
}
