package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFlattenIterable<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f135735d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlattenIterableSubscriber<T, R> extends BasicIntQueueSubscription<R> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -3096000382929934955L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f135737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135738c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135739d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Subscription f135741g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        SimpleQueue f135742h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f135743i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f135744j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Iterator f135746l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f135747m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f135748n;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicReference f135745k = new AtomicReference();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f135740f = new AtomicLong();

        FlattenIterableSubscriber(Subscriber subscriber, Function function, int i3) {
            this.f135736a = subscriber;
            this.f135737b = function;
            this.f135738c = i3;
            this.f135739d = i3 - (i3 >> 2);
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x0128 A[PHI: r6
          0x0128: PHI (r6v4 java.util.Iterator<T>) = (r6v3 java.util.Iterator<T>), (r6v6 java.util.Iterator<T>) binds: [B:31:0x0081, B:68:0x0123] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c() {
            /*
                Method dump skipped, instruction units count: 304
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlattenIterable.FlattenIterableSubscriber.c():void");
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135744j) {
                return;
            }
            this.f135744j = true;
            this.f135741g.cancel();
            if (getAndIncrement() == 0) {
                this.f135742h.clear();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f135746l = null;
            this.f135742h.clear();
        }

        boolean e(boolean z2, boolean z3, Subscriber subscriber, SimpleQueue simpleQueue) {
            if (this.f135744j) {
                this.f135746l = null;
                simpleQueue.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (((Throwable) this.f135745k.get()) == null) {
                if (!z3) {
                    return false;
                }
                subscriber.onComplete();
                return true;
            }
            Throwable thB = ExceptionHelper.b(this.f135745k);
            this.f135746l = null;
            simpleQueue.clear();
            subscriber.onError(thB);
            return true;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135741g, subscription)) {
                this.f135741g = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(3);
                    if (iL == 1) {
                        this.f135748n = iL;
                        this.f135742h = queueSubscription;
                        this.f135743i = true;
                        this.f135736a.g(this);
                        return;
                    }
                    if (iL == 2) {
                        this.f135748n = iL;
                        this.f135742h = queueSubscription;
                        this.f135736a.g(this);
                        subscription.y(this.f135738c);
                        return;
                    }
                }
                this.f135742h = new SpscArrayQueue(this.f135738c);
                this.f135736a.g(this);
                subscription.y(this.f135738c);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135743i) {
                return;
            }
            if (this.f135748n != 0 || this.f135742h.offer(obj)) {
                c();
            } else {
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f135746l == null && this.f135742h.isEmpty();
        }

        void j(boolean z2) {
            if (z2) {
                int i3 = this.f135747m + 1;
                if (i3 != this.f135739d) {
                    this.f135747m = i3;
                } else {
                    this.f135747m = 0;
                    this.f135741g.y(i3);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return ((i3 & 1) == 0 || this.f135748n != 1) ? 0 : 1;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135743i) {
                return;
            }
            this.f135743i = true;
            c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135743i || !ExceptionHelper.a(this.f135745k, th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f135743i = true;
                c();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Iterator<T> it = this.f135746l;
            while (true) {
                if (it == null) {
                    Object objPoll = this.f135742h.poll();
                    if (objPoll != null) {
                        it = ((Iterable) this.f135737b.apply(objPoll)).iterator();
                        if (it.hasNext()) {
                            this.f135746l = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            Object objD = ObjectHelper.d(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f135746l = null;
            }
            return objD;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135740f, j3);
                c();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        Flowable flowable = this.f135196b;
        if (!(flowable instanceof Callable)) {
            flowable.w(new FlattenIterableSubscriber(subscriber, this.f135734c, this.f135735d));
            return;
        }
        try {
            Object objCall = ((Callable) flowable).call();
            if (objCall == null) {
                EmptySubscription.a(subscriber);
                return;
            }
            try {
                FlowableFromIterable.A(subscriber, ((Iterable) this.f135734c.apply(objCall)).iterator());
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptySubscription.b(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptySubscription.b(th2, subscriber);
        }
    }
}
