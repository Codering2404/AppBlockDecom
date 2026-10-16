package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f137469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ErrorMode f137470d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -6951100001833242599L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f137473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f137474d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final DelayErrorInnerObserver f137475f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f137476g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        SimpleQueue f137477h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Disposable f137478i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137479j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f137480k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f137481l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f137482m;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long serialVersionUID = 2620149119579502636L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Observer f137483a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final ConcatMapDelayErrorObserver f137484b;

            DelayErrorInnerObserver(Observer observer, ConcatMapDelayErrorObserver concatMapDelayErrorObserver) {
                this.f137483a = observer;
                this.f137484b = concatMapDelayErrorObserver;
            }

            @Override // io.reactivex.Observer
            public void a(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.Observer
            public void h(Object obj) {
                this.f137483a.h(obj);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                ConcatMapDelayErrorObserver concatMapDelayErrorObserver = this.f137484b;
                concatMapDelayErrorObserver.f137479j = false;
                concatMapDelayErrorObserver.b();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver concatMapDelayErrorObserver = this.f137484b;
                if (!concatMapDelayErrorObserver.f137474d.a(th)) {
                    RxJavaPlugins.s(th);
                    return;
                }
                if (!concatMapDelayErrorObserver.f137476g) {
                    concatMapDelayErrorObserver.f137478i.dispose();
                }
                concatMapDelayErrorObserver.f137479j = false;
                concatMapDelayErrorObserver.b();
            }
        }

        ConcatMapDelayErrorObserver(Observer observer, Function function, int i3, boolean z2) {
            this.f137471a = observer;
            this.f137472b = function;
            this.f137473c = i3;
            this.f137476g = z2;
            this.f137475f = new DelayErrorInnerObserver(observer, this);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137478i, disposable)) {
                this.f137478i = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int iL = queueDisposable.l(3);
                    if (iL == 1) {
                        this.f137482m = iL;
                        this.f137477h = queueDisposable;
                        this.f137480k = true;
                        this.f137471a.a(this);
                        b();
                        return;
                    }
                    if (iL == 2) {
                        this.f137482m = iL;
                        this.f137477h = queueDisposable;
                        this.f137471a.a(this);
                        return;
                    }
                }
                this.f137477h = new SpscLinkedArrayQueue(this.f137473c);
                this.f137471a.a(this);
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.f137471a;
            SimpleQueue simpleQueue = this.f137477h;
            AtomicThrowable atomicThrowable = this.f137474d;
            while (true) {
                if (!this.f137479j) {
                    if (this.f137481l) {
                        simpleQueue.clear();
                        return;
                    }
                    if (!this.f137476g && atomicThrowable.get() != null) {
                        simpleQueue.clear();
                        this.f137481l = true;
                        observer.onError(atomicThrowable.b());
                        return;
                    }
                    boolean z2 = this.f137480k;
                    try {
                        Object objPoll = simpleQueue.poll();
                        boolean z3 = objPoll == null;
                        if (z2 && z3) {
                            this.f137481l = true;
                            Throwable thB = atomicThrowable.b();
                            if (thB != null) {
                                observer.onError(thB);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                        if (!z3) {
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137472b.apply(objPoll), "The mapper returned a null ObservableSource");
                                if (observableSource instanceof Callable) {
                                    try {
                                        Object objCall = ((Callable) observableSource).call();
                                        if (objCall != null && !this.f137481l) {
                                            observer.h(objCall);
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.b(th);
                                        atomicThrowable.a(th);
                                    }
                                } else {
                                    this.f137479j = true;
                                    observableSource.b(this.f137475f);
                                }
                            } catch (Throwable th2) {
                                Exceptions.b(th2);
                                this.f137481l = true;
                                this.f137478i.dispose();
                                simpleQueue.clear();
                                atomicThrowable.a(th2);
                                observer.onError(atomicThrowable.b());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        Exceptions.b(th3);
                        this.f137481l = true;
                        this.f137478i.dispose();
                        atomicThrowable.a(th3);
                        observer.onError(atomicThrowable.b());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137481l = true;
            this.f137478i.dispose();
            this.f137475f.b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137481l;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137482m == 0) {
                this.f137477h.offer(obj);
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137480k = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137474d.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f137480k = true;
                b();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8828587559905699186L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final InnerObserver f137487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f137488d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SimpleQueue f137489f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Disposable f137490g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f137491h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137492i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f137493j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f137494k;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long serialVersionUID = -7449079488798789337L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Observer f137495a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final SourceObserver f137496b;

            InnerObserver(Observer observer, SourceObserver sourceObserver) {
                this.f137495a = observer;
                this.f137496b = sourceObserver;
            }

            @Override // io.reactivex.Observer
            public void a(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            void b() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.Observer
            public void h(Object obj) {
                this.f137495a.h(obj);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                this.f137496b.c();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                this.f137496b.dispose();
                this.f137495a.onError(th);
            }
        }

        SourceObserver(Observer observer, Function function, int i3) {
            this.f137485a = observer;
            this.f137486b = function;
            this.f137488d = i3;
            this.f137487c = new InnerObserver(observer, this);
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137490g, disposable)) {
                this.f137490g = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int iL = queueDisposable.l(3);
                    if (iL == 1) {
                        this.f137494k = iL;
                        this.f137489f = queueDisposable;
                        this.f137493j = true;
                        this.f137485a.a(this);
                        b();
                        return;
                    }
                    if (iL == 2) {
                        this.f137494k = iL;
                        this.f137489f = queueDisposable;
                        this.f137485a.a(this);
                        return;
                    }
                }
                this.f137489f = new SpscLinkedArrayQueue(this.f137488d);
                this.f137485a.a(this);
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.f137492i) {
                if (!this.f137491h) {
                    boolean z2 = this.f137493j;
                    try {
                        Object objPoll = this.f137489f.poll();
                        boolean z3 = objPoll == null;
                        if (z2 && z3) {
                            this.f137492i = true;
                            this.f137485a.onComplete();
                            return;
                        } else if (!z3) {
                            try {
                                ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137486b.apply(objPoll), "The mapper returned a null ObservableSource");
                                this.f137491h = true;
                                observableSource.b(this.f137487c);
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                dispose();
                                this.f137489f.clear();
                                this.f137485a.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        dispose();
                        this.f137489f.clear();
                        this.f137485a.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.f137489f.clear();
        }

        void c() {
            this.f137491h = false;
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137492i = true;
            this.f137487c.b();
            this.f137490g.dispose();
            if (getAndIncrement() == 0) {
                this.f137489f.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137492i;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137493j) {
                return;
            }
            if (this.f137494k == 0) {
                this.f137489f.offer(obj);
            }
            b();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137493j) {
                return;
            }
            this.f137493j = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137493j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f137493j = true;
            dispose();
            this.f137485a.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        if (ObservableScalarXMap.a(this.f137267a, observer, this.f137468b)) {
            return;
        }
        if (this.f137470d == ErrorMode.IMMEDIATE) {
            this.f137267a.b(new SourceObserver(new SerializedObserver(observer), this.f137468b, this.f137469c));
        } else {
            this.f137267a.b(new ConcatMapDelayErrorObserver(observer, this.f137468b, this.f137469c, this.f137470d == ErrorMode.END));
        }
    }
}
