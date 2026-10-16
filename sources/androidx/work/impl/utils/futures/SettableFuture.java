package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class SettableFuture<V> extends AbstractFuture<V> {
    private SettableFuture() {
    }

    public static SettableFuture s() {
        return new SettableFuture();
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean o(Object obj) {
        return super.o(obj);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean p(Throwable th) {
        return super.p(th);
    }

    @Override // androidx.work.impl.utils.futures.AbstractFuture
    public boolean q(ListenableFuture listenableFuture) {
        return super.q(listenableFuture);
    }
}
