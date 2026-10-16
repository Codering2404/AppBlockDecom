package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzflk implements zzhbt {
    final /* synthetic */ zzfll zza;
    final /* synthetic */ int zzb;

    zzflk(zzfll zzfllVar, int i3) {
        this.zzb = i3;
        Objects.requireNonNull(zzfllVar);
        this.zza = zzfllVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.l().zzg(th, "BufferingUrlPinger.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zza.zzc((String) obj, this.zzb, null);
    }
}
