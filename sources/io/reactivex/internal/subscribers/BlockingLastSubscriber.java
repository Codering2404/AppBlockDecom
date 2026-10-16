package io.reactivex.internal.subscribers;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        this.f139121a = obj;
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f139121a = null;
        this.f139122b = th;
        countDown();
    }
}
