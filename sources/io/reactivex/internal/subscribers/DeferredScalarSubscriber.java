package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
    private static final long serialVersionUID = 2984505488220891551L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Subscription f139133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f139134d;

    public DeferredScalarSubscriber(Subscriber subscriber) {
        super(subscriber);
    }

    @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
    public void cancel() {
        super.cancel();
        this.f139133c.cancel();
    }

    public void g(Subscription subscription) {
        if (SubscriptionHelper.i(this.f139133c, subscription)) {
            this.f139133c = subscription;
            this.f139174a.g(this);
            subscription.y(Long.MAX_VALUE);
        }
    }

    public void onComplete() {
        if (this.f139134d) {
            e(this.f139175b);
        } else {
            this.f139174a.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.f139175b = null;
        this.f139174a.onError(th);
    }
}
