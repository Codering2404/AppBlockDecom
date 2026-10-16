package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableThrottleFirstTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f136446d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f136447f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DebounceTimedSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f136450c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f136451d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f136452f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final SequentialDisposable f136453g = new SequentialDisposable();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f136454h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f136455i;

        DebounceTimedSubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f136448a = subscriber;
            this.f136449b = j3;
            this.f136450c = timeUnit;
            this.f136451d = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136452f.cancel();
            this.f136451d.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136452f, subscription)) {
                this.f136452f = subscription;
                this.f136448a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136455i || this.f136454h) {
                return;
            }
            this.f136454h = true;
            if (get() == 0) {
                this.f136455i = true;
                cancel();
                this.f136448a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            } else {
                this.f136448a.h(obj);
                BackpressureHelper.e(this, 1L);
                Disposable disposable = this.f136453g.get();
                if (disposable != null) {
                    disposable.dispose();
                }
                this.f136453g.a(this.f136451d.c(this, this.f136449b, this.f136450c));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136455i) {
                return;
            }
            this.f136455i = true;
            this.f136448a.onComplete();
            this.f136451d.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136455i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136455i = true;
            this.f136448a.onError(th);
            this.f136451d.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f136454h = false;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this, j3);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new DebounceTimedSubscriber(new SerializedSubscriber(subscriber), this.f136445c, this.f136446d, this.f136447f.b()));
    }
}
