package io.reactivex.internal.subscriptions;

import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    private static final long serialVersionUID = -2151279923272604993L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Subscriber f139174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Object f139175b;

    public DeferredScalarSubscription(Subscriber subscriber) {
        this.f139174a = subscriber;
    }

    public void cancel() {
        set(4);
        this.f139175b = null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.f139175b = null;
    }

    public final void e(Object obj) {
        int i3 = get();
        while (i3 != 8) {
            if ((i3 & (-3)) != 0) {
                return;
            }
            if (i3 == 2) {
                lazySet(3);
                Subscriber subscriber = this.f139174a;
                subscriber.h(obj);
                if (get() != 4) {
                    subscriber.onComplete();
                    return;
                }
                return;
            }
            this.f139175b = obj;
            if (compareAndSet(0, 1)) {
                return;
            }
            i3 = get();
            if (i3 == 4) {
                this.f139175b = null;
                return;
            }
        }
        this.f139175b = obj;
        lazySet(16);
        Subscriber subscriber2 = this.f139174a;
        subscriber2.h(obj);
        if (get() != 4) {
            subscriber2.onComplete();
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return get() != 16;
    }

    public final boolean j() {
        return get() == 4;
    }

    public final boolean k() {
        return getAndSet(4) != 4;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int l(int i3) {
        if ((i3 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        Object obj = this.f139175b;
        this.f139175b = null;
        return obj;
    }

    @Override // org.reactivestreams.Subscription
    public final void y(long j3) {
        Object obj;
        if (SubscriptionHelper.h(j3)) {
            do {
                int i3 = get();
                if ((i3 & (-2)) != 0) {
                    return;
                }
                if (i3 == 1) {
                    if (!compareAndSet(1, 3) || (obj = this.f139175b) == null) {
                        return;
                    }
                    this.f139175b = null;
                    Subscriber subscriber = this.f139174a;
                    subscriber.h(obj);
                    if (get() != 4) {
                        subscriber.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }
}
