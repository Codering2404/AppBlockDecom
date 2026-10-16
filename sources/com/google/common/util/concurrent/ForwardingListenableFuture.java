package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingListenableFuture<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class SimpleForwardingListenableFuture<V> extends ForwardingListenableFuture<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ListenableFuture f85845a;

        protected SimpleForwardingListenableFuture(ListenableFuture listenableFuture) {
            this.f85845a = (ListenableFuture) Preconditions.t(listenableFuture);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.ForwardingListenableFuture, com.google.common.util.concurrent.ForwardingFuture
        /* JADX INFO: renamed from: S1, reason: merged with bridge method [inline-methods] */
        public final ListenableFuture k2() {
            return this.f85845a;
        }
    }

    protected ForwardingListenableFuture() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.ForwardingFuture
    /* JADX INFO: renamed from: S1 */
    public abstract ListenableFuture k2();

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        k2().addListener(runnable, executor);
    }
}
