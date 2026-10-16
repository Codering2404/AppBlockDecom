package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzenr implements zzdno {
    final /* synthetic */ zzelv zza;
    final /* synthetic */ zzfkf zzb;
    final /* synthetic */ zzens zzc;

    zzenr(zzens zzensVar, zzelv zzelvVar, zzfkf zzfkfVar) {
        this.zza = zzelvVar;
        this.zzb = zzfkfVar;
        Objects.requireNonNull(zzensVar);
        this.zzc = zzensVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z2, Context context, zzdde zzddeVar) throws zzdnn {
        try {
            zzflw zzflwVar = (zzflw) this.zza.zzb;
            zzflwVar.zzs(z2);
            if (this.zzc.zzc().f70151c < ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbt)).intValue()) {
                zzflwVar.zzd();
            } else {
                zzflwVar.zze(context);
            }
        } catch (zzflf e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.e("Cannot show interstitial.");
            throw new zzdnn(e3.getCause());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zzb;
    }
}
