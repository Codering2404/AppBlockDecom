package io.reactivex.internal.operators.observable;

import androidx.compose.animation.core.h;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f137656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f137657d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f137658f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        private static final long serialVersionUID = -4606175640614850599L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f137659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MergeObserver f137660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f137661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile SimpleQueue f137662d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f137663f;

        InnerObserver(MergeObserver mergeObserver, long j3) {
            this.f137659a = j3;
            this.f137660b = mergeObserver;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int iL = queueDisposable.l(7);
                if (iL == 1) {
                    this.f137663f = iL;
                    this.f137662d = queueDisposable;
                    this.f137661c = true;
                    this.f137660b.f();
                    return;
                }
                if (iL == 2) {
                    this.f137663f = iL;
                    this.f137662d = queueDisposable;
                }
            }
        }

        public void b() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137663f == 0) {
                this.f137660b.k(obj, this);
            } else {
                this.f137660b.f();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137661c = true;
            this.f137660b.f();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137660b.f137673i.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            MergeObserver mergeObserver = this.f137660b;
            if (!mergeObserver.f137668c) {
                mergeObserver.d();
            }
            this.f137661c = true;
            this.f137660b.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        static final InnerObserver[] f137664r = new InnerObserver[0];

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        static final InnerObserver[] f137665s = new InnerObserver[0];
        private static final long serialVersionUID = -2117620485640801370L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f137668c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f137669d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f137670f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile SimplePlainQueue f137671g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f137672h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final AtomicThrowable f137673i = new AtomicThrowable();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137674j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicReference f137675k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Disposable f137676l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f137677m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f137678n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f137679o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Queue f137680p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        int f137681q;

        MergeObserver(Observer observer, Function function, boolean z2, int i3, int i4) {
            this.f137666a = observer;
            this.f137667b = function;
            this.f137668c = z2;
            this.f137669d = i3;
            this.f137670f = i4;
            if (i3 != Integer.MAX_VALUE) {
                this.f137680p = new ArrayDeque(i3);
            }
            this.f137675k = new AtomicReference(f137664r);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137676l, disposable)) {
                this.f137676l = disposable;
                this.f137666a.a(this);
            }
        }

        boolean b(InnerObserver innerObserver) {
            InnerObserver[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.f137675k.get();
                if (innerObserverArr == f137665s) {
                    innerObserver.b();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!h.a(this.f137675k, innerObserverArr, innerObserverArr2));
            return true;
        }

        boolean c() {
            if (this.f137674j) {
                return true;
            }
            Throwable th = this.f137673i.get();
            if (this.f137668c || th == null) {
                return false;
            }
            d();
            Throwable thB = this.f137673i.b();
            if (thB != ExceptionHelper.f139204a) {
                this.f137666a.onError(thB);
            }
            return true;
        }

        boolean d() {
            InnerObserver[] innerObserverArr;
            this.f137676l.dispose();
            InnerObserver[] innerObserverArr2 = (InnerObserver[]) this.f137675k.get();
            InnerObserver[] innerObserverArr3 = f137665s;
            if (innerObserverArr2 == innerObserverArr3 || (innerObserverArr = (InnerObserver[]) this.f137675k.getAndSet(innerObserverArr3)) == innerObserverArr3) {
                return false;
            }
            for (InnerObserver innerObserver : innerObserverArr) {
                innerObserver.b();
            }
            return true;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Throwable thB;
            if (this.f137674j) {
                return;
            }
            this.f137674j = true;
            if (!d() || (thB = this.f137673i.b()) == null || thB == ExceptionHelper.f139204a) {
                return;
            }
            RxJavaPlugins.s(thB);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137674j;
        }

        void f() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:128:0x0004, code lost:
        
            continue;
         */
        /* JADX WARN: Removed duplicated region for block: B:120:0x0132 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:133:0x00f9 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x00f2  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x00f8 A[PHI: r4
          0x00f8: PHI (r4v10 int) = (r4v8 int), (r4v11 int) binds: [B:71:0x00d7, B:83:0x00f6] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void g() {
            /*
                Method dump skipped, instruction units count: 307
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.g():void");
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137672h) {
                return;
            }
            try {
                ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137667b.apply(obj), "The mapper returned a null ObservableSource");
                if (this.f137669d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            int i3 = this.f137681q;
                            if (i3 == this.f137669d) {
                                this.f137680p.offer(observableSource);
                                return;
                            }
                            this.f137681q = i3 + 1;
                        } finally {
                        }
                    }
                }
                j(observableSource);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137676l.dispose();
                onError(th);
            }
        }

        void i(InnerObserver innerObserver) {
            InnerObserver[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = (InnerObserver[]) this.f137675k.get();
                int length = innerObserverArr.length;
                if (length == 0) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    } else if (innerObserverArr[i3] == innerObserver) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr2 = f137664r;
                } else {
                    InnerObserver[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr, 0, innerObserverArr3, 0, i3);
                    System.arraycopy(innerObserverArr, i3 + 1, innerObserverArr3, i3, (length - i3) - 1);
                    innerObserverArr2 = innerObserverArr3;
                }
            } while (!h.a(this.f137675k, innerObserverArr, innerObserverArr2));
        }

        void j(ObservableSource observableSource) {
            boolean z2;
            while (observableSource instanceof Callable) {
                if (!l((Callable) observableSource) || this.f137669d == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    try {
                        observableSource = (ObservableSource) this.f137680p.poll();
                        if (observableSource == null) {
                            z2 = true;
                            this.f137681q--;
                        } else {
                            z2 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z2) {
                    f();
                    return;
                }
            }
            long j3 = this.f137677m;
            this.f137677m = 1 + j3;
            InnerObserver innerObserver = new InnerObserver(this, j3);
            if (b(innerObserver)) {
                observableSource.b(innerObserver);
            }
        }

        void k(Object obj, InnerObserver innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f137666a.h(obj);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimpleQueue spscLinkedArrayQueue = innerObserver.f137662d;
                if (spscLinkedArrayQueue == null) {
                    spscLinkedArrayQueue = new SpscLinkedArrayQueue(this.f137670f);
                    innerObserver.f137662d = spscLinkedArrayQueue;
                }
                spscLinkedArrayQueue.offer(obj);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            g();
        }

        boolean l(Callable callable) {
            try {
                Object objCall = callable.call();
                if (objCall == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f137666a.h(objCall);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    SimplePlainQueue spscLinkedArrayQueue = this.f137671g;
                    if (spscLinkedArrayQueue == null) {
                        spscLinkedArrayQueue = this.f137669d == Integer.MAX_VALUE ? new SpscLinkedArrayQueue(this.f137670f) : new SpscArrayQueue(this.f137669d);
                        this.f137671g = spscLinkedArrayQueue;
                    }
                    if (!spscLinkedArrayQueue.offer(objCall)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                g();
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137673i.a(th);
                f();
                return true;
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137672h) {
                return;
            }
            this.f137672h = true;
            f();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137672h) {
                RxJavaPlugins.s(th);
            } else if (!this.f137673i.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f137672h = true;
                f();
            }
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        if (ObservableScalarXMap.a(this.f137267a, observer, this.f137655b)) {
            return;
        }
        this.f137267a.b(new MergeObserver(observer, this.f137655b, this.f137656c, this.f137657d, this.f137658f));
    }
}
