package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
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
public final class ObservableFlatMapSingle<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137716c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8600231336733376951L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f137718b;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Function f137722g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Disposable f137724i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137725j;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompositeDisposable f137719c = new CompositeDisposable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicThrowable f137721f = new AtomicThrowable();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicInteger f137720d = new AtomicInteger(1);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference f137723h = new AtomicReference();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class InnerObserver extends AtomicReference<Disposable> implements SingleObserver<R>, Disposable {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.SingleObserver
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

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                FlatMapSingleObserver.this.g(this, th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                FlatMapSingleObserver.this.i(this, obj);
            }
        }

        FlatMapSingleObserver(Observer observer, Function function, boolean z2) {
            this.f137717a = observer;
            this.f137722g = function;
            this.f137718b = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137724i, disposable)) {
                this.f137724i = disposable;
                this.f137717a.a(this);
            }
        }

        void b() {
            SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) this.f137723h.get();
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
            Observer observer = this.f137717a;
            AtomicInteger atomicInteger = this.f137720d;
            AtomicReference atomicReference = this.f137723h;
            int iAddAndGet = 1;
            while (!this.f137725j) {
                if (!this.f137718b && this.f137721f.get() != null) {
                    Throwable thB = this.f137721f.b();
                    b();
                    observer.onError(thB);
                    return;
                }
                boolean z2 = atomicInteger.get() == 0;
                SpscLinkedArrayQueue spscLinkedArrayQueue = (SpscLinkedArrayQueue) atomicReference.get();
                Object objPoll = spscLinkedArrayQueue != null ? spscLinkedArrayQueue.poll() : null;
                boolean z3 = objPoll == null;
                if (z2 && z3) {
                    Throwable thB2 = this.f137721f.b();
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
            this.f137725j = true;
            this.f137724i.dispose();
            this.f137719c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137725j;
        }

        SpscLinkedArrayQueue f() {
            SpscLinkedArrayQueue spscLinkedArrayQueue;
            do {
                SpscLinkedArrayQueue spscLinkedArrayQueue2 = (SpscLinkedArrayQueue) this.f137723h.get();
                if (spscLinkedArrayQueue2 != null) {
                    return spscLinkedArrayQueue2;
                }
                spscLinkedArrayQueue = new SpscLinkedArrayQueue(Observable.d());
            } while (!h.a(this.f137723h, null, spscLinkedArrayQueue));
            return spscLinkedArrayQueue;
        }

        void g(InnerObserver innerObserver, Throwable th) {
            this.f137719c.c(innerObserver);
            if (!this.f137721f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137718b) {
                this.f137724i.dispose();
                this.f137719c.dispose();
            }
            this.f137720d.decrementAndGet();
            c();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.d(this.f137722g.apply(obj), "The mapper returned a null SingleSource");
                this.f137720d.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.f137725j || !this.f137719c.b(innerObserver)) {
                    return;
                }
                singleSource.b(innerObserver);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137724i.dispose();
                onError(th);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void i(io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver.InnerObserver r3, java.lang.Object r4) {
            /*
                r2 = this;
                io.reactivex.disposables.CompositeDisposable r0 = r2.f137719c
                r0.c(r3)
                int r3 = r2.get()
                if (r3 != 0) goto L4e
                r3 = 0
                r0 = 1
                boolean r1 = r2.compareAndSet(r3, r0)
                if (r1 == 0) goto L4e
                io.reactivex.Observer r1 = r2.f137717a
                r1.h(r4)
                java.util.concurrent.atomic.AtomicInteger r4 = r2.f137720d
                int r4 = r4.decrementAndGet()
                if (r4 != 0) goto L21
                r3 = r0
            L21:
                java.util.concurrent.atomic.AtomicReference r4 = r2.f137723h
                java.lang.Object r4 = r4.get()
                io.reactivex.internal.queue.SpscLinkedArrayQueue r4 = (io.reactivex.internal.queue.SpscLinkedArrayQueue) r4
                if (r3 == 0) goto L47
                if (r4 == 0) goto L33
                boolean r3 = r4.isEmpty()
                if (r3 == 0) goto L47
            L33:
                io.reactivex.internal.util.AtomicThrowable r3 = r2.f137721f
                java.lang.Throwable r3 = r3.b()
                if (r3 == 0) goto L41
                io.reactivex.Observer r4 = r2.f137717a
                r4.onError(r3)
                return
            L41:
                io.reactivex.Observer r3 = r2.f137717a
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
                java.util.concurrent.atomic.AtomicInteger r3 = r2.f137720d
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver.i(io.reactivex.internal.operators.observable.ObservableFlatMapSingle$FlatMapSingleObserver$InnerObserver, java.lang.Object):void");
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137720d.decrementAndGet();
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137720d.decrementAndGet();
            if (!this.f137721f.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (!this.f137718b) {
                this.f137719c.dispose();
            }
            c();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new FlatMapSingleObserver(observer, this.f137715b, this.f137716c));
    }
}
