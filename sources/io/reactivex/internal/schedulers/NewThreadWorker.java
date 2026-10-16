package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class NewThreadWorker extends Scheduler.Worker implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScheduledExecutorService f139057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f139058b;

    public NewThreadWorker(ThreadFactory threadFactory) {
        this.f139057a = SchedulerPoolFactory.a(threadFactory);
    }

    @Override // io.reactivex.Scheduler.Worker
    public Disposable b(Runnable runnable) {
        return c(runnable, 0L, null);
    }

    @Override // io.reactivex.Scheduler.Worker
    public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
        return this.f139058b ? EmptyDisposable.INSTANCE : f(runnable, j3, timeUnit, null);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        if (this.f139058b) {
            return;
        }
        this.f139058b = true;
        this.f139057a.shutdownNow();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this.f139058b;
    }

    public ScheduledRunnable f(Runnable runnable, long j3, TimeUnit timeUnit, DisposableContainer disposableContainer) {
        ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.u(runnable), disposableContainer);
        if (disposableContainer != null && !disposableContainer.b(scheduledRunnable)) {
            return scheduledRunnable;
        }
        try {
            scheduledRunnable.a(j3 <= 0 ? this.f139057a.submit((Callable) scheduledRunnable) : this.f139057a.schedule((Callable) scheduledRunnable, j3, timeUnit));
            return scheduledRunnable;
        } catch (RejectedExecutionException e3) {
            if (disposableContainer != null) {
                disposableContainer.a(scheduledRunnable);
            }
            RxJavaPlugins.s(e3);
            return scheduledRunnable;
        }
    }

    public Disposable g(Runnable runnable, long j3, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.u(runnable));
        try {
            scheduledDirectTask.a(j3 <= 0 ? this.f139057a.submit(scheduledDirectTask) : this.f139057a.schedule(scheduledDirectTask, j3, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e3) {
            RxJavaPlugins.s(e3);
            return EmptyDisposable.INSTANCE;
        }
    }

    public Disposable h(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        Runnable runnableU = RxJavaPlugins.u(runnable);
        if (j4 <= 0) {
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(runnableU, this.f139057a);
            try {
                instantPeriodicTask.b(j3 <= 0 ? this.f139057a.submit(instantPeriodicTask) : this.f139057a.schedule(instantPeriodicTask, j3, timeUnit));
                return instantPeriodicTask;
            } catch (RejectedExecutionException e3) {
                RxJavaPlugins.s(e3);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableU);
        try {
            scheduledDirectPeriodicTask.a(this.f139057a.scheduleAtFixedRate(scheduledDirectPeriodicTask, j3, j4, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e4) {
            RxJavaPlugins.s(e4);
            return EmptyDisposable.INSTANCE;
        }
    }

    public void i() {
        if (this.f139058b) {
            return;
        }
        this.f139058b = true;
        this.f139057a.shutdown();
    }
}
