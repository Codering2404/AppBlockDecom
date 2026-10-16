package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f139125b = new Object();
    private static final long serialVersionUID = -4875965440900746268L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Queue f139126a;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (SubscriptionHelper.a(this)) {
            this.f139126a.offer(f139125b);
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (SubscriptionHelper.f(this, subscription)) {
            this.f139126a.offer(NotificationLite.m(this));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        this.f139126a.offer(NotificationLite.l(obj));
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f139126a.offer(NotificationLite.e());
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f139126a.offer(NotificationLite.g(th));
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        get().y(j3);
    }
}
