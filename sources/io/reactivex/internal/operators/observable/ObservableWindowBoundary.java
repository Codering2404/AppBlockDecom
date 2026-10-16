package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f138418c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainObserver f138419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f138420c;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver windowBoundaryMainObserver) {
            this.f138419b = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138420c) {
                return;
            }
            this.f138419b.f();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138420c) {
                return;
            }
            this.f138420c = true;
            this.f138419b.c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138420c) {
                RxJavaPlugins.s(th);
            } else {
                this.f138420c = true;
                this.f138419b.d(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final Object f138421l = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f138423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowBoundaryInnerObserver f138424c = new WindowBoundaryInnerObserver(this);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f138425d = new AtomicReference();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicInteger f138426f = new AtomicInteger(1);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final MpscLinkedQueue f138427g = new MpscLinkedQueue();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicThrowable f138428h = new AtomicThrowable();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicBoolean f138429i = new AtomicBoolean();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f138430j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        UnicastSubject f138431k;

        WindowBoundaryMainObserver(Observer observer, int i3) {
            this.f138422a = observer;
            this.f138423b = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this.f138425d, disposable)) {
                f();
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.f138422a;
            MpscLinkedQueue mpscLinkedQueue = this.f138427g;
            AtomicThrowable atomicThrowable = this.f138428h;
            int iAddAndGet = 1;
            while (this.f138426f.get() != 0) {
                UnicastSubject unicastSubject = this.f138431k;
                boolean z2 = this.f138430j;
                if (z2 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thB = atomicThrowable.b();
                    if (unicastSubject != null) {
                        this.f138431k = null;
                        unicastSubject.onError(thB);
                    }
                    observer.onError(thB);
                    return;
                }
                Object objPoll = mpscLinkedQueue.poll();
                boolean z3 = objPoll == null;
                if (z2 && z3) {
                    Throwable thB2 = atomicThrowable.b();
                    if (thB2 == null) {
                        if (unicastSubject != null) {
                            this.f138431k = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != null) {
                        this.f138431k = null;
                        unicastSubject.onError(thB2);
                    }
                    observer.onError(thB2);
                    return;
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != f138421l) {
                    unicastSubject.h(objPoll);
                } else {
                    if (unicastSubject != null) {
                        this.f138431k = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.f138429i.get()) {
                        UnicastSubject unicastSubjectD = UnicastSubject.D(this.f138423b, this);
                        this.f138431k = unicastSubjectD;
                        this.f138426f.getAndIncrement();
                        observer.h(unicastSubjectD);
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.f138431k = null;
        }

        void c() {
            DisposableHelper.a(this.f138425d);
            this.f138430j = true;
            b();
        }

        void d(Throwable th) {
            DisposableHelper.a(this.f138425d);
            if (!this.f138428h.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f138430j = true;
                b();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138429i.compareAndSet(false, true)) {
                this.f138424c.dispose();
                if (this.f138426f.decrementAndGet() == 0) {
                    DisposableHelper.a(this.f138425d);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138429i.get();
        }

        void f() {
            this.f138427g.offer(f138421l);
            b();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138427g.offer(obj);
            b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138424c.dispose();
            this.f138430j = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138424c.dispose();
            if (!this.f138428h.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f138430j = true;
                b();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f138426f.decrementAndGet() == 0) {
                DisposableHelper.a(this.f138425d);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.f138418c);
        observer.a(windowBoundaryMainObserver);
        this.f138417b.b(windowBoundaryMainObserver.f138424c);
        this.f137267a.b(windowBoundaryMainObserver);
    }
}
