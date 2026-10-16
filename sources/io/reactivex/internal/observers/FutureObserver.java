package io.reactivex.internal.observers;

import androidx.compose.animation.core.h;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class FutureObserver<T> extends CountDownLatch implements Observer<T>, Future<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f134982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f134983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f134984c;

    @Override // io.reactivex.Observer
    public void a(Disposable disposable) {
        DisposableHelper.g(this.f134984c, disposable);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = (Disposable) this.f134984c.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!h.a(this.f134984c, disposable, disposableHelper));
        if (disposable != null) {
            disposable.dispose();
        }
        countDown();
        return true;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            BlockingHelper.a();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.f134983b;
        if (th == null) {
            return this.f134982a;
        }
        throw new ExecutionException(th);
    }

    @Override // io.reactivex.Observer
    public void h(Object obj) {
        if (this.f134982a == null) {
            this.f134982a = obj;
        } else {
            ((Disposable) this.f134984c.get()).dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.b((Disposable) this.f134984c.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        Disposable disposable;
        if (this.f134982a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            disposable = (Disposable) this.f134984c.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!h.a(this.f134984c, disposable, this));
        countDown();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        Disposable disposable;
        if (this.f134983b != null) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f134983b = th;
        do {
            disposable = (Disposable) this.f134984c.get();
            if (disposable == this || disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.s(th);
                return;
            }
        } while (!h.a(this.f134984c, disposable, this));
        countDown();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.a();
            if (!await(j3, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.d(j3, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f134983b;
            if (th == null) {
                return this.f134982a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }
}
