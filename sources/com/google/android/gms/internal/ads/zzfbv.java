package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfbv implements zzfci {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final Long zze;

    public zzfbv(String str, String str2, String str3, String str4, Long l3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = l3;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfln.zze(bundle, "gmp_app_id", this.zza);
        zzfln.zze(bundle, "fbs_aiid", this.zzb);
        zzfln.zze(bundle, "fbs_aeid", this.zzc);
        zzfln.zze(bundle, "apm_id_origin", this.zzd);
        Long l3 = this.zze;
        if (l3 != null) {
            bundle.putLong("sai_timeout", l3.longValue());
        }
    }
}
