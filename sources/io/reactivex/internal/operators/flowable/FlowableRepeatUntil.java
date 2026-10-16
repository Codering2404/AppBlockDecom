package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableRepeatUntil<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BooleanSupplier f136153c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RepeatSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SubscriptionArbiter f136155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Publisher f136156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final BooleanSupplier f136157d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f136158f;

        RepeatSubscriber(Subscriber subscriber, BooleanSupplier booleanSupplier, SubscriptionArbiter subscriptionArbiter, Publisher publisher) {
            this.f136154a = subscriber;
            this.f136155b = subscriptionArbiter;
            this.f136156c = publisher;
            this.f136157d = booleanSupplier;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f136155b.e()) {
                    long j3 = this.f136158f;
                    if (j3 != 0) {
                        this.f136158f = 0L;
                        this.f136155b.i(j3);
                    }
                    this.f136156c.i(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            this.f136155b.j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136158f++;
            this.f136154a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                if (this.f136157d.a()) {
                    this.f136154a.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136154a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136154a.onError(th);
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        subscriber.g(subscriptionArbiter);
        new RepeatSubscriber(subscriber, this.f136153c, subscriptionArbiter, this.f135196b).a();
    }
}
