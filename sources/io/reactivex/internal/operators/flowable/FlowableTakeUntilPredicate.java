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
public final class FlowableTakeUntilPredicate<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Predicate f136435c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InnerSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136436a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Predicate f136437b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136438c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f136439d;

        InnerSubscriber(Subscriber subscriber, Predicate predicate) {
            this.f136436a = subscriber;
            this.f136437b = predicate;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136438c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136438c, subscription)) {
                this.f136438c = subscription;
                this.f136436a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136439d) {
                return;
            }
            this.f136436a.h(obj);
            try {
                if (this.f136437b.test(obj)) {
                    this.f136439d = true;
                    this.f136438c.cancel();
                    this.f136436a.onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136438c.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136439d) {
                return;
            }
            this.f136439d = true;
            this.f136436a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136439d) {
                RxJavaPlugins.s(th);
            } else {
                this.f136439d = true;
                this.f136436a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136438c.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new InnerSubscriber(subscriber, this.f136435c));
    }
}
