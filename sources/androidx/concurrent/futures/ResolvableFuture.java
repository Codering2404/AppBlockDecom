package androidx.concurrent.futures;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    private ResolvableFuture() {
    }

    public static ResolvableFuture s() {
        return new ResolvableFuture();
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean o(Object obj) {
        return super.o(obj);
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean p(Throwable th) {
        return super.p(th);
    }
}
