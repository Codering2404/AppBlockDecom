package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f134961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f134962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Disposable f134963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f134964d;

    @Override // io.reactivex.SingleObserver
    public void a(Disposable disposable) {
        this.f134963c = disposable;
        if (this.f134964d) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.f134962b = th;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object obj) {
        this.f134961a = obj;
        countDown();
    }
}
