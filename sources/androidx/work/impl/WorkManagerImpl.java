package androidx.work.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkManagerImpl extends WorkManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f54682k = Logger.i("WorkManagerImpl");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static WorkManagerImpl f54683l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static WorkManagerImpl f54684m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Object f54685n = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f54686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Configuration f54687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WorkDatabase f54688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TaskExecutor f54689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List f54690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Processor f54691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PreferenceUtils f54692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f54693h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private BroadcastReceiver.PendingResult f54694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Trackers f54695j;

    /* JADX INFO: renamed from: androidx.work.impl.WorkManagerImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettableFuture f54696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ PreferenceUtils f54697b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f54696a.o(Long.valueOf(this.f54697b.a()));
            } catch (Throwable th) {
                this.f54696a.p(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static boolean a(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    public WorkManagerImpl(Context context, Configuration configuration, TaskExecutor taskExecutor, WorkDatabase workDatabase, List list, Processor processor, Trackers trackers) {
        Context applicationContext = context.getApplicationContext();
        if (Api24Impl.a(applicationContext)) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        Logger.h(new Logger.LogcatLogger(configuration.j()));
        this.f54686a = applicationContext;
        this.f54689d = taskExecutor;
        this.f54688c = workDatabase;
        this.f54691f = processor;
        this.f54695j = trackers;
        this.f54687b = configuration;
        this.f54690e = list;
        this.f54692g = new PreferenceUtils(workDatabase);
        Schedulers.e(list, this.f54691f, taskExecutor.c(), this.f54688c, configuration);
        this.f54689d.d(new ForceStopRunnable(applicationContext, this));
    }

    public static void l(Context context, Configuration configuration) {
        synchronized (f54685n) {
            try {
                WorkManagerImpl workManagerImpl = f54683l;
                if (workManagerImpl != null && f54684m != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
                if (workManagerImpl == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (f54684m == null) {
                        f54684m = WorkManagerImplExtKt.c(applicationContext, configuration);
                    }
                    f54683l = f54684m;
                }
            } finally {
            }
        }
    }

    public static WorkManagerImpl q() {
        synchronized (f54685n) {
            try {
                WorkManagerImpl workManagerImpl = f54683l;
                if (workManagerImpl != null) {
                    return workManagerImpl;
                }
                return f54684m;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static WorkManagerImpl r(Context context) {
        WorkManagerImpl workManagerImplQ;
        synchronized (f54685n) {
            try {
                workManagerImplQ = q();
                if (workManagerImplQ == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (!(applicationContext instanceof Configuration.Provider)) {
                        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                    }
                    l(applicationContext, ((Configuration.Provider) applicationContext).b());
                    workManagerImplQ = r(applicationContext);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return workManagerImplQ;
    }

    public void A(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f54685n) {
            try {
                BroadcastReceiver.PendingResult pendingResult2 = this.f54694i;
                if (pendingResult2 != null) {
                    pendingResult2.finish();
                }
                this.f54694i = pendingResult;
                if (this.f54693h) {
                    pendingResult.finish();
                    this.f54694i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void B(WorkGenerationalId workGenerationalId) {
        this.f54689d.d(new StopWorkRunnable(this.f54691f, new StartStopToken(workGenerationalId), true));
    }

    @Override // androidx.work.WorkManager
    public Operation a(String str) {
        CancelWorkRunnable cancelWorkRunnableD = CancelWorkRunnable.d(str, this);
        this.f54689d.d(cancelWorkRunnableD);
        return cancelWorkRunnableD.e();
    }

    @Override // androidx.work.WorkManager
    public Operation b(String str) {
        CancelWorkRunnable cancelWorkRunnableC = CancelWorkRunnable.c(str, this, true);
        this.f54689d.d(cancelWorkRunnableC);
        return cancelWorkRunnableC.e();
    }

    @Override // androidx.work.WorkManager
    public Operation d(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new WorkContinuationImpl(this, list).a();
    }

    @Override // androidx.work.WorkManager
    public Operation e(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        return existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.UPDATE ? WorkerUpdater.c(this, str, periodicWorkRequest) : n(str, existingPeriodicWorkPolicy, periodicWorkRequest).a();
    }

    @Override // androidx.work.WorkManager
    public Operation g(String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        return new WorkContinuationImpl(this, str, existingWorkPolicy, list).a();
    }

    @Override // androidx.work.WorkManager
    public LiveData i(UUID uuid) {
        return LiveDataUtils.a(this.f54688c.t().E(Collections.singletonList(uuid.toString())), new Function<List<WorkSpec.WorkInfoPojo>, WorkInfo>() { // from class: androidx.work.impl.WorkManagerImpl.2
            @Override // androidx.arch.core.util.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public WorkInfo apply(List list) {
                if (list == null || list.size() <= 0) {
                    return null;
                }
                return ((WorkSpec.WorkInfoPojo) list.get(0)).e();
            }
        }, this.f54689d);
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture j(String str) {
        StatusRunnable statusRunnableA = StatusRunnable.a(this, str);
        this.f54689d.c().execute(statusRunnableA);
        return statusRunnableA.c();
    }

    @Override // androidx.work.WorkManager
    public ListenableFuture k(String str) {
        StatusRunnable statusRunnableB = StatusRunnable.b(this, str);
        this.f54689d.c().execute(statusRunnableB);
        return statusRunnableB.c();
    }

    public Operation m(UUID uuid) {
        CancelWorkRunnable cancelWorkRunnableB = CancelWorkRunnable.b(uuid, this);
        this.f54689d.d(cancelWorkRunnableB);
        return cancelWorkRunnableB.e();
    }

    public WorkContinuationImpl n(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, PeriodicWorkRequest periodicWorkRequest) {
        return new WorkContinuationImpl(this, str, existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE, Collections.singletonList(periodicWorkRequest));
    }

    public Context o() {
        return this.f54686a;
    }

    public Configuration p() {
        return this.f54687b;
    }

    public PreferenceUtils s() {
        return this.f54692g;
    }

    public Processor t() {
        return this.f54691f;
    }

    public List u() {
        return this.f54690e;
    }

    public Trackers v() {
        return this.f54695j;
    }

    public WorkDatabase w() {
        return this.f54688c;
    }

    public TaskExecutor x() {
        return this.f54689d;
    }

    public void y() {
        synchronized (f54685n) {
            try {
                this.f54693h = true;
                BroadcastReceiver.PendingResult pendingResult = this.f54694i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.f54694i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void z() {
        SystemJobScheduler.c(o());
        w().t().r();
        Schedulers.f(p(), w(), u());
    }
}
