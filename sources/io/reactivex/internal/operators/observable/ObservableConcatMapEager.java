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
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f137497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ErrorMode f137498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f137499d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f137500f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long serialVersionUID = 8080567949447303262L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137502b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f137503c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f137504d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ErrorMode f137505f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicThrowable f137506g = new AtomicThrowable();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final ArrayDeque f137507h = new ArrayDeque();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        SimpleQueue f137508i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Disposable f137509j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f137510k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f137511l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        volatile boolean f137512m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        InnerQueuedObserver f137513n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f137514o;

        ConcatMapEagerMainObserver(Observer observer, Function function, int i3, int i4, ErrorMode errorMode) {
            this.f137501a = observer;
            this.f137502b = function;
            this.f137503c = i3;
            this.f137504d = i4;
            this.f137505f = errorMode;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137509j, disposable)) {
                this.f137509j = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int iL = queueDisposable.l(3);
                    if (iL == 1) {
                        this.f137511l = iL;
                        this.f137508i = queueDisposable;
                        this.f137510k = true;
                        this.f137501a.a(this);
                        c();
                        return;
                    }
                    if (iL == 2) {
                        this.f137511l = iL;
                        this.f137508i = queueDisposable;
                        this.f137501a.a(this);
                        return;
                    }
                }
                this.f137508i = new SpscLinkedArrayQueue(this.f137504d);
                this.f137501a.a(this);
            }
        }

        void b() {
            InnerQueuedObserver innerQueuedObserver = this.f137513n;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver innerQueuedObserver2 = (InnerQueuedObserver) this.f137507h.poll();
                if (innerQueuedObserver2 == null) {
                    return;
                } else {
                    innerQueuedObserver2.dispose();
                }
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void c() {
            Object objPoll;
            boolean z2;
            if (getAndIncrement() != 0) {
                return;
            }
            SimpleQueue simpleQueue = this.f137508i;
            ArrayDeque arrayDeque = this.f137507h;
            Observer observer = this.f137501a;
            ErrorMode errorMode = this.f137505f;
            int iAddAndGet = 1;
            while (true) {
                int i3 = this.f137514o;
                while (i3 != this.f137503c) {
                    if (this.f137512m) {
                        simpleQueue.clear();
                        b();
                        return;
                    }
                    if (errorMode == ErrorMode.IMMEDIATE && this.f137506g.get() != null) {
                        simpleQueue.clear();
                        b();
                        observer.onError(this.f137506g.b());
                        return;
                    }
                    try {
                        Object objPoll2 = simpleQueue.poll();
                        if (objPoll2 == null) {
                            break;
                        }
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137502b.apply(objPoll2), "The mapper returned a null ObservableSource");
                        InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.f137504d);
                        arrayDeque.offer(innerQueuedObserver);
                        observableSource.b(innerQueuedObserver);
                        i3++;
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f137509j.dispose();
                        simpleQueue.clear();
                        b();
                        this.f137506g.a(th);
                        observer.onError(this.f137506g.b());
                        return;
                    }
                }
                this.f137514o = i3;
                if (this.f137512m) {
                    simpleQueue.clear();
                    b();
                    return;
                }
                if (errorMode == ErrorMode.IMMEDIATE && this.f137506g.get() != null) {
                    simpleQueue.clear();
                    b();
                    observer.onError(this.f137506g.b());
                    return;
                }
                InnerQueuedObserver innerQueuedObserver2 = this.f137513n;
                if (innerQueuedObserver2 == null) {
                    if (errorMode == ErrorMode.BOUNDARY && this.f137506g.get() != null) {
                        simpleQueue.clear();
                        b();
                        observer.onError(this.f137506g.b());
                        return;
                    }
                    boolean z3 = this.f137510k;
                    InnerQueuedObserver innerQueuedObserver3 = (InnerQueuedObserver) arrayDeque.poll();
                    boolean z4 = innerQueuedObserver3 == null;
                    if (z3 && z4) {
                        if (this.f137506g.get() == null) {
                            observer.onComplete();
                            return;
                        }
                        simpleQueue.clear();
                        b();
                        observer.onError(this.f137506g.b());
                        return;
                    }
                    if (!z4) {
                        this.f137513n = innerQueuedObserver3;
                    }
                    innerQueuedObserver2 = innerQueuedObserver3;
                }
                if (innerQueuedObserver2 != null) {
                    SimpleQueue simpleQueueC = innerQueuedObserver2.c();
                    while (!this.f137512m) {
                        boolean zB = innerQueuedObserver2.b();
                        if (errorMode == ErrorMode.IMMEDIATE && this.f137506g.get() != null) {
                            simpleQueue.clear();
                            b();
                            observer.onError(this.f137506g.b());
                            return;
                        }
                        try {
                            objPoll = simpleQueueC.poll();
                            z2 = objPoll == null;
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            this.f137506g.a(th2);
                            this.f137513n = null;
                            this.f137514o--;
                        }
                        if (zB && z2) {
                            this.f137513n = null;
                            this.f137514o--;
                        } else if (!z2) {
                            observer.h(objPoll);
                        }
                    }
                    simpleQueue.clear();
                    b();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void d(InnerQueuedObserver innerQueuedObserver, Throwable th) {
            if (!this.f137506g.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            if (this.f137505f == ErrorMode.IMMEDIATE) {
                this.f137509j.dispose();
            }
            innerQueuedObserver.d();
            c();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f137512m = true;
            if (getAndIncrement() == 0) {
                this.f137508i.clear();
                b();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f137512m;
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void f(InnerQueuedObserver innerQueuedObserver) {
            innerQueuedObserver.d();
            c();
        }

        @Override // io.reactivex.internal.observers.InnerQueuedObserverSupport
        public void g(InnerQueuedObserver innerQueuedObserver, Object obj) {
            innerQueuedObserver.c().offer(obj);
            c();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137511l == 0) {
                this.f137508i.offer(obj);
            }
            c();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137510k = true;
            c();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137506g.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f137510k = true;
                c();
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new ConcatMapEagerMainObserver(observer, this.f137497b, this.f137499d, this.f137500f, this.f137498c));
    }
}
