package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable, SchedulerRunnableIntrospection {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final FutureTask f138988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final FutureTask f138989d;
    private static final long serialVersionUID = 1811839108042568751L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Runnable f138990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Thread f138991b;

    static {
        Runnable runnable = Functions.f134906b;
        f138988c = new FutureTask(runnable, null);
        f138989d = new FutureTask(runnable, null);
    }

    AbstractDirectTask(Runnable runnable) {
        this.f138990a = runnable;
    }

    public final void a(Future future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == f138988c) {
                return;
            }
            if (future2 == f138989d) {
                future.cancel(this.f138991b != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        FutureTask futureTask;
        Future<?> future = get();
        if (future == f138988c || future == (futureTask = f138989d) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f138991b != Thread.currentThread());
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        Future<?> future = get();
        return future == f138988c || future == f138989d;
    }
}
