package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class AsyncSubscription extends AtomicLong implements Subscription, Disposable {
    private static final long serialVersionUID = 7028635084060361255L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f139173b;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.a(this.f139172a);
        DisposableHelper.a(this.f139173b);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f139172a.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        SubscriptionHelper.b(this.f139172a, this, j3);
    }
}
