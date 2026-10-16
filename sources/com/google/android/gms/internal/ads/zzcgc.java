package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcgc implements zzhbt {
    final /* synthetic */ zzcga zza;
    final /* synthetic */ zzcfy zzb;

    zzcgc(zzcgd zzcgdVar, zzcga zzcgaVar, zzcfy zzcfyVar) {
        this.zza = zzcgaVar;
        this.zzb = zzcfyVar;
        Objects.requireNonNull(zzcgdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zza.zza(obj);
    }
}
