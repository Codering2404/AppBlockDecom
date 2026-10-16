package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f137345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ObservableSource f137346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f137347d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8466418554264089604L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f137348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Callable f137349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ObservableSource f137350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Function f137351d;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f137355i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f137357k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f137358l;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final SpscLinkedArrayQueue f137356j = new SpscLinkedArrayQueue(Observable.d());

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final CompositeDisposable f137352f = new CompositeDisposable();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference f137353g = new AtomicReference();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Map f137359m = new LinkedHashMap();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicThrowable f137354h = new AtomicThrowable();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class BufferOpenObserver<Open> extends AtomicReference<Disposable> implements Observer<Open>, Disposable {
            private static final long serialVersionUID = -8498650778633225126L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final BufferBoundaryObserver f137360a;

            BufferOpenObserver(BufferBoundaryObserver bufferBoundaryObserver) {
                this.f137360a = bufferBoundaryObserver;
            }

            @Override // io.reactivex.Observer
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                DisposableHelper.a(this);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean e() {
                return get() == DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.Observer
            public void h(Object obj) {
                this.f137360a.f(obj);
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.f137360a.g(this);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                this.f137360a.b(this, th);
            }
        }

        BufferBoundaryObserver(Observer observer, ObservableSource observableSource, Function function, Callable callable) {
            this.f137348a = observer;
            this.f137349b = callable;
            this.f137350c = observableSource;
            this.f137351d = function;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this.f137353g, disposable)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.f137352f.b(bufferOpenObserver);
                this.f137350c.b(bufferOpenObserver);
            }
        }

        void b(Disposable disposable, Throwable th) {
            DisposableHelper.a(this.f137353g);
            this.f137352f.c(disposable);
            onError(th);
        }

        void c(BufferCloseObserver bufferCloseObserver, long j3) {
            boolean z2;
            this.f137352f.c(bufferCloseObserver);
            if (this.f137352f.g() == 0) {
                DisposableHelper.a(this.f137353g);
                z2 = true;
            } else {
                z2 = false;
            }
            synchronized (this) {
                try {
                    Map map = this.f137359m;
                    if (map == null) {
                        return;
                    }
                    this.f137356j.offer(map.remove(Long.valueOf(j3)));
                    if (z2) {
                        this.f137355i = true;
                    }
                    d();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        void d() {
            if (getAndIncrement() != 0) {
                return;
            }
            Observer observer = this.f137348a;
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f137356j;
            int iAddAndGet = 1;
            while (!this.f137357k) {
                boolean z2 = this.f137355i;
                if (z2 && this.f137354h.get() != null) {
                    spscLinkedArrayQueue.clear();
                    observer.onError(this.f137354h.b());
                    return;
                }
                Collection collection = (Collection) spscLinkedArrayQueue.poll();
                boolean z3 = collection == null;
                if (z2 && z3) {
                    observer.onComplete();
                    return;
                } else if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    observer.h(collection);
                }
            }
            spscLinkedArrayQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (DisposableHelper.a(this.f137353g)) {
                this.f137357k = true;
                this.f137352f.dispose();
                synchronized (this) {
                    this.f137359m = null;
                }
                if (getAndIncrement() != 0) {
                    this.f137356j.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b((Disposable) this.f137353g.get());
        }

        void f(Object obj) {
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f137349b.call(), "The bufferSupplier returned a null Collection");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137351d.apply(obj), "The bufferClose returned a null ObservableSource");
                long j3 = this.f137358l;
                this.f137358l = 1 + j3;
                synchronized (this) {
                    try {
                        Map map = this.f137359m;
                        if (map == null) {
                            return;
                        }
                        map.put(Long.valueOf(j3), collection);
                        BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j3);
                        this.f137352f.b(bufferCloseObserver);
                        observableSource.b(bufferCloseObserver);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                DisposableHelper.a(this.f137353g);
                onError(th2);
            }
        }

        void g(BufferOpenObserver bufferOpenObserver) {
            this.f137352f.c(bufferOpenObserver);
            if (this.f137352f.g() == 0) {
                DisposableHelper.a(this.f137353g);
                this.f137355i = true;
                d();
            }
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            synchronized (this) {
                try {
                    Map map = this.f137359m;
                    if (map == null) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        ((Collection) it.next()).add(obj);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137352f.dispose();
            synchronized (this) {
                try {
                    Map map = this.f137359m;
                    if (map == null) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    while (it.hasNext()) {
                        this.f137356j.offer((Collection) it.next());
                    }
                    this.f137359m = null;
                    this.f137355i = true;
                    d();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (!this.f137354h.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f137352f.dispose();
            synchronized (this) {
                this.f137359m = null;
            }
            this.f137355i = true;
            d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<Disposable> implements Observer<Object>, Disposable {
        private static final long serialVersionUID = -8498650778633225126L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final BufferBoundaryObserver f137361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f137362b;

        BufferCloseObserver(BufferBoundaryObserver bufferBoundaryObserver, long j3) {
            this.f137361a = bufferBoundaryObserver;
            this.f137362b = j3;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                disposable.dispose();
                this.f137361a.c(this, this.f137362b);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                lazySet(disposableHelper);
                this.f137361a.c(this, this.f137362b);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Disposable disposable = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable == disposableHelper) {
                RxJavaPlugins.s(th);
            } else {
                lazySet(disposableHelper);
                this.f137361a.b(this, th);
            }
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(observer, this.f137346c, this.f137347d, this.f137345b);
        observer.a(bufferBoundaryObserver);
        this.f137267a.b(bufferBoundaryObserver);
    }
}
