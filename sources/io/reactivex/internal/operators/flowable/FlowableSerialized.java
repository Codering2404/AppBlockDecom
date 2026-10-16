package io.reactivex.internal.operators.flowable;

import io.reactivex.subscribers.SerializedSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSerialized<T> extends AbstractFlowableWithUpstream<T, T> {
    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new SerializedSubscriber(subscriber));
    }
}
