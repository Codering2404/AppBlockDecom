package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgft implements zzhbe {
    final /* synthetic */ zzgfy zza;

    zzgft(zzgfy zzgfyVar) {
        Objects.requireNonNull(zzgfyVar);
        this.zza = zzgfyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzgfr zzgfrVar = (zzgfr) obj;
        if (zzgfrVar != null) {
            return zzhbw.zza(zzgfrVar);
        }
        zzgfy zzgfyVar = this.zza;
        zzgfyVar.zza().zzb(51);
        return zzgfyVar.zzd(zzgfyVar.zze());
    }
}
