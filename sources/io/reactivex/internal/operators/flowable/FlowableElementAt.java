package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableElementAt<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f135613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f135614d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f135615f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ElementAtSubscriber<T> extends DeferredScalarSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4066607327284737757L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f135616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Object f135617d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f135618f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Subscription f135619g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f135620h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f135621i;

        ElementAtSubscriber(Subscriber subscriber, long j3, Object obj, boolean z2) {
            super(subscriber);
            this.f135616c = j3;
            this.f135617d = obj;
            this.f135618f = z2;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f135619g.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135619g, subscription)) {
                this.f135619g = subscription;
                this.f139174a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135621i) {
                return;
            }
            long j3 = this.f135620h;
            if (j3 != this.f135616c) {
                this.f135620h = j3 + 1;
                return;
            }
            this.f135621i = true;
            this.f135619g.cancel();
            e(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135621i) {
                return;
            }
            this.f135621i = true;
            Object obj = this.f135617d;
            if (obj != null) {
                e(obj);
            } else if (this.f135618f) {
                this.f139174a.onError(new NoSuchElementException());
            } else {
                this.f139174a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135621i) {
                RxJavaPlugins.s(th);
            } else {
                this.f135621i = true;
                this.f139174a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new ElementAtSubscriber(subscriber, this.f135613c, this.f135614d, this.f135615f));
    }
}
