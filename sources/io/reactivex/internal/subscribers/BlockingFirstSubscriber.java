package io.reactivex.internal.subscribers;

import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (this.f139121a == null) {
            this.f139121a = obj;
            this.f139123c.cancel();
            countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f139121a == null) {
            this.f139122b = th;
        } else {
            RxJavaPlugins.s(th);
        }
        countDown();
    }
}
