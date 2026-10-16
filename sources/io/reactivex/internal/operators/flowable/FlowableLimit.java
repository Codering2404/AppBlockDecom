package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableLimit<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f135928c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LimitSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2288246011222124525L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f135930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f135931c;

        LimitSubscriber(Subscriber subscriber, long j3) {
            this.f135929a = subscriber;
            this.f135930b = j3;
            lazySet(j3);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135931c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135931c, subscription)) {
                if (this.f135930b == 0) {
                    subscription.cancel();
                    EmptySubscription.a(this.f135929a);
                } else {
                    this.f135931c = subscription;
                    this.f135929a.g(this);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            long j3 = this.f135930b;
            if (j3 > 0) {
                long j4 = j3 - 1;
                this.f135930b = j4;
                this.f135929a.h(obj);
                if (j4 == 0) {
                    this.f135931c.cancel();
                    this.f135929a.onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135930b > 0) {
                this.f135930b = 0L;
                this.f135929a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135930b <= 0) {
                RxJavaPlugins.s(th);
            } else {
                this.f135930b = 0L;
                this.f135929a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            long j4;
            long j5;
            if (SubscriptionHelper.h(j3)) {
                do {
                    j4 = get();
                    if (j4 == 0) {
                        return;
                    } else {
                        j5 = j4 <= j3 ? j4 : j3;
                    }
                } while (!compareAndSet(j4, j4 - j5));
                this.f135931c.y(j5);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new LimitSubscriber(subscriber, this.f135928c));
    }
}
