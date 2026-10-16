package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFlatMapMaybe<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137704c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapMaybeObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f137706b;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Function f137710g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Disposable f137712i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137713j;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompositeDisposable f137707c = new CompositeDisposable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicThrowable f137709f = new AtomicThrowable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicInteger f137708d = new AtomicInteger(1);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference f137711h = new AtomicReference();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class InnerObserver extends AtomicReference<Disposable> implements MaybeObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean e() {
                return DisposableHelper.b(get());
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapMaybeObserver.this.g(this);
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.i(this, th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                FlatMapMaybeObserver.this.j(this, obj);
            }
        }

        FlatMapMaybeObserver(Observer observer, Function function, boolean z2) {
            this.f137705a = observer;
            this.f137710g = function;
            this.f137706b = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137712i, disposable)) {
                this.f137712i = disposable;
                this.f137705a.a(this);
            }
        }

        void b() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f137711h.get();
            if (spscLinkedArrayQueue != null) {
                spscLinkedArrayQueue.clear();
            }
        }

        void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        void d() {
            Observer observer = this.f137705a;
            AtomicInteger atomicInteger = this.f137708d;
            AtomicReference atomicReference = this.f137711h;
            int iAddAndGet = 1;
            while (!this.f137713j) {
                if (!this.f137706b && this.f137709f.get() != null) {
                    Throwable thB = this.f137709f.b();
                    b();
                    observer.onError(thB);
                    return;
                }
                boolean z2 = atomicInteger.get() == 0;
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                Object objPoll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : null;
                boolean z3 = objPoll == null;
                if (z2 && z3) {
                    Throwable thB2 = this.f137709f.b();
                    if (thB2 != null) {
                        observer.onError(thB2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    observer.h(objPoll);
                }
            }
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137713j = true;
            this.f137712i.dispose();
            this.f137707c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137713j;
        }

        SpscLinkedArrayQueue f() {
            SpscLinkedArrayQueue spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) this.f137711h.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.d());
            } while (!h.a(this.f137711h, null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        void g(InnerObserver innerObserver) {
            this.f137707c.c(innerObserver);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z2 = this.f137708d.decrementAndGet() == 0;
                    SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f137711h.get();
                    if (!z2 || (spscLinkedArrayQueue != null && !spscLinkedArrayQueue.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        d();
                        return;
                    } else {
                        Throwable thB = this.f137709f.b();
                        if (thB != null) {
                            this.f137705a.onError(thB);
                            return;
                        } else {
                            this.f137705a.onComplete();
                            return;
                        }
                    }
                }
            }
            this.f137708d.decrementAndGet();
            c();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.d(this.f137710g.apply(obj), "The mapper returned a null MaybeSource");
                this.f137708d.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f137713j || !this.f137707c.b(innerObserver)) {
                    return;
                }
                maybeSource.b(innerObserver);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137712i.dispose();
                onError(th);
            }
        }

        void i(InnerObserver innerObserver, Throwable th) {
            this.f137707c.c(innerObserver);
            if (!this.f137709f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137706b) {
                this.f137712i.dispose();
                this.f137707c.dispose();
            }
            this.f137708d.decrementAndGet();
            c();
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void j(io.reactivex.internal.operators.observable.ObservableFlatMapMaybe.FlatMapMaybeObserver.InnerObserver r3, java.lang.Object r4) {
            /*
                r2 = this;
                io.reactivex.disposables.CompositeDisposable r0 = r2.f137707c
                r0.c(r3)
                int r3 = r2.get()
                if (r3 != 0) goto L4e
                r3 = 0
                r0 = 1
                boolean r1 = r2.compareAndSet(r3, r0)
                if (r1 == 0) goto L4e
                io.reactivex.Observer r1 = r2.f137705a
                r1.h(r4)
                java.util.concurrent.atomic.AtomicInteger r4 = r2.f137708d
                int r4 = r4.decrementAndGet()
                if (r4 != 0) goto L21
                r3 = r0
            L21:
                java.util.concurrent.atomic.AtomicReference r4 = r2.f137711h
                java.lang.Object r4 = r4.get()
                io.reactivex.internal.queue.SpscLinkedArrayQueue r4 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r4
                if (r3 == 0) goto L47
                if (r4 == 0) goto L33
                boolean r3 = r4.isEmpty()
                if (r3 == 0) goto L47
            L33:
                io.reactivex.internal.util.AtomicThrowable r3 = r2.f137709f
                java.lang.Throwable r3 = r3.b()
                if (r3 == 0) goto L41
                io.reactivex.Observer r4 = r2.f137705a
                r4.onError(r3)
                return
            L41:
                io.reactivex.Observer r3 = r2.f137705a
                r3.onComplete()
                return
            L47:
                int r3 = r2.decrementAndGet()
                if (r3 != 0) goto L63
                goto L62
            L4e:
                io.reactivex.internal.queue.SpscLinkedArrayQueue r3 = r2.f()
                monitor-enter(r3)
                r3.offer(r4)     // Catch: java.lang.Throwable -> L67
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L67
                java.util.concurrent.atomic.AtomicInteger r3 = r2.f137708d
                r3.decrementAndGet()
                int r3 = r2.getAndIncrement()
                if (r3 == 0) goto L63
            L62:
                return
            L63:
                r2.d()
                return
            L67:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L67
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMapMaybe.FlatMapMaybeObserver.j(io.reactivex.internal.operators.observable.ObservableFlatMapMaybe$FlatMapMaybeObserver$InnerObserver, java.lang.Object):void");
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137708d.decrementAndGet();
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137708d.decrementAndGet();
            if (!this.f137709f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137706b) {
                this.f137707c.dispose();
            }
            c();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new FlatMapMaybeObserver(observer, this.f137703b, this.f137704c));
    }
}
