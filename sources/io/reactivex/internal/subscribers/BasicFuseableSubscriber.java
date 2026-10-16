package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Subscriber f139116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Subscription f139117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected QueueSubscription f139118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f139119d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f139120f;

    public BasicFuseableSubscriber(Subscriber subscriber) {
        this.f139116a = subscriber;
    }

    protected boolean b() {
        return true;
    }

    protected final void c(Throwable th) {
        Exceptions.b(th);
        this.f139117b.cancel();
        onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f139117b.cancel();
    }

    public void clear() {
        this.f139118c.clear();
    }

    protected final int e(int i3) {
        QueueSubscription queueSubscription = this.f139118c;
        if (queueSubscription == null || (i3 & 4) != 0) {
            return 0;
        }
        int iL = queueSubscription.l(i3);
        if (iL != 0) {
            this.f139120f = iL;
        }
        return iL;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void g(Subscription subscription) {
        if (SubscriptionHelper.i(this.f139117b, subscription)) {
            this.f139117b = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f139118c = (QueueSubscription) subscription;
            }
            if (b()) {
                this.f139116a.g(this);
                a();
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.f139118c.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f139119d) {
            return;
        }
        this.f139119d = true;
        this.f139116a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f139119d) {
            RxJavaPlugins.s(th);
        } else {
            this.f139119d = true;
            this.f139116a.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        this.f139117b.y(j3);
    }

    protected void a() {
    }
}
