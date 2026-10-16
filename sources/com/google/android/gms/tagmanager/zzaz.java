package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaz implements Runnable {
    final /* synthetic */ zzav zza;
    final /* synthetic */ zzbd zzb;

    zzaz(zzbd zzbdVar, zzav zzavVar) {
        this.zzb = zzbdVar;
        this.zza = zzavVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(zzbd.zzf(this.zzb));
    }
}
