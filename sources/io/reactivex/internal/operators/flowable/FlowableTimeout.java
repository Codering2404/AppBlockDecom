package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableTimeout<T, U, V> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f136481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f136482d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Publisher f136483f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutConsumer extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 8708641127342403073L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TimeoutSelectorSupport f136484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136485b;

        TimeoutConsumer(long j3, TimeoutSelectorSupport timeoutSelectorSupport) {
            this.f136485b = j3;
            this.f136484a = timeoutSelectorSupport;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            Subscription subscription = (Subscription) get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                subscription.cancel();
                lazySet(subscriptionHelper);
                this.f136484a.c(this.f136485b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f136484a.c(this.f136485b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Object obj = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (obj == subscriptionHelper) {
                RxJavaPlugins.s(th);
            } else {
                lazySet(subscriptionHelper);
                this.f136484a.b(this.f136485b, th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Subscriber f136486j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final Function f136487k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final SequentialDisposable f136488l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final AtomicReference f136489m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final AtomicLong f136490n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Publisher f136491o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        long f136492p;

        TimeoutFallbackSubscriber(Subscriber subscriber, Function function, Publisher publisher) {
            super(true);
            this.f136486j = subscriber;
            this.f136487k = function;
            this.f136488l = new SequentialDisposable();
            this.f136489m = new AtomicReference();
            this.f136491o = publisher;
            this.f136490n = new AtomicLong();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport
        public void b(long j3, Throwable th) {
            if (!this.f136490n.compareAndSet(j3, Long.MAX_VALUE)) {
                RxJavaPlugins.s(th);
            } else {
                SubscriptionHelper.a(this.f136489m);
                this.f136486j.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void c(long j3) {
            if (this.f136490n.compareAndSet(j3, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.f136489m);
                Publisher publisher = this.f136491o;
                this.f136491o = null;
                long j4 = this.f136492p;
                if (j4 != 0) {
                    i(j4);
                }
                publisher.i(new FlowableTimeoutTimed.FallbackSubscriber(this.f136486j, this));
            }
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f136488l.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this.f136489m, subscription)) {
                j(subscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            long j3 = this.f136490n.get();
            if (j3 != Long.MAX_VALUE) {
                long j4 = j3 + 1;
                if (this.f136490n.compareAndSet(j3, j4)) {
                    Disposable disposable = this.f136488l.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f136492p++;
                    this.f136486j.h(obj);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.d(this.f136487k.apply(obj), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j4, this);
                        if (this.f136488l.a(timeoutConsumer)) {
                            publisher.i(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        ((Subscription) this.f136489m.get()).cancel();
                        this.f136490n.getAndSet(Long.MAX_VALUE);
                        this.f136486j.onError(th);
                    }
                }
            }
        }

        void k(Publisher publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.f136488l.a(timeoutConsumer)) {
                    publisher.i(timeoutConsumer);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136490n.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f136488l.dispose();
                this.f136486j.onComplete();
                this.f136488l.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136490n.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136488l.dispose();
            this.f136486j.onError(th);
            this.f136488l.dispose();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface TimeoutSelectorSupport extends FlowableTimeoutTimed.TimeoutSupport {
        void b(long j3, Throwable th);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSelectorSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136494b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SequentialDisposable f136495c = new SequentialDisposable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f136496d = new AtomicReference();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f136497f = new AtomicLong();

        TimeoutSubscriber(Subscriber subscriber, Function function) {
            this.f136493a = subscriber;
            this.f136494b = function;
        }

        void a(Publisher publisher) {
            if (publisher != null) {
                TimeoutConsumer timeoutConsumer = new TimeoutConsumer(0L, this);
                if (this.f136495c.a(timeoutConsumer)) {
                    publisher.i(timeoutConsumer);
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeout.TimeoutSelectorSupport
        public void b(long j3, Throwable th) {
            if (!compareAndSet(j3, Long.MAX_VALUE)) {
                RxJavaPlugins.s(th);
            } else {
                SubscriptionHelper.a(this.f136496d);
                this.f136493a.onError(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void c(long j3) {
            if (compareAndSet(j3, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.f136496d);
                this.f136493a.onError(new TimeoutException());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f136496d);
            this.f136495c.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f136496d, this.f136497f, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            long j3 = get();
            if (j3 != Long.MAX_VALUE) {
                long j4 = 1 + j3;
                if (compareAndSet(j3, j4)) {
                    Disposable disposable = this.f136495c.get();
                    if (disposable != null) {
                        disposable.dispose();
                    }
                    this.f136493a.h(obj);
                    try {
                        Publisher publisher = (Publisher) ObjectHelper.d(this.f136494b.apply(obj), "The itemTimeoutIndicator returned a null Publisher.");
                        TimeoutConsumer timeoutConsumer = new TimeoutConsumer(j4, this);
                        if (this.f136495c.a(timeoutConsumer)) {
                            publisher.i(timeoutConsumer);
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        ((Subscription) this.f136496d.get()).cancel();
                        getAndSet(Long.MAX_VALUE);
                        this.f136493a.onError(th);
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f136495c.dispose();
                this.f136493a.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.s(th);
            } else {
                this.f136495c.dispose();
                this.f136493a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this.f136496d, this.f136497f, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (this.f136483f == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f136482d);
            subscriber.g(timeoutSubscriber);
            timeoutSubscriber.a(this.f136481c);
            this.f135196b.w(timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f136482d, this.f136483f);
        subscriber.g(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.k(this.f136481c);
        this.f135196b.w(timeoutFallbackSubscriber);
    }
}
