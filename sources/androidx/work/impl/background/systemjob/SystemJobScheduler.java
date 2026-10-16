package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class SystemJobScheduler implements Scheduler {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f54839g = Logger.i("SystemJobScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f54840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JobScheduler f54841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SystemJobInfoConverter f54842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WorkDatabase f54843d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Configuration f54844f;

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration) {
        this(context, workDatabase, configuration, (JobScheduler) context.getSystemService("jobscheduler"), new SystemJobInfoConverter(context, configuration.a()));
    }

    public static void c(Context context) {
        List listG;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (listG = g(context, jobScheduler)) == null || listG.isEmpty()) {
            return;
        }
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            e(jobScheduler, ((JobInfo) it.next()).getId());
        }
    }

    private static void e(JobScheduler jobScheduler, int i3) {
        try {
            jobScheduler.cancel(i3);
        } catch (Throwable th) {
            Logger.e().d(f54839g, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i3)), th);
        }
    }

    private static List f(Context context, JobScheduler jobScheduler, String str) {
        List<JobInfo> listG = g(context, jobScheduler);
        if (listG == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : listG) {
            WorkGenerationalId workGenerationalIdH = h(jobInfo);
            if (workGenerationalIdH != null && str.equals(workGenerationalIdH.b())) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    private static List g(Context context, JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.e().d(f54839g, "getAllPendingJobs() is not reliable on this device.", th);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    private static WorkGenerationalId h(JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (!extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return null;
            }
            return new WorkGenerationalId(extras.getString("EXTRA_WORK_SPEC_ID"), extras.getInt("EXTRA_WORK_SPEC_GENERATION", 0));
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(Context context, WorkDatabase workDatabase) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> listG = g(context, jobScheduler);
        List listE = workDatabase.q().e();
        boolean z2 = false;
        HashSet hashSet = new HashSet(listG != null ? listG.size() : 0);
        if (listG != null && !listG.isEmpty()) {
            for (JobInfo jobInfo : listG) {
                WorkGenerationalId workGenerationalIdH = h(jobInfo);
                if (workGenerationalIdH != null) {
                    hashSet.add(workGenerationalIdH.b());
                } else {
                    e(jobScheduler, jobInfo.getId());
                }
            }
        }
        Iterator it = listE.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (!hashSet.contains((String) it.next())) {
                Logger.e().a(f54839g, "Reconciling jobs");
                z2 = true;
                break;
            }
        }
        if (!z2) {
            return z2;
        }
        workDatabase.beginTransaction();
        try {
            WorkSpecDao workSpecDaoT = workDatabase.t();
            Iterator it2 = listE.iterator();
            while (it2.hasNext()) {
                workSpecDaoT.s((String) it2.next(), -1L);
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            return z2;
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void a(String str) {
        List listF = f(this.f54840a, this.f54841b, str);
        if (listF == null || listF.isEmpty()) {
            return;
        }
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            e(this.f54841b, ((Integer) it.next()).intValue());
        }
        this.f54843d.q().i(str);
    }

    @Override // androidx.work.impl.Scheduler
    public void b(WorkSpec... workSpecArr) {
        IdGenerator idGenerator = new IdGenerator(this.f54843d);
        for (WorkSpec workSpec : workSpecArr) {
            this.f54843d.beginTransaction();
            try {
                WorkSpec workSpecL = this.f54843d.t().l(workSpec.f55013a);
                if (workSpecL == null) {
                    Logger.e().k(f54839g, "Skipping scheduling " + workSpec.f55013a + " because it's no longer in the DB");
                    this.f54843d.setTransactionSuccessful();
                } else if (workSpecL.f55014b != WorkInfo.State.ENQUEUED) {
                    Logger.e().k(f54839g, "Skipping scheduling " + workSpec.f55013a + " because it is no longer enqueued");
                    this.f54843d.setTransactionSuccessful();
                } else {
                    WorkGenerationalId workGenerationalIdA = WorkSpecKt.a(workSpec);
                    SystemIdInfo systemIdInfoB = this.f54843d.q().b(workGenerationalIdA);
                    int iE = systemIdInfoB != null ? systemIdInfoB.f54986c : idGenerator.e(this.f54844f.i(), this.f54844f.g());
                    if (systemIdInfoB == null) {
                        this.f54843d.q().f(SystemIdInfoKt.a(workGenerationalIdA, iE));
                    }
                    j(workSpec, iE);
                    this.f54843d.setTransactionSuccessful();
                }
            } finally {
                this.f54843d.endTransaction();
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public boolean d() {
        return true;
    }

    public void j(WorkSpec workSpec, int i3) {
        JobInfo jobInfoA = this.f54842c.a(workSpec, i3);
        Logger loggerE = Logger.e();
        String str = f54839g;
        loggerE.a(str, "Scheduling work ID " + workSpec.f55013a + "Job ID " + i3);
        try {
            if (this.f54841b.schedule(jobInfoA) == 0) {
                Logger.e().k(str, "Unable to schedule work ID " + workSpec.f55013a);
                if (workSpec.f55029q && workSpec.f55030r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.f55029q = false;
                    Logger.e().a(str, String.format("Scheduling a non-expedited job (work ID %s)", workSpec.f55013a));
                    j(workSpec, i3);
                }
            }
        } catch (IllegalStateException e3) {
            List listG = g(this.f54840a, this.f54841b);
            String str2 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(listG != null ? listG.size() : 0), Integer.valueOf(this.f54843d.t().h().size()), Integer.valueOf(this.f54844f.h()));
            Logger.e().c(f54839g, str2);
            IllegalStateException illegalStateException = new IllegalStateException(str2, e3);
            Consumer consumerL = this.f54844f.l();
            if (consumerL == null) {
                throw illegalStateException;
            }
            consumerL.accept(illegalStateException);
        } catch (Throwable th) {
            Logger.e().d(f54839g, "Unable to schedule " + workSpec, th);
        }
    }

    public SystemJobScheduler(Context context, WorkDatabase workDatabase, Configuration configuration, JobScheduler jobScheduler, SystemJobInfoConverter systemJobInfoConverter) {
        this.f54840a = context;
        this.f54841b = jobScheduler;
        this.f54842c = systemJobInfoConverter;
        this.f54843d = workDatabase;
        this.f54844f = configuration;
    }
}
