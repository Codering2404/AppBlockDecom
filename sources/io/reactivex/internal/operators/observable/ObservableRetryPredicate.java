package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableRetryPredicate<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f138085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f138086c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SequentialDisposable f138088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ObservableSource f138089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Predicate f138090d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f138091f;

        RepeatObserver(Observer observer, long j3, Predicate predicate, SequentialDisposable sequentialDisposable, ObservableSource observableSource) {
            this.f138087a = observer;
            this.f138088b = sequentialDisposable;
            this.f138089c = observableSource;
            this.f138090d = predicate;
            this.f138091f = j3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f138088b.a(disposable);
        }

        void b() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f138088b.e()) {
                    this.f138089c.b(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138087a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138087a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            long j3 = this.f138091f;
            if (j3 != Long.MAX_VALUE) {
                this.f138091f = j3 - 1;
            }
            if (j3 == 0) {
                this.f138087a.onError(th);
                return;
            }
            try {
                if (this.f138090d.test(th)) {
                    b();
                } else {
                    this.f138087a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f138087a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.a(sequentialDisposable);
        new RepeatObserver(observer, this.f138086c, this.f138085b, sequentialDisposable, this.f137267a).b();
    }
}
