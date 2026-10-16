package io.reactivex.internal.observers;

import androidx.compose.animation.core.h;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class FutureSingleObserver<T> extends CountDownLatch implements SingleObserver<T>, Future<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f134985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f134986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f134987c;

    @Override // io.reactivex.SingleObserver
    public void a(Disposable disposable) {
        DisposableHelper.g(this.f134987c, disposable);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        Disposable disposable;
        DisposableHelper disposableHelper;
        do {
            disposable = (Disposable) this.f134987c.get();
            if (disposable == this || disposable == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!h.a(this.f134987c, disposable, disposableHelper));
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
        Throwable th = this.f134986b;
        if (th == null) {
            return this.f134985a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.b((Disposable) this.f134987c.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        Disposable disposable;
        do {
            disposable = (Disposable) this.f134987c.get();
            if (disposable == DisposableHelper.DISPOSED) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f134986b = th;
        } while (!h.a(this.f134987c, disposable, this));
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object obj) {
        Disposable disposable = (Disposable) this.f134987c.get();
        if (disposable == DisposableHelper.DISPOSED) {
            return;
        }
        this.f134985a = obj;
        h.a(this.f134987c, disposable, this);
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
            Throwable th = this.f134986b;
            if (th == null) {
                return this.f134985a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }
}
