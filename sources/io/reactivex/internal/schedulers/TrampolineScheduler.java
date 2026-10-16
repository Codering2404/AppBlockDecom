package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class TrampolineScheduler extends Scheduler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TrampolineScheduler f139097b = new TrampolineScheduler();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SleepingRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Runnable f139098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TrampolineWorker f139099b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f139100c;

        SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j3) {
            this.f139098a = runnable;
            this.f139099b = trampolineWorker;
            this.f139100c = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f139099b.f139108d) {
                return;
            }
            long jA = this.f139099b.a(TimeUnit.MILLISECONDS);
            long j3 = this.f139100c;
            if (j3 > jA) {
                try {
                    Thread.sleep(j3 - jA);
                } catch (InterruptedException e3) {
                    Thread.currentThread().interrupt();
                    RxJavaPlugins.s(e3);
                    return;
                }
            }
            if (this.f139099b.f139108d) {
                return;
            }
            this.f139098a.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TimedRunnable implements Comparable<TimedRunnable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Runnable f139101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f139102b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f139103c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f139104d;

        TimedRunnable(Runnable runnable, Long l3, int i3) {
            this.f139101a = runnable;
            this.f139102b = l3.longValue();
            this.f139103c = i3;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(TimedRunnable timedRunnable) {
            int iB = ObjectHelper.b(this.f139102b, timedRunnable.f139102b);
            return iB == 0 ? ObjectHelper.a(this.f139103c, timedRunnable.f139103c) : iB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TrampolineWorker extends Scheduler.Worker implements Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final PriorityBlockingQueue f139105a = new PriorityBlockingQueue();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f139106b = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f139107c = new AtomicInteger();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f139108d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class AppendToQueueTask implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final TimedRunnable f139109a;

            AppendToQueueTask(TimedRunnable timedRunnable) {
                this.f139109a = timedRunnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f139109a.f139104d = true;
                TrampolineWorker.this.f139105a.remove(this.f139109a);
            }
        }

        TrampolineWorker() {
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable b(Runnable runnable) {
            return f(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j3);
            return f(new SleepingRunnable(runnable, this, jA), jA);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f139108d = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139108d;
        }

        Disposable f(Runnable runnable, long j3) {
            if (this.f139108d) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j3), this.f139107c.incrementAndGet());
            this.f139105a.add(timedRunnable);
            if (this.f139106b.getAndIncrement() != 0) {
                return Disposables.c(new AppendToQueueTask(timedRunnable));
            }
            int iAddAndGet = 1;
            while (!this.f139108d) {
                TimedRunnable timedRunnable2 = (TimedRunnable) this.f139105a.poll();
                if (timedRunnable2 == null) {
                    iAddAndGet = this.f139106b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!timedRunnable2.f139104d) {
                    timedRunnable2.f139101a.run();
                }
            }
            this.f139105a.clear();
            return EmptyDisposable.INSTANCE;
        }
    }

    TrampolineScheduler() {
    }

    public static TrampolineScheduler h() {
        return f139097b;
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new TrampolineWorker();
    }

    @Override // io.reactivex.Scheduler
    public Disposable d(Runnable runnable) {
        RxJavaPlugins.u(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public Disposable f(Runnable runnable, long j3, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j3);
            RxJavaPlugins.u(runnable).run();
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.s(e3);
        }
        return EmptyDisposable.INSTANCE;
    }
}
