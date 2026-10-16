package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f134853a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DisposeTask implements Disposable, Runnable, SchedulerRunnableIntrospection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f134854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Worker f134855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Thread f134856c;

        DisposeTask(Runnable runnable, Worker worker) {
            this.f134854a = runnable;
            this.f134855b = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f134856c == Thread.currentThread()) {
                Worker worker = this.f134855b;
                if (worker instanceof NewThreadWorker) {
                    ((NewThreadWorker) worker).i();
                    return;
                }
            }
            this.f134855b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f134855b.e();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f134856c = Thread.currentThread();
            try {
                this.f134854a.run();
            } finally {
                dispose();
                this.f134856c = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PeriodicDirectTask implements Disposable, Runnable, SchedulerRunnableIntrospection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f134857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Worker f134858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f134859c;

        PeriodicDirectTask(Runnable runnable, Worker worker) {
            this.f134857a = runnable;
            this.f134858b = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f134859c = true;
            this.f134858b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f134859c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f134859c) {
                return;
            }
            try {
                this.f134857a.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f134858b.dispose();
                throw ExceptionHelper.e(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Worker implements Disposable {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class PeriodicTask implements Runnable, SchedulerRunnableIntrospection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Runnable f134860a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final SequentialDisposable f134861b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final long f134862c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f134863d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            long f134864f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            long f134865g;

            PeriodicTask(long j3, Runnable runnable, long j4, SequentialDisposable sequentialDisposable, long j5) {
                this.f134860a = runnable;
                this.f134861b = sequentialDisposable;
                this.f134862c = j5;
                this.f134864f = j4;
                this.f134865g = j3;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r12 = this;
                    java.lang.Runnable r0 = r12.f134860a
                    r0.run()
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r12.f134861b
                    boolean r0 = r0.e()
                    if (r0 != 0) goto L51
                    io.reactivex.Scheduler$Worker r0 = io.reactivex.Scheduler.Worker.this
                    java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.NANOSECONDS
                    long r2 = r0.a(r1)
                    long r4 = io.reactivex.Scheduler.f134853a
                    long r6 = r2 + r4
                    long r8 = r12.f134864f
                    int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                    r6 = 1
                    if (r0 < 0) goto L34
                    long r10 = r12.f134862c
                    long r8 = r8 + r10
                    long r8 = r8 + r4
                    int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                    if (r0 < 0) goto L2a
                    goto L34
                L2a:
                    long r4 = r12.f134865g
                    long r8 = r12.f134863d
                    long r8 = r8 + r6
                    r12.f134863d = r8
                    long r8 = r8 * r10
                    long r4 = r4 + r8
                    goto L43
                L34:
                    long r4 = r12.f134862c
                    long r8 = r2 + r4
                    long r10 = r12.f134863d
                    long r10 = r10 + r6
                    r12.f134863d = r10
                    long r4 = r4 * r10
                    long r4 = r8 - r4
                    r12.f134865g = r4
                    r4 = r8
                L43:
                    r12.f134864f = r2
                    long r4 = r4 - r2
                    io.reactivex.internal.disposables.SequentialDisposable r0 = r12.f134861b
                    io.reactivex.Scheduler$Worker r2 = io.reactivex.Scheduler.Worker.this
                    io.reactivex.disposables.Disposable r1 = r2.c(r12, r4, r1)
                    r0.a(r1)
                L51:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: io.reactivex.Scheduler.Worker.PeriodicTask.run():void");
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public Disposable b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract Disposable c(Runnable runnable, long j3, TimeUnit timeUnit);

        public Disposable d(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable runnableU = RxJavaPlugins.u(runnable);
            long nanos = timeUnit.toNanos(j4);
            long jA = a(TimeUnit.NANOSECONDS);
            Disposable disposableC = c(new PeriodicTask(jA + timeUnit.toNanos(j3), runnableU, jA, sequentialDisposable2, nanos), j3, timeUnit);
            if (disposableC == EmptyDisposable.INSTANCE) {
                return disposableC;
            }
            sequentialDisposable.a(disposableC);
            return sequentialDisposable2;
        }
    }

    public abstract Worker b();

    public long c(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable d(Runnable runnable) {
        return f(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public Disposable f(Runnable runnable, long j3, TimeUnit timeUnit) {
        Worker workerB = b();
        DisposeTask disposeTask = new DisposeTask(RxJavaPlugins.u(runnable), workerB);
        workerB.c(disposeTask, j3, timeUnit);
        return disposeTask;
    }

    public Disposable g(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        Worker workerB = b();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(RxJavaPlugins.u(runnable), workerB);
        Disposable disposableD = workerB.d(periodicDirectTask, j3, j4, timeUnit);
        return disposableD == EmptyDisposable.INSTANCE ? disposableD : periodicDirectTask;
    }
}
