package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSampleTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f138103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f138104d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f138105f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicInteger f138106h;

        SampleTimedEmitLast(Observer observer, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j3, timeUnit, scheduler);
            this.f138106h = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void c() {
            d();
            if (this.f138106h.decrementAndGet() == 0) {
                this.f138107a.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f138106h.incrementAndGet() == 2) {
                d();
                if (this.f138106h.decrementAndGet() == 0) {
                    this.f138107a.onComplete();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(Observer observer, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, j3, timeUnit, scheduler);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        void c() {
            this.f138107a.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f138109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler f138110d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f138111f = new AtomicReference();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f138112g;

        SampleTimedObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler scheduler) {
            this.f138107a = observer;
            this.f138108b = j3;
            this.f138109c = timeUnit;
            this.f138110d = scheduler;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138112g, disposable)) {
                this.f138112g = disposable;
                this.f138107a.a(this);
                Scheduler scheduler = this.f138110d;
                long j3 = this.f138108b;
                DisposableHelper.c(this.f138111f, scheduler.g(this, j3, j3, this.f138109c));
            }
        }

        void b() {
            DisposableHelper.a(this.f138111f);
        }

        abstract void c();

        void d() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.f138107a.h(andSet);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            b();
            this.f138112g.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138112g.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            lazySet(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            b();
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            b();
            this.f138107a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f138105f) {
            this.f137267a.b(new SampleTimedEmitLast(serializedObserver, this.f138102b, this.f138103c, this.f138104d));
        } else {
            this.f137267a.b(new SampleTimedNoLast(serializedObserver, this.f138102b, this.f138103c, this.f138104d));
        }
    }
}
