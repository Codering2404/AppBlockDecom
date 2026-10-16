package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableNever extends Flowable<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Flowable f135984b = new FlowableNever();

    private FlowableNever() {
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        subscriber.g(EmptySubscription.INSTANCE);
    }
}
