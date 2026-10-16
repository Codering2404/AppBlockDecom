package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableAmb<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher[] f135236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Iterable f135237c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AmbCoordinator<T> implements Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AmbInnerSubscriber[] f135239b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f135240c = new AtomicInteger();

        AmbCoordinator(Subscriber subscriber, int i3) {
            this.f135238a = subscriber;
            this.f135239b = new AmbInnerSubscriber[i3];
        }

        public void a(Publisher[] publisherArr) {
            AmbInnerSubscriber[] ambInnerSubscriberArr = this.f135239b;
            int length = ambInnerSubscriberArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                ambInnerSubscriberArr[i3] = new AmbInnerSubscriber(this, i4, this.f135238a);
                i3 = i4;
            }
            this.f135240c.lazySet(0);
            this.f135238a.g(this);
            for (int i5 = 0; i5 < length && this.f135240c.get() == 0; i5++) {
                publisherArr[i5].i(ambInnerSubscriberArr[i5]);
            }
        }

        public boolean b(int i3) {
            int i4 = 0;
            if (this.f135240c.get() != 0 || !this.f135240c.compareAndSet(0, i3)) {
                return false;
            }
            AmbInnerSubscriber[] ambInnerSubscriberArr = this.f135239b;
            int length = ambInnerSubscriberArr.length;
            while (i4 < length) {
                int i5 = i4 + 1;
                if (i5 != i3) {
                    ambInnerSubscriberArr[i4].cancel();
                }
                i4 = i5;
            }
            return true;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135240c.get() != -1) {
                this.f135240c.lazySet(-1);
                for (AmbInnerSubscriber ambInnerSubscriber : this.f135239b) {
                    ambInnerSubscriber.cancel();
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                int i3 = this.f135240c.get();
                if (i3 > 0) {
                    this.f135239b[i3 - 1].y(j3);
                    return;
                }
                if (i3 == 0) {
                    for (AmbInnerSubscriber ambInnerSubscriber : this.f135239b) {
                        ambInnerSubscriber.y(j3);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AmbInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1185974347409665484L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AmbCoordinator f135241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f135242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Subscriber f135243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f135244d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f135245f = new AtomicLong();

        AmbInnerSubscriber(AmbCoordinator ambCoordinator, int i3, Subscriber subscriber) {
            this.f135241a = ambCoordinator;
            this.f135242b = i3;
            this.f135243c = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this, this.f135245f, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135244d) {
                this.f135243c.h(obj);
            } else if (!this.f135241a.b(this.f135242b)) {
                get().cancel();
            } else {
                this.f135244d = true;
                this.f135243c.h(obj);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135244d) {
                this.f135243c.onComplete();
            } else if (!this.f135241a.b(this.f135242b)) {
                get().cancel();
            } else {
                this.f135244d = true;
                this.f135243c.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135244d) {
                this.f135243c.onError(th);
            } else if (this.f135241a.b(this.f135242b)) {
                this.f135244d = true;
                this.f135243c.onError(th);
            } else {
                get().cancel();
                RxJavaPlugins.s(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this, this.f135245f, j3);
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        int length;
        Publisher[] publisherArr = this.f135236b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            try {
                length = 0;
                for (Publisher publisher : this.f135237c) {
                    if (publisher == null) {
                        EmptySubscription.b(new NullPointerException("One of the sources is null"), subscriber);
                        return;
                    }
                    if (length == publisherArr.length) {
                        Publisher[] publisherArr2 = new Publisher[(length >> 2) + length];
                        System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                        publisherArr = publisherArr2;
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
            EmptySubscription.a(subscriber);
        } else if (length == 1) {
            publisherArr[0].i(subscriber);
        } else {
            new AmbCoordinator(subscriber, length).a(publisherArr);
        }
    }
}
