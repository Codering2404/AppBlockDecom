package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 7917814472626990048L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Subscriber f139160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Subscription f139161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Object f139162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected long f139163d;

    public SinglePostCompleteSubscriber(Subscriber subscriber) {
        this.f139160a = subscriber;
    }

    protected final void b(Object obj) {
        long j3 = this.f139163d;
        if (j3 != 0) {
            BackpressureHelper.e(this, j3);
        }
        while (true) {
            long j4 = get();
            if ((j4 & Long.MIN_VALUE) != 0) {
                c(obj);
                return;
            }
            if ((j4 & Long.MAX_VALUE) != 0) {
                lazySet(-9223372036854775807L);
                this.f139160a.h(obj);
                this.f139160a.onComplete();
                return;
            } else {
                this.f139162c = obj;
                if (compareAndSet(0L, Long.MIN_VALUE)) {
                    return;
                } else {
                    this.f139162c = null;
                }
            }
        }
    }

    public void cancel() {
        this.f139161b.cancel();
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (SubscriptionHelper.i(this.f139161b, subscription)) {
            this.f139161b = subscription;
            this.f139160a.g(this);
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void y(long j3) {
        long j4;
        if (SubscriptionHelper.h(j3)) {
            do {
                j4 = get();
                if ((j4 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, -9223372036854775807L)) {
                        this.f139160a.h(this.f139162c);
                        this.f139160a.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j4, BackpressureHelper.c(j4, j3)));
            this.f139161b.y(j3);
        }
    }

    protected void c(Object obj) {
    }
}
