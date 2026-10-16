package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f136324c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3807491841935125653L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f136326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136327c;

        SkipLastSubscriber(Subscriber subscriber, int i3) {
            super(i3);
            this.f136325a = subscriber;
            this.f136326b = i3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136327c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136327c, subscription)) {
                this.f136327c = subscription;
                this.f136325a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136326b == size()) {
                this.f136325a.h(poll());
            } else {
                this.f136327c.y(1L);
            }
            offer(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136325a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136325a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136327c.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new SkipLastSubscriber(subscriber, this.f136324c));
    }
}
