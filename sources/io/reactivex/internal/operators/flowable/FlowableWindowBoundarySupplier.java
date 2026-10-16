package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableWindowBoundarySupplier<T, B> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable f136617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f136618d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryInnerSubscriber<T, B> extends DisposableSubscriber<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainSubscriber f136619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f136620c;

        WindowBoundaryInnerSubscriber(WindowBoundaryMainSubscriber windowBoundaryMainSubscriber) {
            this.f136619b = windowBoundaryMainSubscriber;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136620c) {
                return;
            }
            this.f136620c = true;
            dispose();
            this.f136619b.e(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136620c) {
                return;
            }
            this.f136620c = true;
            this.f136619b.c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136620c) {
                RxJavaPlugins.s(th);
            } else {
                this.f136620c = true;
                this.f136619b.d(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryMainSubscriber<T, B> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final WindowBoundaryInnerSubscriber f136621o = new WindowBoundaryInnerSubscriber(null);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final Object f136622p = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f136624b;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Callable f136630i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Subscription f136632k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f136633l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        UnicastProcessor f136634m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f136635n;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f136625c = new AtomicReference();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicInteger f136626d = new AtomicInteger(1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final MpscLinkedQueue f136627f = new MpscLinkedQueue();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicThrowable f136628g = new AtomicThrowable();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicBoolean f136629h = new AtomicBoolean();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicLong f136631j = new AtomicLong();

        WindowBoundaryMainSubscriber(Subscriber subscriber, int i3, Callable callable) {
            this.f136623a = subscriber;
            this.f136624b = i3;
            this.f136630i = callable;
        }

        void a() {
            AtomicReference atomicReference = this.f136625c;
            WindowBoundaryInnerSubscriber windowBoundaryInnerSubscriber = f136621o;
            Disposable disposable = (Disposable) atomicReference.getAndSet(windowBoundaryInnerSubscriber);
            if (disposable == null || disposable == windowBoundaryInnerSubscriber) {
                return;
            }
            disposable.dispose();
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f136623a;
            MpscLinkedQueue mpscLinkedQueue = this.f136627f;
            AtomicThrowable atomicThrowable = this.f136628g;
            long j3 = this.f136635n;
            int iAddAndGet = 1;
            while (this.f136626d.get() != 0) {
                UnicastProcessor unicastProcessor = this.f136634m;
                boolean z2 = this.f136633l;
                if (z2 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thB = atomicThrowable.b();
                    if (unicastProcessor != null) {
                        this.f136634m = null;
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
                            this.f136634m = null;
                            unicastProcessor.onComplete();
                        }
                        subscriber.onComplete();
                        return;
                    }
                    if (unicastProcessor != null) {
                        this.f136634m = null;
                        unicastProcessor.onError(thB2);
                    }
                    subscriber.onError(thB2);
                    return;
                }
                if (z3) {
                    this.f136635n = j3;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != f136622p) {
                    unicastProcessor.h(objPoll);
                } else {
                    if (unicastProcessor != null) {
                        this.f136634m = null;
                        unicastProcessor.onComplete();
                    }
                    if (!this.f136629h.get()) {
                        if (j3 != this.f136631j.get()) {
                            UnicastProcessor unicastProcessorE = UnicastProcessor.E(this.f136624b, this);
                            this.f136634m = unicastProcessorE;
                            this.f136626d.getAndIncrement();
                            try {
                                Publisher publisher = (Publisher) ObjectHelper.d(this.f136630i.call(), "The other Callable returned a null Publisher");
                                WindowBoundaryInnerSubscriber windowBoundaryInnerSubscriber = new WindowBoundaryInnerSubscriber(this);
                                if (h.a(this.f136625c, null, windowBoundaryInnerSubscriber)) {
                                    publisher.i(windowBoundaryInnerSubscriber);
                                    j3++;
                                    subscriber.h(unicastProcessorE);
                                }
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                atomicThrowable.a(th);
                                this.f136633l = true;
                            }
                        } else {
                            this.f136632k.cancel();
                            a();
                            atomicThrowable.a(new MissingBackpressureException("Could not deliver a window due to lack of requests"));
                            this.f136633l = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.f136634m = null;
        }

        void c() {
            this.f136632k.cancel();
            this.f136633l = true;
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136629h.compareAndSet(false, true)) {
                a();
                if (this.f136626d.decrementAndGet() == 0) {
                    this.f136632k.cancel();
                }
            }
        }

        void d(Throwable th) {
            this.f136632k.cancel();
            if (!this.f136628g.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f136633l = true;
                b();
            }
        }

        void e(WindowBoundaryInnerSubscriber windowBoundaryInnerSubscriber) {
            h.a(this.f136625c, windowBoundaryInnerSubscriber, null);
            this.f136627f.offer(f136622p);
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136632k, subscription)) {
                this.f136632k = subscription;
                this.f136623a.g(this);
                this.f136627f.offer(f136622p);
                b();
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136627f.offer(obj);
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            a();
            this.f136633l = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            a();
            if (!this.f136628g.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f136633l = true;
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f136626d.decrementAndGet() == 0) {
                this.f136632k.cancel();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            BackpressureHelper.a(this.f136631j, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new WindowBoundaryMainSubscriber(subscriber, this.f136618d, this.f136617c));
    }
}
