package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Subscription f139507a;

    protected void a() {
        b(Long.MAX_VALUE);
    }

    protected final void b(long j3) {
        Subscription subscription = this.f139507a;
        if (subscription != null) {
            subscription.y(j3);
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void g(Subscription subscription) {
        if (EndConsumerHelper.f(this.f139507a, subscription, getClass())) {
            this.f139507a = subscription;
            a();
        }
    }
}
