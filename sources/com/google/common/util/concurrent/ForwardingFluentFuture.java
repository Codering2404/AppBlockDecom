package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class ForwardingFluentFuture<V> extends FluentFuture<V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ListenableFuture f85843i;

    ForwardingFluentFuture(ListenableFuture listenableFuture) {
        this.f85843i = (ListenableFuture) Preconditions.t(listenableFuture);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.f85843i.addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return this.f85843i.cancel(z2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public Object get() {
        return this.f85843i.get();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f85843i.isCancelled();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public boolean isDone() {
        return this.f85843i.isDone();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String toString() {
        return this.f85843i.toString();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        return this.f85843i.get(j3, timeUnit);
    }
}
