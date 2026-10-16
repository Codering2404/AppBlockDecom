package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableJust<T> extends Flowable<T> implements ScalarCallable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f135916b;

    public FlowableJust(Object obj) {
        this.f135916b = obj;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f135916b;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        subscriber.g(new ScalarSubscription(subscriber, this.f135916b));
    }
}
