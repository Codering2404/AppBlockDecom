package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzedx implements zzasa {
    final /* synthetic */ zzedy zza;

    zzedx(zzedy zzedyVar) {
        Objects.requireNonNull(zzedyVar);
        this.zza = zzedyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzasa
    public final void zza(int i3) {
        zzasb zzasbVarZzd;
        try {
            zzfqt zzfqtVarZza = zzfqu.zza();
            zzfqtVarZza.zzh(i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? 7 : 6 : 5 : 4 : 3);
            if (i3 == 0 && (zzasbVarZzd = this.zza.zzc().zzd()) != null) {
                zzfqtVarZza.zzb(zzasbVarZzd.zzb());
                zzfqtVarZza.zzc(zzasbVarZzd.zzc());
                zzfqtVarZza.zzd(zzasbVarZzd.zzd());
                zzfqtVarZza.zze(zzasbVarZzd.zze());
                zzfqtVarZza.zzf(zzasbVarZzd.zzf());
                if (!TextUtils.isEmpty(zzasbVarZzd.zza())) {
                    zzfqtVarZza.zza(zzasbVarZzd.zza());
                }
                if (!TextUtils.isEmpty(zzasbVarZzd.zzg())) {
                    zzfqtVarZza.zzg(zzasbVarZzd.zzg());
                }
            }
            zzedy zzedyVar = this.zza;
            zzedyVar.zzc().zzc();
            zzdzl zzdzlVarZzd = zzedyVar.zzd();
            String strEncodeToString = Base64.encodeToString(((zzfqu) zzfqtVarZza.zzbu()).zzaN(), 1);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfP)).booleanValue()) {
                zzdzk zzdzkVarZza = zzdzlVarZzd.zza();
                zzdzkVarZza.zzc("action", "irda");
                zzdzkVarZza.zzc("irdd", strEncodeToString);
                zzdzkVarZza.zzf();
            }
            zzedyVar.zze().e(true);
        } catch (Exception e3) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfQ)).booleanValue()) {
                zzedy zzedyVar2 = this.zza;
                if (zzedyVar2.zzb == null) {
                    zzedyVar2.zzb = zzbzy.zzc(zzedyVar2.zzb());
                }
                zzedyVar2.zzb.zzh(e3, "InstallReferrerUnsampled.onInstallReferrerSetupFinished");
                return;
            }
            zzedy zzedyVar3 = this.zza;
            if (zzedyVar3.zza == null) {
                zzedyVar3.zza = zzbzy.zza(zzedyVar3.zzb());
            }
            zzedyVar3.zza.zzh(e3, "InstallReferrer.onInstallReferrerSetupFinished");
        }
    }
}
