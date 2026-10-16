package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class WrappingExecutorService implements ExecutorService, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f85981a;

    public static /* synthetic */ void a(Callable callable) {
        try {
            callable.call();
        } catch (Exception e3) {
            Platform.b(e3);
            Throwables.m(e3);
            throw new RuntimeException(e3);
        }
    }

    private ImmutableList f(Collection collection) {
        ImmutableList.Builder builderO = ImmutableList.o();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            builderO.a(c((Callable) it.next()));
        }
        return builderO.m();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j3, TimeUnit timeUnit) {
        return this.f85981a.awaitTermination(j3, timeUnit);
    }

    protected Runnable b(Runnable runnable) {
        final Callable callableC = c(Executors.callable(runnable, null));
        return new Runnable() { // from class: com.google.common.util.concurrent.i
            @Override // java.lang.Runnable
            public final void run() {
                WrappingExecutorService.a(callableC);
            }
        };
    }

    protected abstract Callable c(Callable callable);

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        f.b.a(this);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f85981a.execute(b(runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection) {
        return this.f85981a.invokeAll(f(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection) {
        return this.f85981a.invokeAny(f(collection));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f85981a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f85981a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f85981a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return this.f85981a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Callable callable) {
        return this.f85981a.submit(c((Callable) Preconditions.t(callable)));
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection, long j3, TimeUnit timeUnit) {
        return this.f85981a.invokeAll(f(collection), j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection, long j3, TimeUnit timeUnit) {
        return this.f85981a.invokeAny(f(collection), j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        return this.f85981a.submit(b(runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable, Object obj) {
        return this.f85981a.submit(b(runnable), obj);
    }
}
