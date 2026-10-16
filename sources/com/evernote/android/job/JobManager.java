package com.evernote.android.job;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.evernote.android.job.JobCreator;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobPreconditions;
import com.evernote.android.job.util.JobUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class JobManager {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final JobCat f67868f = new JobCat("JobManager");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile JobManager f67869g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f67870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JobCreatorHolder f67871b = new JobCreatorHolder();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JobExecutor f67872c = new JobExecutor();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile JobStorage f67873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CountDownLatch f67874e;

    private JobManager(final Context context) {
        this.f67870a = context;
        if (!JobConfig.j()) {
            JobRescheduleService.l(context);
        }
        this.f67874e = new CountDownLatch(1);
        new Thread("AndroidJob-storage-init") { // from class: com.evernote.android.job.JobManager.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                JobManager.this.f67873d = new JobStorage(context);
                JobManager.this.f67874e.countDown();
            }
        }.start();
    }

    private synchronized int f(String str) {
        int i3;
        i3 = 0;
        try {
            Iterator it = j(str, true, false).iterator();
            while (it.hasNext()) {
                if (h((JobRequest) it.next())) {
                    i3++;
                }
            }
            Iterator it2 = (TextUtils.isEmpty(str) ? l() : m(str)).iterator();
            while (it2.hasNext()) {
                if (g((Job) it2.next())) {
                    i3++;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return i3;
    }

    private boolean g(Job job) {
        if (job == null || !job.b(true)) {
            return false;
        }
        f67868f.i("Cancel running %s", job);
        return true;
    }

    private boolean h(JobRequest jobRequest) {
        if (jobRequest == null) {
            return false;
        }
        f67868f.i("Found pending job %s, canceling", jobRequest);
        r(jobRequest.n()).c(jobRequest.o());
        u().p(jobRequest);
        jobRequest.L(0L);
        return true;
    }

    public static JobManager i(Context context) {
        if (f67869g == null) {
            synchronized (JobManager.class) {
                try {
                    if (f67869g == null) {
                        JobPreconditions.g(context, "Context cannot be null");
                        if (context.getApplicationContext() != null) {
                            context = context.getApplicationContext();
                        }
                        JobApi jobApiC = JobApi.c(context);
                        if (jobApiC == JobApi.V_14 && !jobApiC.j(context)) {
                            throw new JobManagerCreateException("All APIs are disabled, cannot schedule any job");
                        }
                        f67869g = new JobManager(context);
                        if (!JobUtil.c(context)) {
                            f67868f.j("No wake lock permission");
                        }
                        if (!JobUtil.a(context)) {
                            f67868f.j("No boot permission");
                        }
                        y(context);
                    }
                } finally {
                }
            }
        }
        return f67869g;
    }

    public static JobManager v() {
        if (f67869g == null) {
            synchronized (JobManager.class) {
                try {
                    if (f67869g == null) {
                        throw new IllegalStateException("You need to call create() at least once to create the singleton");
                    }
                } finally {
                }
            }
        }
        return f67869g;
    }

    private void x(JobRequest jobRequest, JobApi jobApi, boolean z2, boolean z3) {
        JobProxy jobProxyR = r(jobApi);
        if (!z2) {
            jobProxyR.e(jobRequest);
        } else if (z3) {
            jobProxyR.d(jobRequest);
        } else {
            jobProxyR.a(jobRequest);
        }
    }

    private static void y(Context context) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        String packageName = context.getPackageName();
        Intent intent = new Intent("com.evernote.android.job.ADD_JOB_CREATOR");
        intent.setPackage(packageName);
        try {
            listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
        } catch (Exception unused) {
            listQueryBroadcastReceivers = Collections.EMPTY_LIST;
        }
        Iterator<ResolveInfo> it = listQueryBroadcastReceivers.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && !activityInfo.exported && packageName.equals(activityInfo.packageName) && !TextUtils.isEmpty(activityInfo.name)) {
                try {
                    ((JobCreator.AddJobCreatorReceiver) Class.forName(activityInfo.name).newInstance()).a(context, f67869g);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public void c(JobCreator jobCreator) {
        this.f67871b.a(jobCreator);
    }

    public boolean d(int i3) {
        boolean zH = h(t(i3, true)) | g(o(i3));
        JobProxy.Common.d(this.f67870a, i3);
        return zH;
    }

    public int e(String str) {
        return f(str);
    }

    Set j(String str, boolean z2, boolean z3) {
        Set setJ = u().j(str, z2);
        if (z3) {
            Iterator it = setJ.iterator();
            while (it.hasNext()) {
                JobRequest jobRequest = (JobRequest) it.next();
                if (jobRequest.A() && !jobRequest.n().d(this.f67870a).b(jobRequest)) {
                    u().p(jobRequest);
                    it.remove();
                }
            }
        }
        return setJ;
    }

    public Set k(String str) {
        return j(str, false, true);
    }

    public Set l() {
        return this.f67872c.e();
    }

    public Set m(String str) {
        return this.f67872c.f(str);
    }

    Context n() {
        return this.f67870a;
    }

    public Job o(int i3) {
        return this.f67872c.g(i3);
    }

    JobCreatorHolder p() {
        return this.f67871b;
    }

    JobExecutor q() {
        return this.f67872c;
    }

    JobProxy r(JobApi jobApi) {
        return jobApi.d(this.f67870a);
    }

    public JobRequest s(int i3) {
        JobRequest jobRequestT = t(i3, false);
        if (jobRequestT == null || !jobRequestT.A() || jobRequestT.n().d(this.f67870a).b(jobRequestT)) {
            return jobRequestT;
        }
        u().p(jobRequestT);
        return null;
    }

    JobRequest t(int i3, boolean z2) {
        JobRequest jobRequestI = u().i(i3);
        if (z2 || jobRequestI == null || !jobRequestI.z()) {
            return jobRequestI;
        }
        return null;
    }

    JobStorage u() {
        if (this.f67873d == null) {
            try {
                this.f67874e.await(20L, TimeUnit.SECONDS);
            } catch (InterruptedException e3) {
                throw new RuntimeException(e3);
            }
        }
        if (this.f67873d != null) {
            return this.f67873d;
        }
        throw new IllegalStateException("Job storage shouldn't be null");
    }

    public synchronized void w(JobRequest jobRequest) {
        JobApi jobApi;
        try {
            if (this.f67871b.c()) {
                f67868f.j("you haven't registered a JobCreator with addJobCreator(), it's likely that your job never will be executed");
            }
            if (jobRequest.r() > 0) {
                return;
            }
            if (jobRequest.B()) {
                e(jobRequest.t());
            }
            JobProxy.Common.d(this.f67870a, jobRequest.o());
            JobApi jobApiN = jobRequest.n();
            boolean zY = jobRequest.y();
            boolean z2 = zY && jobApiN.g() && jobRequest.l() < jobRequest.m();
            jobRequest.L(JobConfig.a().currentTimeMillis());
            jobRequest.K(z2);
            u().o(jobRequest);
            try {
                try {
                    x(jobRequest, jobApiN, zY, z2);
                } catch (Exception e3) {
                    JobApi jobApi2 = JobApi.V_14;
                    if (jobApiN == jobApi2 || jobApiN == (jobApi = JobApi.V_19)) {
                        u().p(jobRequest);
                        throw e3;
                    }
                    if (jobApi.j(this.f67870a)) {
                        jobApi2 = jobApi;
                    }
                    try {
                        x(jobRequest, jobApi2, zY, z2);
                    } catch (Exception e4) {
                        u().p(jobRequest);
                        throw e4;
                    }
                }
            } catch (JobProxyIllegalStateException unused) {
                jobApiN.e();
                x(jobRequest, jobApiN, zY, z2);
            } catch (Exception e5) {
                u().p(jobRequest);
                throw e5;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
