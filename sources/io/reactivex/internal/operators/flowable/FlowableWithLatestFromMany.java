package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableWithLatestFromMany<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher[] f136688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Iterable f136689d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Function f136690f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return ObjectHelper.d(FlowableWithLatestFromMany.this.f136690f.apply(new Object[]{obj}), "The combiner returned a null value");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WithLatestFromSubscriber<T, R> extends AtomicInteger implements ConditionalSubscriber<T>, Subscription {
        private static final long serialVersionUID = 1577321883966341961L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WithLatestInnerSubscriber[] f136694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceArray f136695d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f136696f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicLong f136697g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicThrowable f136698h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f136699i;

        WithLatestFromSubscriber(Subscriber subscriber, Function function, int i3) {
            this.f136692a = subscriber;
            this.f136693b = function;
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = new WithLatestInnerSubscriber[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                withLatestInnerSubscriberArr[i4] = new WithLatestInnerSubscriber(this, i4);
            }
            this.f136694c = withLatestInnerSubscriberArr;
            this.f136695d = new AtomicReferenceArray(i3);
            this.f136696f = new AtomicReference();
            this.f136697g = new AtomicLong();
            this.f136698h = new AtomicThrowable();
        }

        void a(int i3) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.f136694c;
            for (int i4 = 0; i4 < withLatestInnerSubscriberArr.length; i4++) {
                if (i4 != i3) {
                    withLatestInnerSubscriberArr[i4].a();
                }
            }
        }

        void b(int i3, boolean z2) {
            if (z2) {
                return;
            }
            this.f136699i = true;
            SubscriptionHelper.a(this.f136696f);
            a(i3);
            HalfSerializer.b(this.f136692a, this, this.f136698h);
        }

        void c(int i3, Throwable th) {
            this.f136699i = true;
            SubscriptionHelper.a(this.f136696f);
            a(i3);
            HalfSerializer.d(this.f136692a, th, this, this.f136698h);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this.f136696f);
            for (WithLatestInnerSubscriber withLatestInnerSubscriber : this.f136694c) {
                withLatestInnerSubscriber.a();
            }
        }

        void d(int i3, Object obj) {
            this.f136695d.set(i3, obj);
        }

        void e(Publisher[] publisherArr, int i3) {
            WithLatestInnerSubscriber[] withLatestInnerSubscriberArr = this.f136694c;
            AtomicReference atomicReference = this.f136696f;
            for (int i4 = 0; i4 < i3 && atomicReference.get() != SubscriptionHelper.CANCELLED; i4++) {
                publisherArr[i4].i(withLatestInnerSubscriberArr[i4]);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f136696f, this.f136697g, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (o(obj) || this.f136699i) {
                return;
            }
            ((Subscription) this.f136696f.get()).y(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            if (this.f136699i) {
                return false;
            }
            AtomicReferenceArray atomicReferenceArray = this.f136695d;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            objArr[0] = obj;
            int i3 = 0;
            while (i3 < length) {
                Object obj2 = atomicReferenceArray.get(i3);
                if (obj2 == null) {
                    return false;
                }
                i3++;
                objArr[i3] = obj2;
            }
            try {
                HalfSerializer.f(this.f136692a, ObjectHelper.d(this.f136693b.apply(objArr), "The combiner returned a null value"), this, this.f136698h);
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                onError(th);
                return false;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136699i) {
                return;
            }
            this.f136699i = true;
            a(-1);
            HalfSerializer.b(this.f136692a, this, this.f136698h);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136699i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136699i = true;
            a(-1);
            HalfSerializer.d(this.f136692a, th, this, this.f136698h);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this.f136696f, this.f136697g, j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WithLatestInnerSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object> {
        private static final long serialVersionUID = 3256684027868224024L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WithLatestFromSubscriber f136700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f136701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f136702c;

        WithLatestInnerSubscriber(WithLatestFromSubscriber withLatestFromSubscriber, int i3) {
            this.f136700a = withLatestFromSubscriber;
            this.f136701b = i3;
        }

        void a() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (!this.f136702c) {
                this.f136702c = true;
            }
            this.f136700a.d(this.f136701b, obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136700a.b(this.f136701b, this.f136702c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136700a.c(this.f136701b, th);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        int length;
        Publisher[] publisherArr = this.f136688c;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher publisher : this.f136689d) {
                    if (length == publisherArr.length) {
                        publisherArr = (Publisher[]) Arrays.copyOf(publisherArr, (length >> 1) + length);
                    }
                    int i3 = length + 1;
                    publisherArr[length] = publisher;
                    length = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptySubscription.b(th, subscriber);
                return;
            }
        } else {
            length = publisherArr.length;
        }
        if (length == 0) {
            new FlowableMap(this.f135196b, new SingletonArrayFunc()).x(subscriber);
            return;
        }
        WithLatestFromSubscriber withLatestFromSubscriber = new WithLatestFromSubscriber(subscriber, this.f136690f, length);
        subscriber.g(withLatestFromSubscriber);
        withLatestFromSubscriber.e(publisherArr, length);
        this.f135196b.w(withLatestFromSubscriber);
    }
}
