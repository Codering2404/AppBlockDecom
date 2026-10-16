package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f139121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f139122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Subscription f139123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f139124d;

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void g(Subscription subscription) {
        if (SubscriptionHelper.i(this.f139123c, subscription)) {
            this.f139123c = subscription;
            if (this.f139124d) {
                return;
            }
            subscription.y(Long.MAX_VALUE);
            if (this.f139124d) {
                this.f139123c = SubscriptionHelper.CANCELLED;
                subscription.cancel();
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        countDown();
    }
}
