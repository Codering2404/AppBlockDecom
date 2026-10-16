package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f138449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f138450c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainObserver f138451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f138452c;

        WindowBoundaryInnerObserver(WindowBoundaryMainObserver windowBoundaryMainObserver) {
            this.f138451b = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138452c) {
                return;
            }
            this.f138452c = true;
            dispose();
            this.f138451b.g(this);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138452c) {
                return;
            }
            this.f138452c = true;
            this.f138451b.d();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138452c) {
                RxJavaPlugins.s(th);
            } else {
                this.f138452c = true;
                this.f138451b.f(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        static final WindowBoundaryInnerObserver f138453m = new WindowBoundaryInnerObserver(null);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        static final Object f138454n = new Object();
        private static final long serialVersionUID = 2233020065421370272L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f138456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f138457c = new AtomicReference();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicInteger f138458d = new AtomicInteger(1);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final MpscLinkedQueue f138459f = new MpscLinkedQueue();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicThrowable f138460g = new AtomicThrowable();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicBoolean f138461h = new AtomicBoolean();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Callable f138462i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Disposable f138463j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f138464k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        UnicastSubject f138465l;

        WindowBoundaryMainObserver(Observer observer, int i3, Callable callable) {
            this.f138455a = observer;
            this.f138456b = i3;
            this.f138462i = callable;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138463j, disposable)) {
                this.f138463j = disposable;
                this.f138455a.a(this);
                this.f138459f.offer(f138454n);
                c();
            }
        }

        void b() {
            AtomicReference atomicReference = this.f138457c;
            WindowBoundaryInnerObserver windowBoundaryInnerObserver = f138453m;
            Disposable disposable = (Disposable) atomicReference.getAndSet(windowBoundaryInnerObserver);
            if (disposable == null || disposable == windowBoundaryInnerObserver) {
                return;
            }
            disposable.dispose();
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.f138455a;
            MpscLinkedQueue mpscLinkedQueue = this.f138459f;
            AtomicThrowable atomicThrowable = this.f138460g;
            int iAddAndGet = 1;
            while (this.f138458d.get() != 0) {
                UnicastSubject unicastSubject = this.f138465l;
                boolean z2 = this.f138464k;
                if (z2 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thB = atomicThrowable.b();
                    if (unicastSubject != null) {
                        this.f138465l = null;
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
                            this.f138465l = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != null) {
                        this.f138465l = null;
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
                } else if (objPoll != f138454n) {
                    unicastSubject.h(objPoll);
                } else {
                    if (unicastSubject != null) {
                        this.f138465l = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.f138461h.get()) {
                        UnicastSubject unicastSubjectD = UnicastSubject.D(this.f138456b, this);
                        this.f138465l = unicastSubjectD;
                        this.f138458d.getAndIncrement();
                        try {
                            ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f138462i.call(), "The other Callable returned a null ObservableSource");
                            WindowBoundaryInnerObserver windowBoundaryInnerObserver = new WindowBoundaryInnerObserver(this);
                            if (h.a(this.f138457c, null, windowBoundaryInnerObserver)) {
                                observableSource.b(windowBoundaryInnerObserver);
                                observer.h(unicastSubjectD);
                            }
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            atomicThrowable.a(th);
                            this.f138464k = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.f138465l = null;
        }

        void d() {
            this.f138463j.dispose();
            this.f138464k = true;
            c();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138461h.compareAndSet(false, true)) {
                b();
                if (this.f138458d.decrementAndGet() == 0) {
                    this.f138463j.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138461h.get();
        }

        void f(Throwable th) {
            this.f138463j.dispose();
            if (!this.f138460g.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f138464k = true;
                c();
            }
        }

        void g(WindowBoundaryInnerObserver windowBoundaryInnerObserver) {
            h.a(this.f138457c, windowBoundaryInnerObserver, null);
            this.f138459f.offer(f138454n);
            c();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138459f.offer(obj);
            c();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            b();
            this.f138464k = true;
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            b();
            if (!this.f138460g.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f138464k = true;
                c();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f138458d.decrementAndGet() == 0) {
                this.f138463j.dispose();
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new WindowBoundaryMainObserver(observer, this.f138450c, this.f138449b));
    }
}
