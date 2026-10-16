package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSkipWhile<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Predicate f136352c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f136354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f136356d;

        SkipWhileSubscriber(Subscriber subscriber, Predicate predicate) {
            this.f136353a = subscriber;
            this.f136354b = predicate;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136355c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136355c, subscription)) {
                this.f136355c = subscription;
                this.f136353a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136356d) {
                this.f136353a.h(obj);
                return;
            }
            try {
                if (this.f136354b.test(obj)) {
                    this.f136355c.y(1L);
                } else {
                    this.f136356d = true;
                    this.f136353a.h(obj);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136355c.cancel();
                this.f136353a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136353a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136353a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136355c.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new SkipWhileSubscriber(subscriber, this.f136352c));
    }
}
