package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableCache<T> extends AbstractFlowableWithUpstream<T, T> implements FlowableSubscriber<T> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final CacheSubscription[] f135360m = new CacheSubscription[0];

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final CacheSubscription[] f135361n = new CacheSubscription[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicBoolean f135362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f135363d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicReference f135364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile long f135365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Node f135366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Node f135367i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f135368j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Throwable f135369k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    volatile boolean f135370l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CacheSubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 6770240836423125754L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final FlowableCache f135372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicLong f135373c = new AtomicLong();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Node f135374d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f135375f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f135376g;

        CacheSubscription(Subscriber subscriber, FlowableCache flowableCache) {
            this.f135371a = subscriber;
            this.f135372b = flowableCache;
            this.f135374d = flowableCache.f135366h;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135373c.getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f135372b.B(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.b(this.f135373c, j3);
                this.f135372b.C(this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Node<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object[] f135377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile Node f135378b;

        Node(int i3) {
            this.f135377a = new Object[i3];
        }
    }

    void A(CacheSubscription cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f135364f.get();
            if (cacheSubscriptionArr == f135361n) {
                return;
            }
            int length = cacheSubscriptionArr.length;
            cacheSubscriptionArr2 = new CacheSubscription[length + 1];
            System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr2, 0, length);
            cacheSubscriptionArr2[length] = cacheSubscription;
        } while (!h.a(this.f135364f, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    void B(CacheSubscription cacheSubscription) {
        CacheSubscription[] cacheSubscriptionArr;
        CacheSubscription[] cacheSubscriptionArr2;
        do {
            cacheSubscriptionArr = (CacheSubscription[]) this.f135364f.get();
            int length = cacheSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (cacheSubscriptionArr[i3] == cacheSubscription) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                cacheSubscriptionArr2 = f135360m;
            } else {
                CacheSubscription[] cacheSubscriptionArr3 = new CacheSubscription[length - 1];
                System.arraycopy(cacheSubscriptionArr, 0, cacheSubscriptionArr3, 0, i3);
                System.arraycopy(cacheSubscriptionArr, i3 + 1, cacheSubscriptionArr3, i3, (length - i3) - 1);
                cacheSubscriptionArr2 = cacheSubscriptionArr3;
            }
        } while (!h.a(this.f135364f, cacheSubscriptionArr, cacheSubscriptionArr2));
    }

    void C(CacheSubscription cacheSubscription) {
        if (cacheSubscription.getAndIncrement() != 0) {
            return;
        }
        long j3 = cacheSubscription.f135376g;
        int i3 = cacheSubscription.f135375f;
        Node node = cacheSubscription.f135374d;
        AtomicLong atomicLong = cacheSubscription.f135373c;
        Subscriber subscriber = cacheSubscription.f135371a;
        int i4 = this.f135363d;
        int iAddAndGet = 1;
        while (true) {
            boolean z2 = this.f135370l;
            boolean z3 = this.f135365g == j3;
            if (z2 && z3) {
                cacheSubscription.f135374d = null;
                Throwable th = this.f135369k;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            if (!z3) {
                long j4 = atomicLong.get();
                if (j4 == Long.MIN_VALUE) {
                    cacheSubscription.f135374d = null;
                    return;
                } else if (j4 != j3) {
                    if (i3 == i4) {
                        node = node.f135378b;
                        i3 = 0;
                    }
                    subscriber.h(node.f135377a[i3]);
                    i3++;
                    j3++;
                }
            }
            cacheSubscription.f135376g = j3;
            cacheSubscription.f135375f = i3;
            cacheSubscription.f135374d = node;
            iAddAndGet = cacheSubscription.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        subscription.y(Long.MAX_VALUE);
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        int i3 = this.f135368j;
        if (i3 == this.f135363d) {
            Node node = new Node(i3);
            node.f135377a[0] = obj;
            this.f135368j = 1;
            this.f135367i.f135378b = node;
            this.f135367i = node;
        } else {
            this.f135367i.f135377a[i3] = obj;
            this.f135368j = i3 + 1;
        }
        this.f135365g++;
        for (CacheSubscription cacheSubscription : (CacheSubscription[]) this.f135364f.get()) {
            C(cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        this.f135370l = true;
        for (CacheSubscription cacheSubscription : (CacheSubscription[]) this.f135364f.getAndSet(f135361n)) {
            C(cacheSubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f135370l) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f135369k = th;
        this.f135370l = true;
        for (CacheSubscription cacheSubscription : (CacheSubscription[]) this.f135364f.getAndSet(f135361n)) {
            C(cacheSubscription);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        CacheSubscription cacheSubscription = new CacheSubscription(subscriber, this);
        subscriber.g(cacheSubscription);
        A(cacheSubscription);
        if (this.f135362c.get() || !this.f135362c.compareAndSet(false, true)) {
            C(cacheSubscription);
        } else {
            this.f135196b.w(this);
        }
    }
}
