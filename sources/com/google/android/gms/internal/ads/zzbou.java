package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbou implements zzhbt {
    final /* synthetic */ zzcku zza;

    zzbou(zzcku zzckuVar) {
        this.zza = zzckuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.l().zzg(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        zzcku zzckuVar = this.zza;
        new com.google.android.gms.ads.internal.util.zzbt(zzckuVar.getContext(), zzckuVar.zzs().f70149a, str, null, zzckuVar.zzC() != null ? zzckuVar.zzC().zzax : null).zzb();
    }
}
