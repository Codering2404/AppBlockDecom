package io.reactivex.internal.schedulers;

import androidx.compose.animation.core.h;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class IoScheduler extends Scheduler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final RxThreadFactory f139036d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final RxThreadFactory f139037f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final ThreadWorker f139040i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final CachedWorkerPool f139041j;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadFactory f139042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f139043c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final TimeUnit f139039h = TimeUnit.SECONDS;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long f139038g = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CachedWorkerPool implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f139044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentLinkedQueue f139045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CompositeDisposable f139046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final ScheduledExecutorService f139047d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Future f139048f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ThreadFactory f139049g;

        CachedWorkerPool(long j3, TimeUnit timeUnit, ThreadFactory threadFactory) {
            CachedWorkerPool cachedWorkerPool;
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
            ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
            long nanos = timeUnit != null ? timeUnit.toNanos(j3) : 0L;
            this.f139044a = nanos;
            this.f139045b = new ConcurrentLinkedQueue();
            this.f139046c = new CompositeDisposable();
            this.f139049g = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, IoScheduler.f139037f);
                cachedWorkerPool = this;
                scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(cachedWorkerPool, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                cachedWorkerPool = this;
                scheduledExecutorServiceNewScheduledThreadPool = null;
                scheduledFutureScheduleWithFixedDelay = null;
            }
            cachedWorkerPool.f139047d = scheduledExecutorServiceNewScheduledThreadPool;
            cachedWorkerPool.f139048f = scheduledFutureScheduleWithFixedDelay;
        }

        void a() {
            if (this.f139045b.isEmpty()) {
                return;
            }
            long jC = c();
            for (ThreadWorker threadWorker : this.f139045b) {
                if (threadWorker.j() > jC) {
                    return;
                }
                if (this.f139045b.remove(threadWorker)) {
                    this.f139046c.a(threadWorker);
                }
            }
        }

        ThreadWorker b() {
            if (this.f139046c.e()) {
                return IoScheduler.f139040i;
            }
            while (!this.f139045b.isEmpty()) {
                ThreadWorker threadWorker = (ThreadWorker) this.f139045b.poll();
                if (threadWorker != null) {
                    return threadWorker;
                }
            }
            ThreadWorker threadWorker2 = new ThreadWorker(this.f139049g);
            this.f139046c.b(threadWorker2);
            return threadWorker2;
        }

        long c() {
            return System.nanoTime();
        }

        void d(ThreadWorker threadWorker) {
            threadWorker.k(c() + this.f139044a);
            this.f139045b.offer(threadWorker);
        }

        void e() {
            this.f139046c.dispose();
            Future future = this.f139048f;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f139047d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EventLoopWorker extends Scheduler.Worker {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CachedWorkerPool f139051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ThreadWorker f139052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f139053d = new AtomicBoolean();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CompositeDisposable f139050a = new CompositeDisposable();

        EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            this.f139051b = cachedWorkerPool;
            this.f139052c = cachedWorkerPool.b();
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
            return this.f139050a.e() ? EmptyDisposable.INSTANCE : this.f139052c.f(runnable, j3, timeUnit, this.f139050a);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f139053d.compareAndSet(false, true)) {
                this.f139050a.dispose();
                this.f139051b.d(this.f139052c);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139053d.get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ThreadWorker extends NewThreadWorker {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f139054c;

        ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f139054c = 0L;
        }

        public long j() {
            return this.f139054c;
        }

        public void k(long j3) {
            this.f139054c = j3;
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f139040i = threadWorker;
        threadWorker.dispose();
        int iMax = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", iMax);
        f139036d = rxThreadFactory;
        f139037f = new RxThreadFactory("RxCachedWorkerPoolEvictor", iMax);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0L, null, rxThreadFactory);
        f139041j = cachedWorkerPool;
        cachedWorkerPool.e();
    }

    public IoScheduler() {
        this(f139036d);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new EventLoopWorker((CachedWorkerPool) this.f139043c.get());
    }

    public void h() {
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(f139038g, f139039h, this.f139042b);
        if (h.a(this.f139043c, f139041j, cachedWorkerPool)) {
            return;
        }
        cachedWorkerPool.e();
    }

    public IoScheduler(ThreadFactory threadFactory) {
        this.f139042b = threadFactory;
        this.f139043c = new AtomicReference(f139041j);
        h();
    }
}
