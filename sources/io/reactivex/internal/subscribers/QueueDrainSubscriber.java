package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Subscriber f139153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final SimplePlainQueue f139154d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected volatile boolean f139155f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected volatile boolean f139156g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Throwable f139157h;

    public QueueDrainSubscriber(Subscriber subscriber, SimplePlainQueue simplePlainQueue) {
        this.f139153c = subscriber;
        this.f139154d = simplePlainQueue;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long a() {
        return this.f139158b.get();
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final int b(int i3) {
        return this.f139159a.addAndGet(i3);
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean c() {
        return this.f139156g;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final boolean d() {
        return this.f139155f;
    }

    public boolean f(Subscriber subscriber, Object obj) {
        return false;
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final long i(long j3) {
        return this.f139158b.addAndGet(-j3);
    }

    public final boolean j() {
        return this.f139159a.getAndIncrement() == 0;
    }

    public final boolean k() {
        return this.f139159a.get() == 0 && this.f139159a.compareAndSet(0, 1);
    }

    protected final void l(Object obj, boolean z2, Disposable disposable) {
        Subscriber subscriber = this.f139153c;
        SimplePlainQueue simplePlainQueue = this.f139154d;
        if (k()) {
            long j3 = this.f139158b.get();
            if (j3 == 0) {
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else {
                if (f(subscriber, obj) && j3 != Long.MAX_VALUE) {
                    i(1L);
                }
                if (b(-1) == 0) {
                    return;
                }
            }
        } else {
            simplePlainQueue.offer(obj);
            if (!j()) {
                return;
            }
        }
        QueueDrainHelper.e(simplePlainQueue, subscriber, z2, disposable, this);
    }

    protected final void m(Object obj, boolean z2, Disposable disposable) {
        Subscriber subscriber = this.f139153c;
        SimplePlainQueue simplePlainQueue = this.f139154d;
        if (k()) {
            long j3 = this.f139158b.get();
            if (j3 == 0) {
                this.f139155f = true;
                disposable.dispose();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (simplePlainQueue.isEmpty()) {
                if (f(subscriber, obj) && j3 != Long.MAX_VALUE) {
                    i(1L);
                }
                if (b(-1) == 0) {
                    return;
                }
            } else {
                simplePlainQueue.offer(obj);
            }
        } else {
            simplePlainQueue.offer(obj);
            if (!j()) {
                return;
            }
        }
        QueueDrainHelper.e(simplePlainQueue, subscriber, z2, disposable, this);
    }

    public final void n(long j3) {
        if (SubscriptionHelper.h(j3)) {
            BackpressureHelper.a(this.f139158b, j3);
        }
    }

    @Override // io.reactivex.internal.util.QueueDrain
    public final Throwable p() {
        return this.f139157h;
    }
}
