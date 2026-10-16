package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcna extends Thread {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzcnb zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcna(zzcnb zzcnbVar, Runnable runnable, String str, Runnable runnable2) {
        super(runnable, str);
        this.zza = runnable2;
        Objects.requireNonNull(zzcnbVar);
        this.zzb = zzcnbVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.zzb.zza());
        this.zza.run();
    }
}
