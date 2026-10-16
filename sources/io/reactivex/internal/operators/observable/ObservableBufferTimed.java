package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f137380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f137381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f137382d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Scheduler f137383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Callable f137384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f137385h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f137386i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Callable f137387h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final long f137388i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final TimeUnit f137389j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final int f137390k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final boolean f137391l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final Scheduler.Worker f137392m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Collection f137393n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Disposable f137394o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Disposable f137395p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        long f137396q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        long f137397r;

        BufferExactBoundedObserver(Observer observer, Callable callable, long j3, TimeUnit timeUnit, int i3, boolean z2, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f137387h = callable;
            this.f137388i = j3;
            this.f137389j = timeUnit;
            this.f137390k = i3;
            this.f137391l = z2;
            this.f137392m = worker;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137395p, disposable)) {
                this.f137395p = disposable;
                try {
                    this.f137393n = (Collection) ObjectHelper.d(this.f137387h.call(), "The buffer supplied is null");
                    this.f134997b.a(this);
                    Scheduler.Worker worker = this.f137392m;
                    long j3 = this.f137388i;
                    this.f137394o = worker.d(this, j3, j3, this.f137389j);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.dispose();
                    EmptyDisposable.i(th, this.f134997b);
                    this.f137392m.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f134999d) {
                return;
            }
            this.f134999d = true;
            this.f137395p.dispose();
            this.f137392m.dispose();
            synchronized (this) {
                this.f137393n = null;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f134999d;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:45:0x0078
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // io.reactivex.Observer
        public void h(java.lang.Object r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.util.Collection r0 = r7.f137393n     // Catch: java.lang.Throwable -> L73
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
                int r1 = r7.f137390k     // Catch: java.lang.Throwable -> L73
                if (r8 >= r1) goto L19
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L7
                return
            L19:
                r8 = 0
                r7.f137393n = r8     // Catch: java.lang.Throwable -> L73
                long r1 = r7.f137396q     // Catch: java.lang.Throwable -> L73
                r3 = 1
                long r1 = r1 + r3
                r7.f137396q = r1     // Catch: java.lang.Throwable -> L73
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L73
                boolean r8 = r7.f137391l
                if (r8 == 0) goto L2d
                io.reactivex.disposables.Disposable r8 = r7.f137394o
                r8.dispose()
            L2d:
                r8 = 0
                r7.k(r0, r8, r7)
                java.util.concurrent.Callable r8 = r7.f137387h     // Catch: java.lang.Throwable -> L64
                java.lang.Object r8 = r8.call()     // Catch: java.lang.Throwable -> L64
                java.lang.String r0 = "The buffer supplied is null"
                java.lang.Object r8 = io.reactivex.internal.functions.ObjectHelper.d(r8, r0)     // Catch: java.lang.Throwable -> L64
                java.util.Collection r8 = (java.util.Collection) r8     // Catch: java.lang.Throwable -> L64
                monitor-enter(r7)
                r7.f137393n = r8     // Catch: java.lang.Throwable -> L5d
                long r0 = r7.f137397r     // Catch: java.lang.Throwable -> L5d
                long r0 = r0 + r3
                r7.f137397r = r0     // Catch: java.lang.Throwable -> L5d
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L5d
                boolean r8 = r7.f137391l
                if (r8 == 0) goto L5b
                io.reactivex.Scheduler$Worker r0 = r7.f137392m
                long r2 = r7.f137388i
                java.util.concurrent.TimeUnit r6 = r7.f137389j
                r4 = r2
                r1 = r7
                io.reactivex.disposables.Disposable r8 = r0.d(r1, r2, r4, r6)
                r1.f137394o = r8
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
                io.reactivex.Observer r0 = r1.f134997b
                r0.onError(r8)
                r7.dispose()
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver.h(java.lang.Object):void");
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void f(Observer observer, Collection collection) {
            observer.h(collection);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Collection collection;
            this.f137392m.dispose();
            synchronized (this) {
                collection = this.f137393n;
                this.f137393n = null;
            }
            this.f134998c.offer(collection);
            this.f135000f = true;
            if (g()) {
                QueueDrainHelper.d(this.f134998c, this.f134997b, false, this, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.f137393n = null;
            }
            this.f134997b.onError(th);
            this.f137392m.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f137387h.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    Collection collection2 = this.f137393n;
                    if (collection2 != null && this.f137396q == this.f137397r) {
                        this.f137393n = collection;
                        k(collection2, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                this.f134997b.onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Callable f137398h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final long f137399i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final TimeUnit f137400j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final Scheduler f137401k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Disposable f137402l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Collection f137403m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final AtomicReference f137404n;

        BufferExactUnboundedObserver(Observer observer, Callable callable, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.f137404n = new AtomicReference();
            this.f137398h = callable;
            this.f137399i = j3;
            this.f137400j = timeUnit;
            this.f137401k = scheduler;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137402l, disposable)) {
                this.f137402l = disposable;
                try {
                    this.f137403m = (Collection) ObjectHelper.d(this.f137398h.call(), "The buffer supplied is null");
                    this.f134997b.a(this);
                    if (!this.f134999d) {
                        Scheduler scheduler = this.f137401k;
                        long j3 = this.f137399i;
                        Disposable disposableG = scheduler.g(this, j3, j3, this.f137400j);
                        if (h.a(this.f137404n, null, disposableG)) {
                            return;
                        }
                        disposableG.dispose();
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    dispose();
                    EmptyDisposable.i(th, this.f134997b);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f137404n);
            this.f137402l.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137404n.get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.f137403m;
                    if (collection == null) {
                        return;
                    }
                    collection.add(obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void f(Observer observer, Collection collection) {
            this.f134997b.h(collection);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Collection collection;
            synchronized (this) {
                collection = this.f137403m;
                this.f137403m = null;
            }
            if (collection != null) {
                this.f134998c.offer(collection);
                this.f135000f = true;
                if (g()) {
                    QueueDrainHelper.d(this.f134998c, this.f134997b, false, null, this);
                }
            }
            DisposableHelper.a(this.f137404n);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                this.f137403m = null;
            }
            this.f134997b.onError(th);
            DisposableHelper.a(this.f137404n);
        }

        @Override // java.lang.Runnable
        public void run() {
            Collection collection;
            try {
                Collection collection2 = (Collection) ObjectHelper.d(this.f137398h.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    try {
                        collection = this.f137403m;
                        if (collection != null) {
                            this.f137403m = collection2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (collection == null) {
                    DisposableHelper.a(this.f137404n);
                } else {
                    j(collection, false, this);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f134997b.onError(th2);
                dispose();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Callable f137405h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final long f137406i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final long f137407j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final TimeUnit f137408k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final Scheduler.Worker f137409l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final List f137410m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Disposable f137411n;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class RemoveFromBuffer implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Collection f137412a;

            RemoveFromBuffer(Collection collection) {
                this.f137412a = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f137410m.remove(this.f137412a);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.k(this.f137412a, false, bufferSkipBoundedObserver.f137409l);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class RemoveFromBufferEmit implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Collection f137414a;

            RemoveFromBufferEmit(Collection collection) {
                this.f137414a = collection;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.f137410m.remove(this.f137414a);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.k(this.f137414a, false, bufferSkipBoundedObserver.f137409l);
            }
        }

        BufferSkipBoundedObserver(Observer observer, Callable callable, long j3, long j4, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f137405h = callable;
            this.f137406i = j3;
            this.f137407j = j4;
            this.f137408k = timeUnit;
            this.f137409l = worker;
            this.f137410m = new LinkedList();
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137411n, disposable)) {
                this.f137411n = disposable;
                try {
                    Collection collection = (Collection) ObjectHelper.d(this.f137405h.call(), "The buffer supplied is null");
                    this.f137410m.add(collection);
                    this.f134997b.a(this);
                    Scheduler.Worker worker = this.f137409l;
                    long j3 = this.f137407j;
                    worker.d(this, j3, j3, this.f137408k);
                    this.f137409l.c(new RemoveFromBufferEmit(collection), this.f137406i, this.f137408k);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.dispose();
                    EmptyDisposable.i(th, this.f134997b);
                    this.f137409l.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f134999d) {
                return;
            }
            this.f134999d = true;
            o();
            this.f137411n.dispose();
            this.f137409l.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f134999d;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            synchronized (this) {
                try {
                    Iterator it = this.f137410m.iterator();
                    while (it.hasNext()) {
                        ((Collection) it.next()).add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void f(Observer observer, Collection collection) {
            observer.h(collection);
        }

        void o() {
            synchronized (this) {
                this.f137410m.clear();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f137410m);
                this.f137410m.clear();
            }
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                this.f134998c.offer((Collection) obj);
            }
            this.f135000f = true;
            if (g()) {
                QueueDrainHelper.d(this.f134998c, this.f134997b, false, this.f137409l, this);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f135000f = true;
            o();
            this.f134997b.onError(th);
            this.f137409l.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f134999d) {
                return;
            }
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f137405h.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    try {
                        if (this.f134999d) {
                            return;
                        }
                        this.f137410m.add(collection);
                        this.f137409l.c(new RemoveFromBuffer(collection), this.f137406i, this.f137408k);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f134997b.onError(th2);
                dispose();
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        if (this.f137380b == this.f137381c && this.f137385h == Integer.MAX_VALUE) {
            this.f137267a.b(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.f137384g, this.f137380b, this.f137382d, this.f137383f));
            return;
        }
        Scheduler.Worker workerB = this.f137383f.b();
        if (this.f137380b == this.f137381c) {
            this.f137267a.b(new BufferExactBoundedObserver(new SerializedObserver(observer), this.f137384g, this.f137380b, this.f137382d, this.f137385h, this.f137386i, workerB));
        } else {
            this.f137267a.b(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.f137384g, this.f137380b, this.f137381c, this.f137382d, workerB));
        }
    }
}
