package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f134957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f134958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Disposable f134959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f134960d;

    @Override // io.reactivex.Observer
    public final void a(Disposable disposable) {
        this.f134959c = disposable;
        if (this.f134960d) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f134960d = true;
        Disposable disposable = this.f134959c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return this.f134960d;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        countDown();
    }
}
