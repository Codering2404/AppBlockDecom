package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingFlowableLatest<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f135207a;

    @Override // java.lang.Iterable
    public Iterator iterator() {
        LatestSubscriberIterator latestSubscriberIterator = new LatestSubscriberIterator();
        Flowable.d(this.f135207a).k().w(latestSubscriberIterator);
        return latestSubscriberIterator;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LatestSubscriberIterator<T> extends DisposableSubscriber<Notification<T>> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Semaphore f135208b = new Semaphore(0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f135209c = new AtomicReference();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Notification f135210d;

        LatestSubscriberIterator() {
        }

        @Override // org.reactivestreams.Subscriber
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void h(Notification notification) {
            if (this.f135209c.getAndSet(notification) == null) {
                this.f135208b.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Notification notification = this.f135210d;
            if (notification != null && notification.g()) {
                throw ExceptionHelper.e(this.f135210d.d());
            }
            Notification notification2 = this.f135210d;
            if ((notification2 == null || notification2.h()) && this.f135210d == null) {
                try {
                    BlockingHelper.a();
                    this.f135208b.acquire();
                    Notification notification3 = (Notification) this.f135209c.getAndSet(null);
                    this.f135210d = notification3;
                    if (notification3.g()) {
                        throw ExceptionHelper.e(notification3.d());
                    }
                } catch (InterruptedException e3) {
                    dispose();
                    this.f135210d = Notification.b(e3);
                    throw ExceptionHelper.e(e3);
                }
            }
            return this.f135210d.h();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext() || !this.f135210d.h()) {
                throw new NoSuchElementException();
            }
            Object objE = this.f135210d.e();
            this.f135210d = null;
            return objE;
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            RxJavaPlugins.s(th);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }
    }
}
