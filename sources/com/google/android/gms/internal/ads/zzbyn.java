package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbyn extends zzbnh {
    final /* synthetic */ zzbyo zza;

    /* synthetic */ zzbyn(zzbyo zzbyoVar, byte[] bArr) {
        Objects.requireNonNull(zzbyoVar);
        this.zza = zzbyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbni
    public final void zze(zzbmv zzbmvVar) {
        zzbyo zzbyoVar = this.zza;
        zzbyoVar.zzd().a(zzbyoVar.zzc(zzbmvVar));
    }
}
