package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableAmb<T> extends Observable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource[] f137305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable f137306b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AmbCoordinator<T> implements Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AmbInnerObserver[] f137308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f137309c = new AtomicInteger();

        AmbCoordinator(Observer observer, int i3) {
            this.f137307a = observer;
            this.f137308b = new AmbInnerObserver[i3];
        }

        public void a(ObservableSource[] observableSourceArr) {
            AmbInnerObserver[] ambInnerObserverArr = this.f137308b;
            int length = ambInnerObserverArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                ambInnerObserverArr[i3] = new AmbInnerObserver(this, i4, this.f137307a);
                i3 = i4;
            }
            this.f137309c.lazySet(0);
            this.f137307a.a(this);
            for (int i5 = 0; i5 < length && this.f137309c.get() == 0; i5++) {
                observableSourceArr[i5].b(ambInnerObserverArr[i5]);
            }
        }

        public boolean b(int i3) {
            int i4 = this.f137309c.get();
            int i5 = 0;
            if (i4 != 0) {
                return i4 == i3;
            }
            if (!this.f137309c.compareAndSet(0, i3)) {
                return false;
            }
            AmbInnerObserver[] ambInnerObserverArr = this.f137308b;
            int length = ambInnerObserverArr.length;
            while (i5 < length) {
                int i6 = i5 + 1;
                if (i6 != i3) {
                    ambInnerObserverArr[i5].b();
                }
                i5 = i6;
            }
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f137309c.get() != -1) {
                this.f137309c.lazySet(-1);
                for (AmbInnerObserver ambInnerObserver : this.f137308b) {
                    ambInnerObserver.b();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137309c.get() == -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AmbInnerObserver<T> extends AtomicReference<Disposable> implements Observer<T> {
        private static final long serialVersionUID = -1185974347409665484L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AmbCoordinator f137310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f137311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Observer f137312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f137313d;

        AmbInnerObserver(AmbCoordinator ambCoordinator, int i3, Observer observer) {
            this.f137310a = ambCoordinator;
            this.f137311b = i3;
            this.f137312c = observer;
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
            if (this.f137313d) {
                this.f137312c.h(obj);
            } else if (!this.f137310a.b(this.f137311b)) {
                get().dispose();
            } else {
                this.f137313d = true;
                this.f137312c.h(obj);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137313d) {
                this.f137312c.onComplete();
            } else if (this.f137310a.b(this.f137311b)) {
                this.f137313d = true;
                this.f137312c.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137313d) {
                this.f137312c.onError(th);
            } else if (!this.f137310a.b(this.f137311b)) {
                RxJavaPlugins.s(th);
            } else {
                this.f137313d = true;
                this.f137312c.onError(th);
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        int length;
        ObservableSource[] observableSourceArr = this.f137305a;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            try {
                length = 0;
                for (ObservableSource observableSource : this.f137306b) {
                    if (observableSource == null) {
                        EmptyDisposable.i(new NullPointerException("One of the sources is null"), observer);
                        return;
                    }
                    if (length == observableSourceArr.length) {
                        ObservableSource[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                        System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                        observableSourceArr = observableSourceArr2;
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
            EmptyDisposable.c(observer);
        } else if (length == 1) {
            observableSourceArr[0].b(observer);
        } else {
            new AmbCoordinator(observer, length).a(observableSourceArr);
        }
    }
}
