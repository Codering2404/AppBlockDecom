package io.reactivex.internal.observers;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    @Override // io.reactivex.Observer
    public void h(Object obj) {
        if (this.f134957a == null) {
            this.f134957a = obj;
            this.f134959c.dispose();
            countDown();
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (this.f134957a == null) {
            this.f134958b = th;
        }
        countDown();
    }
}
