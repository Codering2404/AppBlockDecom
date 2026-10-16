package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcgb implements zzhbt {
    final /* synthetic */ zzcgd zza;

    zzcgb(zzcgd zzcgdVar) {
        Objects.requireNonNull(zzcgdVar);
        this.zza = zzcgdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zza.zzj().set(-1);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zza.zzj().set(1);
    }
}
