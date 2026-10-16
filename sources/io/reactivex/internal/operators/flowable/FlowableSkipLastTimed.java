package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSkipLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f136329d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f136330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f136331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f136332h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f136335c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler f136336d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final SpscLinkedArrayQueue f136337f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f136338g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Subscription f136339h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicLong f136340i = new AtomicLong();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f136341j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f136342k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Throwable f136343l;

        SkipLastTimedSubscriber(Subscriber subscriber, long j3, TimeUnit timeUnit, Scheduler scheduler, int i3, boolean z2) {
            this.f136333a = subscriber;
            this.f136334b = j3;
            this.f136335c = timeUnit;
            this.f136336d = scheduler;
            this.f136337f = new SpscLinkedArrayQueue(i3);
            this.f136338g = z2;
        }

        boolean a(boolean z2, boolean z3, Subscriber subscriber, boolean z4) {
            if (this.f136341j) {
                this.f136337f.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (z4) {
                if (!z3) {
                    return false;
                }
                Throwable th = this.f136343l;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.f136343l;
            if (th2 != null) {
                this.f136337f.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z3) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        void b() {
            long j3;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f136333a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f136337f;
            boolean z2 = this.f136338g;
            TimeUnit timeUnit = this.f136335c;
            Scheduler scheduler = this.f136336d;
            long j4 = this.f136334b;
            int iAddAndGet = 1;
            do {
                long j5 = this.f136340i.get();
                long j6 = 0;
                while (true) {
                    if (j6 == j5) {
                        j3 = 0;
                        break;
                    }
                    boolean z3 = this.f136342k;
                    Long l3 = (Long) spscLinkedArrayQueue.peek();
                    boolean z4 = l3 == null;
                    boolean z5 = (z4 || l3.longValue() <= scheduler.c(timeUnit) - j4) ? z4 : true;
                    j3 = 0;
                    if (a(z3, z5, subscriber, z2)) {
                        return;
                    }
                    if (z5) {
                        break;
                    }
                    spscLinkedArrayQueue.poll();
                    subscriber.h(spscLinkedArrayQueue.poll());
                    j6++;
                }
                if (j6 != j3) {
                    BackpressureHelper.e(this.f136340i, j6);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136341j) {
                return;
            }
            this.f136341j = true;
            this.f136339h.cancel();
            if (getAndIncrement() == 0) {
                this.f136337f.clear();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136339h, subscription)) {
                this.f136339h = subscription;
                this.f136333a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136337f.p(Long.valueOf(this.f136336d.c(this.f136335c)), obj);
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136342k = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136343l = th;
            this.f136342k = true;
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136340i, j3);
                b();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new SkipLastTimedSubscriber(subscriber, this.f136328c, this.f136329d, this.f136330f, this.f136331g, this.f136332h));
    }
}
