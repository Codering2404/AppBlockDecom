package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements QueueSubscription<T> {
    private static final long serialVersionUID = -3830916580126663321L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f139178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Subscriber f139179b;

    public ScalarSubscription(Subscriber subscriber, Object obj) {
        this.f139179b = subscriber;
        this.f139178a = obj;
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        lazySet(2);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        lazySet(1);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int l(int i3) {
        return i3 & 1;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f139178a;
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        if (SubscriptionHelper.h(j3) && compareAndSet(0, 1)) {
            Subscriber subscriber = this.f139179b;
            subscriber.h(this.f139178a);
            if (get() != 2) {
                subscriber.onComplete();
            }
        }
    }
}
