package com.google.android.gms.internal.appset;

import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzj implements Runnable {
    final /* synthetic */ zzl zza;

    /* synthetic */ zzj(zzl zzlVar, zzi zziVar) {
        this.zza = zzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jZza = this.zza.zza();
        if (jZza == -1 || DefaultClock.c().currentTimeMillis() <= jZza) {
            return;
        }
        zzl.zze(this.zza.zzb);
    }
}
