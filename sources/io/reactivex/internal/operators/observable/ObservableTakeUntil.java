package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138284b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1418547743690811973L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f138286b = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final OtherObserver f138287c = new OtherObserver();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f138288d = new AtomicThrowable();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            OtherObserver() {
            }

            @Override // io.reactivex.Observer
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.Observer
            public void h(Object obj) {
                DisposableHelper.a(this);
                TakeUntilMainObserver.this.b();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                TakeUntilMainObserver.this.b();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                TakeUntilMainObserver.this.c(th);
            }
        }

        TakeUntilMainObserver(Observer observer) {
            this.f138285a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f138286b, disposable);
        }

        void b() {
            DisposableHelper.a(this.f138286b);
            HalfSerializer.a(this.f138285a, this, this.f138288d);
        }

        void c(Throwable th) {
            DisposableHelper.a(this.f138286b);
            HalfSerializer.c(this.f138285a, th, this, this.f138288d);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138286b);
            DisposableHelper.a(this.f138287c);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b((Disposable) this.f138286b.get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            HalfSerializer.e(this.f138285a, obj, this, this.f138288d);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this.f138287c);
            HalfSerializer.a(this.f138285a, this, this.f138288d);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.a(this.f138287c);
            HalfSerializer.c(this.f138285a, th, this, this.f138288d);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.a(takeUntilMainObserver);
        this.f138284b.b(takeUntilMainObserver.f138287c);
        this.f137267a.b(takeUntilMainObserver);
    }
}
