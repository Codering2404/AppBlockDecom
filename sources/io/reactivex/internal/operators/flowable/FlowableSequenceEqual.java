package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableSequenceEqual<T> extends Flowable<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Publisher f136273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f136274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final BiPredicate f136275d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f136276f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements EqualCoordinatorHelper {
        private static final long serialVersionUID = -6178010334400373240L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BiPredicate f136277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final EqualSubscriber f136278d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final EqualSubscriber f136279f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicThrowable f136280g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicInteger f136281h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f136282i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f136283j;

        EqualCoordinator(Subscriber subscriber, int i3, BiPredicate biPredicate) {
            super(subscriber);
            this.f136277c = biPredicate;
            this.f136281h = new AtomicInteger();
            this.f136278d = new EqualSubscriber(this, i3);
            this.f136279f = new EqualSubscriber(this, i3);
            this.f136280g = new AtomicThrowable();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void b(Throwable th) {
            if (this.f136280g.a(th)) {
                c();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.EqualCoordinatorHelper
        public void c() {
            if (this.f136281h.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                SimpleQueue simpleQueue = this.f136278d.f136288f;
                SimpleQueue simpleQueue2 = this.f136279f.f136288f;
                if (simpleQueue != null && simpleQueue2 != null) {
                    while (!j()) {
                        if (this.f136280g.get() != null) {
                            m();
                            this.f139174a.onError(this.f136280g.b());
                            return;
                        }
                        boolean z2 = this.f136278d.f136289g;
                        Object objPoll = this.f136282i;
                        if (objPoll == null) {
                            try {
                                objPoll = simpleQueue.poll();
                                this.f136282i = objPoll;
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                m();
                                this.f136280g.a(th);
                                this.f139174a.onError(this.f136280g.b());
                                return;
                            }
                        }
                        boolean z3 = objPoll == null;
                        boolean z4 = this.f136279f.f136289g;
                        Object objPoll2 = this.f136283j;
                        if (objPoll2 == null) {
                            try {
                                objPoll2 = simpleQueue2.poll();
                                this.f136283j = objPoll2;
                            } catch (Throwable th2) {
                                Exceptions.b(th2);
                                m();
                                this.f136280g.a(th2);
                                this.f139174a.onError(this.f136280g.b());
                                return;
                            }
                        }
                        boolean z5 = objPoll2 == null;
                        if (z2 && z4 && z3 && z5) {
                            e(Boolean.TRUE);
                            return;
                        }
                        if (z2 && z4 && z3 != z5) {
                            m();
                            e(Boolean.FALSE);
                            return;
                        }
                        if (!z3 && !z5) {
                            try {
                                if (!this.f136277c.test(objPoll, objPoll2)) {
                                    m();
                                    e(Boolean.FALSE);
                                    return;
                                } else {
                                    this.f136282i = null;
                                    this.f136283j = null;
                                    this.f136278d.c();
                                    this.f136279f.c();
                                }
                            } catch (Throwable th3) {
                                Exceptions.b(th3);
                                m();
                                this.f136280g.a(th3);
                                this.f139174a.onError(this.f136280g.b());
                                return;
                            }
                        }
                    }
                    this.f136278d.b();
                    this.f136279f.b();
                    return;
                }
                if (j()) {
                    this.f136278d.b();
                    this.f136279f.b();
                    return;
                } else if (this.f136280g.get() != null) {
                    m();
                    this.f139174a.onError(this.f136280g.b());
                    return;
                }
                iAddAndGet = this.f136281h.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            super.cancel();
            this.f136278d.a();
            this.f136279f.a();
            if (this.f136281h.getAndIncrement() == 0) {
                this.f136278d.b();
                this.f136279f.b();
            }
        }

        void m() {
            this.f136278d.a();
            this.f136278d.b();
            this.f136279f.a();
            this.f136279f.b();
        }

        void p(Publisher publisher, Publisher publisher2) {
            publisher.i(this.f136278d);
            publisher2.i(this.f136279f);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface EqualCoordinatorHelper {
        void b(Throwable th);

        void c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EqualSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4804128302091633067L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EqualCoordinatorHelper f136284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f136285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f136286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f136287d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile SimpleQueue f136288f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f136289g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f136290h;

        EqualSubscriber(EqualCoordinatorHelper equalCoordinatorHelper, int i3) {
            this.f136284a = equalCoordinatorHelper;
            this.f136286c = i3 - (i3 >> 2);
            this.f136285b = i3;
        }

        public void a() {
            SubscriptionHelper.a(this);
        }

        void b() {
            SimpleQueue simpleQueue = this.f136288f;
            if (simpleQueue != null) {
                simpleQueue.clear();
            }
        }

        public void c() {
            if (this.f136290h != 1) {
                long j3 = this.f136287d + 1;
                if (j3 < this.f136286c) {
                    this.f136287d = j3;
                } else {
                    this.f136287d = 0L;
                    get().y(j3);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(3);
                    if (iL == 1) {
                        this.f136290h = iL;
                        this.f136288f = queueSubscription;
                        this.f136289g = true;
                        this.f136284a.c();
                        return;
                    }
                    if (iL == 2) {
                        this.f136290h = iL;
                        this.f136288f = queueSubscription;
                        subscription.y(this.f136285b);
                        return;
                    }
                }
                this.f136288f = new SpscArrayQueue(this.f136285b);
                subscription.y(this.f136285b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136290h != 0 || this.f136288f.offer(obj)) {
                this.f136284a.c();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136289g = true;
            this.f136284a.c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136284a.b(th);
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(subscriber, this.f136276f, this.f136275d);
        subscriber.g(equalCoordinator);
        equalCoordinator.p(this.f136273b, this.f136274c);
    }
}
