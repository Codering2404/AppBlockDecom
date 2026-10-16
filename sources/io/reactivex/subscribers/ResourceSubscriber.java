package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ResourceSubscriber<T> implements FlowableSubscriber<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f139509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListCompositeDisposable f139510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicLong f139511c;

    protected void a() {
        b(Long.MAX_VALUE);
    }

    protected final void b(long j3) {
        SubscriptionHelper.b(this.f139509a, this.f139511c, j3);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (SubscriptionHelper.a(this.f139509a)) {
            this.f139510b.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return this.f139509a.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void g(Subscription subscription) {
        if (EndConsumerHelper.d(this.f139509a, subscription, getClass())) {
            long andSet = this.f139511c.getAndSet(0L);
            if (andSet != 0) {
                subscription.y(andSet);
            }
            a();
        }
    }
}
