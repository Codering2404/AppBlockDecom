package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableRetryWhen<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138092b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class RepeatWhenObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 802743776666017014L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138093a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Subject f138096d;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final ObservableSource f138099h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f138100i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicInteger f138094b = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicThrowable f138095c = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final InnerRepeatObserver f138097f = new InnerRepeatObserver();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f138098g = new AtomicReference();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class InnerRepeatObserver extends AtomicReference<Disposable> implements Observer<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            InnerRepeatObserver() {
            }

            @Override // io.reactivex.Observer
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.Observer
            public void h(Object obj) {
                RepeatWhenObserver.this.d();
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                RepeatWhenObserver.this.b();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                RepeatWhenObserver.this.c(th);
            }
        }

        RepeatWhenObserver(Observer observer, Subject subject, ObservableSource observableSource) {
            this.f138093a = observer;
            this.f138096d = subject;
            this.f138099h = observableSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.c(this.f138098g, disposable);
        }

        void b() {
            DisposableHelper.a(this.f138098g);
            HalfSerializer.a(this.f138093a, this, this.f138095c);
        }

        void c(Throwable th) {
            DisposableHelper.a(this.f138098g);
            HalfSerializer.c(this.f138093a, th, this, this.f138095c);
        }

        void d() {
            f();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138098g);
            DisposableHelper.a(this.f138097f);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b((Disposable) this.f138098g.get());
        }

        void f() {
            if (this.f138094b.getAndIncrement() == 0) {
                while (!e()) {
                    if (!this.f138100i) {
                        this.f138100i = true;
                        this.f138099h.b(this);
                    }
                    if (this.f138094b.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            HalfSerializer.e(this.f138093a, obj, this, this.f138095c);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.a(this.f138097f);
            HalfSerializer.a(this.f138093a, this, this.f138095c);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            DisposableHelper.c(this.f138098g, null);
            this.f138100i = false;
            this.f138096d.h(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        Subject subjectA = PublishSubject.C().A();
        try {
            ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f138092b.apply(subjectA), "The handler returned a null ObservableSource");
            RepeatWhenObserver repeatWhenObserver = new RepeatWhenObserver(observer, subjectA, this.f137267a);
            observer.a(repeatWhenObserver);
            observableSource.b(repeatWhenObserver.f138097f);
            repeatWhenObserver.f();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.i(th, observer);
        }
    }
}
