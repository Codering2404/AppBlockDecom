package io.reactivex.internal.schedulers;

import androidx.compose.animation.core.h;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
final class InstantPeriodicTask implements Callable<Void>, Disposable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final FutureTask f139030g = new FutureTask(Functions.f134906b, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Runnable f139031a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final ExecutorService f139034d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Thread f139035f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f139033c = new AtomicReference();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f139032b = new AtomicReference();

    InstantPeriodicTask(Runnable runnable, ExecutorService executorService) {
        this.f139031a = runnable;
        this.f139034d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.f139035f = Thread.currentThread();
        try {
            this.f139031a.run();
            c(this.f139034d.submit(this));
            this.f139035f = null;
        } catch (Throwable th) {
            this.f139035f = null;
            RxJavaPlugins.s(th);
        }
        return null;
    }

    void b(Future future) {
        Future future2;
        do {
            future2 = (Future) this.f139033c.get();
            if (future2 == f139030g) {
                future.cancel(this.f139035f != Thread.currentThread());
                return;
            }
        } while (!h.a(this.f139033c, future2, future));
    }

    void c(Future future) {
        Future future2;
        do {
            future2 = (Future) this.f139032b.get();
            if (future2 == f139030g) {
                future.cancel(this.f139035f != Thread.currentThread());
                return;
            }
        } while (!h.a(this.f139032b, future2, future));
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        AtomicReference atomicReference = this.f139033c;
        FutureTask futureTask = f139030g;
        Future future = (Future) atomicReference.getAndSet(futureTask);
        if (future != null && future != futureTask) {
            future.cancel(this.f139035f != Thread.currentThread());
        }
        Future future2 = (Future) this.f139032b.getAndSet(futureTask);
        if (future2 == null || future2 == futureTask) {
            return;
        }
        future2.cancel(this.f139035f != Thread.currentThread());
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f139033c.get() == f139030g;
    }
}
