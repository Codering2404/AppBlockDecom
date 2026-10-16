package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Subscriber f135005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Disposable f135006b;

    public SubscriberCompletableObserver(Subscriber subscriber) {
        this.f135005a = subscriber;
    }

    @Override // io.reactivex.CompletableObserver
    public void a(Disposable disposable) {
        if (DisposableHelper.i(this.f135006b, disposable)) {
            this.f135006b = disposable;
            this.f135005a.g(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f135006b.dispose();
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        this.f135005a.onComplete();
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        this.f135005a.onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
    }
}
