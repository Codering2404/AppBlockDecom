package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableRetryBiPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiPredicate f136212c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RetryBiSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SubscriptionArbiter f136214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Publisher f136215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final BiPredicate f136216d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f136217f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f136218g;

        RetryBiSubscriber(Subscriber subscriber, BiPredicate biPredicate, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
            this.f136213a = subscriber;
            this.f136214b = subscriptionArbiter;
            this.f136215c = publisher;
            this.f136216d = biPredicate;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f136214b.e()) {
                    long j3 = this.f136218g;
                    if (j3 != 0) {
                        this.f136218g = 0L;
                        this.f136214b.i(j3);
                    }
                    this.f136215c.i(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            this.f136214b.j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136218g++;
            this.f136213a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136213a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                BiPredicate biPredicate = this.f136216d;
                int i3 = this.f136217f + 1;
                this.f136217f = i3;
                if (biPredicate.test(Integer.valueOf(i3), th)) {
                    a();
                } else {
                    this.f136213a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f136213a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.g(subscriptionArbiter);
        new RetryBiSubscriber(subscriber, this.f136212c, subscriptionArbiter, this.f135196b).a();
    }
}
