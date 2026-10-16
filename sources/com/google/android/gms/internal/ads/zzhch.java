package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzhch extends ScheduledExecutorService, zzhcg, AutoCloseable {
    @Override // com.google.android.gms.internal.ads.zzhcg, java.lang.AutoCloseable
    /* synthetic */ default void close() {
        f.b.a(this);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    zzhcf schedule(Runnable runnable, long j3, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    zzhcf schedule(Callable callable, long j3, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    zzhcf scheduleAtFixedRate(Runnable runnable, long j3, long j4, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    zzhcf scheduleWithFixedDelay(Runnable runnable, long j3, long j4, TimeUnit timeUnit);
}
