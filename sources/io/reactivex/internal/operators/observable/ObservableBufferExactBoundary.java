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
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f137372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable f137373c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BufferExactBoundaryObserver f137374b;

        BufferBoundaryObserver(BufferExactBoundaryObserver bufferExactBoundaryObserver) {
            this.f137374b = bufferExactBoundaryObserver;
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137374b.m();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137374b.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137374b.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Callable f137375h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final ObservableSource f137376i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Disposable f137377j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Disposable f137378k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Collection f137379l;

        BufferExactBoundaryObserver(Observer observer, Callable callable, ObservableSource observableSource) {
            super(observer, new MpscLinkedQueue());
            this.f137375h = callable;
            this.f137376i = observableSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137377j, disposable)) {
                this.f137377j = disposable;
                try {
                    this.f137379l = (Collection) ObjectHelper.d(this.f137375h.call(), "The buffer supplied is null");
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.f137378k = bufferBoundaryObserver;
                    this.f134997b.a(this);
                    if (this.f134999d) {
                        return;
                    }
                    this.f137376i.b(bufferBoundaryObserver);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f134999d = true;
                    disposable.dispose();
                    EmptyDisposable.i(th, this.f134997b);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f134999d) {
                return;
            }
            this.f134999d = true;
            this.f137378k.dispose();
            this.f137377j.dispose();
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
                    Collection collection = this.f137379l;
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
            try {
                Collection collection = (Collection) ObjectHelper.d(this.f137375h.call(), "The buffer supplied is null");
                synchronized (this) {
                    try {
                        Collection collection2 = this.f137379l;
                        if (collection2 == null) {
                            return;
                        }
                        this.f137379l = collection;
                        j(collection2, false, this);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                dispose();
                this.f134997b.onError(th2);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            synchronized (this) {
                try {
                    Collection collection = this.f137379l;
                    if (collection == null) {
                        return;
                    }
                    this.f137379l = null;
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
        this.f137267a.b(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.f137373c, this.f137372b));
    }
}
