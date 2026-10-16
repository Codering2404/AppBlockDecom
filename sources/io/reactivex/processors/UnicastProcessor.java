package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class UnicastProcessor<T> extends FlowableProcessor<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SpscLinkedArrayQueue f139379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f139380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f139381d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f139382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Throwable f139383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AtomicReference f139384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    volatile boolean f139385i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final AtomicBoolean f139386j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final BasicIntQueueSubscription f139387k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final AtomicLong f139388l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f139389m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        UnicastQueueSubscription() {
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (UnicastProcessor.this.f139385i) {
                return;
            }
            UnicastProcessor.this.f139385i = true;
            UnicastProcessor.this.F();
            UnicastProcessor unicastProcessor = UnicastProcessor.this;
            if (unicastProcessor.f139389m || unicastProcessor.f139387k.getAndIncrement() != 0) {
                return;
            }
            UnicastProcessor.this.f139379b.clear();
            UnicastProcessor.this.f139384h.lazySet(null);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            UnicastProcessor.this.f139379b.clear();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return UnicastProcessor.this.f139379b.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            UnicastProcessor.this.f139389m = true;
            return 2;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            return UnicastProcessor.this.f139379b.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(UnicastProcessor.this.f139388l, j3);
                UnicastProcessor.this.G();
            }
        }
    }

    UnicastProcessor(int i3) {
        this(i3, null, true);
    }

    public static UnicastProcessor C() {
        return new UnicastProcessor(Flowable.a());
    }

    public static UnicastProcessor D(int i3) {
        return new UnicastProcessor(i3);
    }

    public static UnicastProcessor E(int i3, Runnable runnable) {
        ObjectHelper.d(runnable, "onTerminate");
        return new UnicastProcessor(i3, runnable);
    }

    boolean B(boolean z2, boolean z3, boolean z4, Subscriber subscriber, SpscLinkedArrayQueue spscLinkedArrayQueue) {
        if (this.f139385i) {
            spscLinkedArrayQueue.clear();
            this.f139384h.lazySet(null);
            return true;
        }
        if (!z3) {
            return false;
        }
        if (z2 && this.f139383g != null) {
            spscLinkedArrayQueue.clear();
            this.f139384h.lazySet(null);
            subscriber.onError(this.f139383g);
            return true;
        }
        if (!z4) {
            return false;
        }
        Throwable th = this.f139383g;
        this.f139384h.lazySet(null);
        if (th != null) {
            subscriber.onError(th);
        } else {
            subscriber.onComplete();
        }
        return true;
    }

    void F() {
        Runnable runnable = (Runnable) this.f139380c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    void G() {
        if (this.f139387k.getAndIncrement() != 0) {
            return;
        }
        Subscriber subscriber = (Subscriber) this.f139384h.get();
        int iAddAndGet = 1;
        while (subscriber == null) {
            iAddAndGet = this.f139387k.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                subscriber = (Subscriber) this.f139384h.get();
            }
        }
        if (this.f139389m) {
            H(subscriber);
        } else {
            I(subscriber);
        }
    }

    void H(Subscriber subscriber) {
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f139379b;
        boolean z2 = this.f139381d;
        int iAddAndGet = 1;
        while (!this.f139385i) {
            boolean z3 = this.f139382f;
            if (!z2 && z3 && this.f139383g != null) {
                spscLinkedArrayQueue.clear();
                this.f139384h.lazySet(null);
                subscriber.onError(this.f139383g);
                return;
            }
            subscriber.h(null);
            if (z3) {
                this.f139384h.lazySet(null);
                Throwable th = this.f139383g;
                if (th != null) {
                    subscriber.onError(th);
                    return;
                } else {
                    subscriber.onComplete();
                    return;
                }
            }
            iAddAndGet = this.f139387k.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
        }
        spscLinkedArrayQueue.clear();
        this.f139384h.lazySet(null);
    }

    void I(Subscriber subscriber) {
        SpscLinkedArrayQueue spscLinkedArrayQueue = this.f139379b;
        boolean z2 = !this.f139381d;
        int iAddAndGet = 1;
        do {
            long j3 = this.f139388l.get();
            long j4 = 0;
            while (j3 != j4) {
                boolean z3 = this.f139382f;
                Object objPoll = spscLinkedArrayQueue.poll();
                boolean z4 = objPoll == null;
                if (B(z2, z3, z4, subscriber, spscLinkedArrayQueue)) {
                    return;
                }
                if (z4) {
                    break;
                }
                subscriber.h(objPoll);
                j4++;
            }
            if (j3 == j4 && B(z2, this.f139382f, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                return;
            }
            if (j4 != 0 && j3 != Long.MAX_VALUE) {
                this.f139388l.addAndGet(-j4);
            }
            iAddAndGet = this.f139387k.addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
    }

    @Override // org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (this.f139382f || this.f139385i) {
            subscription.cancel();
        } else {
            subscription.y(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139382f || this.f139385i) {
            return;
        }
        this.f139379b.offer(obj);
        G();
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f139382f || this.f139385i) {
            return;
        }
        this.f139382f = true;
        F();
        G();
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139382f || this.f139385i) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139383g = th;
        this.f139382f = true;
        F();
        G();
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (this.f139386j.get() || !this.f139386j.compareAndSet(false, true)) {
            EmptySubscription.b(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.g(this.f139387k);
        this.f139384h.set(subscriber);
        if (this.f139385i) {
            this.f139384h.lazySet(null);
        } else {
            G();
        }
    }

    UnicastProcessor(int i3, Runnable runnable) {
        this(i3, runnable, true);
    }

    UnicastProcessor(int i3, Runnable runnable, boolean z2) {
        this.f139379b = new SpscLinkedArrayQueue(ObjectHelper.e(i3, "capacityHint"));
        this.f139380c = new AtomicReference(runnable);
        this.f139381d = z2;
        this.f139384h = new AtomicReference();
        this.f139386j = new AtomicBoolean();
        this.f139387k = new UnicastQueueSubscription();
        this.f139388l = new AtomicLong();
    }
}
