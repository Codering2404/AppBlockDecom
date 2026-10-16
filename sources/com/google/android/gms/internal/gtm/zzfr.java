package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfr extends zzbt implements zzct {
    private final zzft zza;

    public zzfr(zzbx zzbxVar) {
        super(zzbxVar);
        this.zza = new zzft();
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final /* synthetic */ zzcs zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final void zzb(String str, String str2) {
        this.zza.zzg.put(str, str2);
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final void zzc(String str, boolean z2) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.zza.zzd = z2 ? 1 : 0;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.zza.zze = z2 ? 1 : 0;
        } else if (!"ga_reportUncaughtExceptions".equals(str)) {
            zzR("bool configuration name not recognized", str);
        } else {
            this.zza.zzf = z2 ? 1 : 0;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final void zzd(String str, int i3) {
        if ("ga_sessionTimeout".equals(str)) {
            this.zza.zzc = i3;
        } else {
            zzR("int configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzct
    public final void zze(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.zza.zza = str2;
            return;
        }
        if (!"ga_sampleFrequency".equals(str)) {
            zzR("string configuration name not recognized", str);
            return;
        }
        try {
            this.zza.zzb = Double.parseDouble(str2);
        } catch (NumberFormatException e3) {
            zzS("Error parsing ga_sampleFrequency value", str2, e3);
        }
    }
}
