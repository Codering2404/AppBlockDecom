package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDelay<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f138751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Scheduler f138752d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f138753f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class Delay implements SingleObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SequentialDisposable f138754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SingleObserver f138755b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OnError implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Throwable f138757a;

            OnError(Throwable th) {
                this.f138757a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f138755b.onError(this.f138757a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OnSuccess implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object f138759a;

            OnSuccess(Object obj) {
                this.f138759a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                Delay.this.f138755b.onSuccess(this.f138759a);
            }
        }

        Delay(SequentialDisposable sequentialDisposable, SingleObserver singleObserver) {
            this.f138754a = sequentialDisposable;
            this.f138755b = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            this.f138754a.a(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            SequentialDisposable sequentialDisposable = this.f138754a;
            Scheduler scheduler = SingleDelay.this.f138752d;
            OnError onError = new OnError(th);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.a(scheduler.f(onError, singleDelay.f138753f ? singleDelay.f138750b : 0L, singleDelay.f138751c));
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            SequentialDisposable sequentialDisposable = this.f138754a;
            Scheduler scheduler = SingleDelay.this.f138752d;
            OnSuccess onSuccess = new OnSuccess(obj);
            SingleDelay singleDelay = SingleDelay.this;
            sequentialDisposable.a(scheduler.f(onSuccess, singleDelay.f138750b, singleDelay.f138751c));
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        singleObserver.a(sequentialDisposable);
        this.f138749a.b(new Delay(sequentialDisposable, singleObserver));
    }
}
