package io.reactivex.processors;

import androidx.compose.animation.core.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BehaviorProcessor<T> extends FlowableProcessor<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final Object[] f139301i = new Object[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final BehaviorSubscription[] f139302j = new BehaviorSubscription[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final BehaviorSubscription[] f139303k = new BehaviorSubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f139304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Lock f139305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Lock f139306d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicReference f139307f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference f139308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f139309h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BehaviorSubscription<T> extends AtomicLong implements Subscription, AppendOnlyLinkedArrayList.NonThrowingPredicate<Object> {
        private static final long serialVersionUID = 3293175281126227086L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f139310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BehaviorProcessor f139311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f139312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f139313d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        AppendOnlyLinkedArrayList f139314f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f139315g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f139316h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f139317i;

        BehaviorSubscription(Subscriber subscriber, BehaviorProcessor behaviorProcessor) {
            this.f139310a = subscriber;
            this.f139311b = behaviorProcessor;
        }

        void a() {
            if (this.f139316h) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.f139316h) {
                        return;
                    }
                    if (this.f139312c) {
                        return;
                    }
                    BehaviorProcessor behaviorProcessor = this.f139311b;
                    Lock lock = behaviorProcessor.f139305c;
                    lock.lock();
                    this.f139317i = behaviorProcessor.f139309h;
                    Object obj = behaviorProcessor.f139307f.get();
                    lock.unlock();
                    this.f139313d = obj != null;
                    this.f139312c = true;
                    if (obj == null || test(obj)) {
                        return;
                    }
                    b();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void b() {
            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList;
            while (!this.f139316h) {
                synchronized (this) {
                    try {
                        appendOnlyLinkedArrayList = this.f139314f;
                        if (appendOnlyLinkedArrayList == null) {
                            this.f139313d = false;
                            return;
                        }
                        this.f139314f = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                appendOnlyLinkedArrayList.d(this);
            }
        }

        void c(Object obj, long j3) {
            if (this.f139316h) {
                return;
            }
            if (!this.f139315g) {
                synchronized (this) {
                    try {
                        if (this.f139316h) {
                            return;
                        }
                        if (this.f139317i == j3) {
                            return;
                        }
                        if (this.f139313d) {
                            AppendOnlyLinkedArrayList appendOnlyLinkedArrayList = this.f139314f;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList(4);
                                this.f139314f = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(obj);
                            return;
                        }
                        this.f139312c = true;
                        this.f139315g = true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            test(obj);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f139316h) {
                return;
            }
            this.f139316h = true;
            this.f139311b.C(this);
        }

        @Override // io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate, io.reactivex.functions.Predicate
        public boolean test(Object obj) {
            if (this.f139316h) {
                return true;
            }
            if (NotificationLite.j(obj)) {
                this.f139310a.onComplete();
                return true;
            }
            if (NotificationLite.k(obj)) {
                this.f139310a.onError(NotificationLite.h(obj));
                return true;
            }
            long j3 = get();
            if (j3 == 0) {
                cancel();
                this.f139310a.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                return true;
            }
            this.f139310a.h(NotificationLite.i(obj));
            if (j3 == Long.MAX_VALUE) {
                return false;
            }
            decrementAndGet();
            return false;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this, j3);
            }
        }
    }

    boolean B(BehaviorSubscription behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.f139304b.get();
            if (behaviorSubscriptionArr == f139303k) {
                return false;
            }
            int length = behaviorSubscriptionArr.length;
            behaviorSubscriptionArr2 = new BehaviorSubscription[length + 1];
            System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr2, 0, length);
            behaviorSubscriptionArr2[length] = behaviorSubscription;
        } while (!h.a(this.f139304b, behaviorSubscriptionArr, behaviorSubscriptionArr2));
        return true;
    }

    void C(BehaviorSubscription behaviorSubscription) {
        BehaviorSubscription[] behaviorSubscriptionArr;
        BehaviorSubscription[] behaviorSubscriptionArr2;
        do {
            behaviorSubscriptionArr = (BehaviorSubscription[]) this.f139304b.get();
            int length = behaviorSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (behaviorSubscriptionArr[i3] == behaviorSubscription) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                behaviorSubscriptionArr2 = f139302j;
            } else {
                BehaviorSubscription[] behaviorSubscriptionArr3 = new BehaviorSubscription[length - 1];
                System.arraycopy(behaviorSubscriptionArr, 0, behaviorSubscriptionArr3, 0, i3);
                System.arraycopy(behaviorSubscriptionArr, i3 + 1, behaviorSubscriptionArr3, i3, (length - i3) - 1);
                behaviorSubscriptionArr2 = behaviorSubscriptionArr3;
            }
        } while (!h.a(this.f139304b, behaviorSubscriptionArr, behaviorSubscriptionArr2));
    }

    void D(Object obj) {
        Lock lock = this.f139306d;
        lock.lock();
        this.f139309h++;
        this.f139307f.lazySet(obj);
        lock.unlock();
    }

    BehaviorSubscription[] E(Object obj) {
        BehaviorSubscription[] behaviorSubscriptionArr = (BehaviorSubscription[]) this.f139304b.get();
        BehaviorSubscription[] behaviorSubscriptionArr2 = f139303k;
        if (behaviorSubscriptionArr != behaviorSubscriptionArr2 && (behaviorSubscriptionArr = (BehaviorSubscription[]) this.f139304b.getAndSet(behaviorSubscriptionArr2)) != behaviorSubscriptionArr2) {
            D(obj);
        }
        return behaviorSubscriptionArr;
    }

    @Override // org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (this.f139308g.get() != null) {
            subscription.cancel();
        } else {
            subscription.y(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139308g.get() != null) {
            return;
        }
        Object objL = NotificationLite.l(obj);
        D(objL);
        for (BehaviorSubscription behaviorSubscription : (BehaviorSubscription[]) this.f139304b.get()) {
            behaviorSubscription.c(objL, this.f139309h);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (h.a(this.f139308g, null, ExceptionHelper.f139204a)) {
            Object objE = NotificationLite.e();
            for (BehaviorSubscription behaviorSubscription : E(objE)) {
                behaviorSubscription.c(objE, this.f139309h);
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!h.a(this.f139308g, null, th)) {
            RxJavaPlugins.s(th);
            return;
        }
        Object objG = NotificationLite.g(th);
        for (BehaviorSubscription behaviorSubscription : E(objG)) {
            behaviorSubscription.c(objG, this.f139309h);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        BehaviorSubscription behaviorSubscription = new BehaviorSubscription(subscriber, this);
        subscriber.g(behaviorSubscription);
        if (B(behaviorSubscription)) {
            if (behaviorSubscription.f139316h) {
                C(behaviorSubscription);
                return;
            } else {
                behaviorSubscription.a();
                return;
            }
        }
        Throwable th = (Throwable) this.f139308g.get();
        if (th == ExceptionHelper.f139204a) {
            subscriber.onComplete();
        } else {
            subscriber.onError(th);
        }
    }
}
