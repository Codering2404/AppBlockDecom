package com.google.common.util.concurrent;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public interface ListeningExecutorService extends ExecutorService, AutoCloseable {
    @Override // java.lang.AutoCloseable
    /* synthetic */ default void close() {
        f.b.a(this);
    }

    @Override // java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    ListenableFuture submit(Runnable runnable);

    @Override // java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    ListenableFuture submit(Runnable runnable, Object obj);

    @Override // java.util.concurrent.ExecutorService, com.google.common.util.concurrent.ListeningExecutorService
    ListenableFuture submit(Callable callable);
}
