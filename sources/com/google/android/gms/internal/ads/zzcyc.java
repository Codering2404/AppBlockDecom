package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcyc implements zzhbt {
    final /* synthetic */ zzhbt zza;
    final /* synthetic */ zzcyi zzb;

    zzcyc(zzcyi zzcyiVar, zzhbt zzhbtVar) {
        this.zza = zzhbtVar;
        Objects.requireNonNull(zzcyiVar);
        this.zzb = zzcyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zza.zza(th);
        this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zze(((zzcyb) obj).zza, this.zza);
    }
}
