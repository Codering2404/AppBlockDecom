package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfut extends TimerTask {
    final /* synthetic */ zzfuv zza;
    final /* synthetic */ Timer zzb;
    final /* synthetic */ zzfuw zzc;

    zzfut(zzfuw zzfuwVar, zzfuv zzfuvVar, Timer timer) {
        this.zza = zzfuvVar;
        this.zzb = timer;
        Objects.requireNonNull(zzfuwVar);
        this.zzc = zzfuwVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zzc.zze();
        this.zza.zza(true);
        this.zzb.cancel();
    }
}
