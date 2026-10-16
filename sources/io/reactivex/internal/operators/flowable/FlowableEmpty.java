package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableEmpty extends Flowable<Object> implements ScalarCallable<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Flowable f135638b = new FlowableEmpty();

    private FlowableEmpty() {
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        EmptySubscription.a(subscriber);
    }
}
