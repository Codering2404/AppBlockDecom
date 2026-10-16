package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDelaySubscriptionOther<T, U> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f135551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f135552c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MainSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2259811067697317255L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Publisher f135554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final OtherSubscriber f135555c = new OtherSubscriber();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f135556d = new AtomicReference();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3892798459447644106L;

            OtherSubscriber() {
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void g(Subscription subscription) {
                if (SubscriptionHelper.f(this, subscription)) {
                    subscription.y(Long.MAX_VALUE);
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void h(Object obj) {
                Subscription subscription = get();
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (subscription != subscriptionHelper) {
                    lazySet(subscriptionHelper);
                    subscription.cancel();
                    MainSubscriber.this.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                if (get() != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.a();
                }
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                if (get() != SubscriptionHelper.CANCELLED) {
                    MainSubscriber.this.f135553a.onError(th);
                } else {
                    RxJavaPlugins.s(th);
                }
            }
        }

        MainSubscriber(Subscriber subscriber, Publisher publisher) {
            this.f135553a = subscriber;
            this.f135554b = publisher;
        }

        void a() {
            this.f135554b.i(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f135555c);
            SubscriptionHelper.a(this.f135556d);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f135556d, this, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135553a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135553a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135553a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                SubscriptionHelper.b(this.f135556d, this, j3);
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        MainSubscriber mainSubscriber = new MainSubscriber(subscriber, this.f135551b);
        subscriber.g(mainSubscriber);
        this.f135552c.i(mainSubscriber.f135555c);
    }
}
