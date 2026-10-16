package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public class ListenableFutureTask<V> extends FutureTask<V> implements ListenableFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutionList f85879a;

    ListenableFutureTask(Callable callable) {
        super(callable);
        this.f85879a = new ExecutionList();
    }

    public static ListenableFutureTask a(Callable callable) {
        return new ListenableFutureTask(callable);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.f85879a.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        this.f85879a.b();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j3);
        return nanos <= 2147483647999999999L ? super.get(j3, timeUnit) : super.get(Math.min(nanos, 2147483647999999999L), TimeUnit.NANOSECONDS);
    }
}
