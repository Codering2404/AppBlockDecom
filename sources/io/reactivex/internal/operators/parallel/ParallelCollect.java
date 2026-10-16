package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelCollect<T, C> extends ParallelFlowable<C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ParallelFlowable f138557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f138558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiConsumer f138559c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelCollectSubscriber<T, C> extends DeferredScalarSubscriber<T, C> {
        private static final long serialVersionUID = -4767392946044436228L;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final BiConsumer f138560f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f138561g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f138562h;

        ParallelCollectSubscriber(Subscriber subscriber, Object obj, BiConsumer biConsumer) {
            super(subscriber);
            this.f138561g = obj;
            this.f138560f = biConsumer;
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f139133c.cancel();
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f139133c, subscription)) {
                this.f139133c = subscription;
                this.f139174a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f138562h) {
                return;
            }
            try {
                this.f138560f.accept(this.f138561g, obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138562h) {
                return;
            }
            this.f138562h = true;
            Object obj = this.f138561g;
            this.f138561g = null;
            e(obj);
        }

        @Override // io.reactivex.internal.subscribers.DeferredScalarSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138562h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138562h = true;
            this.f138561g = null;
            this.f139174a.onError(th);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138557a.a();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    subscriberArr2[i3] = new ParallelCollectSubscriber(subscriberArr[i3], ObjectHelper.d(this.f138558b.call(), "The initialSupplier returned a null value"), this.f138559c);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    d(subscriberArr, th);
                    return;
                }
            }
            this.f138557a.b(subscriberArr2);
        }
    }

    void d(Subscriber[] subscriberArr, Throwable th) {
        for (Subscriber subscriber : subscriberArr) {
            EmptySubscription.b(th, subscriber);
        }
    }
}
