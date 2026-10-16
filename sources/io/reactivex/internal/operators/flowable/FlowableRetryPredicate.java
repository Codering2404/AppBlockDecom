package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableRetryPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Predicate f136219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f136220d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RetrySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SubscriptionArbiter f136222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Publisher f136223c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Predicate f136224d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f136225f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f136226g;

        RetrySubscriber(Subscriber subscriber, long j3, Predicate predicate, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
            this.f136221a = subscriber;
            this.f136222b = subscriptionArbiter;
            this.f136223c = publisher;
            this.f136224d = predicate;
            this.f136225f = j3;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f136222b.e()) {
                    long j3 = this.f136226g;
                    if (j3 != 0) {
                        this.f136226g = 0L;
                        this.f136222b.i(j3);
                    }
                    this.f136223c.i(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            this.f136222b.j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136226g++;
            this.f136221a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136221a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j3 = this.f136225f;
            if (j3 != Long.MAX_VALUE) {
                this.f136225f = j3 - 1;
            }
            if (j3 == 0) {
                this.f136221a.onError(th);
                return;
            }
            try {
                if (this.f136224d.test(th)) {
                    a();
                } else {
                    this.f136221a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f136221a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.g(subscriptionArbiter);
        new RetrySubscriber(subscriber, this.f136220d, this.f136219c, subscriptionArbiter, this.f135196b).a();
    }
}
