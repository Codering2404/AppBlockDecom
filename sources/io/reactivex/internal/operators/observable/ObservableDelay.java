package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f137565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f137566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f137567d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f137568f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DelayObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f137571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Scheduler.Worker f137572d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f137573f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137574g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.f137569a.onComplete();
                } finally {
                    DelayObserver.this.f137572d.dispose();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OnError implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Throwable f137576a;

            OnError(Throwable th) {
                this.f137576a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.f137569a.onError(this.f137576a);
                } finally {
                    DelayObserver.this.f137572d.dispose();
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OnNext implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object f137578a;

            OnNext(Object obj) {
                this.f137578a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelayObserver.this.f137569a.h(this.f137578a);
            }
        }

        DelayObserver(Observer observer, long j3, TimeUnit timeUnit, Scheduler.Worker worker, boolean z2) {
            this.f137569a = observer;
            this.f137570b = j3;
            this.f137571c = timeUnit;
            this.f137572d = worker;
            this.f137573f = z2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137574g, disposable)) {
                this.f137574g = disposable;
                this.f137569a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137574g.dispose();
            this.f137572d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137572d.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137572d.c(new OnNext(obj), this.f137570b, this.f137571c);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137572d.c(new OnComplete(), this.f137570b, this.f137571c);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137572d.c(new OnError(th), this.f137573f ? this.f137570b : 0L, this.f137571c);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new DelayObserver(this.f137568f ? observer : new SerializedObserver(observer), this.f137565b, this.f137566c, this.f137567d.b(), this.f137568f));
    }
}
