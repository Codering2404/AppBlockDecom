package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableWithLatestFrom<T, U, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f136679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Publisher f136680d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WithLatestFromSubscriber<T, U, R> extends AtomicReference<U> implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = -312246233408980075L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f136684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f136685c = new AtomicReference();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f136686d = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f136687f = new AtomicReference();

        WithLatestFromSubscriber(Subscriber subscriber, BiFunction biFunction) {
            this.f136683a = subscriber;
            this.f136684b = biFunction;
        }

        public void a(Throwable th) {
            SubscriptionHelper.a(this.f136685c);
            this.f136683a.onError(th);
        }

        public boolean b(Subscription subscription) {
            return SubscriptionHelper.f(this.f136687f, subscription);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f136685c);
            SubscriptionHelper.a(this.f136687f);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f136685c, this.f136686d, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (o(obj)) {
                return;
            }
            ((Subscription) this.f136685c.get()).y(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            U u2 = get();
            if (u2 != null) {
                try {
                    this.f136683a.h(ObjectHelper.d(this.f136684b.apply(obj, u2), "The combiner returned a null value"));
                    return true;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    this.f136683a.onError(th);
                }
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.a(this.f136687f);
            this.f136683a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.a(this.f136687f);
            this.f136683a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this.f136685c, this.f136686d, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(serializedSubscriber, this.f136679c);
        serializedSubscriber.g(withLatestFromSubscriber);
        this.f136680d.i(new FlowableWithLatestSubscriber(withLatestFromSubscriber));
        this.f135196b.w(withLatestFromSubscriber);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class FlowableWithLatestSubscriber implements FlowableSubscriber<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WithLatestFromSubscriber f136681a;

        FlowableWithLatestSubscriber(WithLatestFromSubscriber withLatestFromSubscriber) {
            this.f136681a = withLatestFromSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (this.f136681a.b(subscription)) {
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136681a.lazySet(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136681a.a(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }
    }
}
