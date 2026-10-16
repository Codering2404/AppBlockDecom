package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbn implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ zzbs zzb;

    zzbn(zzbs zzbsVar, int i3) {
        this.zzb = zzbsVar;
        this.zza = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzY(((long) this.zza) * 1000);
    }
}
