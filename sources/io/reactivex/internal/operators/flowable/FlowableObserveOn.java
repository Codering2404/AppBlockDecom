package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Scheduler f135985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f135986d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f135987f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Scheduler.Worker f135988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f135989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135991d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f135992f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Subscription f135993g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        SimpleQueue f135994h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f135995i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f135996j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Throwable f135997k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f135998l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f135999m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f136000n;

        BaseObserveOnSubscriber(Scheduler.Worker worker, boolean z2, int i3) {
            this.f135988a = worker;
            this.f135989b = z2;
            this.f135990c = i3;
            this.f135991d = i3 - (i3 >> 2);
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.f135995i) {
                return;
            }
            this.f135995i = true;
            this.f135993g.cancel();
            this.f135988a.dispose();
            if (getAndIncrement() == 0) {
                this.f135994h.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.f135994h.clear();
        }

        final boolean e(boolean z2, boolean z3, Subscriber subscriber) {
            if (this.f135995i) {
                clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.f135989b) {
                if (!z3) {
                    return false;
                }
                this.f135995i = true;
                Throwable th = this.f135997k;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                this.f135988a.dispose();
                return true;
            }
            Throwable th2 = this.f135997k;
            if (th2 != null) {
                this.f135995i = true;
                clear();
                subscriber.onError(th2);
                this.f135988a.dispose();
                return true;
            }
            if (!z3) {
                return false;
            }
            this.f135995i = true;
            subscriber.onComplete();
            this.f135988a.dispose();
            return true;
        }

        @Override // org.reactivestreams.Subscriber
        public final void h(Object obj) {
            if (this.f135996j) {
                return;
            }
            if (this.f135998l == 2) {
                p();
                return;
            }
            if (!this.f135994h.offer(obj)) {
                this.f135993g.cancel();
                this.f135997k = new MissingBackpressureException("Queue is full?!");
                this.f135996j = true;
            }
            p();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.f135994h.isEmpty();
        }

        abstract void j();

        abstract void k();

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            this.f136000n = true;
            return 2;
        }

        abstract void m();

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.f135996j) {
                return;
            }
            this.f135996j = true;
            p();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.f135996j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135997k = th;
            this.f135996j = true;
            p();
        }

        final void p() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.f135988a.b(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f136000n) {
                k();
            } else if (this.f135998l == 1) {
                m();
            } else {
                j();
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135992f, j3);
                p();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final ConditionalSubscriber f136001o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        long f136002p;

        ObserveOnConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Scheduler.Worker worker, boolean z2, int i3) {
            super(worker, z2, i3);
            this.f136001o = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135993g, subscription)) {
                this.f135993g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(7);
                    if (iL == 1) {
                        this.f135998l = 1;
                        this.f135994h = queueSubscription;
                        this.f135996j = true;
                        this.f136001o.g(this);
                        return;
                    }
                    if (iL == 2) {
                        this.f135998l = 2;
                        this.f135994h = queueSubscription;
                        this.f136001o.g(this);
                        subscription.y(this.f135990c);
                        return;
                    }
                }
                this.f135994h = new SpscArrayQueue(this.f135990c);
                this.f136001o.g(this);
                subscription.y(this.f135990c);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void j() {
            ConditionalSubscriber conditionalSubscriber = this.f136001o;
            SimpleQueue simpleQueue = this.f135994h;
            long j3 = this.f135999m;
            long j4 = this.f136002p;
            int iAddAndGet = 1;
            while (true) {
                long j5 = this.f135992f.get();
                while (j3 != j5) {
                    boolean z2 = this.f135996j;
                    try {
                        Object objPoll = simpleQueue.poll();
                        boolean z3 = objPoll == null;
                        if (e(z2, z3, conditionalSubscriber)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        if (conditionalSubscriber.o(objPoll)) {
                            j3++;
                        }
                        j4++;
                        if (j4 == this.f135991d) {
                            this.f135993g.y(j4);
                            j4 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f135995i = true;
                        this.f135993g.cancel();
                        simpleQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.f135988a.dispose();
                        return;
                    }
                }
                if (j3 == j5 && e(this.f135996j, simpleQueue.isEmpty(), conditionalSubscriber)) {
                    return;
                }
                int i3 = get();
                if (iAddAndGet == i3) {
                    this.f135999m = j3;
                    this.f136002p = j4;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i3;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void k() {
            int iAddAndGet = 1;
            while (!this.f135995i) {
                boolean z2 = this.f135996j;
                this.f136001o.h(null);
                if (z2) {
                    this.f135995i = true;
                    Throwable th = this.f135997k;
                    if (th != null) {
                        this.f136001o.onError(th);
                    } else {
                        this.f136001o.onComplete();
                    }
                    this.f135988a.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void m() {
            ConditionalSubscriber conditionalSubscriber = this.f136001o;
            SimpleQueue simpleQueue = this.f135994h;
            long j3 = this.f135999m;
            int iAddAndGet = 1;
            while (true) {
                long j4 = this.f135992f.get();
                while (j3 != j4) {
                    try {
                        Object objPoll = simpleQueue.poll();
                        if (this.f135995i) {
                            return;
                        }
                        if (objPoll == null) {
                            this.f135995i = true;
                            conditionalSubscriber.onComplete();
                            this.f135988a.dispose();
                            return;
                        } else if (conditionalSubscriber.o(objPoll)) {
                            j3++;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f135995i = true;
                        this.f135993g.cancel();
                        conditionalSubscriber.onError(th);
                        this.f135988a.dispose();
                        return;
                    }
                }
                if (this.f135995i) {
                    return;
                }
                if (simpleQueue.isEmpty()) {
                    this.f135995i = true;
                    conditionalSubscriber.onComplete();
                    this.f135988a.dispose();
                    return;
                } else {
                    int i3 = get();
                    if (iAddAndGet == i3) {
                        this.f135999m = j3;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i3;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f135994h.poll();
            if (objPoll != null && this.f135998l != 1) {
                long j3 = this.f136002p + 1;
                if (j3 == this.f135991d) {
                    this.f136002p = 0L;
                    this.f135993g.y(j3);
                    return objPoll;
                }
                this.f136002p = j3;
            }
            return objPoll;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -4547113800637756442L;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final Subscriber f136003o;

        ObserveOnSubscriber(Subscriber subscriber, Scheduler.Worker worker, boolean z2, int i3) {
            super(worker, z2, i3);
            this.f136003o = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135993g, subscription)) {
                this.f135993g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(7);
                    if (iL == 1) {
                        this.f135998l = 1;
                        this.f135994h = queueSubscription;
                        this.f135996j = true;
                        this.f136003o.g(this);
                        return;
                    }
                    if (iL == 2) {
                        this.f135998l = 2;
                        this.f135994h = queueSubscription;
                        this.f136003o.g(this);
                        subscription.y(this.f135990c);
                        return;
                    }
                }
                this.f135994h = new SpscArrayQueue(this.f135990c);
                this.f136003o.g(this);
                subscription.y(this.f135990c);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void j() {
            Subscriber subscriber = this.f136003o;
            SimpleQueue simpleQueue = this.f135994h;
            long j3 = this.f135999m;
            int iAddAndGet = 1;
            while (true) {
                long jAddAndGet = this.f135992f.get();
                while (j3 != jAddAndGet) {
                    boolean z2 = this.f135996j;
                    try {
                        Object objPoll = simpleQueue.poll();
                        boolean z3 = objPoll == null;
                        if (e(z2, z3, subscriber)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        subscriber.h(objPoll);
                        j3++;
                        if (j3 == this.f135991d) {
                            if (jAddAndGet != Long.MAX_VALUE) {
                                jAddAndGet = this.f135992f.addAndGet(-j3);
                            }
                            this.f135993g.y(j3);
                            j3 = 0;
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f135995i = true;
                        this.f135993g.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.f135988a.dispose();
                        return;
                    }
                }
                if (j3 == jAddAndGet && e(this.f135996j, simpleQueue.isEmpty(), subscriber)) {
                    return;
                }
                int i3 = get();
                if (iAddAndGet == i3) {
                    this.f135999m = j3;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i3;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void k() {
            int iAddAndGet = 1;
            while (!this.f135995i) {
                boolean z2 = this.f135996j;
                this.f136003o.h(null);
                if (z2) {
                    this.f135995i = true;
                    Throwable th = this.f135997k;
                    if (th != null) {
                        this.f136003o.onError(th);
                    } else {
                        this.f136003o.onComplete();
                    }
                    this.f135988a.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        void m() {
            Subscriber subscriber = this.f136003o;
            SimpleQueue simpleQueue = this.f135994h;
            long j3 = this.f135999m;
            int iAddAndGet = 1;
            while (true) {
                long j4 = this.f135992f.get();
                while (j3 != j4) {
                    try {
                        Object objPoll = simpleQueue.poll();
                        if (this.f135995i) {
                            return;
                        }
                        if (objPoll == null) {
                            this.f135995i = true;
                            subscriber.onComplete();
                            this.f135988a.dispose();
                            return;
                        }
                        subscriber.h(objPoll);
                        j3++;
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f135995i = true;
                        this.f135993g.cancel();
                        subscriber.onError(th);
                        this.f135988a.dispose();
                        return;
                    }
                }
                if (this.f135995i) {
                    return;
                }
                if (simpleQueue.isEmpty()) {
                    this.f135995i = true;
                    subscriber.onComplete();
                    this.f135988a.dispose();
                    return;
                } else {
                    int i3 = get();
                    if (iAddAndGet == i3) {
                        this.f135999m = j3;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i3;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f135994h.poll();
            if (objPoll != null && this.f135998l != 1) {
                long j3 = this.f135999m + 1;
                if (j3 == this.f135991d) {
                    this.f135999m = 0L;
                    this.f135993g.y(j3);
                    return objPoll;
                }
                this.f135999m = j3;
            }
            return objPoll;
        }
    }

    public FlowableObserveOn(Flowable flowable, Scheduler scheduler, boolean z2, int i3) {
        super(flowable);
        this.f135985c = scheduler;
        this.f135986d = z2;
        this.f135987f = i3;
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        Scheduler.Worker workerB = this.f135985c.b();
        if (subscriber instanceof ConditionalSubscriber) {
            this.f135196b.w(new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, workerB, this.f135986d, this.f135987f));
        } else {
            this.f135196b.w(new ObserveOnSubscriber(subscriber, workerB, this.f135986d, this.f135987f));
        }
    }
}
