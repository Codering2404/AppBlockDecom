package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfow implements zzhbt {
    final /* synthetic */ zzfor zza;
    final /* synthetic */ zzfpb zzb;

    zzfow(zzfpb zzfpbVar, zzfor zzforVar) {
        this.zza = zzforVar;
        Objects.requireNonNull(zzfpbVar);
        this.zzb = zzfpbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zzb.zza.zzg().zzc(this.zza, th);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zzb.zza.zzg().zzd(this.zza);
    }
}
