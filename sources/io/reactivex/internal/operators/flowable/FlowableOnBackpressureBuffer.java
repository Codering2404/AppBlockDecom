package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableOnBackpressureBuffer<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f136004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f136005d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f136006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Action f136007g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -2514538129242366402L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SimplePlainQueue f136009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f136010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Action f136011d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f136012f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f136013g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f136014h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Throwable f136015i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicLong f136016j = new AtomicLong();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f136017k;

        BackpressureBufferSubscriber(Subscriber subscriber, int i3, boolean z2, boolean z3, Action action) {
            this.f136008a = subscriber;
            this.f136011d = action;
            this.f136010c = z3;
            this.f136009b = z2 ? new SpscLinkedArrayQueue(i3) : new SpscArrayQueue(i3);
        }

        void c() {
            if (getAndIncrement() == 0) {
                SimplePlainQueue simplePlainQueue = this.f136009b;
                Subscriber subscriber = this.f136008a;
                int iAddAndGet = 1;
                while (!e(this.f136014h, simplePlainQueue.isEmpty(), subscriber)) {
                    long j3 = this.f136016j.get();
                    long j4 = 0;
                    while (j4 != j3) {
                        boolean z2 = this.f136014h;
                        Object objPoll = simplePlainQueue.poll();
                        boolean z3 = objPoll == null;
                        if (e(z2, z3, subscriber)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        subscriber.h(objPoll);
                        j4++;
                    }
                    if (j4 == j3 && e(this.f136014h, simplePlainQueue.isEmpty(), subscriber)) {
                        return;
                    }
                    if (j4 != 0 && j3 != Long.MAX_VALUE) {
                        this.f136016j.addAndGet(-j4);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136013g) {
                return;
            }
            this.f136013g = true;
            this.f136012f.cancel();
            if (getAndIncrement() == 0) {
                this.f136009b.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f136009b.clear();
        }

        boolean e(boolean z2, boolean z3, Subscriber subscriber) {
            if (this.f136013g) {
                this.f136009b.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.f136010c) {
                if (!z3) {
                    return false;
                }
                Throwable th = this.f136015i;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
            Throwable th2 = this.f136015i;
            if (th2 != null) {
                this.f136009b.clear();
                subscriber.onError(th2);
                return true;
            }
            if (!z3) {
                return false;
            }
            subscriber.onComplete();
            return true;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136012f, subscription)) {
                this.f136012f = subscription;
                this.f136008a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136009b.offer(obj)) {
                if (this.f136017k) {
                    this.f136008a.h(null);
                    return;
                } else {
                    c();
                    return;
                }
            }
            this.f136012f.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.f136011d.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                missingBackpressureException.initCause(th);
            }
            onError(missingBackpressureException);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f136009b.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 2) == 0) {
                return 0;
            }
            this.f136017k = true;
            return 2;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136014h = true;
            if (this.f136017k) {
                this.f136008a.onComplete();
            } else {
                c();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136015i = th;
            this.f136014h = true;
            if (this.f136017k) {
                this.f136008a.onError(th);
            } else {
                c();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            return this.f136009b.poll();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (this.f136017k || !SubscriptionHelper.h(j3)) {
                return;
            }
            BackpressureHelper.a(this.f136016j, j3);
            c();
        }
    }

    public FlowableOnBackpressureBuffer(Flowable flowable, int i3, boolean z2, boolean z3, Action action) {
        super(flowable);
        this.f136004c = i3;
        this.f136005d = z2;
        this.f136006f = z3;
        this.f136007g = action;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new BackpressureBufferSubscriber(subscriber, this.f136004c, this.f136005d, this.f136006f, this.f136007g));
    }
}
