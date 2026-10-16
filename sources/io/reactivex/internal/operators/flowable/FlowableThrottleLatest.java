package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableThrottleLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f136457d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f136458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f136459g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136461b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f136462c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f136463d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f136464f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f136465g = new AtomicReference();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicLong f136466h = new AtomicLong();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Subscription f136467i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f136468j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Throwable f136469k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f136470l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        volatile boolean f136471m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f136472n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f136473o;

        ThrottleLatestSubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler.Worker worker, boolean z2) {
            this.f136460a = subscriber;
            this.f136461b = j3;
            this.f136462c = timeUnit;
            this.f136463d = worker;
            this.f136464f = z2;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference atomicReference = this.f136465g;
            AtomicLong atomicLong = this.f136466h;
            Subscriber subscriber = this.f136460a;
            int iAddAndGet = 1;
            while (!this.f136470l) {
                boolean z2 = this.f136468j;
                if (z2 && this.f136469k != null) {
                    atomicReference.lazySet(null);
                    subscriber.onError(this.f136469k);
                    this.f136463d.dispose();
                    return;
                }
                boolean z3 = atomicReference.get() == null;
                if (z2) {
                    if (z3 || !this.f136464f) {
                        atomicReference.lazySet(null);
                        subscriber.onComplete();
                    } else {
                        Object andSet = atomicReference.getAndSet(null);
                        long j3 = this.f136472n;
                        if (j3 != atomicLong.get()) {
                            this.f136472n = j3 + 1;
                            subscriber.h(andSet);
                            subscriber.onComplete();
                        } else {
                            subscriber.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                        }
                    }
                    this.f136463d.dispose();
                    return;
                }
                if (z3) {
                    if (this.f136471m) {
                        this.f136473o = false;
                        this.f136471m = false;
                    }
                } else if (!this.f136473o || this.f136471m) {
                    Object andSet2 = atomicReference.getAndSet(null);
                    long j4 = this.f136472n;
                    if (j4 == atomicLong.get()) {
                        this.f136467i.cancel();
                        subscriber.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                        this.f136463d.dispose();
                        return;
                    } else {
                        subscriber.h(andSet2);
                        this.f136472n = j4 + 1;
                        this.f136471m = false;
                        this.f136473o = true;
                        this.f136463d.c(this, this.f136461b, this.f136462c);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136470l = true;
            this.f136467i.cancel();
            this.f136463d.dispose();
            if (getAndIncrement() == 0) {
                this.f136465g.lazySet(null);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136467i, subscription)) {
                this.f136467i = subscription;
                this.f136460a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136465g.set(obj);
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136468j = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136469k = th;
            this.f136468j = true;
            a();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f136471m = true;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136466h, j3);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new ThrottleLatestSubscriber(subscriber, this.f136456c, this.f136457d, this.f136458f.b(), this.f136459g));
    }
}
