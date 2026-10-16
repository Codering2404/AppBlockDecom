package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatMap<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f135427d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final ErrorMode f135428f;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.FlowableConcatMap$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f135429a;

        static {
            int[] iArr = new int[ErrorMode.values().length];
            f135429a = iArr;
            try {
                iArr[ErrorMode.BOUNDARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f135429a[ErrorMode.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseConcatMapSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, ConcatMapSupport<R>, Subscription {
        private static final long serialVersionUID = -3511336836796789179L;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f135431b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135432c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135433d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Subscription f135434f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f135435g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        SimpleQueue f135436h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f135437i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f135438j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f135440l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f135441m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ConcatMapInner f135430a = new ConcatMapInner(this);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicThrowable f135439k = new AtomicThrowable();

        BaseConcatMapSubscriber(Function function, int i3) {
            this.f135431b = function;
            this.f135432c = i3;
            this.f135433d = i3 - (i3 >> 2);
        }

        abstract void a();

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public final void c() {
            this.f135440l = false;
            a();
        }

        abstract void e();

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public final void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135434f, subscription)) {
                this.f135434f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(7);
                    if (iL == 1) {
                        this.f135441m = iL;
                        this.f135436h = queueSubscription;
                        this.f135437i = true;
                        e();
                        a();
                        return;
                    }
                    if (iL == 2) {
                        this.f135441m = iL;
                        this.f135436h = queueSubscription;
                        e();
                        subscription.y(this.f135432c);
                        return;
                    }
                }
                this.f135436h = new SpscArrayQueue(this.f135432c);
                e();
                subscription.y(this.f135432c);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void h(Object obj) {
            if (this.f135441m == 2 || this.f135436h.offer(obj)) {
                a();
            } else {
                this.f135434f.cancel();
                onError(new IllegalStateException("Queue full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public final void onComplete() {
            this.f135437i = true;
            a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapDelayed<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = -2945777694260521066L;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final Subscriber f135442n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final boolean f135443o;

        ConcatMapDelayed(Subscriber subscriber, Function function, int i3, boolean z2) {
            super(function, i3);
            this.f135442n = subscriber;
            this.f135443o = z2;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void a() {
            if (getAndIncrement() == 0) {
                while (!this.f135438j) {
                    if (!this.f135440l) {
                        boolean z2 = this.f135437i;
                        if (z2 && !this.f135443o && this.f135439k.get() != null) {
                            this.f135442n.onError(this.f135439k.b());
                            return;
                        }
                        try {
                            Object objPoll = this.f135436h.poll();
                            boolean z3 = objPoll == null;
                            if (z2 && z3) {
                                Throwable thB = this.f135439k.b();
                                if (thB != null) {
                                    this.f135442n.onError(thB);
                                    return;
                                } else {
                                    this.f135442n.onComplete();
                                    return;
                                }
                            }
                            if (!z3) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.d(this.f135431b.apply(objPoll), "The mapper returned a null Publisher");
                                    if (this.f135441m != 1) {
                                        int i3 = this.f135435g + 1;
                                        if (i3 == this.f135433d) {
                                            this.f135435g = 0;
                                            this.f135434f.y(i3);
                                        } else {
                                            this.f135435g = i3;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object objCall = ((Callable) publisher).call();
                                            if (objCall == null) {
                                                continue;
                                            } else if (this.f135430a.f()) {
                                                this.f135442n.h(objCall);
                                            } else {
                                                this.f135440l = true;
                                                ConcatMapInner concatMapInner = this.f135430a;
                                                concatMapInner.j(new WeakScalarSubscription(objCall, concatMapInner));
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            this.f135434f.cancel();
                                            this.f135439k.a(th);
                                            this.f135442n.onError(this.f135439k.b());
                                            return;
                                        }
                                    } else {
                                        this.f135440l = true;
                                        publisher.i(this.f135430a);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.b(th2);
                                    this.f135434f.cancel();
                                    this.f135439k.a(th2);
                                    this.f135442n.onError(this.f135439k.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.b(th3);
                            this.f135434f.cancel();
                            this.f135439k.a(th3);
                            this.f135442n.onError(this.f135439k.b());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void b(Throwable th) {
            if (!this.f135439k.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f135443o) {
                this.f135434f.cancel();
                this.f135437i = true;
            }
            this.f135440l = false;
            a();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135438j) {
                return;
            }
            this.f135438j = true;
            this.f135430a.cancel();
            this.f135434f.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void d(Object obj) {
            this.f135442n.h(obj);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void e() {
            this.f135442n.g(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135439k.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f135437i = true;
                a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f135430a.y(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapImmediate<T, R> extends BaseConcatMapSubscriber<T, R> {
        private static final long serialVersionUID = 7898995095634264146L;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final Subscriber f135444n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final AtomicInteger f135445o;

        ConcatMapImmediate(Subscriber subscriber, Function function, int i3) {
            super(function, i3);
            this.f135444n = subscriber;
            this.f135445o = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void a() {
            if (this.f135445o.getAndIncrement() == 0) {
                while (!this.f135438j) {
                    if (!this.f135440l) {
                        boolean z2 = this.f135437i;
                        try {
                            Object objPoll = this.f135436h.poll();
                            boolean z3 = objPoll == null;
                            if (z2 && z3) {
                                this.f135444n.onComplete();
                                return;
                            }
                            if (!z3) {
                                try {
                                    Publisher publisher = (Publisher) ObjectHelper.d(this.f135431b.apply(objPoll), "The mapper returned a null Publisher");
                                    if (this.f135441m != 1) {
                                        int i3 = this.f135435g + 1;
                                        if (i3 == this.f135433d) {
                                            this.f135435g = 0;
                                            this.f135434f.y(i3);
                                        } else {
                                            this.f135435g = i3;
                                        }
                                    }
                                    if (publisher instanceof Callable) {
                                        try {
                                            Object objCall = ((Callable) publisher).call();
                                            if (objCall == null) {
                                                continue;
                                            } else if (!this.f135430a.f()) {
                                                this.f135440l = true;
                                                ConcatMapInner concatMapInner = this.f135430a;
                                                concatMapInner.j(new WeakScalarSubscription(objCall, concatMapInner));
                                            } else if (get() == 0 && compareAndSet(0, 1)) {
                                                this.f135444n.h(objCall);
                                                if (!compareAndSet(1, 0)) {
                                                    this.f135444n.onError(this.f135439k.b());
                                                    return;
                                                }
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            this.f135434f.cancel();
                                            this.f135439k.a(th);
                                            this.f135444n.onError(this.f135439k.b());
                                            return;
                                        }
                                    } else {
                                        this.f135440l = true;
                                        publisher.i(this.f135430a);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.b(th2);
                                    this.f135434f.cancel();
                                    this.f135439k.a(th2);
                                    this.f135444n.onError(this.f135439k.b());
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.b(th3);
                            this.f135434f.cancel();
                            this.f135439k.a(th3);
                            this.f135444n.onError(this.f135439k.b());
                            return;
                        }
                    }
                    if (this.f135445o.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void b(Throwable th) {
            if (!this.f135439k.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135434f.cancel();
            if (getAndIncrement() == 0) {
                this.f135444n.onError(this.f135439k.b());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135438j) {
                return;
            }
            this.f135438j = true;
            this.f135430a.cancel();
            this.f135434f.cancel();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.ConcatMapSupport
        public void d(Object obj) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f135444n.h(obj);
                if (compareAndSet(1, 0)) {
                    return;
                }
                this.f135444n.onError(this.f135439k.b());
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableConcatMap.BaseConcatMapSubscriber
        void e() {
            this.f135444n.g(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135439k.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135430a.cancel();
            if (getAndIncrement() == 0) {
                this.f135444n.onError(this.f135439k.b());
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f135430a.y(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapInner<R> extends SubscriptionArbiter implements FlowableSubscriber<R> {
        private static final long serialVersionUID = 897683679971470653L;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final ConcatMapSupport f135446j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f135447k;

        ConcatMapInner(ConcatMapSupport concatMapSupport) {
            super(false);
            this.f135446j = concatMapSupport;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            j(subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135447k++;
            this.f135446j.d(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            long j3 = this.f135447k;
            if (j3 != 0) {
                this.f135447k = 0L;
                i(j3);
            }
            this.f135446j.c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            long j3 = this.f135447k;
            if (j3 != 0) {
                this.f135447k = 0L;
                i(j3);
            }
            this.f135446j.b(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ConcatMapSupport<T> {
        void b(Throwable th);

        void c();

        void d(Object obj);
    }

    public static Subscriber A(Subscriber subscriber, Function function, int i3, ErrorMode errorMode) {
        int i4 = AnonymousClass1.f135429a[errorMode.ordinal()];
        return i4 != 1 ? i4 != 2 ? new ConcatMapImmediate(subscriber, function, i3) : new ConcatMapDelayed(subscriber, function, i3, true) : new ConcatMapDelayed(subscriber, function, i3, false);
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (FlowableScalarXMap.a(this.f135196b, subscriber, this.f135426c)) {
            return;
        }
        this.f135196b.i(A(subscriber, this.f135426c, this.f135427d, this.f135428f));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeakScalarSubscription<T> implements Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f135449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f135450c;

        WeakScalarSubscription(Object obj, Subscriber subscriber) {
            this.f135449b = obj;
            this.f135448a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (j3 <= 0 || this.f135450c) {
                return;
            }
            this.f135450c = true;
            Subscriber subscriber = this.f135448a;
            subscriber.h(this.f135449b);
            subscriber.onComplete();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
        }
    }
}
