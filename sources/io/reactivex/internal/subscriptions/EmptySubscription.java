package io.reactivex.internal.subscriptions;

import io.reactivex.internal.fuseable.QueueSubscription;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public enum EmptySubscription implements QueueSubscription<Object> {
    INSTANCE;

    public static void a(Subscriber subscriber) {
        subscriber.g(INSTANCE);
        subscriber.onComplete();
    }

    public static void b(Throwable th, Subscriber subscriber) {
        subscriber.g(INSTANCE);
        subscriber.onError(th);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int l(int i3) {
        return i3 & 2;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        SubscriptionHelper.h(j3);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }
}
