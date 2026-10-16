package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f137549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f137550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f137551d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        private static final long serialVersionUID = 6812032969491025141L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f137552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final DebounceTimedObserver f137554c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f137555d = new AtomicBoolean();

        DebounceEmitter(Object obj, long j3, DebounceTimedObserver debounceTimedObserver) {
            this.f137552a = obj;
            this.f137553b = j3;
            this.f137554c = debounceTimedObserver;
        }

        public void a(Disposable disposable) {
            DisposableHelper.c(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f137555d.compareAndSet(false, true)) {
                this.f137554c.b(this.f137553b, this.f137552a, this);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f137558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f137559d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f137560f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137561g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile long f137562h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f137563i;

        DebounceTimedObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f137556a = observer;
            this.f137557b = j3;
            this.f137558c = timeUnit;
            this.f137559d = worker;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137560f, disposable)) {
                this.f137560f = disposable;
                this.f137556a.a(this);
            }
        }

        void b(long j3, Object obj, DebounceEmitter debounceEmitter) {
            if (j3 == this.f137562h) {
                this.f137556a.h(obj);
                debounceEmitter.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137560f.dispose();
            this.f137559d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137559d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137563i) {
                return;
            }
            long j3 = this.f137562h + 1;
            this.f137562h = j3;
            Disposable disposable = this.f137561g;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(obj, j3, this);
            this.f137561g = debounceEmitter;
            debounceEmitter.a(this.f137559d.c(debounceEmitter, this.f137557b, this.f137558c));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137563i) {
                return;
            }
            this.f137563i = true;
            Disposable disposable = this.f137561g;
            if (disposable != null) {
                disposable.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.f137556a.onComplete();
            this.f137559d.dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137563i) {
                RxJavaPlugins.s(th);
                return;
            }
            Disposable disposable = this.f137561g;
            if (disposable != null) {
                disposable.dispose();
            }
            this.f137563i = true;
            this.f137556a.onError(th);
            this.f137559d.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new DebounceTimedObserver(new SerializedObserver(observer), this.f137549b, this.f137550c, this.f137551d.b()));
    }
}
