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
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource[] f138517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Iterable f138518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f138519d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            return ObjectHelper.d(ObservableWithLatestFromMany.this.f138519d.apply(new Object[]{obj}), "The combiner returned a null value");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 1577321883966341961L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WithLatestInnerObserver[] f138523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReferenceArray f138524d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f138525f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicThrowable f138526g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f138527h;

        WithLatestFromObserver(Observer observer, Function function, int i3) {
            this.f138521a = observer;
            this.f138522b = function;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                withLatestInnerObserverArr[i4] = new WithLatestInnerObserver(this, i4);
            }
            this.f138523c = withLatestInnerObserverArr;
            this.f138524d = new AtomicReferenceArray(i3);
            this.f138525f = new AtomicReference();
            this.f138526g = new AtomicThrowable();
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f138525f, disposable);
        }

        void b(int i3) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f138523c;
            for (int i4 = 0; i4 < withLatestInnerObserverArr.length; i4++) {
                if (i4 != i3) {
                    withLatestInnerObserverArr[i4].b();
                }
            }
        }

        void c(int i3, boolean z2) {
            if (z2) {
                return;
            }
            this.f138527h = true;
            b(i3);
            HalfSerializer.a(this.f138521a, this, this.f138526g);
        }

        void d(int i3, Throwable th) {
            this.f138527h = true;
            DisposableHelper.a(this.f138525f);
            b(i3);
            HalfSerializer.c(this.f138521a, th, this, this.f138526g);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138525f);
            for (WithLatestInnerObserver withLatestInnerObserver : this.f138523c) {
                withLatestInnerObserver.b();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b((Disposable) this.f138525f.get());
        }

        void f(int i3, Object obj) {
            this.f138524d.set(i3, obj);
        }

        void g(ObservableSource[] observableSourceArr, int i3) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.f138523c;
            AtomicReference atomicReference = this.f138525f;
            for (int i4 = 0; i4 < i3 && !DisposableHelper.b((Disposable) atomicReference.get()) && !this.f138527h; i4++) {
                observableSourceArr[i4].b(withLatestInnerObserverArr[i4]);
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f138527h) {
                return;
            }
            AtomicReferenceArray atomicReferenceArray = this.f138524d;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i3 = 0;
            objArr[0] = obj;
            while (i3 < length) {
                Object obj2 = atomicReferenceArray.get(i3);
                if (obj2 == null) {
                    return;
                }
                i3++;
                objArr[i3] = obj2;
            }
            try {
                HalfSerializer.e(this.f138521a, ObjectHelper.d(this.f138522b.apply(objArr), "combiner returned a null value"), this, this.f138526g);
            } catch (Throwable th) {
                Exceptions.b(th);
                dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138527h) {
                return;
            }
            this.f138527h = true;
            b(-1);
            HalfSerializer.a(this.f138521a, this, this.f138526g);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138527h) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138527h = true;
            b(-1);
            HalfSerializer.c(this.f138521a, th, this, this.f138526g);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WithLatestInnerObserver extends AtomicReference<Disposable> implements Observer<Object> {
        private static final long serialVersionUID = 3256684027868224024L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WithLatestFromObserver f138528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f138529b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f138530c;

        WithLatestInnerObserver(WithLatestFromObserver withLatestFromObserver, int i3) {
            this.f138528a = withLatestFromObserver;
            this.f138529b = i3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        public void b() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (!this.f138530c) {
                this.f138530c = true;
            }
            this.f138528a.f(this.f138529b, obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138528a.c(this.f138529b, this.f138530c);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138528a.d(this.f138529b, th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        int length;
        ObservableSource[] observableSourceArr = this.f138517b;
        if (observableSourceArr == null) {
            observableSourceArr = new ObservableSource[8];
            try {
                length = 0;
                for (ObservableSource observableSource : this.f138518c) {
                    if (length == observableSourceArr.length) {
                        observableSourceArr = (ObservableSource[]) Arrays.copyOf(observableSourceArr, (length >> 1) + length);
                    }
                    int i3 = length + 1;
                    observableSourceArr[length] = observableSource;
                    length = i3;
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.i(th, observer);
                return;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            new ObservableMap(this.f137267a, new SingletonArrayFunc()).u(observer);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(observer, this.f138519d, length);
        observer.a(withLatestFromObserver);
        withLatestFromObserver.g(observableSourceArr, length);
        this.f137267a.b(withLatestFromObserver);
    }
}
