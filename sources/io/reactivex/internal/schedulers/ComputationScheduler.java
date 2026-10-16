package io.reactivex.internal.schedulers;

import androidx.compose.animation.core.h;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ComputationScheduler extends Scheduler implements SchedulerMultiWorkerSupport {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final FixedSchedulerPool f138992d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final RxThreadFactory f138993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f138994g = h(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final PoolWorker f138995h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadFactory f138996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f138997c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class EventLoopWorker extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ListCompositeDisposable f138998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CompositeDisposable f138999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ListCompositeDisposable f139000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final PoolWorker f139001d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f139002f;

        EventLoopWorker(PoolWorker poolWorker) {
            this.f139001d = poolWorker;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.f138998a = listCompositeDisposable;
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.f138999b = compositeDisposable;
            ListCompositeDisposable listCompositeDisposable2 = new ListCompositeDisposable();
            this.f139000c = listCompositeDisposable2;
            listCompositeDisposable2.b(listCompositeDisposable);
            listCompositeDisposable2.b(compositeDisposable);
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable b(Runnable runnable) {
            return this.f139002f ? EmptyDisposable.INSTANCE : this.f139001d.f(runnable, 0L, TimeUnit.MILLISECONDS, this.f138998a);
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
            return this.f139002f ? EmptyDisposable.INSTANCE : this.f139001d.f(runnable, j3, timeUnit, this.f138999b);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f139002f) {
                return;
            }
            this.f139002f = true;
            this.f139000c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f139002f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FixedSchedulerPool implements SchedulerMultiWorkerSupport {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f139003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final PoolWorker[] f139004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f139005c;

        FixedSchedulerPool(int i3, ThreadFactory threadFactory) {
            this.f139003a = i3;
            this.f139004b = new PoolWorker[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                this.f139004b[i4] = new PoolWorker(threadFactory);
            }
        }

        @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
        public void a(int i3, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
            int i4 = this.f139003a;
            if (i4 == 0) {
                for (int i5 = 0; i5 < i3; i5++) {
                    workerCallback.a(i5, ComputationScheduler.f138995h);
                }
                return;
            }
            int i6 = ((int) this.f139005c) % i4;
            for (int i7 = 0; i7 < i3; i7++) {
                workerCallback.a(i7, new EventLoopWorker(this.f139004b[i6]));
                i6++;
                if (i6 == i4) {
                    i6 = 0;
                }
            }
            this.f139005c = i6;
        }

        public PoolWorker b() {
            int i3 = this.f139003a;
            if (i3 == 0) {
                return ComputationScheduler.f138995h;
            }
            PoolWorker[] poolWorkerArr = this.f139004b;
            long j3 = this.f139005c;
            this.f139005c = 1 + j3;
            return poolWorkerArr[(int) (j3 % ((long) i3))];
        }

        public void c() {
            for (PoolWorker poolWorker : this.f139004b) {
                poolWorker.dispose();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PoolWorker extends NewThreadWorker {
        PoolWorker(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        f138995h = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f138993f = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        f138992d = fixedSchedulerPool;
        fixedSchedulerPool.c();
    }

    public ComputationScheduler() {
        this(f138993f);
    }

    static int h(int i3, int i4) {
        return (i4 <= 0 || i4 > i3) ? i3 : i4;
    }

    @Override // io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport
    public void a(int i3, SchedulerMultiWorkerSupport.WorkerCallback workerCallback) {
        ObjectHelper.e(i3, "number > 0 required");
        ((FixedSchedulerPool) this.f138997c.get()).a(i3, workerCallback);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new EventLoopWorker(((FixedSchedulerPool) this.f138997c.get()).b());
    }

    @Override // io.reactivex.Scheduler
    public Disposable f(Runnable runnable, long j3, TimeUnit timeUnit) {
        return ((FixedSchedulerPool) this.f138997c.get()).b().g(runnable, j3, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public Disposable g(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        return ((FixedSchedulerPool) this.f138997c.get()).b().h(runnable, j3, j4, timeUnit);
    }

    public void i() {
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(f138994g, this.f138996b);
        if (h.a(this.f138997c, f138992d, fixedSchedulerPool)) {
            return;
        }
        fixedSchedulerPool.c();
    }

    public ComputationScheduler(ThreadFactory threadFactory) {
        this.f138996b = threadFactory;
        this.f138997c = new AtomicReference(f138992d);
        i();
    }
}
