package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    private SettableFuture() {
    }

    public static SettableFuture F() {
        return new SettableFuture();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean B(Object obj) {
        return super.B(obj);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean C(Throwable th) {
        return super.C(th);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean D(ListenableFuture listenableFuture) {
        return super.D(listenableFuture);
    }
}
