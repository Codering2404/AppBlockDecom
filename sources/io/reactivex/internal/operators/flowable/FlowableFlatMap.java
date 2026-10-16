package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFlatMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f135644d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f135645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f135646g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InnerSubscriber<T, U> extends AtomicReference<Subscription> implements FlowableSubscriber<U>, Disposable {
        private static final long serialVersionUID = -4606175640614850599L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f135647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MergeSubscriber f135648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135650d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f135651f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile SimpleQueue f135652g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f135653h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f135654i;

        InnerSubscriber(MergeSubscriber mergeSubscriber, long j3) {
            this.f135647a = j3;
            this.f135648b = mergeSubscriber;
            int i3 = mergeSubscriber.f135661f;
            this.f135650d = i3;
            this.f135649c = i3 >> 2;
        }

        void a(long j3) {
            if (this.f135654i != 1) {
                long j4 = this.f135653h + j3;
                if (j4 < this.f135649c) {
                    this.f135653h = j4;
                } else {
                    this.f135653h = 0L;
                    get().y(j4);
                }
            }
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
            if (SubscriptionHelper.f(this, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(7);
                    if (iL == 1) {
                        this.f135654i = iL;
                        this.f135652g = queueSubscription;
                        this.f135651f = true;
                        this.f135648b.e();
                        return;
                    }
                    if (iL == 2) {
                        this.f135654i = iL;
                        this.f135652g = queueSubscription;
                    }
                }
                subscription.y(this.f135650d);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135654i != 2) {
                this.f135648b.m(obj, this);
            } else {
                this.f135648b.e();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135651f = true;
            this.f135648b.e();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.f135648b.k(this, th);
        }
    }

    public static FlowableSubscriber A(Subscriber subscriber, Function function, boolean z2, int i3, int i4) {
        return new MergeSubscriber(subscriber, function, z2, i3, i4);
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (FlowableScalarXMap.a(this.f135196b, subscriber, this.f135643c)) {
            return;
        }
        this.f135196b.w(A(subscriber, this.f135643c, this.f135644d, this.f135645f, this.f135646g));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeSubscriber<T, U> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -2117620485640801370L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f135658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f135659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135660d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f135661f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile SimplePlainQueue f135662g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f135663h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicThrowable f135664i = new AtomicThrowable();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f135665j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicReference f135666k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final AtomicLong f135667l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Subscription f135668m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f135669n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        long f135670o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f135671p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f135672q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final int f135673r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        static final InnerSubscriber[] f135655s = new InnerSubscriber[0];

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        static final InnerSubscriber[] f135656t = new InnerSubscriber[0];

        MergeSubscriber(Subscriber subscriber, Function function, boolean z2, int i3, int i4) {
            AtomicReference atomicReference = new AtomicReference();
            this.f135666k = atomicReference;
            this.f135667l = new AtomicLong();
            this.f135657a = subscriber;
            this.f135658b = function;
            this.f135659c = z2;
            this.f135660d = i3;
            this.f135661f = i4;
            this.f135673r = Math.max(1, i3 >> 1);
            atomicReference.lazySet(f135655s);
        }

        boolean a(InnerSubscriber innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f135666k.get();
                if (innerSubscriberArr == f135656t) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!h.a(this.f135666k, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        boolean b() {
            if (this.f135665j) {
                c();
                return true;
            }
            if (this.f135659c || this.f135664i.get() == null) {
                return false;
            }
            c();
            Throwable thB = this.f135664i.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f135657a.onError(thB);
            }
            return true;
        }

        void c() {
            SimplePlainQueue simplePlainQueue = this.f135662g;
            if (simplePlainQueue != null) {
                simplePlainQueue.clear();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            SimplePlainQueue simplePlainQueue;
            if (this.f135665j) {
                return;
            }
            this.f135665j = true;
            this.f135668m.cancel();
            d();
            if (getAndIncrement() != 0 || (simplePlainQueue = this.f135662g) == null) {
                return;
            }
            simplePlainQueue.clear();
        }

        void d() {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.f135666k.get();
            InnerSubscriber[] innerSubscriberArr3 = f135656t;
            if (innerSubscriberArr2 == innerSubscriberArr3 || (innerSubscriberArr = (InnerSubscriber[]) this.f135666k.getAndSet(innerSubscriberArr3)) == innerSubscriberArr3) {
                return;
            }
            for (InnerSubscriber innerSubscriber : innerSubscriberArr) {
                innerSubscriber.dispose();
            }
            Throwable thB = this.f135664i.b();
            if (thB == null || thB == ExceptionHelper.f139204a) {
                return;
            }
            RxJavaPlugins.s(thB);
        }

        void e() {
            if (getAndIncrement() == 0) {
                f();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:155:0x018d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00db  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void f() {
            /*
                Method dump skipped, instruction units count: 441
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableFlatMap.MergeSubscriber.f():void");
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135668m, subscription)) {
                this.f135668m = subscription;
                this.f135657a.g(this);
                if (this.f135665j) {
                    return;
                }
                int i3 = this.f135660d;
                if (i3 == Integer.MAX_VALUE) {
                    subscription.y(Long.MAX_VALUE);
                } else {
                    subscription.y(i3);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135663h) {
                return;
            }
            try {
                Publisher publisher = (Publisher) ObjectHelper.d(this.f135658b.apply(obj), "The mapper returned a null Publisher");
                if (!(publisher instanceof Callable)) {
                    long j3 = this.f135669n;
                    this.f135669n = 1 + j3;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j3);
                    if (a(innerSubscriber)) {
                        publisher.i(innerSubscriber);
                        return;
                    }
                    return;
                }
                try {
                    Object objCall = ((Callable) publisher).call();
                    if (objCall != null) {
                        n(objCall);
                        return;
                    }
                    if (this.f135660d == Integer.MAX_VALUE || this.f135665j) {
                        return;
                    }
                    int i3 = this.f135672q + 1;
                    this.f135672q = i3;
                    int i4 = this.f135673r;
                    if (i3 == i4) {
                        this.f135672q = 0;
                        this.f135668m.y(i4);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f135664i.a(th);
                    e();
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f135668m.cancel();
                onError(th2);
            }
        }

        SimpleQueue i(InnerSubscriber innerSubscriber) {
            SimpleQueue simpleQueue = innerSubscriber.f135652g;
            if (simpleQueue != null) {
                return simpleQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f135661f);
            innerSubscriber.f135652g = spscArrayQueue;
            return spscArrayQueue;
        }

        SimpleQueue j() {
            SimplePlainQueue spscLinkedArrayQueue = this.f135662g;
            if (spscLinkedArrayQueue == null) {
                spscLinkedArrayQueue = this.f135660d == Integer.MAX_VALUE ? new SpscLinkedArrayQueue(this.f135661f) : new SpscArrayQueue(this.f135660d);
                this.f135662g = spscLinkedArrayQueue;
            }
            return spscLinkedArrayQueue;
        }

        void k(InnerSubscriber innerSubscriber, Throwable th) {
            if (!this.f135664i.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            innerSubscriber.f135651f = true;
            if (!this.f135659c) {
                this.f135668m.cancel();
                for (InnerSubscriber innerSubscriber2 : (InnerSubscriber[]) this.f135666k.getAndSet(f135656t)) {
                    innerSubscriber2.dispose();
                }
            }
            e();
        }

        void l(InnerSubscriber innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f135666k.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    } else if (innerSubscriberArr[i3] == innerSubscriber) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = f135655s;
                } else {
                    InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i3);
                    System.arraycopy(innerSubscriberArr, i3 + 1, innerSubscriberArr3, i3, (length - i3) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!h.a(this.f135666k, innerSubscriberArr, innerSubscriberArr2));
        }

        void m(Object obj, InnerSubscriber innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j3 = this.f135667l.get();
                SimpleQueue simpleQueueI = innerSubscriber.f135652g;
                if (j3 == 0 || !(simpleQueueI == null || simpleQueueI.isEmpty())) {
                    if (simpleQueueI == null) {
                        simpleQueueI = i(innerSubscriber);
                    }
                    if (!simpleQueueI.offer(obj)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.f135657a.h(obj);
                    if (j3 != Long.MAX_VALUE) {
                        this.f135667l.decrementAndGet();
                    }
                    innerSubscriber.a(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue spscArrayQueue = innerSubscriber.f135652g;
                if (spscArrayQueue == null) {
                    spscArrayQueue = new SpscArrayQueue(this.f135661f);
                    innerSubscriber.f135652g = spscArrayQueue;
                }
                if (!spscArrayQueue.offer(obj)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            f();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135663h) {
                return;
            }
            this.f135663h = true;
            e();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135663h) {
                RxJavaPlugins.s(th);
            } else if (!this.f135664i.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f135663h = true;
                e();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135667l, j3);
                e();
            }
        }

        void n(Object obj) {
            int i3 = get();
            String str = sKeKFMqmvNzY.zeMt;
            if (i3 == 0 && compareAndSet(0, 1)) {
                long j3 = this.f135667l.get();
                SimpleQueue simpleQueueJ = this.f135662g;
                if (j3 != 0 && (simpleQueueJ == null || simpleQueueJ.isEmpty())) {
                    this.f135657a.h(obj);
                    if (j3 != Long.MAX_VALUE) {
                        this.f135667l.decrementAndGet();
                    }
                    if (this.f135660d != Integer.MAX_VALUE && !this.f135665j) {
                        int i4 = this.f135672q + 1;
                        this.f135672q = i4;
                        int i5 = this.f135673r;
                        if (i4 == i5) {
                            this.f135672q = 0;
                            this.f135668m.y(i5);
                        }
                    }
                } else {
                    if (simpleQueueJ == null) {
                        simpleQueueJ = j();
                    }
                    if (!simpleQueueJ.offer(obj)) {
                        onError(new IllegalStateException(str));
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!j().offer(obj)) {
                onError(new IllegalStateException(str));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            f();
        }
    }
}
