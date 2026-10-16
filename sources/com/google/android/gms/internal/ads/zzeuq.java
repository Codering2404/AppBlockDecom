package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeuq implements zzfck {
    private final ListenableFuture zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    zzeuq(ListenableFuture listenableFuture, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = listenableFuture;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        ListenableFuture listenableFuture = this.zza;
        zzeup zzeupVar = zzeup.zza;
        Executor executor = this.zzb;
        ListenableFuture listenableFutureZzj = zzhbw.zzj(listenableFuture, zzeupVar, executor);
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznW)).intValue() > 0) {
            listenableFutureZzj = zzhbw.zzi(listenableFutureZzj, ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(r1)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzhbw.zzh(listenableFutureZzj, Throwable.class, zzeuo.zza, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 6;
    }
}
