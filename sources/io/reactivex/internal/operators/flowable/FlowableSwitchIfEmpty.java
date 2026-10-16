package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f136367c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Publisher f136369b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f136371d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SubscriptionArbiter f136370c = new SubscriptionArbiter(false);

        SwitchIfEmptySubscriber(Subscriber subscriber, Publisher publisher) {
            this.f136368a = subscriber;
            this.f136369b = publisher;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            this.f136370c.j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136371d) {
                this.f136371d = false;
            }
            this.f136368a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (!this.f136371d) {
                this.f136368a.onComplete();
            } else {
                this.f136371d = false;
                this.f136369b.i(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136368a.onError(th);
        }
    }

    public FlowableSwitchIfEmpty(Flowable flowable, Publisher publisher) {
        super(flowable);
        this.f136367c = publisher;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(subscriber, this.f136367c);
        subscriber.g(switchIfEmptySubscriber.f136370c);
        this.f135196b.w(switchIfEmptySubscriber);
    }
}
