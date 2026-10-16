package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzba implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbd zzb;

    zzba(zzbd zzbdVar, String str) {
        this.zzb = zzbdVar;
        this.zza = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbd.zzg(this.zzb, this.zza);
    }
}
