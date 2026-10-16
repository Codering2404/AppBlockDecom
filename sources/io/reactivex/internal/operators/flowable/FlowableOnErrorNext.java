package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableOnErrorNext<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f136047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f136048d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnErrorNextSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4063763155303814625L;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Subscriber f136049j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final Function f136050k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final boolean f136051l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f136052m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f136053n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        long f136054o;

        OnErrorNextSubscriber(Subscriber subscriber, Function function, boolean z2) {
            super(false);
            this.f136049j = subscriber;
            this.f136050k = function;
            this.f136051l = z2;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136053n) {
                return;
            }
            if (!this.f136052m) {
                this.f136054o++;
            }
            this.f136049j.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136053n) {
                return;
            }
            this.f136053n = true;
            this.f136052m = true;
            this.f136049j.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136052m) {
                if (this.f136053n) {
                    RxJavaPlugins.s(th);
                    return;
                } else {
                    this.f136049j.onError(th);
                    return;
                }
            }
            this.f136052m = true;
            if (this.f136051l && !(th instanceof Exception)) {
                this.f136049j.onError(th);
                return;
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.d(this.f136050k.apply(th), "The nextSupplier returned a null Publisher");
                long j3 = this.f136054o;
                if (j3 != 0) {
                    i(j3);
                }
                publisher.i(this);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f136049j.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        OnErrorNextSubscriber onErrorNextSubscriber = new OnErrorNextSubscriber(subscriber, this.f136047c, this.f136048d);
        subscriber.g(onErrorNextSubscriber);
        this.f135196b.w(onErrorNextSubscriber);
    }
}
