package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f136499d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f136500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Publisher f136501g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SubscriptionArbiter f136503b;

        FallbackSubscriber(Subscriber subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.f136502a = subscriber;
            this.f136503b = subscriptionArbiter;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            this.f136503b.j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136502a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136502a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136502a.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Subscriber f136504j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final long f136505k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final TimeUnit f136506l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final Scheduler.Worker f136507m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final SequentialDisposable f136508n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final AtomicReference f136509o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final AtomicLong f136510p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        long f136511q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Publisher f136512r;

        TimeoutFallbackSubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler.Worker worker, Publisher publisher) {
            super(true);
            this.f136504j = subscriber;
            this.f136505k = j3;
            this.f136506l = timeUnit;
            this.f136507m = worker;
            this.f136512r = publisher;
            this.f136508n = new SequentialDisposable();
            this.f136509o = new AtomicReference();
            this.f136510p = new AtomicLong();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void c(long j3) {
            if (this.f136510p.compareAndSet(j3, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.f136509o);
                long j4 = this.f136511q;
                if (j4 != 0) {
                    i(j4);
                }
                Publisher publisher = this.f136512r;
                this.f136512r = null;
                publisher.i(new FallbackSubscriber(this.f136504j, this));
                this.f136507m.dispose();
            }
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f136507m.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this.f136509o, subscription)) {
                j(subscription);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            long j3 = this.f136510p.get();
            if (j3 != Long.MAX_VALUE) {
                long j4 = j3 + 1;
                if (this.f136510p.compareAndSet(j3, j4)) {
                    this.f136508n.get().dispose();
                    this.f136511q++;
                    this.f136504j.h(obj);
                    k(j4);
                }
            }
        }

        void k(long j3) {
            this.f136508n.a(this.f136507m.c(new TimeoutTask(j3, this), this.f136505k, this.f136506l));
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136510p.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f136508n.dispose();
                this.f136504j.onComplete();
                this.f136507m.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136510p.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136508n.dispose();
            this.f136504j.onError(th);
            this.f136507m.dispose();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSupport {
        private static final long serialVersionUID = 3764492702657003550L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f136515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f136516d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final SequentialDisposable f136517f = new SequentialDisposable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f136518g = new AtomicReference();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicLong f136519h = new AtomicLong();

        TimeoutSubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f136513a = subscriber;
            this.f136514b = j3;
            this.f136515c = timeUnit;
            this.f136516d = worker;
        }

        void a(long j3) {
            this.f136517f.a(this.f136516d.c(new TimeoutTask(j3, this), this.f136514b, this.f136515c));
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.TimeoutSupport
        public void c(long j3) {
            if (compareAndSet(j3, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.f136518g);
                this.f136513a.onError(new TimeoutException(ExceptionHelper.d(this.f136514b, this.f136515c)));
                this.f136516d.dispose();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f136518g);
            this.f136516d.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f136518g, this.f136519h, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            long j3 = get();
            if (j3 != Long.MAX_VALUE) {
                long j4 = 1 + j3;
                if (compareAndSet(j3, j4)) {
                    this.f136517f.get().dispose();
                    this.f136513a.h(obj);
                    a(j4);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f136517f.dispose();
                this.f136513a.onComplete();
                this.f136516d.dispose();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136517f.dispose();
            this.f136513a.onError(th);
            this.f136516d.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this.f136518g, this.f136519h, j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface TimeoutSupport {
        void c(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeoutTask implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TimeoutSupport f136520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136521b;

        TimeoutTask(long j3, TimeoutSupport timeoutSupport) {
            this.f136521b = j3;
            this.f136520a = timeoutSupport;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f136520a.c(this.f136521b);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (this.f136501g == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(subscriber, this.f136498c, this.f136499d, this.f136500f.b());
            subscriber.g(timeoutSubscriber);
            timeoutSubscriber.a(0L);
            this.f135196b.w(timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(subscriber, this.f136498c, this.f136499d, this.f136500f.b(), this.f136501g);
        subscriber.g(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.k(0L);
        this.f135196b.w(timeoutFallbackSubscriber);
    }
}
