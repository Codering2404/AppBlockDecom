package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableCollect<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable f135379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final BiConsumer f135380d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CollectSubscriber<T, U> extends DeferredScalarSubscription<U> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3589550218733891694L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BiConsumer f135381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Object f135382d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f135383f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f135384g;

        CollectSubscriber(Subscriber subscriber, Object obj, BiConsumer biConsumer) {
            super(subscriber);
            this.f135381c = biConsumer;
            this.f135382d = obj;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f135383f.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135383f, subscription)) {
                this.f135383f = subscription;
                this.f139174a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135384g) {
                return;
            }
            try {
                this.f135381c.accept(this.f135382d, obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135383f.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135384g) {
                return;
            }
            this.f135384g = true;
            e(this.f135382d);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135384g) {
                RxJavaPlugins.s(th);
            } else {
                this.f135384g = true;
                this.f139174a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        try {
            this.f135196b.w(new CollectSubscriber(subscriber, ObjectHelper.d(this.f135379c.call(), "The initial value supplied is null"), this.f135380d));
        } catch (Throwable th) {
            EmptySubscription.b(th, subscriber);
        }
    }
}
