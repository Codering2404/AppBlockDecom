package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long serialVersionUID = 22876611072430776L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final InnerQueuedSubscriberSupport f139142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f139143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f139144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile SimpleQueue f139145d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f139146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f139147g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f139148h;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport innerQueuedSubscriberSupport, int i3) {
        this.f139142a = innerQueuedSubscriberSupport;
        this.f139143b = i3;
        this.f139144c = i3 - (i3 >> 2);
    }

    public boolean a() {
        return this.f139146f;
    }

    public SimpleQueue b() {
        return this.f139145d;
    }

    public void c() {
        if (this.f139148h != 1) {
            long j3 = this.f139147g + 1;
            if (j3 != this.f139144c) {
                this.f139147g = j3;
            } else {
                this.f139147g = 0L;
                get().y(j3);
            }
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.a(this);
    }

    public void d() {
        this.f139146f = true;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (SubscriptionHelper.f(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int iL = queueSubscription.l(3);
                if (iL == 1) {
                    this.f139148h = iL;
                    this.f139145d = queueSubscription;
                    this.f139146f = true;
                    this.f139142a.b(this);
                    return;
                }
                if (iL == 2) {
                    this.f139148h = iL;
                    this.f139145d = queueSubscription;
                    QueueDrainHelper.j(subscription, this.f139143b);
                    return;
                }
            }
            this.f139145d = QueueDrainHelper.c(this.f139143b);
            QueueDrainHelper.j(subscription, this.f139143b);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (this.f139148h == 0) {
            this.f139142a.a(this, obj);
        } else {
            this.f139142a.c();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f139142a.b(this);
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        this.f139142a.d(this, th);
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        if (this.f139148h != 1) {
            long j4 = this.f139147g + j3;
            if (j4 < this.f139144c) {
                this.f139147g = j4;
            } else {
                this.f139147g = 0L;
                get().y(j4);
            }
        }
    }
}
