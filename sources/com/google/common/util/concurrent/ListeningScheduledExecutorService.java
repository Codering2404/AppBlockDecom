package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public interface ListeningScheduledExecutorService extends ScheduledExecutorService, ListeningExecutorService, AutoCloseable {
    @Override // com.google.common.util.concurrent.ListeningExecutorService, java.lang.AutoCloseable
    /* synthetic */ default void close() {
        f.b.a(this);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture schedule(Runnable runnable, long j3, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture schedule(Callable callable, long j3, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture scheduleAtFixedRate(Runnable runnable, long j3, long j4, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    ListenableScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j3, long j4, TimeUnit timeUnit);
}
