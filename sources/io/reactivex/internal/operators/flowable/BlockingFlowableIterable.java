package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingFlowableIterable<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Flowable f135197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f135198b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BlockingFlowableIterator<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Iterator<T>, Runnable, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SpscArrayQueue f135199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f135200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f135201c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Lock f135202d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Condition f135203f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f135204g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile boolean f135205h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Throwable f135206i;

        BlockingFlowableIterator(int i3) {
            this.f135199a = new SpscArrayQueue(i3);
            this.f135200b = i3;
            this.f135201c = i3 - (i3 >> 2);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f135202d = reentrantLock;
            this.f135203f = reentrantLock.newCondition();
        }

        void a() {
            this.f135202d.lock();
            try {
                this.f135203f.signalAll();
            } finally {
                this.f135202d.unlock();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, this.f135200b);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135199a.offer(obj)) {
                a();
            } else {
                SubscriptionHelper.a(this);
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z2 = this.f135205h;
                boolean zIsEmpty = this.f135199a.isEmpty();
                if (z2) {
                    Throwable th = this.f135206i;
                    if (th != null) {
                        throw ExceptionHelper.e(th);
                    }
                    if (zIsEmpty) {
                        return false;
                    }
                }
                if (!zIsEmpty) {
                    return true;
                }
                BlockingHelper.a();
                this.f135202d.lock();
                while (!this.f135205h && this.f135199a.isEmpty()) {
                    try {
                        try {
                            this.f135203f.await();
                        } catch (InterruptedException e3) {
                            run();
                            throw ExceptionHelper.e(e3);
                        }
                    } finally {
                        this.f135202d.unlock();
                    }
                }
            }
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objPoll = this.f135199a.poll();
            long j3 = this.f135204g + 1;
            if (j3 != this.f135201c) {
                this.f135204g = j3;
                return objPoll;
            }
            this.f135204g = 0L;
            get().y(j3);
            return objPoll;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135205h = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135206i = th;
            this.f135205h = true;
            a();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            SubscriptionHelper.a(this);
            a();
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        BlockingFlowableIterator blockingFlowableIterator = new BlockingFlowableIterator(this.f135198b);
        this.f135197a.w(blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
