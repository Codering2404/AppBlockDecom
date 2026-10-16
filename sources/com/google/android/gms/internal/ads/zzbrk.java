package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbrk implements zzhbe {
    final /* synthetic */ zzbrc zza;

    zzbrk(zzbro zzbroVar, zzbrc zzbrcVar) {
        this.zza = zzbrcVar;
        Objects.requireNonNull(zzbroVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzcfw zzcfwVar = new zzcfw();
        ((zzbri) obj).zze(this.zza, new zzbrj(this, zzcfwVar));
        return zzcfwVar;
    }
}
