package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfon {
    final Runnable zza;
    final long zzb;
    ScheduledFuture zzc;
    final /* synthetic */ zzfoo zzd;

    zzfon(zzfoo zzfooVar, Runnable runnable, long j3) {
        Objects.requireNonNull(zzfooVar);
        this.zzd = zzfooVar;
        this.zza = runnable;
        this.zzb = j3;
    }
}
