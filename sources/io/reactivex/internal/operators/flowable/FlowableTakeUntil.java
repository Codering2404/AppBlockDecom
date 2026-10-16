package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableTakeUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f136428c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeUntilMainSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4945480365982832967L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicLong f136430b = new AtomicLong();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f136431c = new AtomicReference();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final OtherSubscriber f136433f = new OtherSubscriber();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f136432d = new AtomicThrowable();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -3592821756711087922L;

            OtherSubscriber() {
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void g(Subscription subscription) {
                SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
            }

            @Override // org.reactivestreams.Subscriber
            public void h(Object obj) {
                SubscriptionHelper.a(this);
                onComplete();
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                SubscriptionHelper.a(TakeUntilMainSubscriber.this.f136431c);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.b(takeUntilMainSubscriber.f136429a, takeUntilMainSubscriber, takeUntilMainSubscriber.f136432d);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                SubscriptionHelper.a(TakeUntilMainSubscriber.this.f136431c);
                TakeUntilMainSubscriber takeUntilMainSubscriber = TakeUntilMainSubscriber.this;
                HalfSerializer.d(takeUntilMainSubscriber.f136429a, th, takeUntilMainSubscriber, takeUntilMainSubscriber.f136432d);
            }
        }

        TakeUntilMainSubscriber(Subscriber subscriber) {
            this.f136429a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f136431c);
            SubscriptionHelper.a(this.f136433f);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f136431c, this.f136430b, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            HalfSerializer.f(this.f136429a, obj, this, this.f136432d);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.a(this.f136433f);
            HalfSerializer.b(this.f136429a, this, this.f136432d);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.a(this.f136433f);
            HalfSerializer.d(this.f136429a, th, this, this.f136432d);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this.f136431c, this.f136430b, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        TakeUntilMainSubscriber takeUntilMainSubscriber = new TakeUntilMainSubscriber(subscriber);
        subscriber.g(takeUntilMainSubscriber);
        this.f136428c.i(takeUntilMainSubscriber.f136433f);
        this.f135196b.w(takeUntilMainSubscriber);
    }
}
