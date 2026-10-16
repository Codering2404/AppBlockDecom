package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleScheduler extends Scheduler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final RxThreadFactory f139090d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final ScheduledExecutorService f139091f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadFactory f139092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f139093c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ScheduledWorker extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ScheduledExecutorService f139094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompositeDisposable f139095b = new CompositeDisposable();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f139096c;

        ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.f139094a = scheduledExecutorService;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
            if (this.f139096c) {
                return EmptyDisposable.INSTANCE;
            }
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(RxJavaPlugins.u(runnable), this.f139095b);
            this.f139095b.b(scheduledRunnable);
            try {
                scheduledRunnable.a(j3 <= 0 ? this.f139094a.submit((Callable) scheduledRunnable) : this.f139094a.schedule((Callable) scheduledRunnable, j3, timeUnit));
                return scheduledRunnable;
            } catch (RejectedExecutionException e3) {
                dispose();
                RxJavaPlugins.s(e3);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f139096c) {
                return;
            }
            this.f139096c = true;
            this.f139095b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139096c;
        }
    }

    static {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f139091f = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.shutdown();
        f139090d = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public SingleScheduler() {
        this(f139090d);
    }

    static ScheduledExecutorService h(ThreadFactory threadFactory) {
        return SchedulerPoolFactory.a(threadFactory);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new ScheduledWorker((ScheduledExecutorService) this.f139093c.get());
    }

    @Override // io.reactivex.Scheduler
    public Disposable f(Runnable runnable, long j3, TimeUnit timeUnit) {
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(RxJavaPlugins.u(runnable));
        try {
            scheduledDirectTask.a(j3 <= 0 ? ((ScheduledExecutorService) this.f139093c.get()).submit(scheduledDirectTask) : ((ScheduledExecutorService) this.f139093c.get()).schedule(scheduledDirectTask, j3, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e3) {
            RxJavaPlugins.s(e3);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public Disposable g(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        Runnable runnableU = RxJavaPlugins.u(runnable);
        if (j4 > 0) {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(runnableU);
            try {
                scheduledDirectPeriodicTask.a(((ScheduledExecutorService) this.f139093c.get()).scheduleAtFixedRate(scheduledDirectPeriodicTask, j3, j4, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e3) {
                RxJavaPlugins.s(e3);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.f139093c.get();
        InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(runnableU, scheduledExecutorService);
        try {
            instantPeriodicTask.b(j3 <= 0 ? scheduledExecutorService.submit(instantPeriodicTask) : scheduledExecutorService.schedule(instantPeriodicTask, j3, timeUnit));
            return instantPeriodicTask;
        } catch (RejectedExecutionException e4) {
            RxJavaPlugins.s(e4);
            return EmptyDisposable.INSTANCE;
        }
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference atomicReference = new AtomicReference();
        this.f139093c = atomicReference;
        this.f139092b = threadFactory;
        atomicReference.lazySet(h(threadFactory));
    }
}
