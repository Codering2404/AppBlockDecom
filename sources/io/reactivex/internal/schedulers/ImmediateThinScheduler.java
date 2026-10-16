package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ImmediateThinScheduler extends Scheduler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Scheduler f139027b = new ImmediateThinScheduler();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Scheduler.Worker f139028c = new ImmediateThinWorker();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Disposable f139029d;

    static {
        Disposable disposableB = Disposables.b();
        f139029d = disposableB;
        disposableB.dispose();
    }

    private ImmediateThinScheduler() {
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return f139028c;
    }

    @Override // io.reactivex.Scheduler
    public Disposable d(Runnable runnable) {
        runnable.run();
        return f139029d;
    }

    @Override // io.reactivex.Scheduler
    public Disposable f(Runnable runnable, long j3, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // io.reactivex.Scheduler
    public Disposable g(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ImmediateThinWorker extends Scheduler.Worker {
        ImmediateThinWorker() {
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable b(Runnable runnable) {
            runnable.run();
            return ImmediateThinScheduler.f139029d;
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable c(Runnable runnable, long j3, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // io.reactivex.Scheduler.Worker
        public Disposable d(Runnable runnable, long j3, long j4, TimeUnit timeUnit) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
        }
    }
}
