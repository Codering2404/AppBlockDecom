package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ForEachWhileSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Predicate f139135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f139136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Action f139137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f139138d;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        SubscriptionHelper.a(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (this.f139138d) {
            return;
        }
        try {
            if (this.f139135a.test(obj)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            Exceptions.b(th);
            dispose();
            onError(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f139138d) {
            return;
        }
        this.f139138d = true;
        try {
            this.f139137c.run();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f139138d) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139138d = true;
        try {
            this.f139136b.accept(th);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(th, th2));
        }
    }
}
