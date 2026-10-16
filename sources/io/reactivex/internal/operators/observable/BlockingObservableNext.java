package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingObservableNext<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137284a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NextIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NextObserver f137285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ObservableSource f137286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f137287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f137288d = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f137289f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Throwable f137290g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f137291h;

        NextIterator(ObservableSource observableSource, NextObserver nextObserver) {
            this.f137286b = observableSource;
            this.f137285a = nextObserver;
        }

        private boolean a() {
            if (!this.f137291h) {
                this.f137291h = true;
                this.f137285a.d();
                new ObservableMaterialize(this.f137286b).b(this.f137285a);
            }
            try {
                Notification notificationF = this.f137285a.f();
                if (notificationF.h()) {
                    this.f137289f = false;
                    this.f137287c = notificationF.e();
                    return true;
                }
                this.f137288d = false;
                if (notificationF.f()) {
                    return false;
                }
                Throwable thD = notificationF.d();
                this.f137290g = thD;
                throw ExceptionHelper.e(thD);
            } catch (InterruptedException e3) {
                this.f137285a.dispose();
                this.f137290g = e3;
                throw ExceptionHelper.e(e3);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f137290g;
            if (th != null) {
                throw ExceptionHelper.e(th);
            }
            if (this.f137288d) {
                return !this.f137289f || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            Throwable th = this.f137290g;
            if (th != null) {
                throw ExceptionHelper.e(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f137289f = true;
            return this.f137287c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new NextIterator(this.f137284a, new NextObserver());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NextObserver<T> extends DisposableObserver<Notification<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BlockingQueue f137292b = new ArrayBlockingQueue(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f137293c = new AtomicInteger();

        NextObserver() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void h(Notification notification) {
            if (this.f137293c.getAndSet(0) == 1 || !notification.h()) {
                while (!this.f137292b.offer(notification)) {
                    Notification notification2 = (Notification) this.f137292b.poll();
                    if (notification2 != null && !notification2.h()) {
                        notification = notification2;
                    }
                }
            }
        }

        void d() {
            this.f137293c.set(1);
        }

        public Notification f() {
            d();
            BlockingHelper.a();
            return (Notification) this.f137292b.take();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.s(th);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }
    }
}
