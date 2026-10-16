package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractFlowableWithUpstream<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable f135289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Publisher f135290d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Function f135291f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferBoundarySubscriber<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -8466418554264089604L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Callable f135293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Publisher f135294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Function f135295d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f135300j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f135302l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f135303m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        long f135305o;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final SpscLinkedArrayQueue f135301k = new SpscLinkedArrayQueue(Flowable.a());

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final CompositeDisposable f135296f = new CompositeDisposable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicLong f135297g = new AtomicLong();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference f135298h = new AtomicReference();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Map f135304n = new LinkedHashMap();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicThrowable f135299i = new AtomicThrowable();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class BufferOpenSubscriber<Open> extends AtomicReference<Subscription> implements FlowableSubscriber<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final BufferBoundarySubscriber f135306a;

            BufferOpenSubscriber(BufferBoundarySubscriber bufferBoundarySubscriber) {
                this.f135306a = bufferBoundarySubscriber;
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
                this.f135306a.d(obj);
            }

            @Override // org.reactivestreams.Subscriber
            public void onComplete() {
                lazySet(SubscriptionHelper.CANCELLED);
                this.f135306a.e(this);
            }

            @Override // org.reactivestreams.Subscriber
            public void onError(Throwable th) {
                lazySet(SubscriptionHelper.CANCELLED);
                this.f135306a.a(this, th);
            }
        }

        BufferBoundarySubscriber(Subscriber subscriber, Publisher publisher, Function function, Callable callable) {
            this.f135292a = subscriber;
            this.f135293b = callable;
            this.f135294c = publisher;
            this.f135295d = function;
        }

        void a(Disposable disposable, Throwable th) {
            SubscriptionHelper.a(this.f135298h);
            this.f135296f.c(disposable);
            onError(th);
        }

        void b(BufferCloseSubscriber bufferCloseSubscriber, long j3) {
            boolean z2;
            this.f135296f.c(bufferCloseSubscriber);
            if (this.f135296f.g() == 0) {
                SubscriptionHelper.a(this.f135298h);
                z2 = true;
            } else {
                z2 = false;
            }
            synchronized (this) {
                try {
                    Map map = this.f135304n;
                    if (map == null) {
                        return;
                    }
                    this.f135301k.offer(map.remove(Long.valueOf(j3)));
                    if (z2) {
                        this.f135300j = true;
                    }
                    c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            long j3 = this.f135305o;
            Subscriber subscriber = this.f135292a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f135301k;
            int iAddAndGet = 1;
            do {
                long j4 = this.f135297g.get();
                while (j3 != j4) {
                    if (this.f135302l) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z2 = this.f135300j;
                    if (z2 && this.f135299i.get() != null) {
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(this.f135299i.b());
                        return;
                    }
                    Collection collection = (Collection) spscLinkedArrayQueue.poll();
                    boolean z3 = collection == null;
                    if (z2 && z3) {
                        subscriber.onComplete();
                        return;
                    } else {
                        if (z3) {
                            break;
                        }
                        subscriber.h(collection);
                        j3++;
                    }
                }
                if (j3 == j4) {
                    if (this.f135302l) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    if (this.f135300j) {
                        if (this.f135299i.get() != null) {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(this.f135299i.b());
                            return;
                        } else if (spscLinkedArrayQueue.isEmpty()) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                this.f135305o = j3;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (SubscriptionHelper.a(this.f135298h)) {
                this.f135302l = true;
                this.f135296f.dispose();
                synchronized (this) {
                    this.f135304n = null;
                }
                if (getAndIncrement() != 0) {
                    this.f135301k.clear();
                }
            }
        }

        void d(Object obj) {
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f135293b.call(), "The bufferSupplier returned a null Collection");
                Publisher publisher = (Publisher) ObjectHelper.d(this.f135295d.apply(obj), "The bufferClose returned a null Publisher");
                long j3 = this.f135303m;
                this.f135303m = 1 + j3;
                synchronized (this) {
                    try {
                        Map map = this.f135304n;
                        if (map == null) {
                            return;
                        }
                        map.put(Long.valueOf(j3), collection);
                        BufferCloseSubscriber bufferCloseSubscriber = new BufferCloseSubscriber(this, j3);
                        this.f135296f.b(bufferCloseSubscriber);
                        publisher.i(bufferCloseSubscriber);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                SubscriptionHelper.a(this.f135298h);
                onError(th2);
            }
        }

        void e(BufferOpenSubscriber bufferOpenSubscriber) {
            this.f135296f.c(bufferOpenSubscriber);
            if (this.f135296f.g() == 0) {
                SubscriptionHelper.a(this.f135298h);
                this.f135300j = true;
                c();
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this.f135298h, subscription)) {
                BufferOpenSubscriber bufferOpenSubscriber = new BufferOpenSubscriber(this);
                this.f135296f.b(bufferOpenSubscriber);
                this.f135294c.i(bufferOpenSubscriber);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            synchronized (this) {
                try {
                    Map map = this.f135304n;
                    if (map == null) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        ((Collection) it.next()).add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135296f.dispose();
            synchronized (this) {
                try {
                    Map map = this.f135304n;
                    if (map == null) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        this.f135301k.offer((Collection) it.next());
                    }
                    this.f135304n = null;
                    this.f135300j = true;
                    c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135299i.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f135296f.dispose();
            synchronized (this) {
                this.f135304n = null;
            }
            this.f135300j = true;
            c();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            BackpressureHelper.a(this.f135297g, j3);
            c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferCloseSubscriber<T, C extends Collection<? super T>> extends AtomicReference<Subscription> implements FlowableSubscriber<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BufferBoundarySubscriber f135307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f135308b;

        BufferCloseSubscriber(BufferBoundarySubscriber bufferBoundarySubscriber, long j3) {
            this.f135307a = bufferBoundarySubscriber;
            this.f135308b = j3;
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
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                subscription.cancel();
                this.f135307a.b(this, this.f135308b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription != subscriptionHelper) {
                lazySet(subscriptionHelper);
                this.f135307a.b(this, this.f135308b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            Subscription subscription = get();
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (subscription == subscriptionHelper) {
                RxJavaPlugins.s(th);
            } else {
                lazySet(subscriptionHelper);
                this.f135307a.a(this, th);
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(subscriber, this.f135290d, this.f135291f, this.f135289c);
        subscriber.g(bufferBoundarySubscriber);
        this.f135196b.w(bufferBoundarySubscriber);
    }
}
