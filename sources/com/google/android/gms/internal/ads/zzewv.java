package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzewv {
    public final ListenableFuture zza;
    private final long zzb;
    private final Clock zzc;

    public zzewv(ListenableFuture listenableFuture, long j3, Clock clock) {
        this.zza = listenableFuture;
        this.zzc = clock;
        this.zzb = clock.a() + j3;
    }

    public final boolean zza() {
        return this.zzb < this.zzc.a();
    }
}
