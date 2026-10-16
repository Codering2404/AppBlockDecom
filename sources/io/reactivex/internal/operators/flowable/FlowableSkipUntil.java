package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
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
public final class FlowableSkipUntil<T, U> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f136344c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipUntilMainSubscriber<T> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6270983465606289181L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136345a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f136346b = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicLong f136347c = new AtomicLong();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final OtherSubscriber f136348d = new OtherSubscriber();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicThrowable f136349f = new AtomicThrowable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f136350g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OtherSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
            private static final long serialVersionUID = -5592042965931999169L;

            OtherSubscriber() {
            }

            @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
            public void g(Subscription subscription) {
                SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
            }

            @Override // org.reactivestreams.Subscriber
            public void h(Object obj) {
                SkipUntilMainSubscriber.this.f136350g = true;
                get().cancel();
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                SkipUntilMainSubscriber.this.f136350g = true;
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                SubscriptionHelper.a(SkipUntilMainSubscriber.this.f136346b);
                SkipUntilMainSubscriber skipUntilMainSubscriber = SkipUntilMainSubscriber.this;
                HalfSerializer.d(skipUntilMainSubscriber.f136345a, th, skipUntilMainSubscriber, skipUntilMainSubscriber.f136349f);
            }
        }

        SkipUntilMainSubscriber(Subscriber subscriber) {
            this.f136345a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f136346b);
            SubscriptionHelper.a(this.f136348d);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f136346b, this.f136347c, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (o(obj)) {
                return;
            }
            ((Subscription) this.f136346b.get()).y(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            if (!this.f136350g) {
                return false;
            }
            HalfSerializer.f(this.f136345a, obj, this, this.f136349f);
            return true;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.a(this.f136348d);
            HalfSerializer.b(this.f136345a, this, this.f136349f);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.a(this.f136348d);
            HalfSerializer.d(this.f136345a, th, this, this.f136349f);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this.f136346b, this.f136347c, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        SkipUntilMainSubscriber skipUntilMainSubscriber = new SkipUntilMainSubscriber(subscriber);
        subscriber.g(skipUntilMainSubscriber);
        this.f136344c.i(skipUntilMainSubscriber.f136348d);
        this.f135196b.w(skipUntilMainSubscriber);
    }
}
