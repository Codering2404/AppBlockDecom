package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableRetryBiPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BiPredicate f138079b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RetryBiObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SequentialDisposable f138081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ObservableSource f138082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final BiPredicate f138083d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f138084f;

        RetryBiObserver(Observer observer, BiPredicate biPredicate, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
            this.f138080a = observer;
            this.f138081b = sequentialDisposable;
            this.f138082c = observableSource;
            this.f138083d = biPredicate;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f138081b.a(disposable);
        }

        void b() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f138081b.e()) {
                    this.f138082c.b(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138080a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138080a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            try {
                BiPredicate biPredicate = this.f138083d;
                int i3 = this.f138084f + 1;
                this.f138084f = i3;
                if (biPredicate.test(Integer.valueOf(i3), th)) {
                    b();
                } else {
                    this.f138080a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f138080a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.a(sequentialDisposable);
        new RetryBiObserver(observer, this.f138079b, sequentialDisposable, this.f137267a).b();
    }
}
