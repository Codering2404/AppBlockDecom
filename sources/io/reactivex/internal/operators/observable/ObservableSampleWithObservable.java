package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSampleWithObservable<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f138114c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicInteger f138115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f138116g;

        SampleMainEmitLast(Observer observer, ObservableSource observableSource) {
            super(observer, observableSource);
            this.f138115f = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void c() {
            this.f138116g = true;
            if (this.f138115f.getAndIncrement() == 0) {
                f();
                this.f138117a.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void d() {
            this.f138116g = true;
            if (this.f138115f.getAndIncrement() == 0) {
                f();
                this.f138117a.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void i() {
            if (this.f138115f.getAndIncrement() == 0) {
                do {
                    boolean z2 = this.f138116g;
                    f();
                    if (z2) {
                        this.f138117a.onComplete();
                        return;
                    }
                } while (this.f138115f.decrementAndGet() != 0);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        SampleMainNoLast(Observer observer, ObservableSource observableSource) {
            super(observer, observableSource);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void c() {
            this.f138117a.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void d() {
            this.f138117a.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        void i() {
            f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ObservableSource f138118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f138119c = new AtomicReference();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f138120d;

        SampleMainObserver(Observer observer, ObservableSource observableSource) {
            this.f138117a = observer;
            this.f138118b = observableSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138120d, disposable)) {
                this.f138120d = disposable;
                this.f138117a.a(this);
                if (this.f138119c.get() == null) {
                    this.f138118b.b(new SamplerObserver(this));
                }
            }
        }

        public void b() {
            this.f138120d.dispose();
            d();
        }

        abstract void c();

        abstract void d();

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138119c);
            this.f138120d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138119c.get() == DisposableHelper.DISPOSED;
        }

        void f() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.f138117a.h(andSet);
            }
        }

        public void g(Throwable th) {
            this.f138120d.dispose();
            this.f138117a.onError(th);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            lazySet(obj);
        }

        abstract void i();

        boolean j(Disposable disposable) {
            return DisposableHelper.g(this.f138119c, disposable);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this.f138119c);
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f138119c);
            this.f138117a.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SamplerObserver<T> implements Observer<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SampleMainObserver f138121a;

        SamplerObserver(SampleMainObserver sampleMainObserver) {
            this.f138121a = sampleMainObserver;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f138121a.j(disposable);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138121a.i();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138121a.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138121a.g(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SerializedObserver serializedObserver = new SerializedObserver(observer);
        if (this.f138114c) {
            this.f137267a.b(new SampleMainEmitLast(serializedObserver, this.f138113b));
        } else {
            this.f137267a.b(new SampleMainNoLast(serializedObserver, this.f138113b));
        }
    }
}
