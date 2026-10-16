package io.reactivex.internal.operators.observable;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingObservableLatest<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137275a;

    @Override // java.lang.Iterable
    public Iterator iterator() {
        BlockingObservableLatestIterator blockingObservableLatestIterator = new BlockingObservableLatestIterator();
        Observable.y(this.f137275a).j().b(blockingObservableLatestIterator);
        return blockingObservableLatestIterator;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BlockingObservableLatestIterator<T> extends DisposableObserver<Notification<T>> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Notification f137276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Semaphore f137277c = new Semaphore(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference f137278d = new AtomicReference();

        BlockingObservableLatestIterator() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void h(Notification notification) {
            if (this.f137278d.getAndSet(notification) == null) {
                this.f137277c.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification notification = this.f137276b;
            if (notification != null && notification.g()) {
                throw ExceptionHelper.e(this.f137276b.d());
            }
            if (this.f137276b == null) {
                try {
                    BlockingHelper.a();
                    this.f137277c.acquire();
                    Notification notification2 = (Notification) this.f137278d.getAndSet(null);
                    this.f137276b = notification2;
                    if (notification2.g()) {
                        throw ExceptionHelper.e(notification2.d());
                    }
                } catch (InterruptedException e3) {
                    dispose();
                    this.f137276b = Notification.b(e3);
                    throw ExceptionHelper.e(e3);
                }
            }
            return this.f137276b.h();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objE = this.f137276b.e();
            this.f137276b = null;
            return objE;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            RxJavaPlugins.s(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }
    }
}
