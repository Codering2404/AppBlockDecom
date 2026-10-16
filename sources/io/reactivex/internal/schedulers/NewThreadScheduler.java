package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class NewThreadScheduler extends Scheduler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final RxThreadFactory f139055c = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ThreadFactory f139056b;

    public NewThreadScheduler() {
        this(f139055c);
    }

    @Override // io.reactivex.Scheduler
    public Scheduler.Worker b() {
        return new NewThreadWorker(this.f139056b);
    }

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.f139056b = threadFactory;
    }
}
