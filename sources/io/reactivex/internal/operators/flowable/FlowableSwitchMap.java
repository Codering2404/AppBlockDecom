package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSwitchMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f136372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f136373d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f136374f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapInnerSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 3837284832786408377L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SwitchMapSubscriber f136375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f136376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f136377c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile SimpleQueue f136378d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f136379f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f136380g;

        SwitchMapInnerSubscriber(SwitchMapSubscriber switchMapSubscriber, long j3, int i3) {
            this.f136375a = switchMapSubscriber;
            this.f136376b = j3;
            this.f136377c = i3;
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(7);
                    if (iL == 1) {
                        this.f136380g = iL;
                        this.f136378d = queueSubscription;
                        this.f136379f = true;
                        this.f136375a.b();
                        return;
                    }
                    if (iL == 2) {
                        this.f136380g = iL;
                        this.f136378d = queueSubscription;
                        subscription.y(this.f136377c);
                        return;
                    }
                }
                this.f136378d = new SpscArrayQueue(this.f136377c);
                subscription.y(this.f136377c);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            SwitchMapSubscriber switchMapSubscriber = this.f136375a;
            if (this.f136376b == switchMapSubscriber.f136392l) {
                if (this.f136380g != 0 || this.f136378d.offer(obj)) {
                    switchMapSubscriber.b();
                } else {
                    onError(new MissingBackpressureException("Queue full?!"));
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            SwitchMapSubscriber switchMapSubscriber = this.f136375a;
            if (this.f136376b == switchMapSubscriber.f136392l) {
                this.f136379f = true;
                switchMapSubscriber.b();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            SwitchMapSubscriber switchMapSubscriber = this.f136375a;
            if (this.f136376b != switchMapSubscriber.f136392l || !switchMapSubscriber.f136387g.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!switchMapSubscriber.f136385d) {
                switchMapSubscriber.f136389i.cancel();
            }
            this.f136379f = true;
            switchMapSubscriber.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        static final SwitchMapInnerSubscriber f136381m;
        private static final long serialVersionUID = -3491074160481096299L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f136384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f136385d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f136386f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f136388h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Subscription f136389i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile long f136392l;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final AtomicReference f136390j = new AtomicReference();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicLong f136391k = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicThrowable f136387g = new AtomicThrowable();

        static {
            SwitchMapInnerSubscriber switchMapInnerSubscriber = new SwitchMapInnerSubscriber(null, -1L, 1);
            f136381m = switchMapInnerSubscriber;
            switchMapInnerSubscriber.a();
        }

        SwitchMapSubscriber(Subscriber subscriber, Function function, int i3, boolean z2) {
            this.f136382a = subscriber;
            this.f136383b = function;
            this.f136384c = i3;
            this.f136385d = z2;
        }

        void a() {
            SwitchMapInnerSubscriber switchMapInnerSubscriber;
            SwitchMapInnerSubscriber switchMapInnerSubscriber2 = (SwitchMapInnerSubscriber) this.f136390j.get();
            SwitchMapInnerSubscriber switchMapInnerSubscriber3 = f136381m;
            if (switchMapInnerSubscriber2 == switchMapInnerSubscriber3 || (switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.f136390j.getAndSet(switchMapInnerSubscriber3)) == switchMapInnerSubscriber3 || switchMapInnerSubscriber == null) {
                return;
            }
            switchMapInnerSubscriber.a();
        }

        void b() {
            boolean z2;
            Object objPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            Subscriber subscriber = this.f136382a;
            int iAddAndGet = 1;
            while (!this.f136388h) {
                if (this.f136386f) {
                    if (this.f136385d) {
                        if (this.f136390j.get() == null) {
                            if (this.f136387g.get() != null) {
                                subscriber.onError(this.f136387g.b());
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                    } else if (this.f136387g.get() != null) {
                        a();
                        subscriber.onError(this.f136387g.b());
                        return;
                    } else if (this.f136390j.get() == null) {
                        subscriber.onComplete();
                        return;
                    }
                }
                SwitchMapInnerSubscriber switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.f136390j.get();
                SimpleQueue simpleQueue = switchMapInnerSubscriber != null ? switchMapInnerSubscriber.f136378d : null;
                if (simpleQueue != null) {
                    if (switchMapInnerSubscriber.f136379f) {
                        if (this.f136385d) {
                            if (simpleQueue.isEmpty()) {
                                h.a(this.f136390j, switchMapInnerSubscriber, null);
                            }
                        } else if (this.f136387g.get() != null) {
                            a();
                            subscriber.onError(this.f136387g.b());
                            return;
                        } else if (simpleQueue.isEmpty()) {
                            h.a(this.f136390j, switchMapInnerSubscriber, null);
                        }
                    }
                    long j3 = this.f136391k.get();
                    long j4 = 0;
                    while (true) {
                        z2 = false;
                        if (j4 != j3) {
                            if (!this.f136388h) {
                                boolean z3 = switchMapInnerSubscriber.f136379f;
                                try {
                                    objPoll = simpleQueue.poll();
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    switchMapInnerSubscriber.a();
                                    this.f136387g.a(th);
                                    objPoll = null;
                                    z3 = true;
                                }
                                boolean z4 = objPoll == null;
                                if (switchMapInnerSubscriber != this.f136390j.get()) {
                                    break;
                                }
                                if (z3) {
                                    if (!this.f136385d) {
                                        if (this.f136387g.get() == null) {
                                            if (z4) {
                                                h.a(this.f136390j, switchMapInnerSubscriber, null);
                                                break;
                                            }
                                        } else {
                                            subscriber.onError(this.f136387g.b());
                                            return;
                                        }
                                    } else if (z4) {
                                        h.a(this.f136390j, switchMapInnerSubscriber, null);
                                        break;
                                    }
                                }
                                if (z4) {
                                    break;
                                }
                                subscriber.h(objPoll);
                                j4++;
                            } else {
                                return;
                            }
                        } else {
                            break;
                        }
                    }
                    z2 = true;
                    if (j4 != 0 && !this.f136388h) {
                        if (j3 != Long.MAX_VALUE) {
                            this.f136391k.addAndGet(-j4);
                        }
                        switchMapInnerSubscriber.get().y(j4);
                    }
                    if (z2) {
                        continue;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            this.f136390j.lazySet(null);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f136388h) {
                return;
            }
            this.f136388h = true;
            this.f136389i.cancel();
            a();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136389i, subscription)) {
                this.f136389i = subscription;
                this.f136382a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            SwitchMapInnerSubscriber switchMapInnerSubscriber;
            if (this.f136386f) {
                return;
            }
            long j3 = this.f136392l + 1;
            this.f136392l = j3;
            SwitchMapInnerSubscriber switchMapInnerSubscriber2 = (SwitchMapInnerSubscriber) this.f136390j.get();
            if (switchMapInnerSubscriber2 != null) {
                switchMapInnerSubscriber2.a();
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.d(this.f136383b.apply(obj), "The publisher returned is null");
                SwitchMapInnerSubscriber switchMapInnerSubscriber3 = new SwitchMapInnerSubscriber(this, j3, this.f136384c);
                do {
                    switchMapInnerSubscriber = (SwitchMapInnerSubscriber) this.f136390j.get();
                    if (switchMapInnerSubscriber == f136381m) {
                        return;
                    }
                } while (!h.a(this.f136390j, switchMapInnerSubscriber, switchMapInnerSubscriber3));
                publisher.i(switchMapInnerSubscriber3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136389i.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136386f) {
                return;
            }
            this.f136386f = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136386f || !this.f136387g.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f136385d) {
                a();
            }
            this.f136386f = true;
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136391k, j3);
                if (this.f136392l == 0) {
                    this.f136389i.y(Long.MAX_VALUE);
                } else {
                    b();
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (FlowableScalarXMap.a(this.f135196b, subscriber, this.f136372c)) {
            return;
        }
        this.f135196b.w(new SwitchMapSubscriber(subscriber, this.f136372c, this.f136373d, this.f136374f));
    }
}
