package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableZip<T, R> extends Observable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource[] f138531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable f138532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f138533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f138534d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f138535f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2983708048395377667L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138536a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138537b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ZipObserver[] f138538c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Object[] f138539d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f138540f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f138541g;

        ZipCoordinator(Observer observer, Function function, int i3, boolean z2) {
            this.f138536a = observer;
            this.f138537b = function;
            this.f138538c = new ZipObserver[i3];
            this.f138539d = new Object[i3];
            this.f138540f = z2;
        }

        void a() {
            d();
            b();
        }

        void b() {
            for (ZipObserver zipObserver : this.f138538c) {
                zipObserver.b();
            }
        }

        boolean c(boolean z2, boolean z3, Observer observer, boolean z4, ZipObserver zipObserver) {
            if (this.f138541g) {
                a();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (z4) {
                if (!z3) {
                    return false;
                }
                Throwable th = zipObserver.f138545d;
                a();
                if (th != null) {
                    observer.onError(th);
                } else {
                    observer.onComplete();
                }
                return true;
            }
            Throwable th2 = zipObserver.f138545d;
            if (th2 != null) {
                a();
                observer.onError(th2);
                return true;
            }
            if (!z3) {
                return false;
            }
            a();
            observer.onComplete();
            return true;
        }

        void d() {
            for (ZipObserver zipObserver : this.f138538c) {
                zipObserver.f138543b.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f138541g) {
                return;
            }
            this.f138541g = true;
            b();
            if (getAndIncrement() == 0) {
                d();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138541g;
        }

        public void f() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            ZipObserver[] zipObserverArr = this.f138538c;
            Observer observer = this.f138536a;
            Object[] objArr = this.f138539d;
            boolean z2 = this.f138540f;
            int iAddAndGet = 1;
            while (true) {
                int i3 = 0;
                int i4 = 0;
                for (ZipObserver zipObserver : zipObserverArr) {
                    if (objArr[i4] == null) {
                        boolean z3 = zipObserver.f138544c;
                        Object objPoll = zipObserver.f138543b.poll();
                        boolean z4 = objPoll == null;
                        if (c(z3, z4, observer, z2, zipObserver)) {
                            return;
                        }
                        if (z4) {
                            i3++;
                        } else {
                            objArr[i4] = objPoll;
                        }
                    } else if (zipObserver.f138544c && !z2 && (th = zipObserver.f138545d) != null) {
                        a();
                        observer.onError(th);
                        return;
                    }
                    i4++;
                }
                if (i3 != 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        observer.h(ObjectHelper.d(this.f138537b.apply(objArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        a();
                        observer.onError(th2);
                        return;
                    }
                }
            }
        }

        public void g(ObservableSource[] observableSourceArr, int i3) {
            ZipObserver[] zipObserverArr = this.f138538c;
            int length = zipObserverArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                zipObserverArr[i4] = new ZipObserver(this, i3);
            }
            lazySet(0);
            this.f138536a.a(this);
            for (int i5 = 0; i5 < length && !this.f138541g; i5++) {
                observableSourceArr[i5].b(zipObserverArr[i5]);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipObserver<T, R> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ZipCoordinator f138542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SpscLinkedArrayQueue f138543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f138544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Throwable f138545d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f138546f = new AtomicReference();

        ZipObserver(ZipCoordinator zipCoordinator, int i3) {
            this.f138542a = zipCoordinator;
            this.f138543b = new SpscLinkedArrayQueue(i3);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f138546f, disposable);
        }

        public void b() {
            DisposableHelper.a(this.f138546f);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138543b.offer(obj);
            this.f138542a.f();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138544c = true;
            this.f138542a.f();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138545d = th;
            this.f138544c = true;
            this.f138542a.f();
        }
    }

    public ObservableZip(ObservableSource[] observableSourceArr, Iterable iterable, Function function, int i3, boolean z2) {
        this.f138531a = observableSourceArr;
        this.f138532b = iterable;
        this.f138533c = function;
        this.f138534d = i3;
        this.f138535f = z2;
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        int length;
        ObservableSource[] observableSourceArr = this.f138531a;
        if (observableSourceArr == null) {
            observableSourceArr = new Observable[8];
            length = 0;
            for (ObservableSource observableSource : this.f138532b) {
                if (length == observableSourceArr.length) {
                    ObservableSource[] observableSourceArr2 = new ObservableSource[(length >> 2) + length];
                    System.arraycopy(observableSourceArr, 0, observableSourceArr2, 0, length);
                    observableSourceArr = observableSourceArr2;
                }
                observableSourceArr[length] = observableSource;
                length++;
            }
        } else {
            length = observableSourceArr.length;
        }
        if (length == 0) {
            EmptyDisposable.c(observer);
        } else {
            new ZipCoordinator(observer, this.f138533c, length, this.f138535f).g(observableSourceArr, this.f138534d);
        }
    }
}
