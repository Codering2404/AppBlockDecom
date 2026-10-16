package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableThrottleFirstTimed<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f138301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f138302d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 786994795061867455L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f138304b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f138305c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f138306d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f138307f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f138308g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f138309h;

        DebounceTimedObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.f138303a = observer;
            this.f138304b = j3;
            this.f138305c = timeUnit;
            this.f138306d = worker;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138307f, disposable)) {
                this.f138307f = disposable;
                this.f138303a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138307f.dispose();
            this.f138306d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138306d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138308g || this.f138309h) {
                return;
            }
            this.f138308g = true;
            this.f138303a.h(obj);
            Disposable disposable = get();
            if (disposable != null) {
                disposable.dispose();
            }
            DisposableHelper.c(this, this.f138306d.c(this, this.f138304b, this.f138305c));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138309h) {
                return;
            }
            this.f138309h = true;
            this.f138303a.onComplete();
            this.f138306d.dispose();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138309h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138309h = true;
            this.f138303a.onError(th);
            this.f138306d.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f138308g = false;
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new DebounceTimedObserver(new SerializedObserver(observer), this.f138300b, this.f138301c, this.f138302d.b()));
    }
}
