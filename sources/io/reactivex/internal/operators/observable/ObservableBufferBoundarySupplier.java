package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f137363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable f137364c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BufferBoundarySupplierObserver f137365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f137366c;

        BufferBoundaryObserver(BufferBoundarySupplierObserver bufferBoundarySupplierObserver) {
            this.f137365b = bufferBoundarySupplierObserver;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            if (this.f137366c) {
                return;
            }
            this.f137366c = true;
            dispose();
            this.f137365b.n();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f137366c) {
                return;
            }
            this.f137366c = true;
            this.f137365b.n();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f137366c) {
                RxJavaPlugins.s(th);
            } else {
                this.f137366c = true;
                this.f137365b.onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Callable f137367h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Callable f137368i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Disposable f137369j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final AtomicReference f137370k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Collection f137371l;

        BufferBoundarySupplierObserver(Observer observer, Callable callable, Callable callable2) {
            super(observer, new MpscLinkedQueue());
            this.f137370k = new AtomicReference();
            this.f137367h = callable;
            this.f137368i = callable2;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137369j, disposable)) {
                this.f137369j = disposable;
                Observer observer = this.f134997b;
                try {
                    this.f137371l = (Collection) ObjectHelper.d(this.f137367h.call(), "The buffer supplied is null");
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137368i.call(), "The boundary ObservableSource supplied is null");
                        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                        this.f137370k.set(bufferBoundaryObserver);
                        observer.a(this);
                        if (this.f134999d) {
                            return;
                        }
                        observableSource.b(bufferBoundaryObserver);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        this.f134999d = true;
                        disposable.dispose();
                        EmptyDisposable.i(th, observer);
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f134999d = true;
                    disposable.dispose();
                    EmptyDisposable.i(th2, observer);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f134999d) {
                return;
            }
            this.f134999d = true;
            this.f137369j.dispose();
            m();
            if (g()) {
                this.f134998c.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f134999d;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.f137371l;
                    if (collection == null) {
                        return;
                    }
                    collection.add(obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.internal.observers.QueueDrainObserver, io.reactivex.internal.util.ObservableQueueDrain
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void f(Observer observer, Collection collection) {
            this.f134997b.h(collection);
        }

        void m() {
            DisposableHelper.a(this.f137370k);
        }

        void n() {
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f137367h.call(), "The buffer supplied is null");
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.d(this.f137368i.call(), "The boundary ObservableSource supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    if (DisposableHelper.c(this.f137370k, bufferBoundaryObserver)) {
                        synchronized (this) {
                            try {
                                Collection collection2 = this.f137371l;
                                if (collection2 == null) {
                                    return;
                                }
                                this.f137371l = collection;
                                observableSource.b(bufferBoundaryObserver);
                                j(collection2, false, this);
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f134999d = true;
                    this.f137369j.dispose();
                    this.f134997b.onError(th2);
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                dispose();
                this.f134997b.onError(th3);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            synchronized (this) {
                try {
                    Collection collection = this.f137371l;
                    if (collection == null) {
                        return;
                    }
                    this.f137371l = null;
                    this.f134998c.offer(collection);
                    this.f135000f = true;
                    if (g()) {
                        QueueDrainHelper.d(this.f134998c, this.f134997b, false, this, this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            dispose();
            this.f134997b.onError(th);
        }
    }

    @Override // io.reactivex.Observable
    protected void u(Observer observer) {
        this.f137267a.b(new BufferBoundarySupplierObserver(new SerializedObserver(observer), this.f137364c, this.f137363b));
    }
}
