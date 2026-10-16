package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class DisposableSubscriber<T> implements FlowableSubscriber<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final AtomicReference f139508a = new AtomicReference();

    protected final void a() {
        dispose();
    }

    protected void b() {
        ((Subscription) this.f139508a.get()).y(Long.MAX_VALUE);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        SubscriptionHelper.a(this.f139508a);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return this.f139508a.get() == SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public final void g(Subscription subscription) {
        if (EndConsumerHelper.d(this.f139508a, subscription, getClass())) {
            b();
        }
    }
}
