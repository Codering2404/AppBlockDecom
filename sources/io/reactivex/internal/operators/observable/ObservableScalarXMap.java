package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableScalarXMap {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ScalarDisposable<T> extends AtomicInteger implements QueueDisposable<T>, Runnable {
        private static final long serialVersionUID = 3880992722410194083L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f138123b;

        public ScalarDisposable(Observer observer, Object obj) {
            this.f138122a = observer;
            this.f138123b = obj;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == 3;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            if ((i3 & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean offer(Object obj) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.f138123b;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.f138122a.h(this.f138123b);
                if (get() == 2) {
                    lazySet(3);
                    this.f138122a.onComplete();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScalarXMapObservable<T, R> extends Observable<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f138124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138125b;

        @Override // io.reactivex.Observable
        public void u(Observer observer) {
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f138125b.apply(this.f138124a), "The mapper returned a null ObservableSource");
                if (!(observableSource instanceof Callable)) {
                    observableSource.b(observer);
                    return;
                }
                try {
                    Object objCall = ((Callable) observableSource).call();
                    if (objCall == null) {
                        EmptyDisposable.c(observer);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(observer, objCall);
                    observer.a(scalarDisposable);
                    scalarDisposable.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    EmptyDisposable.i(th, observer);
                }
            } catch (Throwable th2) {
                EmptyDisposable.i(th2, observer);
            }
        }
    }

    public static boolean a(ObservableSource observableSource, Observer observer, Function function) {
        if (!(observableSource instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) observableSource).call();
            if (objCall == null) {
                EmptyDisposable.c(observer);
                return true;
            }
            try {
                ObservableSource observableSource2 = (ObservableSource) ObjectHelper.d(function.apply(objCall), "The mapper returned a null ObservableSource");
                if (observableSource2 instanceof Callable) {
                    try {
                        Object objCall2 = ((Callable) observableSource2).call();
                        if (objCall2 == null) {
                            EmptyDisposable.c(observer);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(observer, objCall2);
                        observer.a(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        EmptyDisposable.i(th, observer);
                        return true;
                    }
                } else {
                    observableSource2.b(observer);
                }
                return true;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                EmptyDisposable.i(th2, observer);
                return true;
            }
        } catch (Throwable th3) {
            Exceptions.b(th3);
            EmptyDisposable.i(th3, observer);
            return true;
        }
    }
}
