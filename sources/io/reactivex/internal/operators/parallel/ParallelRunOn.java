package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelRunOn<T> extends ParallelFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ParallelFlowable f138695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f138696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f138697c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f138698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f138699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SpscArrayQueue f138700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f138701d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f138702f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f138703g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Throwable f138704h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicLong f138705i = new AtomicLong();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f138706j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f138707k;

        BaseRunOnSubscriber(int i3, SpscArrayQueue spscArrayQueue, Scheduler.Worker worker) {
            this.f138698a = i3;
            this.f138700c = spscArrayQueue;
            this.f138699b = i3 - (i3 >> 2);
            this.f138701d = worker;
        }

        final void a() {
            if (getAndIncrement() == 0) {
                this.f138701d.b(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            if (this.f138706j) {
                return;
            }
            this.f138706j = true;
            this.f138702f.cancel();
            this.f138701d.dispose();
            if (getAndIncrement() == 0) {
                this.f138700c.clear();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void h(Object obj) {
            if (this.f138703g) {
                return;
            }
            if (this.f138700c.offer(obj)) {
                a();
            } else {
                this.f138702f.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            if (this.f138703g) {
                return;
            }
            this.f138703g = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public final void onError(Throwable th) {
            if (this.f138703g) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138704h = th;
            this.f138703g = true;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public final void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f138705i, j3);
                a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class MultiWorkerCallback implements SchedulerMultiWorkerSupport.WorkerCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber[] f138708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Subscriber[] f138709b;

        MultiWorkerCallback(Subscriber[] subscriberArr, Subscriber[] subscriberArr2) {
            this.f138708a = subscriberArr;
            this.f138709b = subscriberArr2;
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport.WorkerCallback
        public void a(int i3, Scheduler.Worker worker) {
            ParallelRunOn.this.d(i3, this.f138708a, this.f138709b, worker);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final ConditionalSubscriber f138711l;

        RunOnConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, int i3, SpscArrayQueue spscArrayQueue, Scheduler.Worker worker) {
            super(i3, spscArrayQueue, worker);
            this.f138711l = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138702f, subscription)) {
                this.f138702f = subscription;
                this.f138711l.g(this);
                subscription.y(this.f138698a);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i3 = this.f138707k;
            SpscArrayQueue spscArrayQueue = this.f138700c;
            ConditionalSubscriber conditionalSubscriber = this.f138711l;
            int i4 = this.f138699b;
            int iAddAndGet = 1;
            while (true) {
                long j3 = this.f138705i.get();
                long j4 = 0;
                while (j4 != j3) {
                    if (this.f138706j) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z2 = this.f138703g;
                    if (z2 && (th = this.f138704h) != null) {
                        spscArrayQueue.clear();
                        conditionalSubscriber.onError(th);
                        this.f138701d.dispose();
                        return;
                    }
                    Object objPoll = spscArrayQueue.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        conditionalSubscriber.onComplete();
                        this.f138701d.dispose();
                        return;
                    } else {
                        if (z3) {
                            break;
                        }
                        if (conditionalSubscriber.o(objPoll)) {
                            j4++;
                        }
                        i3++;
                        if (i3 == i4) {
                            this.f138702f.y(i3);
                            i3 = 0;
                        }
                    }
                }
                if (j4 == j3) {
                    if (this.f138706j) {
                        spscArrayQueue.clear();
                        return;
                    }
                    if (this.f138703g) {
                        Throwable th2 = this.f138704h;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            conditionalSubscriber.onError(th2);
                            this.f138701d.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            conditionalSubscriber.onComplete();
                            this.f138701d.dispose();
                            return;
                        }
                    }
                }
                if (j4 != 0 && j3 != Long.MAX_VALUE) {
                    this.f138705i.addAndGet(-j4);
                }
                int i5 = get();
                if (i5 == iAddAndGet) {
                    this.f138707k = i3;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i5;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final Subscriber f138712l;

        RunOnSubscriber(Subscriber subscriber, int i3, SpscArrayQueue spscArrayQueue, Scheduler.Worker worker) {
            super(i3, spscArrayQueue, worker);
            this.f138712l = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138702f, subscription)) {
                this.f138702f = subscription;
                this.f138712l.g(this);
                subscription.y(this.f138698a);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i3 = this.f138707k;
            SpscArrayQueue spscArrayQueue = this.f138700c;
            Subscriber subscriber = this.f138712l;
            int i4 = this.f138699b;
            int iAddAndGet = 1;
            while (true) {
                long j3 = this.f138705i.get();
                long j4 = 0;
                while (j4 != j3) {
                    if (this.f138706j) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z2 = this.f138703g;
                    if (z2 && (th = this.f138704h) != null) {
                        spscArrayQueue.clear();
                        subscriber.onError(th);
                        this.f138701d.dispose();
                        return;
                    }
                    Object objPoll = spscArrayQueue.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        subscriber.onComplete();
                        this.f138701d.dispose();
                        return;
                    } else {
                        if (z3) {
                            break;
                        }
                        subscriber.h(objPoll);
                        j4++;
                        i3++;
                        if (i3 == i4) {
                            this.f138702f.y(i3);
                            i3 = 0;
                        }
                    }
                }
                if (j4 == j3) {
                    if (this.f138706j) {
                        spscArrayQueue.clear();
                        return;
                    }
                    if (this.f138703g) {
                        Throwable th2 = this.f138704h;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            subscriber.onError(th2);
                            this.f138701d.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            this.f138701d.dispose();
                            return;
                        }
                    }
                }
                if (j4 != 0 && j3 != Long.MAX_VALUE) {
                    this.f138705i.addAndGet(-j4);
                }
                int i5 = get();
                if (i5 == iAddAndGet) {
                    this.f138707k = i3;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i5;
                }
            }
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138695a.a();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            Object obj = this.f138696b;
            if (obj instanceof SchedulerMultiWorkerSupport) {
                ((SchedulerMultiWorkerSupport) obj).a(length, new MultiWorkerCallback(subscriberArr, subscriberArr2));
            } else {
                for (int i3 = 0; i3 < length; i3++) {
                    d(i3, subscriberArr, subscriberArr2, this.f138696b.b());
                }
            }
            this.f138695a.b(subscriberArr2);
        }
    }

    void d(int i3, Subscriber[] subscriberArr, Subscriber[] subscriberArr2, Scheduler.Worker worker) {
        Subscriber subscriber = subscriberArr[i3];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f138697c);
        if (subscriber instanceof ConditionalSubscriber) {
            subscriberArr2[i3] = new RunOnConditionalSubscriber((ConditionalSubscriber) subscriber, this.f138697c, spscArrayQueue, worker);
        } else {
            subscriberArr2[i3] = new RunOnSubscriber(subscriber, this.f138697c, spscArrayQueue, worker);
        }
    }
}
