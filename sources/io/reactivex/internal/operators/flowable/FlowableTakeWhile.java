package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableTakeWhile<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Predicate f136440c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f136442b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136443c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f136444d;

        TakeWhileSubscriber(Subscriber subscriber, Predicate predicate) {
            this.f136441a = subscriber;
            this.f136442b = predicate;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136443c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136443c, subscription)) {
                this.f136443c = subscription;
                this.f136441a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136444d) {
                return;
            }
            try {
                if (this.f136442b.test(obj)) {
                    this.f136441a.h(obj);
                    return;
                }
                this.f136444d = true;
                this.f136443c.cancel();
                this.f136441a.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136443c.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136444d) {
                return;
            }
            this.f136444d = true;
            this.f136441a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136444d) {
                RxJavaPlugins.s(th);
            } else {
                this.f136444d = true;
                this.f136441a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136443c.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new TakeWhileSubscriber(subscriber, this.f136440c));
    }
}
