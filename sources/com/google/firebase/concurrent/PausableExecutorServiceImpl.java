package com.google.firebase.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class PausableExecutorServiceImpl implements PausableExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f88189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PausableExecutor f88190b;

    public static /* synthetic */ Object a(Runnable runnable) {
        runnable.run();
        return null;
    }

    public static /* synthetic */ Object b(Runnable runnable, Object obj) {
        runnable.run();
        return obj;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j3, TimeUnit timeUnit) {
        return this.f88189a.awaitTermination(j3, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f88190b.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.f88189a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.f88189a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f88189a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f88189a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public List shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Callable callable) {
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j3, TimeUnit timeUnit) {
        return this.f88189a.invokeAll(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j3, TimeUnit timeUnit) {
        return this.f88189a.invokeAny(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(final Runnable runnable, final Object obj) {
        return submit(new Callable() { // from class: com.google.firebase.concurrent.z
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PausableExecutorServiceImpl.b(runnable, obj);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(final Runnable runnable) {
        return submit(new Callable() { // from class: com.google.firebase.concurrent.y
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PausableExecutorServiceImpl.a(runnable);
            }
        });
    }
}
