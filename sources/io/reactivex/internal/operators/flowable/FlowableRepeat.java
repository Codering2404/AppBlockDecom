package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableRepeat<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136147c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SubscriptionArbiter f136149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Publisher f136150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f136151d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f136152f;

        RepeatSubscriber(Subscriber subscriber, long j3, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
            this.f136148a = subscriber;
            this.f136149b = subscriptionArbiter;
            this.f136150c = publisher;
            this.f136151d = j3;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f136149b.e()) {
                    long j3 = this.f136152f;
                    if (j3 != 0) {
                        this.f136152f = 0L;
                        this.f136149b.i(j3);
                    }
                    this.f136150c.i(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            this.f136149b.j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136152f++;
            this.f136148a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j3 = this.f136151d;
            if (j3 != Long.MAX_VALUE) {
                this.f136151d = j3 - 1;
            }
            if (j3 != 0) {
                a();
            } else {
                this.f136148a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136148a.onError(th);
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.g(subscriptionArbiter);
        long j3 = this.f136147c;
        new RepeatSubscriber(subscriber, j3 != Long.MAX_VALUE ? j3 - 1 : Long.MAX_VALUE, subscriptionArbiter, this.f135196b).a();
    }
}
