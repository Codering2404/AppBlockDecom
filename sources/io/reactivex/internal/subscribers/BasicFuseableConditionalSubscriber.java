package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class BasicFuseableConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, QueueSubscription<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ConditionalSubscriber f139111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Subscription f139112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected QueueSubscription f139113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f139114d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f139115f;

    public BasicFuseableConditionalSubscriber(ConditionalSubscriber conditionalSubscriber) {
        this.f139111a = conditionalSubscriber;
    }

    protected boolean b() {
        return true;
    }

    protected final void c(Throwable th) {
        Exceptions.b(th);
        this.f139112b.cancel();
        onError(th);
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        this.f139112b.cancel();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        this.f139113c.clear();
    }

    protected final int e(int i3) {
        QueueSubscription queueSubscription = this.f139113c;
        if (queueSubscription == null || (i3 & 4) != 0) {
            return 0;
        }
        int iL = queueSubscription.l(i3);
        if (iL != 0) {
            this.f139115f = iL;
        }
        return iL;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void g(Subscription subscription) {
        if (SubscriptionHelper.i(this.f139112b, subscription)) {
            this.f139112b = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f139113c = (QueueSubscription) subscription;
            }
            if (b()) {
                this.f139111a.g(this);
                a();
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return this.f139113c.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f139114d) {
            return;
        }
        this.f139114d = true;
        this.f139111a.onComplete();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f139114d) {
            RxJavaPlugins.s(th);
        } else {
            this.f139114d = true;
            this.f139111a.onError(th);
        }
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        this.f139112b.y(j3);
    }

    protected void a() {
    }
}
