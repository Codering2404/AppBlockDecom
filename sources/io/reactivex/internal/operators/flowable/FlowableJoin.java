package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f135894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f135895d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Function f135896f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final BiFunction f135897g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, FlowableGroupJoin.JoinSupport {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final Integer f135898p = 1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final Integer f135899q = 2;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final Integer f135900r = 3;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        static final Integer f135901s = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135902a;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Function f135909i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Function f135910j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final BiFunction f135911k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f135913m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f135914n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        volatile boolean f135915o;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicLong f135903b = new AtomicLong();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final CompositeDisposable f135905d = new CompositeDisposable();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SpscLinkedArrayQueue f135904c = new SpscLinkedArrayQueue(Flowable.a());

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Map f135906f = new LinkedHashMap();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Map f135907g = new LinkedHashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference f135908h = new AtomicReference();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final AtomicInteger f135912l = new AtomicInteger(2);

        JoinSubscription(Subscriber subscriber, Function function, Function function2, BiFunction biFunction) {
            this.f135902a = subscriber;
            this.f135909i = function;
            this.f135910j = function2;
            this.f135911k = biFunction;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void a(boolean z2, Object obj) {
            synchronized (this) {
                try {
                    this.f135904c.p(z2 ? f135898p : f135899q, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            g();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void b(Throwable th) {
            if (!ExceptionHelper.a(this.f135908h, th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f135912l.decrementAndGet();
                g();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void c(Throwable th) {
            if (ExceptionHelper.a(this.f135908h, th)) {
                g();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135915o) {
                return;
            }
            this.f135915o = true;
            f();
            if (getAndIncrement() == 0) {
                this.f135904c.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void d(boolean z2, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                try {
                    this.f135904c.p(z2 ? f135900r : f135901s, leftRightEndSubscriber);
                } catch (Throwable th) {
                    throw th;
                }
            }
            g();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void e(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.f135905d.c(leftRightSubscriber);
            this.f135912l.decrementAndGet();
            g();
        }

        void f() {
            this.f135905d.dispose();
        }

        void g() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135904c;
            Subscriber subscriber = this.f135902a;
            boolean z2 = true;
            int iAddAndGet = 1;
            while (!this.f135915o) {
                if (((Throwable) this.f135908h.get()) != null) {
                    spscLinkedArrayQueue.clear();
                    f();
                    h(subscriber);
                    return;
                }
                boolean z3 = this.f135912l.get() == 0 ? z2 : false;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z4 = num == null ? z2 : false;
                if (z3 && z4) {
                    this.f135906f.clear();
                    this.f135907g.clear();
                    this.f135905d.dispose();
                    subscriber.onComplete();
                    return;
                }
                if (z4) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = spscLinkedArrayQueue.poll();
                    if (num == f135898p) {
                        int i3 = this.f135913m;
                        this.f135913m = i3 + 1;
                        this.f135906f.put(Integer.valueOf(i3), objPoll);
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.d(this.f135909i.apply(objPoll), "The leftEnd returned a null Publisher");
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber(this, z2, i3);
                            this.f135905d.b(leftRightEndSubscriber);
                            publisher.i(leftRightEndSubscriber);
                            if (((Throwable) this.f135908h.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                f();
                                h(subscriber);
                                return;
                            }
                            long j3 = this.f135903b.get();
                            Iterator it = this.f135907g.values().iterator();
                            long j4 = 0;
                            while (it.hasNext()) {
                                try {
                                    Object objD = ObjectHelper.d(this.f135911k.apply(objPoll, it.next()), "The resultSelector returned a null value");
                                    if (j4 == j3) {
                                        ExceptionHelper.a(this.f135908h, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        spscLinkedArrayQueue.clear();
                                        f();
                                        h(subscriber);
                                        return;
                                    }
                                    subscriber.h(objD);
                                    j4++;
                                } catch (Throwable th) {
                                    i(th, subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                            if (j4 != 0) {
                                BackpressureHelper.e(this.f135903b, j4);
                            }
                        } catch (Throwable th2) {
                            i(th2, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f135899q) {
                        int i4 = this.f135914n;
                        this.f135914n = i4 + 1;
                        this.f135907g.put(Integer.valueOf(i4), objPoll);
                        try {
                            Publisher publisher2 = (Publisher) ObjectHelper.d(this.f135910j.apply(objPoll), "The rightEnd returned a null Publisher");
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, i4);
                            this.f135905d.b(leftRightEndSubscriber2);
                            publisher2.i(leftRightEndSubscriber2);
                            if (((Throwable) this.f135908h.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                f();
                                h(subscriber);
                                return;
                            }
                            long j5 = this.f135903b.get();
                            Iterator it2 = this.f135906f.values().iterator();
                            long j6 = 0;
                            while (it2.hasNext()) {
                                try {
                                    Object objD2 = ObjectHelper.d(this.f135911k.apply(it2.next(), objPoll), "The resultSelector returned a null value");
                                    if (j6 == j5) {
                                        ExceptionHelper.a(this.f135908h, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        spscLinkedArrayQueue.clear();
                                        f();
                                        h(subscriber);
                                        return;
                                    }
                                    subscriber.h(objD2);
                                    j6++;
                                } catch (Throwable th3) {
                                    i(th3, subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                            }
                            if (j6 != 0) {
                                BackpressureHelper.e(this.f135903b, j6);
                            }
                        } catch (Throwable th4) {
                            i(th4, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f135900r) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FlowableGroupJoin.LeftRightEndSubscriber) objPoll;
                        this.f135906f.remove(Integer.valueOf(leftRightEndSubscriber3.f135839c));
                        this.f135905d.a(leftRightEndSubscriber3);
                    } else if (num == f135901s) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FlowableGroupJoin.LeftRightEndSubscriber) objPoll;
                        this.f135907g.remove(Integer.valueOf(leftRightEndSubscriber4.f135839c));
                        this.f135905d.a(leftRightEndSubscriber4);
                    }
                    z2 = true;
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void h(Subscriber subscriber) {
            Throwable thB = ExceptionHelper.b(this.f135908h);
            this.f135906f.clear();
            this.f135907g.clear();
            subscriber.onError(thB);
        }

        void i(Throwable th, Subscriber subscriber, SimpleQueue simpleQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.f135908h, th);
            simpleQueue.clear();
            f();
            h(subscriber);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135903b, j3);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        JoinSubscription joinSubscription = new JoinSubscription(subscriber, this.f135895d, this.f135896f, this.f135897g);
        subscriber.g(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.f135905d.b(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.f135905d.b(leftRightSubscriber2);
        this.f135196b.w(leftRightSubscriber);
        this.f135894c.i(leftRightSubscriber2);
    }
}
