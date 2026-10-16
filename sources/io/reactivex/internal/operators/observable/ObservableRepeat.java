package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f138023b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SequentialDisposable f138025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ObservableSource f138026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f138027d;

        RepeatObserver(Observer observer, long j3, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
            this.f138024a = observer;
            this.f138025b = sequentialDisposable;
            this.f138026c = observableSource;
            this.f138027d = j3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f138025b.a(disposable);
        }

        void b() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f138025b.e()) {
                    this.f138026c.b(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138024a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            long j3 = this.f138027d;
            if (j3 != Long.MAX_VALUE) {
                this.f138027d = j3 - 1;
            }
            if (j3 != 0) {
                b();
            } else {
                this.f138024a.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138024a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.a(sequentialDisposable);
        long j3 = this.f138023b;
        new RepeatObserver(observer, j3 != Long.MAX_VALUE ? j3 - 1 : Long.MAX_VALUE, sequentialDisposable, this.f137267a).b();
    }
}
