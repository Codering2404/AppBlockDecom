package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Scheduler f136474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f136475d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TimeUnit f136477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Scheduler f136478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f136479d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f136480f;

        TimeIntervalSubscriber(Subscriber subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.f136476a = subscriber;
            this.f136478c = scheduler;
            this.f136477b = timeUnit;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136479d.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136479d, subscription)) {
                this.f136480f = this.f136478c.c(this.f136477b);
                this.f136479d = subscription;
                this.f136476a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            long jC = this.f136478c.c(this.f136477b);
            long j3 = this.f136480f;
            this.f136480f = jC;
            this.f136476a.h(new Timed(obj, jC - j3, this.f136477b));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136476a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136476a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136479d.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new TimeIntervalSubscriber(subscriber, this.f136475d, this.f136474c));
    }
}
