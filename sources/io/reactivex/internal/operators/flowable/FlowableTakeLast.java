package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableTakeLast<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f136399c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7240042530241604978L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f136401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f136403d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f136404f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicLong f136405g = new AtomicLong();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicInteger f136406h = new AtomicInteger();

        TakeLastSubscriber(Subscriber subscriber, int i3) {
            this.f136400a = subscriber;
            this.f136401b = i3;
        }

        void a() {
            if (this.f136406h.getAndIncrement() == 0) {
                Subscriber subscriber = this.f136400a;
                long jAddAndGet = this.f136405g.get();
                while (!this.f136404f) {
                    if (this.f136403d) {
                        long j3 = 0;
                        while (j3 != jAddAndGet) {
                            if (this.f136404f) {
                                return;
                            }
                            T tPoll = poll();
                            if (tPoll == null) {
                                subscriber.onComplete();
                                return;
                            } else {
                                subscriber.h(tPoll);
                                j3++;
                            }
                        }
                        if (j3 != 0 && jAddAndGet != Long.MAX_VALUE) {
                            jAddAndGet = this.f136405g.addAndGet(-j3);
                        }
                    }
                    if (this.f136406h.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136404f = true;
            this.f136402c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136402c, subscription)) {
                this.f136402c = subscription;
                this.f136400a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136401b == size()) {
                poll();
            }
            offer(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136403d = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136400a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136405g, j3);
                a();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new TakeLastSubscriber(subscriber, this.f136399c));
    }
}
