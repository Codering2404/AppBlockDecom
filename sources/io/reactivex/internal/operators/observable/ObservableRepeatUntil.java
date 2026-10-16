package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableRepeatUntil<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BooleanSupplier f138028b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RepeatUntilObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SequentialDisposable f138030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ObservableSource f138031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final BooleanSupplier f138032d;

        RepeatUntilObserver(Observer observer, BooleanSupplier booleanSupplier, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
            this.f138029a = observer;
            this.f138030b = sequentialDisposable;
            this.f138031c = observableSource;
            this.f138032d = booleanSupplier;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f138030b.a(disposable);
        }

        void b() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                do {
                    this.f138031c.b(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                } while (iAddAndGet != 0);
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138029a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            try {
                if (this.f138032d.a()) {
                    this.f138029a.onComplete();
                } else {
                    b();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138029a.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138029a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.a(sequentialDisposable);
        new RepeatUntilObserver(observer, this.f138028b, sequentialDisposable, this.f137267a).b();
    }
}
