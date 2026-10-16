package io.reactivex.processors;

import androidx.compose.animation.core.h;
import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ReplayProcessor<T> extends FlowableProcessor<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object[] f139341f = new Object[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final ReplaySubscription[] f139342g = new ReplaySubscription[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final ReplaySubscription[] f139343h = new ReplaySubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ReplayBuffer f139344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f139345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference f139346d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f139347a;

        Node(Object obj) {
            this.f139347a = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ReplayBuffer<T> {
        void a(Throwable th);

        void b();

        void c(ReplaySubscription replaySubscription);

        void e(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ReplaySubscription<T> extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 466549804534799122L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f139348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ReplayProcessor f139349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f139350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f139351d = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f139352f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f139353g;

        ReplaySubscription(Subscriber subscriber, ReplayProcessor replayProcessor) {
            this.f139348a = subscriber;
            this.f139349b = replayProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f139352f) {
                return;
            }
            this.f139352f = true;
            this.f139349b.C(this);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f139351d, j3);
                this.f139349b.f139344b.c(this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeAndTimeBoundReplayBuffer<T> implements ReplayBuffer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f139354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f139355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f139356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler f139357d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f139358e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile TimedNode f139359f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        TimedNode f139360g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Throwable f139361h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f139362i;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void a(Throwable th) {
            g();
            this.f139361h = th;
            this.f139362i = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void b() {
            g();
            this.f139362i = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void c(ReplaySubscription replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = replaySubscription.f139348a;
            TimedNode<T> timedNodeD = (TimedNode) replaySubscription.f139350c;
            if (timedNodeD == null) {
                timedNodeD = d();
            }
            long j3 = replaySubscription.f139353g;
            int iAddAndGet = 1;
            do {
                long j4 = replaySubscription.f139351d.get();
                while (j3 != j4) {
                    if (replaySubscription.f139352f) {
                        replaySubscription.f139350c = null;
                        return;
                    }
                    boolean z2 = this.f139362i;
                    TimedNode<T> timedNode = timedNodeD.get();
                    boolean z3 = timedNode == null;
                    if (z2 && z3) {
                        replaySubscription.f139350c = null;
                        replaySubscription.f139352f = true;
                        Throwable th = this.f139361h;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.h(timedNode.f139369a);
                    j3++;
                    timedNodeD = timedNode;
                }
                if (j3 == j4) {
                    if (replaySubscription.f139352f) {
                        replaySubscription.f139350c = null;
                        return;
                    }
                    if (this.f139362i && timedNodeD.get() == null) {
                        replaySubscription.f139350c = null;
                        replaySubscription.f139352f = true;
                        Throwable th2 = this.f139361h;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.f139350c = timedNodeD;
                replaySubscription.f139353g = j3;
                iAddAndGet = replaySubscription.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        TimedNode d() {
            TimedNode<T> timedNode;
            TimedNode<T> timedNode2 = this.f139359f;
            long jC = this.f139357d.c(this.f139356c) - this.f139355b;
            TimedNode<T> timedNode3 = timedNode2.get();
            while (true) {
                TimedNode<T> timedNode4 = timedNode3;
                timedNode = timedNode2;
                timedNode2 = timedNode4;
                if (timedNode2 == null || timedNode2.f139370b > jC) {
                    break;
                }
                timedNode3 = timedNode2.get();
            }
            return timedNode;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void e(Object obj) {
            TimedNode timedNode = new TimedNode(obj, this.f139357d.c(this.f139356c));
            TimedNode timedNode2 = this.f139360g;
            this.f139360g = timedNode;
            this.f139358e++;
            timedNode2.set(timedNode);
            f();
        }

        void f() {
            int i3 = this.f139358e;
            if (i3 > this.f139354a) {
                this.f139358e = i3 - 1;
                this.f139359f = this.f139359f.get();
            }
            long jC = this.f139357d.c(this.f139356c) - this.f139355b;
            TimedNode<T> timedNode = this.f139359f;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    this.f139359f = timedNode;
                    return;
                } else {
                    if (timedNode2.f139370b > jC) {
                        this.f139359f = timedNode;
                        return;
                    }
                    timedNode = timedNode2;
                }
            }
        }

        void g() {
            long jC = this.f139357d.c(this.f139356c) - this.f139355b;
            TimedNode<T> timedNode = this.f139359f;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null) {
                    if (timedNode.f139369a != null) {
                        this.f139359f = new TimedNode(null, 0L);
                        return;
                    } else {
                        this.f139359f = timedNode;
                        return;
                    }
                }
                if (timedNode2.f139370b > jC) {
                    if (timedNode.f139369a == null) {
                        this.f139359f = timedNode;
                        return;
                    }
                    TimedNode timedNode3 = new TimedNode(null, 0L);
                    timedNode3.lazySet(timedNode.get());
                    this.f139359f = timedNode3;
                    return;
                }
                timedNode = timedNode2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeBoundReplayBuffer<T> implements ReplayBuffer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f139363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f139364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile Node f139365c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Node f139366d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Throwable f139367e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f139368f;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void a(Throwable th) {
            this.f139367e = th;
            f();
            this.f139368f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void b() {
            f();
            this.f139368f = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void c(ReplaySubscription replaySubscription) {
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = replaySubscription.f139348a;
            Node<T> node = (Node) replaySubscription.f139350c;
            if (node == null) {
                node = this.f139365c;
            }
            long j3 = replaySubscription.f139353g;
            int iAddAndGet = 1;
            do {
                long j4 = replaySubscription.f139351d.get();
                while (j3 != j4) {
                    if (replaySubscription.f139352f) {
                        replaySubscription.f139350c = null;
                        return;
                    }
                    boolean z2 = this.f139368f;
                    Node<T> node2 = node.get();
                    boolean z3 = node2 == null;
                    if (z2 && z3) {
                        replaySubscription.f139350c = null;
                        replaySubscription.f139352f = true;
                        Throwable th = this.f139367e;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.h(node2.f139347a);
                    j3++;
                    node = node2;
                }
                if (j3 == j4) {
                    if (replaySubscription.f139352f) {
                        replaySubscription.f139350c = null;
                        return;
                    }
                    if (this.f139368f && node.get() == null) {
                        replaySubscription.f139350c = null;
                        replaySubscription.f139352f = true;
                        Throwable th2 = this.f139367e;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.f139350c = node;
                replaySubscription.f139353g = j3;
                iAddAndGet = replaySubscription.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void d() {
            int i3 = this.f139364b;
            if (i3 > this.f139363a) {
                this.f139364b = i3 - 1;
                this.f139365c = this.f139365c.get();
            }
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void e(Object obj) {
            Node node = new Node(obj);
            Node node2 = this.f139366d;
            this.f139366d = node;
            this.f139364b++;
            node2.set(node);
            d();
        }

        public void f() {
            if (this.f139365c.f139347a != null) {
                Node node = new Node(null);
                node.lazySet(this.f139365c.get());
                this.f139365c = node;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f139369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f139370b;

        TimedNode(Object obj, long j3) {
            this.f139369a = obj;
            this.f139370b = j3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class UnboundedReplayBuffer<T> implements ReplayBuffer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List f139371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Throwable f139372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f139373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile int f139374d;

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void a(Throwable th) {
            this.f139372b = th;
            this.f139373c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void b() {
            this.f139373c = true;
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void c(ReplaySubscription replaySubscription) {
            int iIntValue;
            if (replaySubscription.getAndIncrement() != 0) {
                return;
            }
            List list = this.f139371a;
            Subscriber subscriber = replaySubscription.f139348a;
            Integer num = (Integer) replaySubscription.f139350c;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                iIntValue = 0;
                replaySubscription.f139350c = 0;
            }
            long j3 = replaySubscription.f139353g;
            int iAddAndGet = 1;
            do {
                long j4 = replaySubscription.f139351d.get();
                while (j3 != j4) {
                    if (replaySubscription.f139352f) {
                        replaySubscription.f139350c = null;
                        return;
                    }
                    boolean z2 = this.f139373c;
                    int i3 = this.f139374d;
                    if (z2 && iIntValue == i3) {
                        replaySubscription.f139350c = null;
                        replaySubscription.f139352f = true;
                        Throwable th = this.f139372b;
                        if (th == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th);
                            return;
                        }
                    }
                    if (iIntValue == i3) {
                        break;
                    }
                    subscriber.h(list.get(iIntValue));
                    iIntValue++;
                    j3++;
                }
                if (j3 == j4) {
                    if (replaySubscription.f139352f) {
                        replaySubscription.f139350c = null;
                        return;
                    }
                    boolean z3 = this.f139373c;
                    int i4 = this.f139374d;
                    if (z3 && iIntValue == i4) {
                        replaySubscription.f139350c = null;
                        replaySubscription.f139352f = true;
                        Throwable th2 = this.f139372b;
                        if (th2 == null) {
                            subscriber.onComplete();
                            return;
                        } else {
                            subscriber.onError(th2);
                            return;
                        }
                    }
                }
                replaySubscription.f139350c = Integer.valueOf(iIntValue);
                replaySubscription.f139353g = j3;
                iAddAndGet = replaySubscription.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.processors.ReplayProcessor.ReplayBuffer
        public void e(Object obj) {
            this.f139371a.add(obj);
            this.f139374d++;
        }
    }

    boolean B(ReplaySubscription replaySubscription) {
        ReplaySubscription[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.f139346d.get();
            if (replaySubscriptionArr == f139343h) {
                return false;
            }
            int length = replaySubscriptionArr.length;
            replaySubscriptionArr2 = new ReplaySubscription[length + 1];
            System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr2, 0, length);
            replaySubscriptionArr2[length] = replaySubscription;
        } while (!h.a(this.f139346d, replaySubscriptionArr, replaySubscriptionArr2));
        return true;
    }

    void C(ReplaySubscription replaySubscription) {
        ReplaySubscription[] replaySubscriptionArr;
        ReplaySubscription[] replaySubscriptionArr2;
        do {
            replaySubscriptionArr = (ReplaySubscription[]) this.f139346d.get();
            if (replaySubscriptionArr == f139343h || replaySubscriptionArr == f139342g) {
                return;
            }
            int length = replaySubscriptionArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (replaySubscriptionArr[i3] == replaySubscription) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                replaySubscriptionArr2 = f139342g;
            } else {
                ReplaySubscription[] replaySubscriptionArr3 = new ReplaySubscription[length - 1];
                System.arraycopy(replaySubscriptionArr, 0, replaySubscriptionArr3, 0, i3);
                System.arraycopy(replaySubscriptionArr, i3 + 1, replaySubscriptionArr3, i3, (length - i3) - 1);
                replaySubscriptionArr2 = replaySubscriptionArr3;
            }
        } while (!h.a(this.f139346d, replaySubscriptionArr, replaySubscriptionArr2));
    }

    @Override // org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (this.f139345c) {
            subscription.cancel();
        } else {
            subscription.y(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139345c) {
            return;
        }
        ReplayBuffer replayBuffer = this.f139344b;
        replayBuffer.e(obj);
        for (ReplaySubscription replaySubscription : (ReplaySubscription[]) this.f139346d.get()) {
            replayBuffer.c(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f139345c) {
            return;
        }
        this.f139345c = true;
        ReplayBuffer replayBuffer = this.f139344b;
        replayBuffer.b();
        for (ReplaySubscription replaySubscription : (ReplaySubscription[]) this.f139346d.getAndSet(f139343h)) {
            replayBuffer.c(replaySubscription);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139345c) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139345c = true;
        ReplayBuffer replayBuffer = this.f139344b;
        replayBuffer.a(th);
        for (ReplaySubscription replaySubscription : (ReplaySubscription[]) this.f139346d.getAndSet(f139343h)) {
            replayBuffer.c(replaySubscription);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        ReplaySubscription replaySubscription = new ReplaySubscription(subscriber, this);
        subscriber.g(replaySubscription);
        if (B(replaySubscription) && replaySubscription.f139352f) {
            C(replaySubscription);
        } else {
            this.f139344b.c(replaySubscription);
        }
    }
}
