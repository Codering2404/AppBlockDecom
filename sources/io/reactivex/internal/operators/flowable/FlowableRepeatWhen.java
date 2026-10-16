package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableRepeatWhen<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f136159c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RepeatWhenSubscriber<T> extends WhenSourceSubscriber<T, Object> {
        private static final long serialVersionUID = -2680129890138081029L;

        RepeatWhenSubscriber(Subscriber subscriber, FlowableProcessor flowableProcessor, Subscription subscription) {
            super(subscriber, flowableProcessor, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            k(0);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136166l.cancel();
            this.f136164j.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WhenReceiver<T, U> extends AtomicInteger implements FlowableSubscriber<Object>, Subscription {
        private static final long serialVersionUID = 2827772011130406689L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Publisher f136160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f136161b = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicLong f136162c = new AtomicLong();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        WhenSourceSubscriber f136163d;

        WhenReceiver(Publisher publisher) {
            this.f136160a = publisher;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f136161b);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f136161b, this.f136162c, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (getAndIncrement() == 0) {
                while (this.f136161b.get() != SubscriptionHelper.CANCELLED) {
                    this.f136160a.i(this.f136163d);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136163d.cancel();
            this.f136163d.f136164j.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136163d.cancel();
            this.f136163d.f136164j.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this.f136161b, this.f136162c, j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class WhenSourceSubscriber<T, U> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -5604623027276966720L;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected final Subscriber f136164j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        protected final FlowableProcessor f136165k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        protected final Subscription f136166l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private long f136167m;

        WhenSourceSubscriber(Subscriber subscriber, FlowableProcessor flowableProcessor, Subscription subscription) {
            super(false);
            this.f136164j = subscriber;
            this.f136165k = flowableProcessor;
            this.f136166l = subscription;
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public final void cancel() {
            super.cancel();
            this.f136166l.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void g(Subscription subscription) {
            j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public final void h(Object obj) {
            this.f136167m++;
            this.f136164j.h(obj);
        }

        protected final void k(Object obj) {
            j(EmptySubscription.INSTANCE);
            long j3 = this.f136167m;
            if (j3 != 0) {
                this.f136167m = 0L;
                i(j3);
            }
            this.f136166l.y(1L);
            this.f136165k.h(obj);
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        FlowableProcessor flowableProcessorA = UnicastProcessor.D(8).A();
        try {
            Publisher publisher = (Publisher) ObjectHelper.d(this.f136159c.apply(flowableProcessorA), "handler returned a null Publisher");
            WhenReceiver whenReceiver = new WhenReceiver(this.f135196b);
            RepeatWhenSubscriber repeatWhenSubscriber = new RepeatWhenSubscriber(serializedSubscriber, flowableProcessorA, whenReceiver);
            whenReceiver.f136163d = repeatWhenSubscriber;
            subscriber.g(repeatWhenSubscriber);
            publisher.i(whenReceiver);
            whenReceiver.h(0);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
