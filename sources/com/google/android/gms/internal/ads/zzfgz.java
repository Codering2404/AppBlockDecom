package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfgz implements zzfng {
    private final zzfhw zza;

    public zzfgz(zzfhw zzfhwVar) {
        this.zza = zzfhwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfng
    public final ListenableFuture zza(zzfnh zzfnhVar) {
        zzfhc zzfhcVar = (zzfhc) zzfnhVar;
        return ((zzfgy) this.zza).zzb(zzfhcVar.zzb, zzfhcVar.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfng
    public final void zzb(zzfmw zzfmwVar) {
        zzfmwVar.zza = ((zzfgy) this.zza).zza();
    }
}
