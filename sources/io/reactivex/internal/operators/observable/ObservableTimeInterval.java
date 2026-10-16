package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTimeInterval<T> extends AbstractObservableWithUpstream<T, Timed<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f138326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f138327c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimeIntervalObserver<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TimeUnit f138329b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Scheduler f138330c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f138331d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f138332f;

        TimeIntervalObserver(Observer observer, TimeUnit timeUnit, Scheduler scheduler) {
            this.f138328a = observer;
            this.f138330c = scheduler;
            this.f138329b = timeUnit;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138332f, disposable)) {
                this.f138332f = disposable;
                this.f138331d = this.f138330c.c(this.f138329b);
                this.f138328a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138332f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138332f.e();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            long jC = this.f138330c.c(this.f138329b);
            long j3 = this.f138331d;
            this.f138331d = jC;
            this.f138328a.h(new Timed(obj, jC - j3, this.f138329b));
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138328a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138328a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        this.f137267a.b(new TimeIntervalObserver(observer, this.f138327c, this.f138326b));
    }
}
