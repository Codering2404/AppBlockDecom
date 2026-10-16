package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.SchedulerRunnableIntrospection;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ExecutorScheduler extends Scheduler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Scheduler f139007d = Schedulers.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final boolean f139008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Executor f139009c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class DelayedDispose implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DelayedRunnable f139010a;

        DelayedDispose(DelayedRunnable delayedRunnable) {
            this.f139010a = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayedRunnable delayedRunnable = this.f139010a;
            delayedRunnable.f139013b.a(ExecutorScheduler.this.d(delayedRunnable));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable, SchedulerRunnableIntrospection {
        private static final long serialVersionUID = -4101336210206799084L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SequentialDisposable f139012a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SequentialDisposable f139013b;

        DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.f139012a = new SequentialDisposable();
            this.f139013b = new SequentialDisposable();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(null) != null) {
                this.f139012a.dispose();
                this.f139013b.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return get() == null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    SequentialDisposable sequentialDisposable = this.f139012a;
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable.lazySet(disposableHelper);
                    this.f139013b.lazySet(disposableHelper);
                } catch (Throwable th) {
                    lazySet(null);
                    this.f139012a.lazySet(DisposableHelper.DISPOSED);
                    this.f139013b.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f139014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Executor f139015b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f139017d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicInteger f139018f = new AtomicInteger();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final CompositeDisposable f139019g = new CompositeDisposable();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final MpscLinkedQueue f139016c = new MpscLinkedQueue();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Runnable f139020a;

            BooleanRunnable(Runnable runnable) {
                this.f139020a = runnable;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean e() {
                return get();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.f139020a.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
            private static final long serialVersionUID = -3603436687413320876L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Runnable f139021a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final DisposableContainer f139022b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            volatile Thread f139023c;

            InterruptibleRunnable(Runnable runnable, DisposableContainer disposableContainer) {
                this.f139021a = runnable;
                this.f139022b = disposableContainer;
            }

            void a() {
                DisposableContainer disposableContainer = this.f139022b;
                if (disposableContainer != null) {
                    disposableContainer.c(this);
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                while (true) {
                    int i3 = get();
                    if (i3 >= 2) {
                        return;
                    }
                    if (i3 == 0) {
                        if (compareAndSet(0, 4)) {
                            a();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.f139023c;
                        if (thread != null) {
                            thread.interrupt();
                            this.f139023c = null;
                        }
                        set(4);
                        a();
                        return;
                    }
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean e() {
                return get() >= 2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.f139023c = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.f139023c = null;
                        return;
                    }
                    try {
                        this.f139021a.run();
                        this.f139023c = null;
                        if (compareAndSet(1, 2)) {
                            a();
                            return;
                        }
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } catch (Throwable th) {
                        this.f139023c = null;
                        if (compareAndSet(1, 2)) {
                            a();
                        } else {
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        }
                        throw th;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class SequentialDispose implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final SequentialDisposable f139024a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Runnable f139025b;

            SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.f139024a = sequentialDisposable;
                this.f139025b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f139024a.a(ExecutorWorker.this.b(this.f139025b));
            }
        }

        public ExecutorWorker(Executor executor, boolean z2) {
            this.f139015b = executor;
            this.f139014a = z2;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable b(Runnable runnable) {
            Disposable booleanRunnable;
            if (this.f139017d) {
                return EmptyDisposable.INSTANCE;
            }
            Runnable runnableU = RxJavaPlugins.u(runnable);
            if (this.f139014a) {
                booleanRunnable = new InterruptibleRunnable(runnableU, this.f139019g);
                this.f139019g.b(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(runnableU);
            }
            this.f139016c.offer(booleanRunnable);
            if (this.f139018f.getAndIncrement() != 0) {
                return booleanRunnable;
            }
            try {
                this.f139015b.execute(this);
                return booleanRunnable;
            } catch (RejectedExecutionException e3) {
                this.f139017d = true;
                this.f139016c.clear();
                RxJavaPlugins.s(e3);
                return EmptyDisposable.INSTANCE;
            }
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
            if (j3 <= 0) {
                return b(runnable);
            }
            if (this.f139017d) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, RxJavaPlugins.u(runnable)), this.f139019g);
            this.f139019g.b(scheduledRunnable);
            Executor executor = this.f139015b;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.a(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j3, timeUnit));
                } catch (RejectedExecutionException e3) {
                    this.f139017d = true;
                    RxJavaPlugins.s(e3);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.a(new DisposeOnCancel(ExecutorScheduler.f139007d.f(scheduledRunnable, j3, timeUnit)));
            }
            sequentialDisposable.a(scheduledRunnable);
            return sequentialDisposable2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f139017d) {
                return;
            }
            this.f139017d = true;
            this.f139019g.dispose();
            if (this.f139018f.getAndIncrement() == 0) {
                this.f139016c.clear();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139017d;
        }

        @Override // java.lang.Runnable
        public void run() {
            MpscLinkedQueue mpscLinkedQueue = this.f139016c;
            int iAddAndGet = 1;
            while (!this.f139017d) {
                do {
                    Runnable runnable = (Runnable) mpscLinkedQueue.poll();
                    if (runnable != null) {
                        runnable.run();
                    } else if (this.f139017d) {
                        mpscLinkedQueue.clear();
                        return;
                    } else {
                        iAddAndGet = this.f139018f.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                } while (!this.f139017d);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new ExecutorWorker(this.f139009c, this.f139008b);
    }

    @Override // io.reactivex.Scheduler
    public Disposable d(Runnable runnable) {
        Runnable runnableU = RxJavaPlugins.u(runnable);
        try {
            if (this.f139009c instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableU);
                scheduledDirectTask.a(((ExecutorService) this.f139009c).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.f139008b) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(runnableU, null);
                this.f139009c.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(runnableU);
            this.f139009c.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e3) {
            RxJavaPlugins.s(e3);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public Disposable f(Runnable runnable, long j3, TimeUnit timeUnit) {
        Runnable runnableU = RxJavaPlugins.u(runnable);
        if (!(this.f139009c instanceof ScheduledExecutorService)) {
            DelayedRunnable delayedRunnable = new DelayedRunnable(runnableU);
            delayedRunnable.f139012a.a(f139007d.f(new DelayedDispose(delayedRunnable), j3, timeUnit));
            return delayedRunnable;
        }
        try {
            ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnableU);
            scheduledDirectTask.a(((ScheduledExecutorService) this.f139009c).schedule(scheduledDirectTask, j3, timeUnit));
            return scheduledDirectTask;
        } catch (RejectedExecutionException e3) {
            RxJavaPlugins.s(e3);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public Disposable g(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        if (!(this.f139009c instanceof ScheduledExecutorService)) {
            return super.g(runnable, j3, j4, timeUnit);
        }
        try {
            ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(RxJavaPlugins.u(runnable));
            scheduledDirectPeriodicTask.a(((ScheduledExecutorService) this.f139009c).scheduleAtFixedRate(scheduledDirectPeriodicTask, j3, j4, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e3) {
            RxJavaPlugins.s(e3);
            return EmptyDisposable.INSTANCE;
        }
    }
}
