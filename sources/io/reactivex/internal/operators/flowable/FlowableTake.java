package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableTake<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136393c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeSubscriber<T> extends AtomicBoolean implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5636543848937116287L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f136396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f136397d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f136398f;

        TakeSubscriber(Subscriber subscriber, long j3) {
            this.f136394a = subscriber;
            this.f136395b = j3;
            this.f136398f = j3;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136397d.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136397d, subscription)) {
                this.f136397d = subscription;
                if (this.f136395b != 0) {
                    this.f136394a.g(this);
                    return;
                }
                subscription.cancel();
                this.f136396c = true;
                EmptySubscription.a(this.f136394a);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136396c) {
                return;
            }
            long j3 = this.f136398f;
            long j4 = j3 - 1;
            this.f136398f = j4;
            if (j3 > 0) {
                boolean z2 = j4 == 0;
                this.f136394a.h(obj);
                if (z2) {
                    this.f136397d.cancel();
                    onComplete();
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136396c) {
                return;
            }
            this.f136396c = true;
            this.f136394a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136396c) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136396c = true;
            this.f136397d.cancel();
            this.f136394a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                if (get() || !compareAndSet(false, true) || j3 < this.f136395b) {
                    this.f136397d.y(j3);
                } else {
                    this.f136397d.y(Long.MAX_VALUE);
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new TakeSubscriber(subscriber, this.f136393c));
    }
}
