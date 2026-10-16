package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableThrottleLatest<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f138311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f138312d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f138313f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ThrottleLatestObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f138316c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f138317d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f138318f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f138319g = new AtomicReference();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Disposable f138320h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f138321i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Throwable f138322j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f138323k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f138324l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f138325m;

        ThrottleLatestObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler.Worker worker, boolean z2) {
            this.f138314a = observer;
            this.f138315b = j3;
            this.f138316c = timeUnit;
            this.f138317d = worker;
            this.f138318f = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138320h, disposable)) {
                this.f138320h = disposable;
                this.f138314a.a(this);
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference atomicReference = this.f138319g;
            Observer observer = this.f138314a;
            int iAddAndGet = 1;
            while (!this.f138323k) {
                boolean z2 = this.f138321i;
                if (z2 && this.f138322j != null) {
                    atomicReference.lazySet(null);
                    observer.onError(this.f138322j);
                    this.f138317d.dispose();
                    return;
                }
                boolean z3 = atomicReference.get() == null;
                if (z2) {
                    Object andSet = atomicReference.getAndSet(null);
                    if (!z3 && this.f138318f) {
                        observer.h(andSet);
                    }
                    observer.onComplete();
                    this.f138317d.dispose();
                    return;
                }
                if (z3) {
                    if (this.f138324l) {
                        this.f138325m = false;
                        this.f138324l = false;
                    }
                } else if (!this.f138325m || this.f138324l) {
                    observer.h(atomicReference.getAndSet(null));
                    this.f138324l = false;
                    this.f138325m = true;
                    this.f138317d.c(this, this.f138315b, this.f138316c);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138323k = true;
            this.f138320h.dispose();
            this.f138317d.dispose();
            if (getAndIncrement() == 0) {
                this.f138319g.lazySet(null);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138323k;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138319g.set(obj);
            b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138321i = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138322j = th;
            this.f138321i = true;
            b();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f138324l = true;
            b();
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new ThrottleLatestObserver(observer, this.f138310b, this.f138311c, this.f138312d.b(), this.f138313f));
    }
}
