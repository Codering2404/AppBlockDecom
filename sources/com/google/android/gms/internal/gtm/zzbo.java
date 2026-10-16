package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbo implements Runnable {
    final /* synthetic */ zzez zza;
    final /* synthetic */ zzbs zzb;

    zzbo(zzbs zzbsVar, zzez zzezVar) {
        this.zzb = zzbsVar;
        this.zza = zzezVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.zzb.zza.zzj(this.zza);
    }
}
