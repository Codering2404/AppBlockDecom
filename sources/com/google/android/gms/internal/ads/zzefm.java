package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzefm implements zzhbt {
    final /* synthetic */ zzefs zza;

    zzefm(zzefs zzefsVar) {
        Objects.requireNonNull(zzefsVar);
        this.zza = zzefsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfkq zzfkqVar = (zzfkq) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcS)).booleanValue()) {
            this.zza.zzf().zzdQ(zzfkqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
    }
}
