package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfvc implements Runnable {
    final /* synthetic */ float zza;
    final /* synthetic */ zzfvd zzb;

    zzfvc(zzfvd zzfvdVar, float f3) {
        this.zza = f3;
        Objects.requireNonNull(zzfvdVar);
        this.zzb = zzfvdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzg().zzf(this.zza);
    }
}
