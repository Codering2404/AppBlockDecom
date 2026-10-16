package com.google.android.gms.internal.gtm;

import android.content.ComponentName;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcc implements Runnable {
    final /* synthetic */ ComponentName zza;
    final /* synthetic */ zzcd zzb;

    zzcc(zzcd zzcdVar, ComponentName componentName) {
        this.zzb = zzcdVar;
        this.zza = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzce.zzb(this.zzb.zza, this.zza);
    }
}
