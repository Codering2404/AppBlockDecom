package io.reactivex.subscribers;

import androidx.compose.animation.core.h;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription, Disposable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Subscriber f139521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f139522k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicReference f139523l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicLong f139524m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private QueueSubscription f139525n;

    @Override // org.reactivestreams.Subscription
    public final void cancel() {
        if (this.f139522k) {
            return;
        }
        this.f139522k = true;
        SubscriptionHelper.a(this.f139523l);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return this.f139522k;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        this.f139230f = Thread.currentThread();
        if (subscription == null) {
            this.f139228c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!h.a(this.f139523l, null, subscription)) {
            subscription.cancel();
            if (this.f139523l.get() != SubscriptionHelper.CANCELLED) {
                this.f139228c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
                return;
            }
            return;
        }
        int i3 = this.f139232h;
        if (i3 != 0 && (subscription instanceof QueueSubscription)) {
            QueueSubscription queueSubscription = (QueueSubscription) subscription;
            this.f139525n = queueSubscription;
            int iL = queueSubscription.l(i3);
            this.f139233i = iL;
            if (iL == 1) {
                this.f139231g = true;
                this.f139230f = Thread.currentThread();
                while (true) {
                    try {
                        Object objPoll = this.f139525n.poll();
                        if (objPoll == null) {
                            this.f139229d++;
                            return;
                        }
                        this.f139227b.add(objPoll);
                    } catch (Throwable th) {
                        this.f139228c.add(th);
                        return;
                    }
                }
            }
        }
        this.f139521j.g(subscription);
        long andSet = this.f139524m.getAndSet(0L);
        if (andSet != 0) {
            subscription.y(andSet);
        }
        b();
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (!this.f139231g) {
            this.f139231g = true;
            if (this.f139523l.get() == null) {
                this.f139228c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f139230f = Thread.currentThread();
        if (this.f139233i != 2) {
            this.f139227b.add(obj);
            if (obj == null) {
                this.f139228c.add(new NullPointerException("onNext received a null value"));
            }
            this.f139521j.h(obj);
            return;
        }
        while (true) {
            try {
                Object objPoll = this.f139525n.poll();
                if (objPoll == null) {
                    return;
                } else {
                    this.f139227b.add(objPoll);
                }
            } catch (Throwable th) {
                this.f139228c.add(th);
                this.f139525n.cancel();
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (!this.f139231g) {
            this.f139231g = true;
            if (this.f139523l.get() == null) {
                this.f139228c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f139230f = Thread.currentThread();
            this.f139229d++;
            this.f139521j.onComplete();
        } finally {
            this.f139226a.countDown();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (!this.f139231g) {
            this.f139231g = true;
            if (this.f139523l.get() == null) {
                this.f139228c.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f139230f = Thread.currentThread();
            this.f139228c.add(th);
            if (th == null) {
                this.f139228c.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.f139521j.onError(th);
            this.f139226a.countDown();
        } catch (Throwable th2) {
            this.f139226a.countDown();
            throw th2;
        }
    }

    @Override // org.reactivestreams.Subscription
    public final void y(long j3) {
        SubscriptionHelper.b(this.f139523l, this.f139524m, j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum EmptySubscriber implements FlowableSubscriber<Object> {
        INSTANCE;

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
        }
    }

    protected void b() {
    }
}
