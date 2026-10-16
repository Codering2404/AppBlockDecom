package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzetm implements zzetr {
    final /* synthetic */ zzetn zza;

    zzetm(zzetn zzetnVar) {
        Objects.requireNonNull(zzetnVar);
        this.zza = zzetnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzetr
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcxt zzcxtVar = (zzcxt) obj;
        zzetn zzetnVar = this.zza;
        synchronized (zzetnVar) {
            zzetnVar.zze(zzcxtVar.zzn());
            zzcxtVar.zzj();
        }
    }
}
