package com.google.android.gms.internal.gtm;

import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcx implements Runnable {
    final /* synthetic */ zzcy zza;

    zzcx(zzcy zzcyVar) {
        this.zza = zzcyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.zza.zzb.zzd().i(this);
            return;
        }
        zzcy zzcyVar = this.zza;
        boolean zZzh = zzcyVar.zzh();
        zzcyVar.zzd = 0L;
        if (zZzh) {
            this.zza.zza();
        }
    }
}
