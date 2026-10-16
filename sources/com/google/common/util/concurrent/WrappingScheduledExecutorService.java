package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class WrappingScheduledExecutorService extends WrappingExecutorService implements ScheduledExecutorService, AutoCloseable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ScheduledExecutorService f85982b;

    @Override // com.google.common.util.concurrent.WrappingExecutorService, java.lang.AutoCloseable
    public /* synthetic */ void close() {
        f.b.a(this);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Runnable runnable, long j3, TimeUnit timeUnit) {
        return this.f85982b.schedule(b(runnable), j3, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        return this.f85982b.scheduleAtFixedRate(b(runnable), j3, j4, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        return this.f85982b.scheduleWithFixedDelay(b(runnable), j3, j4, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final ScheduledFuture schedule(Callable callable, long j3, TimeUnit timeUnit) {
        return this.f85982b.schedule(c(callable), j3, timeUnit);
    }
}
