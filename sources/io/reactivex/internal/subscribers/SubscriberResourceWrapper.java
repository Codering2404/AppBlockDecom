package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Subscriber f139170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f139171b = new AtomicReference();

    public SubscriberResourceWrapper(Subscriber subscriber) {
        this.f139170a = subscriber;
    }

    public void a(Disposable disposable) {
        DisposableHelper.f(this, disposable);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.a(this.f139171b);
        DisposableHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f139171b.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (SubscriptionHelper.f(this.f139171b, subscription)) {
            this.f139170a.g(this);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        this.f139170a.h(obj);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        DisposableHelper.a(this);
        this.f139170a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        DisposableHelper.a(this);
        this.f139170a.onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        if (SubscriptionHelper.h(j3)) {
            ((Subscription) this.f139171b.get()).y(j3);
        }
    }
}
