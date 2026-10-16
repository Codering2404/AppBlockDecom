package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingExecutorService extends ForwardingObject implements ExecutorService, AutoCloseable {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
    public abstract ExecutorService o2();

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j3, TimeUnit timeUnit) {
        return o2().awaitTermination(j3, timeUnit);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        f.b.a(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        o2().execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return o2().invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return o2().invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return o2().isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return o2().isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        o2().shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        return o2().shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        return o2().submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j3, TimeUnit timeUnit) {
        return o2().invokeAll(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j3, TimeUnit timeUnit) {
        return o2().invokeAny(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return o2().submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return o2().submit(runnable, obj);
    }
}
