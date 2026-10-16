package io.reactivex.processors;

import androidx.compose.animation.core.h;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@SchedulerSupport
@BackpressureSupport
public final class MulticastProcessor<T> extends FlowableProcessor<T> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final MulticastSubscription[] f139318o = new MulticastSubscription[0];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final MulticastSubscription[] f139319p = new MulticastSubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicInteger f139320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f139321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference f139322d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicBoolean f139323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f139324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f139325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f139326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    volatile SimpleQueue f139327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile boolean f139328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    volatile Throwable f139329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f139330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f139331n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -363282618957264509L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f139332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MulticastProcessor f139333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f139334c;

        MulticastSubscription(Subscriber subscriber, MulticastProcessor multicastProcessor) {
            this.f139332a = subscriber;
            this.f139333b = multicastProcessor;
        }

        void a() {
            if (get() != Long.MIN_VALUE) {
                this.f139332a.onComplete();
            }
        }

        void b(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f139332a.onError(th);
            }
        }

        void c(Object obj) {
            if (get() != Long.MIN_VALUE) {
                this.f139334c++;
                this.f139332a.h(obj);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f139333b.D(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            long j4;
            long j5;
            if (SubscriptionHelper.h(j3)) {
                do {
                    j4 = get();
                    if (j4 == Long.MIN_VALUE) {
                        return;
                    }
                    if (j4 == Long.MAX_VALUE) {
                        return;
                    } else {
                        j5 = j4 + j3;
                    }
                } while (!compareAndSet(j4, j5 >= 0 ? j5 : Long.MAX_VALUE));
                this.f139333b.C();
            }
        }
    }

    boolean B(MulticastSubscription multicastSubscription) {
        MulticastSubscription[] multicastSubscriptionArr;
        MulticastSubscription[] multicastSubscriptionArr2;
        do {
            multicastSubscriptionArr = (MulticastSubscription[]) this.f139322d.get();
            if (multicastSubscriptionArr == f139319p) {
                return false;
            }
            int length = multicastSubscriptionArr.length;
            multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
            multicastSubscriptionArr2[length] = multicastSubscription;
        } while (!h.a(this.f139322d, multicastSubscriptionArr, multicastSubscriptionArr2));
        return true;
    }

    void C() {
        Object objPoll;
        if (this.f139320b.getAndIncrement() != 0) {
            return;
        }
        AtomicReference atomicReference = this.f139322d;
        int i3 = this.f139330m;
        int i4 = this.f139325h;
        int i5 = this.f139331n;
        int iAddAndGet = 1;
        while (true) {
            SimpleQueue simpleQueue = this.f139327j;
            if (simpleQueue != null) {
                MulticastSubscription[] multicastSubscriptionArr = (MulticastSubscription[]) atomicReference.get();
                if (multicastSubscriptionArr.length != 0) {
                    int i6 = 0;
                    long jMin = -1;
                    for (MulticastSubscription multicastSubscription : multicastSubscriptionArr) {
                        long j3 = multicastSubscription.get();
                        if (j3 >= 0) {
                            jMin = jMin == -1 ? j3 - multicastSubscription.f139334c : Math.min(jMin, j3 - multicastSubscription.f139334c);
                        }
                    }
                    int i7 = i3;
                    while (jMin > 0) {
                        MulticastSubscription[] multicastSubscriptionArr2 = (MulticastSubscription[]) atomicReference.get();
                        if (multicastSubscriptionArr2 == f139319p) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr2) {
                            break;
                        }
                        boolean z2 = this.f139328k;
                        try {
                            objPoll = simpleQueue.poll();
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            SubscriptionHelper.a(this.f139321c);
                            this.f139329l = th;
                            this.f139328k = true;
                            objPoll = null;
                            z2 = true;
                        }
                        boolean z3 = objPoll == null;
                        if (z2 && z3) {
                            Throwable th2 = this.f139329l;
                            if (th2 != null) {
                                MulticastSubscription[] multicastSubscriptionArr3 = (MulticastSubscription[]) atomicReference.getAndSet(f139319p);
                                int length = multicastSubscriptionArr3.length;
                                while (i6 < length) {
                                    multicastSubscriptionArr3[i6].b(th2);
                                    i6++;
                                }
                                return;
                            }
                            MulticastSubscription[] multicastSubscriptionArr4 = (MulticastSubscription[]) atomicReference.getAndSet(f139319p);
                            int length2 = multicastSubscriptionArr4.length;
                            while (i6 < length2) {
                                multicastSubscriptionArr4[i6].a();
                                i6++;
                            }
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        for (MulticastSubscription multicastSubscription2 : multicastSubscriptionArr) {
                            multicastSubscription2.c(objPoll);
                        }
                        jMin--;
                        if (i5 != 1 && (i7 = i7 + 1) == i4) {
                            ((Subscription) this.f139321c.get()).y(i4);
                            i7 = 0;
                        }
                    }
                    if (jMin == 0) {
                        MulticastSubscription[] multicastSubscriptionArr5 = (MulticastSubscription[]) atomicReference.get();
                        MulticastSubscription[] multicastSubscriptionArr6 = f139319p;
                        if (multicastSubscriptionArr5 == multicastSubscriptionArr6) {
                            simpleQueue.clear();
                            return;
                        }
                        if (multicastSubscriptionArr != multicastSubscriptionArr5) {
                            i3 = i7;
                        } else if (this.f139328k && simpleQueue.isEmpty()) {
                            Throwable th3 = this.f139329l;
                            if (th3 != null) {
                                MulticastSubscription[] multicastSubscriptionArr7 = (MulticastSubscription[]) atomicReference.getAndSet(multicastSubscriptionArr6);
                                int length3 = multicastSubscriptionArr7.length;
                                while (i6 < length3) {
                                    multicastSubscriptionArr7[i6].b(th3);
                                    i6++;
                                }
                                return;
                            }
                            MulticastSubscription[] multicastSubscriptionArr8 = (MulticastSubscription[]) atomicReference.getAndSet(multicastSubscriptionArr6);
                            int length4 = multicastSubscriptionArr8.length;
                            while (i6 < length4) {
                                multicastSubscriptionArr8[i6].a();
                                i6++;
                            }
                            return;
                        }
                    }
                    i3 = i7;
                }
            }
            iAddAndGet = this.f139320b.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    void D(MulticastSubscription multicastSubscription) {
        while (true) {
            MulticastSubscription[] multicastSubscriptionArr = (MulticastSubscription[]) this.f139322d.get();
            int length = multicastSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (multicastSubscriptionArr[i3] == multicastSubscription) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length != 1) {
                MulticastSubscription[] multicastSubscriptionArr2 = new MulticastSubscription[length - 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, i3);
                System.arraycopy(multicastSubscriptionArr, i3 + 1, multicastSubscriptionArr2, i3, (length - i3) - 1);
                if (h.a(this.f139322d, multicastSubscriptionArr, multicastSubscriptionArr2)) {
                    return;
                }
            } else if (this.f139326i) {
                if (h.a(this.f139322d, multicastSubscriptionArr, f139319p)) {
                    SubscriptionHelper.a(this.f139321c);
                    this.f139323f.set(true);
                    return;
                }
            } else if (h.a(this.f139322d, multicastSubscriptionArr, f139318o)) {
                return;
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (SubscriptionHelper.f(this.f139321c, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int iL = queueSubscription.l(3);
                if (iL == 1) {
                    this.f139331n = iL;
                    this.f139327j = queueSubscription;
                    this.f139328k = true;
                    C();
                    return;
                }
                if (iL == 2) {
                    this.f139331n = iL;
                    this.f139327j = queueSubscription;
                    subscription.y(this.f139324g);
                    return;
                }
            }
            this.f139327j = new SpscArrayQueue(this.f139324g);
            subscription.y(this.f139324g);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (this.f139323f.get()) {
            return;
        }
        if (this.f139331n == 0) {
            ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            if (!this.f139327j.offer(obj)) {
                SubscriptionHelper.a(this.f139321c);
                onError(new MissingBackpressureException());
                return;
            }
        }
        C();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f139323f.compareAndSet(false, true)) {
            this.f139328k = true;
            C();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f139323f.compareAndSet(false, true)) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139329l = th;
        this.f139328k = true;
        C();
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        Throwable th;
        MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
        subscriber.g(multicastSubscription);
        if (B(multicastSubscription)) {
            if (multicastSubscription.get() == Long.MIN_VALUE) {
                D(multicastSubscription);
                return;
            } else {
                C();
                return;
            }
        }
        if ((this.f139323f.get() || !this.f139326i) && (th = this.f139329l) != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
    }
}
