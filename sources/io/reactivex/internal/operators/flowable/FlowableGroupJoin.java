package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
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
public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractFlowableWithUpstream<TLeft, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Publisher f135815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f135816d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Function f135817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final BiFunction f135818g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Subscription, JoinSupport {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        static final Integer f135819p = 1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        static final Integer f135820q = 2;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final Integer f135821r = 3;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        static final Integer f135822s = 4;
        private static final long serialVersionUID = -6071216598687999801L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135823a;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Function f135830i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Function f135831j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final BiFunction f135832k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f135834m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f135835n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        volatile boolean f135836o;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicLong f135824b = new AtomicLong();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final CompositeDisposable f135826d = new CompositeDisposable();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SpscLinkedArrayQueue f135825c = new SpscLinkedArrayQueue(Flowable.a());

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Map f135827f = new LinkedHashMap();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Map f135828g = new LinkedHashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference f135829h = new AtomicReference();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final AtomicInteger f135833l = new AtomicInteger(2);

        GroupJoinSubscription(Subscriber subscriber, Function function, Function function2, BiFunction biFunction) {
            this.f135823a = subscriber;
            this.f135830i = function;
            this.f135831j = function2;
            this.f135832k = biFunction;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void a(boolean z2, Object obj) {
            synchronized (this) {
                try {
                    this.f135825c.p(z2 ? f135819p : f135820q, obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
            g();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void b(Throwable th) {
            if (!ExceptionHelper.a(this.f135829h, th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f135833l.decrementAndGet();
                g();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void c(Throwable th) {
            if (ExceptionHelper.a(this.f135829h, th)) {
                g();
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135836o) {
                return;
            }
            this.f135836o = true;
            f();
            if (getAndIncrement() == 0) {
                this.f135825c.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void d(boolean z2, LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                try {
                    this.f135825c.p(z2 ? f135821r : f135822s, leftRightEndSubscriber);
                } catch (Throwable th) {
                    throw th;
                }
            }
            g();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.JoinSupport
        public void e(LeftRightSubscriber leftRightSubscriber) {
            this.f135826d.c(leftRightSubscriber);
            this.f135833l.decrementAndGet();
            g();
        }

        void f() {
            this.f135826d.dispose();
        }

        void g() {
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135825c;
            Subscriber subscriber = this.f135823a;
            int iAddAndGet = 1;
            while (!this.f135836o) {
                if (((Throwable) this.f135829h.get()) != null) {
                    spscLinkedArrayQueue.clear();
                    f();
                    h(subscriber);
                    return;
                }
                boolean z2 = this.f135833l.get() == 0;
                Integer num = (Integer) spscLinkedArrayQueue.poll();
                boolean z3 = num == null;
                if (z2 && z3) {
                    Iterator it = this.f135827f.values().iterator();
                    while (it.hasNext()) {
                        ((UnicastProcessor) it.next()).onComplete();
                    }
                    this.f135827f.clear();
                    this.f135828g.clear();
                    this.f135826d.dispose();
                    subscriber.onComplete();
                    return;
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = spscLinkedArrayQueue.poll();
                    if (num == f135819p) {
                        UnicastProcessor unicastProcessorC = UnicastProcessor.C();
                        int i3 = this.f135834m;
                        this.f135834m = i3 + 1;
                        this.f135827f.put(Integer.valueOf(i3), unicastProcessorC);
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.d(this.f135830i.apply(objPoll), "The leftEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i3);
                            this.f135826d.b(leftRightEndSubscriber);
                            publisher.i(leftRightEndSubscriber);
                            if (((Throwable) this.f135829h.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                f();
                                h(subscriber);
                                return;
                            }
                            try {
                                Object objD = ObjectHelper.d(this.f135832k.apply(objPoll, unicastProcessorC), "The resultSelector returned a null value");
                                if (this.f135824b.get() == 0) {
                                    i(new MissingBackpressureException("Could not emit value due to lack of requests"), subscriber, spscLinkedArrayQueue);
                                    return;
                                }
                                subscriber.h(objD);
                                BackpressureHelper.e(this.f135824b, 1L);
                                Iterator it2 = this.f135828g.values().iterator();
                                while (it2.hasNext()) {
                                    unicastProcessorC.h(it2.next());
                                }
                            } catch (Throwable th) {
                                i(th, subscriber, spscLinkedArrayQueue);
                                return;
                            }
                        } catch (Throwable th2) {
                            i(th2, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f135820q) {
                        int i4 = this.f135835n;
                        this.f135835n = i4 + 1;
                        this.f135828g.put(Integer.valueOf(i4), objPoll);
                        try {
                            Publisher publisher2 = (Publisher) ObjectHelper.d(this.f135831j.apply(objPoll), "The rightEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i4);
                            this.f135826d.b(leftRightEndSubscriber2);
                            publisher2.i(leftRightEndSubscriber2);
                            if (((Throwable) this.f135829h.get()) != null) {
                                spscLinkedArrayQueue.clear();
                                f();
                                h(subscriber);
                                return;
                            } else {
                                Iterator it3 = this.f135827f.values().iterator();
                                while (it3.hasNext()) {
                                    ((UnicastProcessor) it3.next()).h(objPoll);
                                }
                            }
                        } catch (Throwable th3) {
                            i(th3, subscriber, spscLinkedArrayQueue);
                            return;
                        }
                    } else if (num == f135821r) {
                        LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) objPoll;
                        UnicastProcessor unicastProcessor = (UnicastProcessor) this.f135827f.remove(Integer.valueOf(leftRightEndSubscriber3.f135839c));
                        this.f135826d.a(leftRightEndSubscriber3);
                        if (unicastProcessor != null) {
                            unicastProcessor.onComplete();
                        }
                    } else if (num == f135822s) {
                        LeftRightEndSubscriber leftRightEndSubscriber4 = (LeftRightEndSubscriber) objPoll;
                        this.f135828g.remove(Integer.valueOf(leftRightEndSubscriber4.f135839c));
                        this.f135826d.a(leftRightEndSubscriber4);
                    }
                }
            }
            spscLinkedArrayQueue.clear();
        }

        void h(Subscriber subscriber) {
            Throwable thB = ExceptionHelper.b(this.f135829h);
            Iterator it = this.f135827f.values().iterator();
            while (it.hasNext()) {
                ((UnicastProcessor) it.next()).onError(thB);
            }
            this.f135827f.clear();
            this.f135828g.clear();
            subscriber.onError(thB);
        }

        void i(Throwable th, Subscriber subscriber, SimpleQueue simpleQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.f135829h, th);
            simpleQueue.clear();
            f();
            h(subscriber);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135824b, j3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface JoinSupport {
        void a(boolean z2, Object obj);

        void b(Throwable th);

        void c(Throwable th);

        void d(boolean z2, LeftRightEndSubscriber leftRightEndSubscriber);

        void e(LeftRightSubscriber leftRightSubscriber);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LeftRightEndSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final JoinSupport f135837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f135838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135839c;

        LeftRightEndSubscriber(JoinSupport joinSupport, boolean z2, int i3) {
            this.f135837a = joinSupport;
            this.f135838b = z2;
            this.f135839c = i3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (SubscriptionHelper.a(this)) {
                this.f135837a.d(this.f135838b, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135837a.d(this.f135838b, this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135837a.c(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LeftRightSubscriber extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = 1883890389173668373L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final JoinSupport f135840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f135841b;

        LeftRightSubscriber(JoinSupport joinSupport, boolean z2) {
            this.f135840a = joinSupport;
            this.f135841b = z2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135840a.a(this.f135841b, obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135840a.e(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135840a.b(th);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(subscriber, this.f135816d, this.f135817f, this.f135818g);
        subscriber.g(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.f135826d.b(leftRightSubscriber);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.f135826d.b(leftRightSubscriber2);
        this.f135196b.w(leftRightSubscriber);
        this.f135815c.i(leftRightSubscriber2);
    }
}
