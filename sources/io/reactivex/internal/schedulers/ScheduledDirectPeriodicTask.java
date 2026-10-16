package io.reactivex.internal.schedulers;

import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f138991b = Thread.currentThread();
        try {
            this.f138990a.run();
            this.f138991b = null;
        } catch (Throwable th) {
            this.f138991b = null;
            lazySet(AbstractDirectTask.f138988c);
            RxJavaPlugins.s(th);
        }
    }
}
