package com.google.firebase.concurrent;

import com.google.firebase.concurrent.DelegatingScheduledFuture;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class DelegatingScheduledExecutorService implements ScheduledExecutorService, AutoCloseable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f88172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f88173b;

    DelegatingScheduledExecutorService(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f88172a = executorService;
        this.f88173b = scheduledExecutorService;
    }

    public static /* synthetic */ void f(Callable callable, DelegatingScheduledFuture.Completer completer) {
        try {
            completer.set(callable.call());
        } catch (Exception e3) {
            completer.a(e3);
        }
    }

    public static /* synthetic */ void i(Runnable runnable, DelegatingScheduledFuture.Completer completer) throws Exception {
        try {
            runnable.run();
        } catch (Exception e3) {
            completer.a(e3);
            throw e3;
        }
    }

    public static /* synthetic */ void l(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
        } catch (Exception e3) {
            completer.a(e3);
        }
    }

    public static /* synthetic */ void r(Runnable runnable, DelegatingScheduledFuture.Completer completer) {
        try {
            runnable.run();
            completer.set(null);
        } catch (Exception e3) {
            completer.a(e3);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j3, TimeUnit timeUnit) {
        return this.f88172a.awaitTermination(j3, timeUnit);
    }

    @Override // java.lang.AutoCloseable
    public /* synthetic */ void close() {
        f.b.a(this);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f88172a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection) {
        return this.f88172a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection) {
        return this.f88172a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f88172a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f88172a.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Runnable runnable, final long j3, final TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver() { // from class: com.google.firebase.concurrent.b
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
            public final ScheduledFuture a(DelegatingScheduledFuture.Completer completer) {
                DelegatingScheduledExecutorService delegatingScheduledExecutorService = this.f88211a;
                return delegatingScheduledExecutorService.f88173b.schedule(new Runnable() { // from class: com.google.firebase.concurrent.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        delegatingScheduledExecutorService.f88172a.execute(new Runnable() { // from class: com.google.firebase.concurrent.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                DelegatingScheduledExecutorService.r(runnable, completer);
                            }
                        });
                    }
                }, j3, timeUnit);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j3, final long j4, final TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver() { // from class: com.google.firebase.concurrent.e
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
            public final ScheduledFuture a(DelegatingScheduledFuture.Completer completer) {
                DelegatingScheduledExecutorService delegatingScheduledExecutorService = this.f88219a;
                return delegatingScheduledExecutorService.f88173b.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.concurrent.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        delegatingScheduledExecutorService.f88172a.execute(new Runnable() { // from class: com.google.firebase.concurrent.c
                            @Override // java.lang.Runnable
                            public final void run() throws Exception {
                                DelegatingScheduledExecutorService.i(runnable, completer);
                            }
                        });
                    }
                }, j3, j4, timeUnit);
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j3, final long j4, final TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver() { // from class: com.google.firebase.concurrent.f
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
            public final ScheduledFuture a(DelegatingScheduledFuture.Completer completer) {
                DelegatingScheduledExecutorService delegatingScheduledExecutorService = this.f88224a;
                return delegatingScheduledExecutorService.f88173b.scheduleWithFixedDelay(new Runnable() { // from class: com.google.firebase.concurrent.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        delegatingScheduledExecutorService.f88172a.execute(new Runnable() { // from class: com.google.firebase.concurrent.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                DelegatingScheduledExecutorService.l(runnable, completer);
                            }
                        });
                    }
                }, j3, j4, timeUnit);
            }
        });
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
        return this.f88172a.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public List invokeAll(Collection collection, long j3, TimeUnit timeUnit) {
        return this.f88172a.invokeAll(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public Object invokeAny(Collection collection, long j3, TimeUnit timeUnit) {
        return this.f88172a.invokeAny(collection, j3, timeUnit);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture schedule(final Callable callable, final long j3, final TimeUnit timeUnit) {
        return new DelegatingScheduledFuture(new DelegatingScheduledFuture.Resolver() { // from class: com.google.firebase.concurrent.g
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Resolver
            public final ScheduledFuture a(DelegatingScheduledFuture.Completer completer) {
                DelegatingScheduledExecutorService delegatingScheduledExecutorService = this.f88229a;
                return delegatingScheduledExecutorService.f88173b.schedule(new Callable() { // from class: com.google.firebase.concurrent.j
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return delegatingScheduledExecutorService.f88172a.submit(new Runnable() { // from class: com.google.firebase.concurrent.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                DelegatingScheduledExecutorService.f(callable, completer);
                            }
                        });
                    }
                }, j3, timeUnit);
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable, Object obj) {
        return this.f88172a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future submit(Runnable runnable) {
        return this.f88172a.submit(runnable);
    }
}
