package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableScanSeed<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f136259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable f136260d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScanSeedSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -1776795561228106469L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f136262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SimplePlainQueue f136263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f136264d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f136265f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f136266g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f136267h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f136268i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Throwable f136269j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Subscription f136270k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f136271l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f136272m;

        ScanSeedSubscriber(Subscriber subscriber, BiFunction biFunction, Object obj, int i3) {
            this.f136261a = subscriber;
            this.f136262b = biFunction;
            this.f136271l = obj;
            this.f136265f = i3;
            this.f136266g = i3 - (i3 >> 2);
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(i3);
            this.f136263c = spscArrayQueue;
            spscArrayQueue.offer(obj);
            this.f136264d = new AtomicLong();
        }

        void a() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f136261a;
            SimplePlainQueue simplePlainQueue = this.f136263c;
            int i3 = this.f136266g;
            int i4 = this.f136272m;
            int iAddAndGet = 1;
            do {
                long j3 = this.f136264d.get();
                long j4 = 0;
                while (j4 != j3) {
                    if (this.f136267h) {
                        simplePlainQueue.clear();
                        return;
                    }
                    boolean z2 = this.f136268i;
                    if (z2 && (th = this.f136269j) != null) {
                        simplePlainQueue.clear();
                        subscriber.onError(th);
                        return;
                    }
                    Object objPoll = simplePlainQueue.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        subscriber.onComplete();
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.h(objPoll);
                    j4++;
                    i4++;
                    if (i4 == i3) {
                        this.f136270k.y(i3);
                        i4 = 0;
                    }
                }
                if (j4 == j3 && this.f136268i) {
                    Throwable th2 = this.f136269j;
                    if (th2 != null) {
                        simplePlainQueue.clear();
                        subscriber.onError(th2);
                        return;
                    } else if (simplePlainQueue.isEmpty()) {
                        subscriber.onComplete();
                        return;
                    }
                }
                if (j4 != 0) {
                    BackpressureHelper.e(this.f136264d, j4);
                }
                this.f136272m = i4;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136267h = true;
            this.f136270k.cancel();
            if (getAndIncrement() == 0) {
                this.f136263c.clear();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136270k, subscription)) {
                this.f136270k = subscription;
                this.f136261a.g(this);
                subscription.y(this.f136265f - 1);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136268i) {
                return;
            }
            try {
                Object objD = ObjectHelper.d(this.f136262b.apply(this.f136271l, obj), "The accumulator returned a null value");
                this.f136271l = objD;
                this.f136263c.offer(objD);
                a();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136270k.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136268i) {
                return;
            }
            this.f136268i = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136268i) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136269j = th;
            this.f136268i = true;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136264d, j3);
                a();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        try {
            this.f135196b.w(new ScanSeedSubscriber(subscriber, this.f136259c, ObjectHelper.d(this.f136260d.call(), "The seed supplied is null"), Flowable.a()));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
