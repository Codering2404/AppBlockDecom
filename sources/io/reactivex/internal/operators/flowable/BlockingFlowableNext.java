package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Notification;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subscribers.DisposableSubscriber;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingFlowableNext<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Publisher f135216a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NextIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NextSubscriber f135217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Publisher f135218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f135219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f135220d = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f135221f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Throwable f135222g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f135223h;

        NextIterator(Publisher publisher, NextSubscriber nextSubscriber) {
            this.f135218b = publisher;
            this.f135217a = nextSubscriber;
        }

        private boolean a() {
            try {
                if (!this.f135223h) {
                    this.f135223h = true;
                    this.f135217a.d();
                    Flowable.d(this.f135218b).k().w(this.f135217a);
                }
                Notification notificationF = this.f135217a.f();
                if (notificationF.h()) {
                    this.f135221f = false;
                    this.f135219c = notificationF.e();
                    return true;
                }
                this.f135220d = false;
                if (notificationF.f()) {
                    return false;
                }
                if (!notificationF.g()) {
                    throw new IllegalStateException("Should not reach here");
                }
                Throwable thD = notificationF.d();
                this.f135222g = thD;
                throw ExceptionHelper.e(thD);
            } catch (InterruptedException e3) {
                this.f135217a.dispose();
                this.f135222g = e3;
                throw ExceptionHelper.e(e3);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th = this.f135222g;
            if (th != null) {
                throw ExceptionHelper.e(th);
            }
            if (this.f135220d) {
                return !this.f135221f || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            Throwable th = this.f135222g;
            if (th != null) {
                throw ExceptionHelper.e(th);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f135221f = true;
            return this.f135219c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new NextIterator(this.f135216a, new NextSubscriber());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NextSubscriber<T> extends DisposableSubscriber<Notification<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BlockingQueue f135224b = new ArrayBlockingQueue(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f135225c = new AtomicInteger();

        NextSubscriber() {
        }

        @Override // org.reactivestreams.Subscriber
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void h(Notification notification) {
            if (this.f135225c.getAndSet(0) == 1 || !notification.h()) {
                while (!this.f135224b.offer(notification)) {
                    Notification notification2 = (Notification) this.f135224b.poll();
                    if (notification2 != null && !notification2.h()) {
                        notification = notification2;
                    }
                }
            }
        }

        void d() {
            this.f135225c.set(1);
        }

        public Notification f() {
            d();
            BlockingHelper.a();
            return (Notification) this.f135224b.take();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            RxJavaPlugins.s(th);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
        }
    }
}
