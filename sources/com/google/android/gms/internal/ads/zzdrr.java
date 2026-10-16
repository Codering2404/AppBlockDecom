package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdrr implements zzhbt {
    final /* synthetic */ zzdrt zza;

    zzdrr(zzdrt zzdrtVar) {
        Objects.requireNonNull(zzdrtVar);
        this.zza = zzdrtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgs)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.l().zzg(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(List list) {
        try {
            zzcku zzckuVar = (zzcku) list.get(0);
            if (zzckuVar != null) {
                this.zza.zza(zzckuVar);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e3) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgs)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.l().zzg(e3, "omid native display exp");
            }
        }
    }
}
