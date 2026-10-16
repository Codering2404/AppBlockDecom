package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkTimer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f55217e = Logger.i("WorkTimer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RunnableScheduler f55218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map f55219b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map f55220c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Object f55221d = new Object();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TimeLimitExceededListener {
        void a(WorkGenerationalId workGenerationalId);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class WorkTimerRunnable implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WorkTimer f55222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final WorkGenerationalId f55223b;

        WorkTimerRunnable(WorkTimer workTimer, WorkGenerationalId workGenerationalId) {
            this.f55222a = workTimer;
            this.f55223b = workGenerationalId;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f55222a.f55221d) {
                try {
                    if (((WorkTimerRunnable) this.f55222a.f55219b.remove(this.f55223b)) != null) {
                        TimeLimitExceededListener timeLimitExceededListener = (TimeLimitExceededListener) this.f55222a.f55220c.remove(this.f55223b);
                        if (timeLimitExceededListener != null) {
                            timeLimitExceededListener.a(this.f55223b);
                        }
                    } else {
                        Logger.e().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f55223b));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public WorkTimer(RunnableScheduler runnableScheduler) {
        this.f55218a = runnableScheduler;
    }

    public void a(WorkGenerationalId workGenerationalId, long j3, TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.f55221d) {
            Logger.e().a(f55217e, "Starting timer for " + workGenerationalId);
            b(workGenerationalId);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, workGenerationalId);
            this.f55219b.put(workGenerationalId, workTimerRunnable);
            this.f55220c.put(workGenerationalId, timeLimitExceededListener);
            this.f55218a.b(j3, workTimerRunnable);
        }
    }

    public void b(WorkGenerationalId workGenerationalId) {
        synchronized (this.f55221d) {
            try {
                if (((WorkTimerRunnable) this.f55219b.remove(workGenerationalId)) != null) {
                    Logger.e().a(f55217e, "Stopping timer for " + workGenerationalId);
                    this.f55220c.remove(workGenerationalId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
