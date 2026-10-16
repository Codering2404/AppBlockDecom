package androidx.work.impl.background.greedy;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.RunnableScheduler;
import androidx.work.WorkInfo;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.Scheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.OnConstraintsStateChangedListener;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerKt;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GreedyScheduler implements Scheduler, OnConstraintsStateChangedListener, ExecutionListener {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f54752p = Logger.i("GreedyScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f54753a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DelayedWorkTracker f54755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f54756d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Processor f54759h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final WorkLauncher f54760i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Configuration f54761j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Boolean f54763l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final WorkConstraintsTracker f54764m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final TaskExecutor f54765n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final TimeLimiter f54766o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f54754b = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f54757f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StartStopTokens f54758g = new StartStopTokens();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f54762k = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AttemptData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f54767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f54768b;

        private AttemptData(int i3, long j3) {
            this.f54767a = i3;
            this.f54768b = j3;
        }
    }

    public GreedyScheduler(Context context, Configuration configuration, Trackers trackers, Processor processor, WorkLauncher workLauncher, TaskExecutor taskExecutor) {
        this.f54753a = context;
        RunnableScheduler runnableSchedulerK = configuration.k();
        this.f54755c = new DelayedWorkTracker(this, runnableSchedulerK, configuration.a());
        this.f54766o = new TimeLimiter(runnableSchedulerK, workLauncher);
        this.f54765n = taskExecutor;
        this.f54764m = new WorkConstraintsTracker(trackers);
        this.f54761j = configuration;
        this.f54759h = processor;
        this.f54760i = workLauncher;
    }

    private void f() {
        this.f54763l = Boolean.valueOf(ProcessUtils.b(this.f54753a, this.f54761j));
    }

    private void g() {
        if (this.f54756d) {
            return;
        }
        this.f54759h.e(this);
        this.f54756d = true;
    }

    private void h(WorkGenerationalId workGenerationalId) {
        Job job;
        synchronized (this.f54757f) {
            job = (Job) this.f54754b.remove(workGenerationalId);
        }
        if (job != null) {
            Logger.e().a(f54752p, "Stopping tracking for " + workGenerationalId);
            job.cancel((CancellationException) null);
        }
    }

    private long i(WorkSpec workSpec) {
        long jMax;
        synchronized (this.f54757f) {
            try {
                WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(workSpec);
                AttemptData attemptData = (AttemptData) this.f54762k.get(workGenerationalIdA);
                if (attemptData == null) {
                    attemptData = new AttemptData(workSpec.f55023k, this.f54761j.a().currentTimeMillis());
                    this.f54762k.put(workGenerationalIdA, attemptData);
                }
                jMax = attemptData.f54768b + (((long) Math.max((workSpec.f55023k - attemptData.f54767a) - 5, 0)) * 30000);
            } catch (Throwable th) {
                throw th;
            }
        }
        return jMax;
    }

    @Override // androidx.work.impl.Scheduler
    public void a(String str) {
        if (this.f54763l == null) {
            f();
        }
        if (!this.f54763l.booleanValue()) {
            Logger.e().f(f54752p, "Ignoring schedule request in non-main process");
            return;
        }
        g();
        Logger.e().a(f54752p, "Cancelling work ID " + str);
        DelayedWorkTracker delayedWorkTracker = this.f54755c;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.b(str);
        }
        for (StartStopToken startStopToken : this.f54758g.c(str)) {
            this.f54766o.b(startStopToken);
            this.f54760i.e(startStopToken);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void b(WorkSpec... workSpecArr) {
        if (this.f54763l == null) {
            f();
        }
        if (!this.f54763l.booleanValue()) {
            Logger.e().f(f54752p, "Ignoring schedule request in a secondary process");
            return;
        }
        g();
        HashSet<WorkSpec> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (WorkSpec workSpec : workSpecArr) {
            if (!this.f54758g.a(WorkSpecKt.a(workSpec))) {
                long jMax = Math.max(workSpec.c(), i(workSpec));
                long jCurrentTimeMillis = this.f54761j.a().currentTimeMillis();
                if (workSpec.f55014b == WorkInfo.State.ENQUEUED) {
                    if (jCurrentTimeMillis < jMax) {
                        DelayedWorkTracker delayedWorkTracker = this.f54755c;
                        if (delayedWorkTracker != null) {
                            delayedWorkTracker.a(workSpec, jMax);
                        }
                    } else if (workSpec.k()) {
                        if (workSpec.f55022j.h()) {
                            Logger.e().a(f54752p, "Ignoring " + workSpec + ". Requires device idle.");
                        } else if (workSpec.f55022j.e()) {
                            Logger.e().a(f54752p, "Ignoring " + workSpec + ". Requires ContentUri triggers.");
                        } else {
                            hashSet.add(workSpec);
                            hashSet2.add(workSpec.f55013a);
                        }
                    } else if (!this.f54758g.a(WorkSpecKt.a(workSpec))) {
                        Logger.e().a(f54752p, "Starting work for " + workSpec.f55013a);
                        StartStopToken startStopTokenE = this.f54758g.e(workSpec);
                        this.f54766o.c(startStopTokenE);
                        this.f54760i.c(startStopTokenE);
                    }
                }
            }
        }
        synchronized (this.f54757f) {
            try {
                if (!hashSet.isEmpty()) {
                    Logger.e().a(f54752p, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    for (WorkSpec workSpec2 : hashSet) {
                        WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(workSpec2);
                        if (!this.f54754b.containsKey(workGenerationalIdA)) {
                            this.f54754b.put(workGenerationalIdA, WorkConstraintsTrackerKt.b(this.f54764m, workSpec2, this.f54765n.b(), this));
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void c(WorkGenerationalId workGenerationalId, boolean z2) {
        StartStopToken startStopTokenB = this.f54758g.b(workGenerationalId);
        if (startStopTokenB != null) {
            this.f54766o.b(startStopTokenB);
        }
        h(workGenerationalId);
        if (z2) {
            return;
        }
        synchronized (this.f54757f) {
            this.f54762k.remove(workGenerationalId);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public boolean d() {
        return false;
    }

    @Override // androidx.work.impl.constraints.OnConstraintsStateChangedListener
    public void e(WorkSpec workSpec, ConstraintsState constraintsState) {
        WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(workSpec);
        if (constraintsState instanceof ConstraintsState.ConstraintsMet) {
            if (this.f54758g.a(workGenerationalIdA)) {
                return;
            }
            Logger.e().a(f54752p, "Constraints met: Scheduling work ID " + workGenerationalIdA);
            StartStopToken startStopTokenD = this.f54758g.d(workGenerationalIdA);
            this.f54766o.c(startStopTokenD);
            this.f54760i.c(startStopTokenD);
            return;
        }
        Logger.e().a(f54752p, "Constraints not met: Cancelling work ID " + workGenerationalIdA);
        StartStopToken startStopTokenB = this.f54758g.b(workGenerationalIdA);
        if (startStopTokenB != null) {
            this.f54766o.b(startStopTokenB);
            this.f54760i.b(startStopTokenB, ((ConstraintsState.ConstraintsNotMet) constraintsState).a());
        }
    }
}
