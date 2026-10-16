package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableWindowBoundary<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f136583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f136584d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainSubscriber f136585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f136586c;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber windowBoundaryMainSubscriber) {
            this.f136585b = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136586c) {
                return;
            }
            this.f136585b.d();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136586c) {
                return;
            }
            this.f136586c = true;
            this.f136585b.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136586c) {
                RxJavaPlugins.s(th);
            } else {
                this.f136586c = true;
                this.f136585b.c(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        static final Object f136587n = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f136589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowBoundaryInnerSubscriber f136590c = new WindowBoundaryInnerSubscriber(this);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f136591d = new AtomicReference();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicInteger f136592f = new AtomicInteger(1);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final MpscLinkedQueue f136593g = new MpscLinkedQueue();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicThrowable f136594h = new AtomicThrowable();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicBoolean f136595i = new AtomicBoolean();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicLong f136596j = new AtomicLong();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f136597k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        UnicastProcessor f136598l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f136599m;

        WindowBoundaryMainSubscriber(Subscriber subscriber, int i3) {
            this.f136588a = subscriber;
            this.f136589b = i3;
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f136588a;
            MpscLinkedQueue mpscLinkedQueue = this.f136593g;
            AtomicThrowable atomicThrowable = this.f136594h;
            long j3 = this.f136599m;
            int iAddAndGet = 1;
            while (this.f136592f.get() != 0) {
                UnicastProcessor unicastProcessor = this.f136598l;
                boolean z2 = this.f136597k;
                if (z2 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thB = atomicThrowable.b();
                    if (unicastProcessor != null) {
                        this.f136598l = null;
                        unicastProcessor.onError(thB);
                    }
                    subscriber.onError(thB);
                    return;
                }
                Object objPoll = mpscLinkedQueue.poll();
                boolean z3 = objPoll == null;
                if (z2 && z3) {
                    Throwable thB2 = atomicThrowable.b();
                    if (thB2 == null) {
                        if (unicastProcessor != null) {
                            this.f136598l = null;
                            unicastProcessor.onComplete();
                        }
                        subscriber.onComplete();
                        return;
                    }
                    if (unicastProcessor != null) {
                        this.f136598l = null;
                        unicastProcessor.onError(thB2);
                    }
                    subscriber.onError(thB2);
                    return;
                }
                if (z3) {
                    this.f136599m = j3;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != f136587n) {
                    unicastProcessor.h(objPoll);
                } else {
                    if (unicastProcessor != null) {
                        this.f136598l = null;
                        unicastProcessor.onComplete();
                    }
                    if (!this.f136595i.get()) {
                        UnicastProcessor unicastProcessorE = UnicastProcessor.E(this.f136589b, this);
                        this.f136598l = unicastProcessorE;
                        this.f136592f.getAndIncrement();
                        if (j3 != this.f136596j.get()) {
                            j3++;
                            subscriber.h(unicastProcessorE);
                        } else {
                            SubscriptionHelper.a(this.f136591d);
                            this.f136590c.dispose();
                            atomicThrowable.a(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                            this.f136597k = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.f136598l = null;
        }

        void b() {
            SubscriptionHelper.a(this.f136591d);
            this.f136597k = true;
            a();
        }

        void c(Throwable th) {
            SubscriptionHelper.a(this.f136591d);
            if (!this.f136594h.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f136597k = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136595i.compareAndSet(false, true)) {
                this.f136590c.dispose();
                if (this.f136592f.decrementAndGet() == 0) {
                    SubscriptionHelper.a(this.f136591d);
                }
            }
        }

        void d() {
            this.f136593g.offer(f136587n);
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this.f136591d, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136593g.offer(obj);
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136590c.dispose();
            this.f136597k = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136590c.dispose();
            if (!this.f136594h.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f136597k = true;
                a();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f136592f.decrementAndGet() == 0) {
                SubscriptionHelper.a(this.f136591d);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            BackpressureHelper.a(this.f136596j, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = new WindowBoundaryMainSubscriber(subscriber, this.f136584d);
        subscriber.g(windowBoundaryMainSubscriber);
        windowBoundaryMainSubscriber.d();
        this.f136583c.i(windowBoundaryMainSubscriber.f136590c);
        this.f135196b.w(windowBoundaryMainSubscriber);
    }
}
