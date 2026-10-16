package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableOnBackpressureDrop<T> extends AbstractFlowableWithUpstream<T, T> implements Consumer<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f136032c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BackpressureDropSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -6246093802440953054L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f136034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f136036d;

        BackpressureDropSubscriber(Subscriber subscriber, Consumer consumer) {
            this.f136033a = subscriber;
            this.f136034b = consumer;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136035c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136035c, subscription)) {
                this.f136035c = subscription;
                this.f136033a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136036d) {
                return;
            }
            if (get() != 0) {
                this.f136033a.h(obj);
                BackpressureHelper.e(this, 1L);
                return;
            }
            try {
                this.f136034b.accept(obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136036d) {
                return;
            }
            this.f136036d = true;
            this.f136033a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136036d) {
                RxJavaPlugins.s(th);
            } else {
                this.f136036d = true;
                this.f136033a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this, j3);
            }
        }
    }

    public FlowableOnBackpressureDrop(Flowable flowable) {
        super(flowable);
        this.f136032c = this;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new BackpressureDropSubscriber(subscriber, this.f136032c));
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
    }
}
