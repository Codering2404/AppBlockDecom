package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.WorkLauncherImpl;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SystemJobService extends JobService implements ExecutionListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f54845f = Logger.i("SystemJobService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WorkManagerImpl f54846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f54847b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final StartStopTokens f54848c = new StartStopTokens();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WorkLauncher f54849d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static String[] a(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentAuthorities();
        }

        static Uri[] b(JobParameters jobParameters) {
            return jobParameters.getTriggeredContentUris();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static Network a(JobParameters jobParameters) {
            return jobParameters.getNetwork();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api31Impl {
        static int a(JobParameters jobParameters) {
            return SystemJobService.a(jobParameters.getStopReason());
        }
    }

    static int a(int i3) {
        switch (i3) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return i3;
            default:
                return -512;
        }
    }

    private static WorkGenerationalId b(JobParameters jobParameters) {
        try {
            PersistableBundle extras = jobParameters.getExtras();
            if (extras == null || !extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION"));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public void c(WorkGenerationalId workGenerationalId, boolean z2) {
        JobParameters jobParameters;
        Logger.e().a(f54845f, workGenerationalId.b() + " executed on JobScheduler");
        synchronized (this.f54847b) {
            jobParameters = (JobParameters) this.f54847b.remove(workGenerationalId);
        }
        this.f54848c.b(workGenerationalId);
        if (jobParameters != null) {
            jobFinished(jobParameters, z2);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            WorkManagerImpl workManagerImplR = WorkManagerImpl.r(getApplicationContext());
            this.f54846a = workManagerImplR;
            Processor processorT = workManagerImplR.t();
            this.f54849d = new WorkLauncherImpl(processorT, this.f54846a.x());
            processorT.e(this);
        } catch (IllegalStateException e3) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e3);
            }
            Logger.e().k(f54845f, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl workManagerImpl = this.f54846a;
        if (workManagerImpl != null) {
            workManagerImpl.t().m(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (this.f54846a == null) {
            Logger.e().a(f54845f, "WorkManager is not initialized; requesting retry.");
            jobFinished(jobParameters, true);
            return false;
        }
        WorkGenerationalId workGenerationalIdB = b(jobParameters);
        if (workGenerationalIdB == null) {
            Logger.e().c(f54845f, "WorkSpec id not found!");
            return false;
        }
        synchronized (this.f54847b) {
            try {
                if (this.f54847b.containsKey(workGenerationalIdB)) {
                    Logger.e().a(f54845f, "Job is already being executed by SystemJobService: " + workGenerationalIdB);
                    return false;
                }
                Logger.e().a(f54845f, "onStartJob for " + workGenerationalIdB);
                this.f54847b.put(workGenerationalIdB, jobParameters);
                WorkerParameters.RuntimeExtras runtimeExtras = new WorkerParameters.RuntimeExtras();
                if (Api24Impl.b(jobParameters) != null) {
                    runtimeExtras.f54618b = Arrays.asList(Api24Impl.b(jobParameters));
                }
                if (Api24Impl.a(jobParameters) != null) {
                    runtimeExtras.f54617a = Arrays.asList(Api24Impl.a(jobParameters));
                }
                runtimeExtras.f54619c = Api28Impl.a(jobParameters);
                this.f54849d.a(this.f54848c.d(workGenerationalIdB), runtimeExtras);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        if (this.f54846a == null) {
            Logger.e().a(f54845f, "WorkManager is not initialized; requesting retry.");
            return true;
        }
        WorkGenerationalId workGenerationalIdB = b(jobParameters);
        if (workGenerationalIdB == null) {
            Logger.e().c(f54845f, "WorkSpec id not found!");
            return false;
        }
        Logger.e().a(f54845f, "onStopJob for " + workGenerationalIdB);
        synchronized (this.f54847b) {
            this.f54847b.remove(workGenerationalIdB);
        }
        StartStopToken startStopTokenB = this.f54848c.b(workGenerationalIdB);
        if (startStopTokenB != null) {
            this.f54849d.b(startStopTokenB, Build.VERSION.SDK_INT >= 31 ? Api31Impl.a(jobParameters) : -512);
        }
        return !this.f54846a.t().j(workGenerationalIdB.b());
    }
}
