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
public final class FlowableTakeLastTimed<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f136409d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TimeUnit f136410f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Scheduler f136411g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f136412h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f136413i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5677354903406201275L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f136416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final TimeUnit f136417d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Scheduler f136418f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final SpscLinkedArrayQueue f136419g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final boolean f136420h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Subscription f136421i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicLong f136422j = new AtomicLong();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f136423k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f136424l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Throwable f136425m;

        TakeLastTimedSubscriber(Subscriber subscriber, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler, int i3, boolean z2) {
            this.f136414a = subscriber;
            this.f136415b = j3;
            this.f136416c = j4;
            this.f136417d = timeUnit;
            this.f136418f = scheduler;
            this.f136419g = new SpscLinkedArrayQueue(i3);
            this.f136420h = z2;
        }

        boolean a(boolean z2, Subscriber subscriber, boolean z3) {
            if (this.f136423k) {
                this.f136419g.clear();
                return true;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.f136425m;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.f136425m;
            if (th2 != null) {
                this.f136419g.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f136414a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f136419g;
            boolean z2 = this.f136420h;
            int iAddAndGet = 1;
            do {
                if (this.f136424l) {
                    if (a(spscLinkedArrayQueue.isEmpty(), subscriber, z2)) {
                        return;
                    }
                    long j3 = this.f136422j.get();
                    long j4 = 0;
                    while (true) {
                        if (a(spscLinkedArrayQueue.peek() == null, subscriber, z2)) {
                            return;
                        }
                        if (j3 != j4) {
                            spscLinkedArrayQueue.poll();
                            subscriber.h(spscLinkedArrayQueue.poll());
                            j4++;
                        } else if (j4 != 0) {
                            BackpressureHelper.e(this.f136422j, j4);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        void c(long j3, SpscLinkedArrayQueue spscLinkedArrayQueue) {
            long j4 = this.f136416c;
            long j5 = this.f136415b;
            boolean z2 = j5 == Long.MAX_VALUE;
            while (!spscLinkedArrayQueue.isEmpty()) {
                if (((Long) spscLinkedArrayQueue.peek()).longValue() >= j3 - j4 && (z2 || (spscLinkedArrayQueue.r() >> 1) <= j5)) {
                    return;
                }
                spscLinkedArrayQueue.poll();
                spscLinkedArrayQueue.poll();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136423k) {
                return;
            }
            this.f136423k = true;
            this.f136421i.cancel();
            if (getAndIncrement() == 0) {
                this.f136419g.clear();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136421i, subscription)) {
                this.f136421i = subscription;
                this.f136414a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f136419g;
            long jC = this.f136418f.c(this.f136417d);
            spscLinkedArrayQueue.p(Long.valueOf(jC), obj);
            c(jC, spscLinkedArrayQueue);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            c(this.f136418f.c(this.f136417d), this.f136419g);
            this.f136424l = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136420h) {
                c(this.f136418f.c(this.f136417d), this.f136419g);
            }
            this.f136425m = th;
            this.f136424l = true;
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136422j, j3);
                b();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new TakeLastTimedSubscriber(subscriber, this.f136408c, this.f136409d, this.f136410f, this.f136411g, this.f136412h, this.f136413i));
    }
}
