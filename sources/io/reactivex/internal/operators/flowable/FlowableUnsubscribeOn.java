package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableUnsubscribeOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Scheduler f136534c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnsubscribeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1015244841293359600L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler f136536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136537c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class Cancellation implements Runnable {
            Cancellation() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeSubscriber.this.f136537c.cancel();
            }
        }

        UnsubscribeSubscriber(Subscriber subscriber, Scheduler scheduler) {
            this.f136535a = subscriber;
            this.f136536b = scheduler;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (compareAndSet(false, true)) {
                this.f136536b.d(new Cancellation());
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136537c, subscription)) {
                this.f136537c = subscription;
                this.f136535a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (get()) {
                return;
            }
            this.f136535a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (get()) {
                return;
            }
            this.f136535a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.s(th);
            } else {
                this.f136535a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136537c.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new UnsubscribeSubscriber(subscriber, this.f136534c));
    }
}
