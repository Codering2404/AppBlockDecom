package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableScan<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f136253c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScanSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f136255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f136257d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f136258f;

        ScanSubscriber(Subscriber subscriber, BiFunction biFunction) {
            this.f136254a = subscriber;
            this.f136255b = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136256c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136256c, subscription)) {
                this.f136256c = subscription;
                this.f136254a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136258f) {
                return;
            }
            Subscriber subscriber = this.f136254a;
            Object obj2 = this.f136257d;
            if (obj2 == null) {
                this.f136257d = obj;
                subscriber.h(obj);
                return;
            }
            try {
                Object objD = ObjectHelper.d(this.f136255b.apply(obj2, obj), "The value returned by the accumulator is null");
                this.f136257d = objD;
                subscriber.h(objD);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136256c.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136258f) {
                return;
            }
            this.f136258f = true;
            this.f136254a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136258f) {
                RxJavaPlugins.s(th);
            } else {
                this.f136258f = true;
                this.f136254a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136256c.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new ScanSubscriber(subscriber, this.f136253c));
    }
}
