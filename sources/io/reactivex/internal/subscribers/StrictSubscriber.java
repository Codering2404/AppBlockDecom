package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = -4945028590049415624L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Subscriber f139164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicThrowable f139165b = new AtomicThrowable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicLong f139166c = new AtomicLong();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference f139167d = new AtomicReference();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicBoolean f139168f = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f139169g;

    public StrictSubscriber(Subscriber subscriber) {
        this.f139164a = subscriber;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        if (this.f139169g) {
            return;
        }
        SubscriptionHelper.a(this.f139167d);
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (this.f139168f.compareAndSet(false, true)) {
            this.f139164a.g(this);
            SubscriptionHelper.c(this.f139167d, this.f139166c, subscription);
        } else {
            subscription.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        HalfSerializer.f(this.f139164a, obj, this, this.f139165b);
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f139169g = true;
        HalfSerializer.b(this.f139164a, this, this.f139165b);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f139169g = true;
        HalfSerializer.d(this.f139164a, th, this, this.f139165b);
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        if (j3 > 0) {
            SubscriptionHelper.b(this.f139167d, this.f139166c, j3);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j3));
    }
}
