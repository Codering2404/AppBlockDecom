package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbm implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzbs zzc;

    zzbm(zzbs zzbsVar, String str, Runnable runnable) {
        this.zzc = zzbsVar;
        this.zza = str;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzn(this.zza);
        this.zzb.run();
    }
}
