package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSamplePublisher<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f136228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f136229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f136230d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SampleMainEmitLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicInteger f136231g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f136232h;

        SampleMainEmitLast(Subscriber subscriber, Publisher publisher) {
            super(subscriber, publisher);
            this.f136231g = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void b() {
            this.f136232h = true;
            if (this.f136231g.getAndIncrement() == 0) {
                d();
                this.f136233a.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void c() {
            this.f136232h = true;
            if (this.f136231g.getAndIncrement() == 0) {
                d();
                this.f136233a.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void f() {
            if (this.f136231g.getAndIncrement() == 0) {
                do {
                    boolean z2 = this.f136232h;
                    d();
                    if (z2) {
                        this.f136233a.onComplete();
                        return;
                    }
                } while (this.f136231g.decrementAndGet() != 0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SampleMainNoLast<T> extends SamplePublisherSubscriber<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(Subscriber subscriber, Publisher publisher) {
            super(subscriber, publisher);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void b() {
            this.f136233a.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void c() {
            this.f136233a.onComplete();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSamplePublisher.SamplePublisherSubscriber
        void f() {
            d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SamplePublisherSubscriber<T> extends AtomicReference<T> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -3517602651313910099L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Publisher f136234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicLong f136235c = new AtomicLong();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f136236d = new AtomicReference();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f136237f;

        SamplePublisherSubscriber(Subscriber subscriber, Publisher publisher) {
            this.f136233a = subscriber;
            this.f136234b = publisher;
        }

        public void a() {
            this.f136237f.cancel();
            c();
        }

        abstract void b();

        abstract void c();

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f136236d);
            this.f136237f.cancel();
        }

        void d() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.f136235c.get() != 0) {
                    this.f136233a.h(andSet);
                    BackpressureHelper.e(this.f136235c, 1L);
                } else {
                    cancel();
                    this.f136233a.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        public void e(Throwable th) {
            this.f136237f.cancel();
            this.f136233a.onError(th);
        }

        abstract void f();

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136237f, subscription)) {
                this.f136237f = subscription;
                this.f136233a.g(this);
                if (this.f136236d.get() == null) {
                    this.f136234b.i(new SamplerSubscriber(this));
                    subscription.y(Long.MAX_VALUE);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            lazySet(obj);
        }

        void i(Subscription subscription) {
            SubscriptionHelper.g(this.f136236d, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SubscriptionHelper.a(this.f136236d);
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SubscriptionHelper.a(this.f136236d);
            this.f136233a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136235c, j3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SamplerSubscriber<T> implements FlowableSubscriber<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SamplePublisherSubscriber f136238a;

        SamplerSubscriber(SamplePublisherSubscriber samplePublisherSubscriber) {
            this.f136238a = samplePublisherSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            this.f136238a.i(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136238a.f();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136238a.a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136238a.e(th);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        if (this.f136230d) {
            this.f136228b.i(new SampleMainEmitLast(serializedSubscriber, this.f136229c));
        } else {
            this.f136228b.i(new SampleMainNoLast(serializedSubscriber, this.f136229c));
        }
    }
}
