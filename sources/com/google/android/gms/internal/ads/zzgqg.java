package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgqg implements zzhbt {
    final /* synthetic */ zzgqf zza;

    zzgqg(zzgqh zzgqhVar, zzgqf zzgqfVar) {
        this.zza = zzgqfVar;
        Objects.requireNonNull(zzgqhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzgqf zzgqfVar = this.zza;
        zzgqfVar.zzb(th);
        zzgqfVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zza.zzc();
    }
}
