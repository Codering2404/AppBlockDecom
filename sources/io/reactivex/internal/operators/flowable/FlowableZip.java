package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableZip<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher[] f136703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Iterable f136704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f136705d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f136706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f136707g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = -2434867452883857743L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ZipSubscriber[] f136709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f136710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f136711d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicThrowable f136712f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f136713g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f136714h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Object[] f136715i;

        ZipCoordinator(Subscriber subscriber, Function function, int i3, int i4, boolean z2) {
            this.f136708a = subscriber;
            this.f136710c = function;
            this.f136713g = z2;
            ZipSubscriber[] zipSubscriberArr = new ZipSubscriber[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                zipSubscriberArr[i5] = new ZipSubscriber(this, i4);
            }
            this.f136715i = new Object[i3];
            this.f136709b = zipSubscriberArr;
            this.f136711d = new AtomicLong();
            this.f136712f = new AtomicThrowable();
        }

        void a() {
            for (ZipSubscriber zipSubscriber : this.f136709b) {
                zipSubscriber.cancel();
            }
        }

        void b() {
            long j3;
            boolean z2;
            Object objPoll;
            boolean z3;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f136708a;
            ZipSubscriber[] zipSubscriberArr = this.f136709b;
            int length = zipSubscriberArr.length;
            Object[] objArr = this.f136715i;
            int iAddAndGet = 1;
            do {
                long j4 = this.f136711d.get();
                long j5 = 0;
                while (true) {
                    if (j4 == j5) {
                        j3 = 0;
                        break;
                    }
                    if (this.f136714h) {
                        return;
                    }
                    if (!this.f136713g && this.f136712f.get() != null) {
                        a();
                        subscriber.onError(this.f136712f.b());
                        return;
                    }
                    boolean z4 = false;
                    for (int i3 = 0; i3 < length; i3++) {
                        ZipSubscriber zipSubscriber = zipSubscriberArr[i3];
                        if (objArr[i3] == null) {
                            try {
                                z2 = zipSubscriber.f136721g;
                                SimpleQueue simpleQueue = zipSubscriber.f136719d;
                                objPoll = simpleQueue != null ? simpleQueue.poll() : null;
                                z3 = objPoll == null;
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                this.f136712f.a(th);
                                if (!this.f136713g) {
                                    a();
                                    subscriber.onError(this.f136712f.b());
                                    return;
                                }
                            }
                            if (z2 && z3) {
                                a();
                                if (this.f136712f.get() != null) {
                                    subscriber.onError(this.f136712f.b());
                                    return;
                                } else {
                                    subscriber.onComplete();
                                    return;
                                }
                            }
                            if (z3) {
                                z4 = true;
                            } else {
                                objArr[i3] = objPoll;
                            }
                        }
                    }
                    j3 = 0;
                    if (z4) {
                        break;
                    }
                    try {
                        subscriber.h(ObjectHelper.d(this.f136710c.apply(objArr.clone()), "The zipper returned a null value"));
                        j5++;
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        a();
                        this.f136712f.a(th2);
                        subscriber.onError(this.f136712f.b());
                        return;
                    }
                }
                if (j4 == j5) {
                    if (this.f136714h) {
                        return;
                    }
                    if (!this.f136713g && this.f136712f.get() != null) {
                        a();
                        subscriber.onError(this.f136712f.b());
                        return;
                    }
                    for (int i4 = 0; i4 < length; i4++) {
                        ZipSubscriber zipSubscriber2 = zipSubscriberArr[i4];
                        if (objArr[i4] == null) {
                            try {
                                boolean z5 = zipSubscriber2.f136721g;
                                SimpleQueue simpleQueue2 = zipSubscriber2.f136719d;
                                Object objPoll2 = simpleQueue2 != null ? simpleQueue2.poll() : null;
                                boolean z6 = objPoll2 == null;
                                if (z5 && z6) {
                                    a();
                                    if (this.f136712f.get() != null) {
                                        subscriber.onError(this.f136712f.b());
                                        return;
                                    } else {
                                        subscriber.onComplete();
                                        return;
                                    }
                                }
                                if (!z6) {
                                    objArr[i4] = objPoll2;
                                }
                            } catch (Throwable th3) {
                                Exceptions.b(th3);
                                this.f136712f.a(th3);
                                if (!this.f136713g) {
                                    a();
                                    subscriber.onError(this.f136712f.b());
                                    return;
                                }
                            }
                        }
                    }
                }
                if (j5 != j3) {
                    for (ZipSubscriber zipSubscriber3 : zipSubscriberArr) {
                        zipSubscriber3.y(j5);
                    }
                    if (j4 != Long.MAX_VALUE) {
                        this.f136711d.addAndGet(-j5);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void c(ZipSubscriber zipSubscriber, Throwable th) {
            if (!this.f136712f.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                zipSubscriber.f136721g = true;
                b();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136714h) {
                return;
            }
            this.f136714h = true;
            a();
        }

        void d(Publisher[] publisherArr, int i3) {
            ZipSubscriber[] zipSubscriberArr = this.f136709b;
            for (int i4 = 0; i4 < i3 && !this.f136714h; i4++) {
                if (!this.f136713g && this.f136712f.get() != null) {
                    return;
                }
                publisherArr[i4].i(zipSubscriberArr[i4]);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136711d, j3);
                b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4627193790118206028L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ZipCoordinator f136716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f136717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f136718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        SimpleQueue f136719d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f136720f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f136721g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f136722h;

        ZipSubscriber(ZipCoordinator zipCoordinator, int i3) {
            this.f136716a = zipCoordinator;
            this.f136717b = i3;
            this.f136718c = i3 - (i3 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(7);
                    if (iL == 1) {
                        this.f136722h = iL;
                        this.f136719d = queueSubscription;
                        this.f136721g = true;
                        this.f136716a.b();
                        return;
                    }
                    if (iL == 2) {
                        this.f136722h = iL;
                        this.f136719d = queueSubscription;
                        subscription.y(this.f136717b);
                        return;
                    }
                }
                this.f136719d = new SpscArrayQueue(this.f136717b);
                subscription.y(this.f136717b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136722h != 2) {
                this.f136719d.offer(obj);
            }
            this.f136716a.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136721g = true;
            this.f136716a.b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136716a.c(this, th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (this.f136722h != 1) {
                long j4 = this.f136720f + j3;
                if (j4 < this.f136718c) {
                    this.f136720f = j4;
                } else {
                    this.f136720f = 0L;
                    get().y(j4);
                }
            }
        }
    }

    public FlowableZip(Publisher[] publisherArr, Iterable iterable, Function function, int i3, boolean z2) {
        this.f136703b = publisherArr;
        this.f136704c = iterable;
        this.f136705d = function;
        this.f136706f = i3;
        this.f136707g = z2;
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        int length;
        Publisher[] publisherArr = this.f136703b;
        if (publisherArr == null) {
            publisherArr = new Publisher[8];
            length = 0;
            for (Publisher publisher : this.f136704c) {
                if (length == publisherArr.length) {
                    Publisher[] publisherArr2 = new Publisher[(length >> 2) + length];
                    System.arraycopy(publisherArr, 0, publisherArr2, 0, length);
                    publisherArr = publisherArr2;
                }
                publisherArr[length] = publisher;
                length++;
            }
        } else {
            length = publisherArr.length;
        }
        int i3 = length;
        if (i3 == 0) {
            EmptySubscription.a(subscriber);
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(subscriber, this.f136705d, i3, this.f136706f, this.f136707g);
        subscriber.g(zipCoordinator);
        zipCoordinator.d(publisherArr, i3);
    }
}
