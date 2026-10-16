package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhcm extends zzhci implements zzhch {
    final ScheduledExecutorService zza;

    zzhcm(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzhch, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzd */
    public final zzhcf schedule(Runnable runnable, long j3, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzhcv zzhcvVarZze = zzhcv.zze(runnable, null);
        return new zzhck(zzhcvVarZze, scheduledExecutorService.schedule(zzhcvVarZze, j3, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzhch, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zze */
    public final zzhcf schedule(Callable callable, long j3, TimeUnit timeUnit) {
        zzhcv zzhcvVar = new zzhcv(callable);
        return new zzhck(zzhcvVar, this.zza.schedule(zzhcvVar, j3, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzhch, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzf */
    public final zzhcf scheduleAtFixedRate(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        zzhcl zzhclVar = new zzhcl(runnable);
        return new zzhck(zzhclVar, this.zza.scheduleAtFixedRate(zzhclVar, j3, j4, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzhch, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzg */
    public final zzhcf scheduleWithFixedDelay(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        zzhcl zzhclVar = new zzhcl(runnable);
        return new zzhck(zzhclVar, this.zza.scheduleWithFixedDelay(zzhclVar, j3, j4, timeUnit));
    }
}
