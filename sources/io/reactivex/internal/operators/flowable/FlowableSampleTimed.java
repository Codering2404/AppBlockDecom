package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSampleTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136239c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f136240d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f136241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f136242g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicInteger f136243i;

        SampleTimedEmitLast(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j3, timeUnit, scheduler);
            this.f136243i = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void b() {
            c();
            if (this.f136243i.decrementAndGet() == 0) {
                this.f136244a.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f136243i.incrementAndGet() == 2) {
                c();
                if (this.f136243i.decrementAndGet() == 0) {
                    this.f136244a.onComplete();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, j3, timeUnit, scheduler);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void b() {
            this.f136244a.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f136246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler f136247d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f136248f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final SequentialDisposable f136249g = new SequentialDisposable();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Subscription f136250h;

        SampleTimedSubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            this.f136244a = subscriber;
            this.f136245b = j3;
            this.f136246c = timeUnit;
            this.f136247d = scheduler;
        }

        void a() {
            DisposableHelper.a(this.f136249g);
        }

        abstract void b();

        void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.f136248f.get() != 0) {
                    this.f136244a.h(andSet);
                    BackpressureHelper.e(this.f136248f, 1L);
                } else {
                    cancel();
                    this.f136244a.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            a();
            this.f136250h.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136250h, subscription)) {
                this.f136250h = subscription;
                this.f136244a.g(this);
                SequentialDisposable sequentialDisposable = this.f136249g;
                Scheduler scheduler = this.f136247d;
                long j3 = this.f136245b;
                sequentialDisposable.a(scheduler.g(this, j3, j3, this.f136246c));
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            lazySet(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            a();
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            a();
            this.f136244a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136248f, j3);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f136242g) {
            this.f135196b.w(new SampleTimedEmitLast(serializedSubscriber, this.f136239c, this.f136240d, this.f136241f));
        } else {
            this.f135196b.w(new SampleTimedNoLast(serializedSubscriber, this.f136239c, this.f136240d, this.f136241f));
        }
    }
}
