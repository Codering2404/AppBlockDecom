package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableOnBackpressureError<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BackpressureErrorSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3176480756392482682L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136037a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f136038b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f136039c;

        BackpressureErrorSubscriber(Subscriber subscriber) {
            this.f136037a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136038b.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136038b, subscription)) {
                this.f136038b = subscription;
                this.f136037a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136039c) {
                return;
            }
            if (get() == 0) {
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
            } else {
                this.f136037a.h(obj);
                BackpressureHelper.e(this, 1L);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136039c) {
                return;
            }
            this.f136039c = true;
            this.f136037a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136039c) {
                RxJavaPlugins.s(th);
            } else {
                this.f136039c = true;
                this.f136037a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this, j3);
            }
        }
    }

    public FlowableOnBackpressureError(Flowable flowable) {
        super(flowable);
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new BackpressureErrorSubscriber(subscriber));
    }
}
