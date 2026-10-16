package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDoOnLifecycle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Consumer f135605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LongConsumer f135606d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Action f135607f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscriptionLambdaSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f135609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final LongConsumer f135610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Action f135611d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f135612f;

        SubscriptionLambdaSubscriber(Subscriber subscriber, Consumer consumer, LongConsumer longConsumer, Action action) {
            this.f135608a = subscriber;
            this.f135609b = consumer;
            this.f135611d = action;
            this.f135610c = longConsumer;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            Subscription subscription = this.f135612f;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                this.f135612f = subscriptionHelper;
                try {
                    this.f135611d.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
                subscription.cancel();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            try {
                this.f135609b.accept(subscription);
                if (SubscriptionHelper.i(this.f135612f, subscription)) {
                    this.f135612f = subscription;
                    this.f135608a.g(this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                subscription.cancel();
                this.f135612f = SubscriptionHelper.CANCELLED;
                EmptySubscription.b(th, this.f135608a);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135608a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135612f != SubscriptionHelper.CANCELLED) {
                this.f135608a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135612f != SubscriptionHelper.CANCELLED) {
                this.f135608a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            try {
                this.f135610c.accept(j3);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
            this.f135612f.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new SubscriptionLambdaSubscriber(subscriber, this.f135605c, this.f135606d, this.f135607f));
    }
}
