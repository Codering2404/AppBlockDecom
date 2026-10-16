package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableBufferTimed<T, U extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f135326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f135327d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TimeUnit f135328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Scheduler f135329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Callable f135330h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f135331i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f135332j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferExactBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Callable f135333i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final long f135334j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final TimeUnit f135335k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final int f135336l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final boolean f135337m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final Scheduler.Worker f135338n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Collection f135339o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Disposable f135340p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Subscription f135341q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        long f135342r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        long f135343s;

        BufferExactBoundedSubscriber(Subscriber subscriber, Callable callable, long j3, TimeUnit timeUnit, int i3, boolean z2, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.f135333i = callable;
            this.f135334j = j3;
            this.f135335k = timeUnit;
            this.f135336l = i3;
            this.f135337m = z2;
            this.f135338n = worker;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f139155f) {
                return;
            }
            this.f139155f = true;
            dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            synchronized (this) {
                this.f135339o = null;
            }
            this.f135341q.cancel();
            this.f135338n.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135338n.e();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135341q, subscription)) {
                this.f135341q = subscription;
                try {
                    this.f135339o = (Collection) ObjectHelper.d(this.f135333i.call(), "The supplied buffer is null");
                    this.f139153c.g(this);
                    Scheduler.Worker worker = this.f135338n;
                    long j3 = this.f135334j;
                    this.f135340p = worker.d(this, j3, j3, this.f135335k);
                    subscription.y(Long.MAX_VALUE);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f135338n.dispose();
                    subscription.cancel();
                    EmptySubscription.b(th, this.f139153c);
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:45:0x0078
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // org.reactivestreams.Subscriber
        public void h(java.lang.Object r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.util.Collection r0 = r7.f135339o     // Catch: java.lang.Throwable -> L73
                if (r0 != 0) goto Lc
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L7
                return
            L7:
                r0 = move-exception
                r8 = r0
                r1 = r7
                goto L76
            Lc:
                r0.add(r8)     // Catch: java.lang.Throwable -> L73
                int r8 = r0.size()     // Catch: java.lang.Throwable -> L73
                int r1 = r7.f135336l     // Catch: java.lang.Throwable -> L73
                if (r8 >= r1) goto L19
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L7
                return
            L19:
                r8 = 0
                r7.f135339o = r8     // Catch: java.lang.Throwable -> L73
                long r1 = r7.f135342r     // Catch: java.lang.Throwable -> L73
                r3 = 1
                long r1 = r1 + r3
                r7.f135342r = r1     // Catch: java.lang.Throwable -> L73
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L73
                boolean r8 = r7.f135337m
                if (r8 == 0) goto L2d
                io.reactivex.disposables.Disposable r8 = r7.f135340p
                r8.dispose()
            L2d:
                r8 = 0
                r7.m(r0, r8, r7)
                java.util.concurrent.Callable r8 = r7.f135333i     // Catch: java.lang.Throwable -> L64
                java.lang.Object r8 = r8.call()     // Catch: java.lang.Throwable -> L64
                java.lang.String r0 = "The supplied buffer is null"
                java.lang.Object r8 = io.reactivex.internal.functions.ObjectHelper.d(r8, r0)     // Catch: java.lang.Throwable -> L64
                java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Throwable -> L64
                monitor-enter(r7)
                r7.f135339o = r8     // Catch: java.lang.Throwable -> L5d
                long r0 = r7.f135343s     // Catch: java.lang.Throwable -> L5d
                long r0 = r0 + r3
                r7.f135343s = r0     // Catch: java.lang.Throwable -> L5d
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L5d
                boolean r8 = r7.f135337m
                if (r8 == 0) goto L5b
                io.reactivex.Scheduler$Worker r0 = r7.f135338n
                long r2 = r7.f135334j
                java.util.concurrent.TimeUnit r6 = r7.f135335k
                r4 = r2
                r1 = r7
                io.reactivex.disposables.Disposable r8 = r0.d(r1, r2, r4, r6)
                r1.f135340p = r8
                return
            L5b:
                r1 = r7
                return
            L5d:
                r0 = move-exception
                r1 = r7
            L5f:
                r8 = r0
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L62
                throw r8
            L62:
                r0 = move-exception
                goto L5f
            L64:
                r0 = move-exception
                r1 = r7
                r8 = r0
                io.reactivex.exceptions.Exceptions.b(r8)
                r7.cancel()
                org.reactivestreams.Subscriber r0 = r1.f139153c
                r0.onError(r8)
                return
            L73:
                r0 = move-exception
                r1 = r7
            L75:
                r8 = r0
            L76:
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L78
                throw r8
            L78:
                r0 = move-exception
                goto L75
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferTimed.BufferExactBoundedSubscriber.h(java.lang.Object):void");
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            Collection collection;
            synchronized (this) {
                collection = this.f135339o;
                this.f135339o = null;
            }
            this.f139154d.offer(collection);
            this.f139156g = true;
            if (j()) {
                QueueDrainHelper.e(this.f139154d, this.f139153c, false, this, this);
            }
            this.f135338n.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            synchronized (this) {
                this.f135339o = null;
            }
            this.f139153c.onError(th);
            this.f135338n.dispose();
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public boolean f(Subscriber subscriber, Collection collection) {
            subscriber.h(collection);
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f135333i.call(), "The supplied buffer is null");
                synchronized (this) {
                    Collection collection2 = this.f135339o;
                    if (collection2 != null && this.f135342r == this.f135343s) {
                        this.f135339o = collection;
                        m(collection2, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                this.f139153c.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            n(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferExactUnboundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable, Disposable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Callable f135344i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final long f135345j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final TimeUnit f135346k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final Scheduler f135347l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Subscription f135348m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Collection f135349n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final AtomicReference f135350o;

        BufferExactUnboundedSubscriber(Subscriber subscriber, Callable callable, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            super(subscriber, new MpscLinkedQueue());
            this.f135350o = new AtomicReference();
            this.f135344i = callable;
            this.f135345j = j3;
            this.f135346k = timeUnit;
            this.f135347l = scheduler;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f139155f = true;
            this.f135348m.cancel();
            DisposableHelper.a(this.f135350o);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135350o.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135348m, subscription)) {
                this.f135348m = subscription;
                try {
                    this.f135349n = (Collection) ObjectHelper.d(this.f135344i.call(), "The supplied buffer is null");
                    this.f139153c.g(this);
                    if (!this.f139155f) {
                        subscription.y(Long.MAX_VALUE);
                        Scheduler scheduler = this.f135347l;
                        long j3 = this.f135345j;
                        Disposable disposableG = scheduler.g(this, j3, j3, this.f135346k);
                        if (h.a(this.f135350o, null, disposableG)) {
                            return;
                        }
                        disposableG.dispose();
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    EmptySubscription.b(th, this.f139153c);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.f135349n;
                    if (collection != null) {
                        collection.add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            DisposableHelper.a(this.f135350o);
            synchronized (this) {
                try {
                    Collection collection = this.f135349n;
                    if (collection == null) {
                        return;
                    }
                    this.f135349n = null;
                    this.f139154d.offer(collection);
                    this.f139156g = true;
                    if (j()) {
                        QueueDrainHelper.e(this.f139154d, this.f139153c, false, null, this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            DisposableHelper.a(this.f135350o);
            synchronized (this) {
                this.f135349n = null;
            }
            this.f139153c.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public boolean f(Subscriber subscriber, Collection collection) {
            this.f139153c.h(collection);
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f135344i.call(), "The supplied buffer is null");
                synchronized (this) {
                    try {
                        Collection collection2 = this.f135349n;
                        if (collection2 == null) {
                            return;
                        }
                        this.f135349n = collection;
                        l(collection2, false, this);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                cancel();
                this.f139153c.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            n(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferSkipBoundedSubscriber<T, U extends Collection<? super T>> extends QueueDrainSubscriber<T, U, U> implements Subscription, Runnable {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Callable f135351i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final long f135352j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final long f135353k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final TimeUnit f135354l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final Scheduler.Worker f135355m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final List f135356n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Subscription f135357o;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class RemoveFromBuffer implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Collection f135358a;

            RemoveFromBuffer(Collection collection) {
                this.f135358a = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedSubscriber.this) {
                    BufferSkipBoundedSubscriber.this.f135356n.remove(this.f135358a);
                }
                BufferSkipBoundedSubscriber bufferSkipBoundedSubscriber = BufferSkipBoundedSubscriber.this;
                bufferSkipBoundedSubscriber.m(this.f135358a, false, bufferSkipBoundedSubscriber.f135355m);
            }
        }

        BufferSkipBoundedSubscriber(Subscriber subscriber, Callable callable, long j3, long j4, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(subscriber, new MpscLinkedQueue());
            this.f135351i = callable;
            this.f135352j = j3;
            this.f135353k = j4;
            this.f135354l = timeUnit;
            this.f135355m = worker;
            this.f135356n = new LinkedList();
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f139155f = true;
            this.f135357o.cancel();
            this.f135355m.dispose();
            s();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135357o, subscription)) {
                this.f135357o = subscription;
                try {
                    Collection collection = (Collection) ObjectHelper.d(this.f135351i.call(), "The supplied buffer is null");
                    this.f135356n.add(collection);
                    this.f139153c.g(this);
                    subscription.y(Long.MAX_VALUE);
                    Scheduler.Worker worker = this.f135355m;
                    long j3 = this.f135353k;
                    worker.d(this, j3, j3, this.f135354l);
                    this.f135355m.c(new RemoveFromBuffer(collection), this.f135352j, this.f135354l);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f135355m.dispose();
                    subscription.cancel();
                    EmptySubscription.b(th, this.f139153c);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            synchronized (this) {
                try {
                    Iterator it = this.f135356n.iterator();
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
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f135356n);
                this.f135356n.clear();
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                this.f139154d.offer((Collection) obj);
            }
            this.f139156g = true;
            if (j()) {
                QueueDrainHelper.e(this.f139154d, this.f139153c, false, this.f135355m, this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f139156g = true;
            this.f135355m.dispose();
            s();
            this.f139153c.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.QueueDrainSubscriber, io.reactivex.internal.util.QueueDrain
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public boolean f(Subscriber subscriber, Collection collection) {
            subscriber.h(collection);
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f139155f) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f135351i.call(), "The supplied buffer is null");
                synchronized (this) {
                    try {
                        if (this.f139155f) {
                            return;
                        }
                        this.f135356n.add(collection);
                        this.f135355m.c(new RemoveFromBuffer(collection), this.f135352j, this.f135354l);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                cancel();
                this.f139153c.onError(th2);
            }
        }

        void s() {
            synchronized (this) {
                this.f135356n.clear();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            n(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (this.f135326c == this.f135327d && this.f135331i == Integer.MAX_VALUE) {
            this.f135196b.w(new BufferExactUnboundedSubscriber(new SerializedSubscriber(subscriber), this.f135330h, this.f135326c, this.f135328f, this.f135329g));
            return;
        }
        Scheduler.Worker workerB = this.f135329g.b();
        if (this.f135326c == this.f135327d) {
            this.f135196b.w(new BufferExactBoundedSubscriber(new SerializedSubscriber(subscriber), this.f135330h, this.f135326c, this.f135328f, this.f135331i, this.f135332j, workerB));
        } else {
            this.f135196b.w(new BufferSkipBoundedSubscriber(new SerializedSubscriber(subscriber), this.f135330h, this.f135326c, this.f135327d, this.f135328f, workerB));
        }
    }
}
