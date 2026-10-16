package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.LambdaConsumerIntrospection;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BoundedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription, Disposable, LambdaConsumerIntrospection {
    private static final long serialVersionUID = -7251123623727029452L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Consumer f139127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f139128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Action f139129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Consumer f139130d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f139131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f139132g;

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        SubscriptionHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (SubscriptionHelper.f(this, subscription)) {
            try {
                this.f139130d.accept(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                subscription.cancel();
                onError(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (e()) {
            return;
        }
        try {
            this.f139127a.accept(obj);
            int i3 = this.f139131f + 1;
            if (i3 != this.f139132g) {
                this.f139131f = i3;
            } else {
                this.f139131f = 0;
                get().y(this.f139132g);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.f139129c.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        Subscription subscription = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (subscription == subscriptionHelper) {
            RxJavaPlugins.s(th);
            return;
        }
        lazySet(subscriptionHelper);
        try {
            this.f139128b.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(th, th2));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        get().y(j3);
    }
}
