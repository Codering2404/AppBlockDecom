package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingFuture<V> extends ForwardingObject implements Future<V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SimpleForwardingFuture<V> extends ForwardingFuture<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Future f85844a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
        public final Future k2() {
            return this.f85844a;
        }
    }

    protected ForwardingFuture() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* JADX INFO: renamed from: I1 */
    public abstract Future k2();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return k2().cancel(z2);
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return k2().get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return k2().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return k2().isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        return k2().get(j3, timeUnit);
    }
}
