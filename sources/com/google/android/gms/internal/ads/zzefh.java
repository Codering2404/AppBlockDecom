package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzefh implements zzhbt {
    final /* synthetic */ zzefk zza;

    zzefh(zzefk zzefkVar) {
        Objects.requireNonNull(zzefkVar);
        this.zza = zzefkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhh)).booleanValue()) {
            Matcher matcher = zzefk.zzh.matcher(th.getMessage());
            if (matcher.matches()) {
                String strGroup = matcher.group(1);
                zzefk zzefkVar = this.zza;
                zzefkVar.zzc().zzc(Integer.parseInt(strGroup));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkq zzfkqVar = (zzfkq) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhh)).booleanValue()) {
            zzefk zzefkVar = this.zza;
            zzfki zzfkiVar = zzfkqVar.zzb.zzb;
            zzefkVar.zzc().zzc(zzfkiVar.zzf);
            zzefkVar.zzc().zze(zzfkiVar.zzg);
        }
    }
}
