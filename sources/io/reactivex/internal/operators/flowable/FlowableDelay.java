package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f135536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f135537d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f135538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f135539g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f135541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f135542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f135543d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f135544f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Subscription f135545g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.f135540a.onComplete();
                } finally {
                    DelaySubscriber.this.f135543d.dispose();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OnError implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Throwable f135547a;

            OnError(Throwable th) {
                this.f135547a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.f135540a.onError(this.f135547a);
                } finally {
                    DelaySubscriber.this.f135543d.dispose();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OnNext implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object f135549a;

            OnNext(Object obj) {
                this.f135549a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelaySubscriber.this.f135540a.h(this.f135549a);
            }
        }

        DelaySubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler.Worker worker, boolean z2) {
            this.f135540a = subscriber;
            this.f135541b = j3;
            this.f135542c = timeUnit;
            this.f135543d = worker;
            this.f135544f = z2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135545g.cancel();
            this.f135543d.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135545g, subscription)) {
                this.f135545g = subscription;
                this.f135540a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135543d.c(new OnNext(obj), this.f135541b, this.f135542c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135543d.c(new OnComplete(), this.f135541b, this.f135542c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135543d.c(new OnError(th), this.f135544f ? this.f135541b : 0L, this.f135542c);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f135545g.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new DelaySubscriber(this.f135539g ? subscriber : new SerializedSubscriber(subscriber), this.f135536c, this.f135537d, this.f135538f.b(), this.f135539g));
    }
}
