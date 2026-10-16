package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ObservableSource f137268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f137269b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class BlockingObservableIterator<T> extends AtomicReference<Disposable> implements Observer<T>, Iterator<T>, Disposable {
        private static final long serialVersionUID = 6695226475494099826L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SpscLinkedArrayQueue f137270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Lock f137271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Condition f137272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f137273d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Throwable f137274f;

        BlockingObservableIterator(int i3) {
            this.f137270a = new SpscLinkedArrayQueue(i3);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.f137271b = reentrantLock;
            this.f137272c = reentrantLock.newCondition();
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        void b() {
            this.f137271b.lock();
            try {
                this.f137272c.signalAll();
            } finally {
                this.f137271b.unlock();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f137270a.offer(obj);
            b();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z2 = this.f137273d;
                boolean zIsEmpty = this.f137270a.isEmpty();
                if (z2) {
                    Throwable th = this.f137274f;
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
                try {
                    BlockingHelper.a();
                    this.f137271b.lock();
                    while (!this.f137273d && this.f137270a.isEmpty()) {
                        try {
                            this.f137272c.await();
                        } finally {
                        }
                    }
                    this.f137271b.unlock();
                } catch (InterruptedException e3) {
                    DisposableHelper.a(this);
                    b();
                    throw ExceptionHelper.e(e3);
                }
            }
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                return this.f137270a.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f137273d = true;
            b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f137274f = th;
            this.f137273d = true;
            b();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f137269b);
        this.f137268a.b(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
