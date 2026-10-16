package androidx.work.impl.background.greedy;

import androidx.work.Clock;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DelayedWorkTracker {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String f54745e = Logger.i("DelayedWorkTracker");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Scheduler f54746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RunnableScheduler f54747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f54748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f54749d = new HashMap();

    public DelayedWorkTracker(Scheduler scheduler, RunnableScheduler runnableScheduler, Clock clock) {
        this.f54746a = scheduler;
        this.f54747b = runnableScheduler;
        this.f54748c = clock;
    }

    public void a(final WorkSpec workSpec, long j3) {
        Runnable runnable = (Runnable) this.f54749d.remove(workSpec.f55013a);
        if (runnable != null) {
            this.f54747b.a(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.e().a(DelayedWorkTracker.f54745e, "Scheduling work " + workSpec.f55013a);
                DelayedWorkTracker.this.f54746a.b(workSpec);
            }
        };
        this.f54749d.put(workSpec.f55013a, runnable2);
        this.f54747b.b(j3 - this.f54748c.currentTimeMillis(), runnable2);
    }

    public void b(String str) {
        Runnable runnable = (Runnable) this.f54749d.remove(str);
        if (runnable != null) {
            this.f54747b.a(runnable);
        }
    }
}
