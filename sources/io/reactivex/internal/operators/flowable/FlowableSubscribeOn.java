package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Scheduler f136357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f136358d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscribeOnSubscriber<T> extends AtomicReference<Thread> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler.Worker f136360b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f136361c = new AtomicReference();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f136362d = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f136363f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Publisher f136364g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class Request implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Subscription f136365a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final long f136366b;

            Request(Subscription subscription, long j3) {
                this.f136365a = subscription;
                this.f136366b = j3;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f136365a.y(this.f136366b);
            }
        }

        SubscribeOnSubscriber(Subscriber subscriber, Scheduler.Worker worker, Publisher publisher, boolean z2) {
            this.f136359a = subscriber;
            this.f136360b = worker;
            this.f136364g = publisher;
            this.f136363f = !z2;
        }

        void a(long j3, Subscription subscription) {
            if (this.f136363f || Thread.currentThread() == get()) {
                subscription.y(j3);
            } else {
                this.f136360b.b(new Request(subscription, j3));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f136361c);
            this.f136360b.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this.f136361c, subscription)) {
                long andSet = this.f136362d.getAndSet(0L);
                if (andSet != 0) {
                    a(andSet, subscription);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136359a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136359a.onComplete();
            this.f136360b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136359a.onError(th);
            this.f136360b.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            Publisher publisher = this.f136364g;
            this.f136364g = null;
            publisher.i(this);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                Subscription subscription = (Subscription) this.f136361c.get();
                if (subscription != null) {
                    a(j3, subscription);
                    return;
                }
                BackpressureHelper.a(this.f136362d, j3);
                Subscription subscription2 = (Subscription) this.f136361c.get();
                if (subscription2 != null) {
                    long andSet = this.f136362d.getAndSet(0L);
                    if (andSet != 0) {
                        a(andSet, subscription2);
                    }
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        Scheduler.Worker workerB = this.f136357c.b();
        SubscribeOnSubscriber subscribeOnSubscriber = new SubscribeOnSubscriber(subscriber, workerB, this.f135196b, this.f136358d);
        subscriber.g(subscribeOnSubscriber);
        workerB.b(subscribeOnSubscriber);
    }
}
