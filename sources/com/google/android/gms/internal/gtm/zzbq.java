package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbq implements Runnable {
    final /* synthetic */ zzdb zza;
    final /* synthetic */ zzbs zzb;

    zzbq(zzbs zzbsVar, zzdb zzdbVar) {
        this.zzb = zzbsVar;
        this.zza = zzdbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzf(this.zza);
    }
}
