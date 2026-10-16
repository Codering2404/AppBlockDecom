package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzedj implements zzhbt {
    final /* synthetic */ zzedo zza;

    zzedj(zzedo zzedoVar) {
        Objects.requireNonNull(zzedoVar);
        this.zza = zzedoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzecf) obj).zze();
        this.zza.zzi().zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
    }
}
