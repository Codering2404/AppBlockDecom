package com.evernote.android.job.v21;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Bundle;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobConfig;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PlatformJobService extends JobService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JobCat f67997a = new JobCat("PlatformJobService");

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle c(JobParameters jobParameters) {
        return jobParameters.getTransientExtras();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        JobConfig.b().execute(new Runnable() { // from class: com.evernote.android.job.v21.PlatformJobService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JobProxy.Common common = new JobProxy.Common(PlatformJobService.this, PlatformJobService.f67997a, jobParameters.getJobId());
                    JobRequest jobRequestM = common.m(true, false);
                    if (jobRequestM != null) {
                        if (jobRequestM.A() && TransientBundleCompat.d(PlatformJobService.this, jobRequestM)) {
                            PlatformJobService.f67997a.c("PendingIntent for transient bundle is not null although running on O, using compat mode, request %s", jobRequestM);
                        } else {
                            common.q(jobRequestM);
                            common.g(jobRequestM, PlatformJobService.this.c(jobParameters));
                        }
                    }
                    PlatformJobService.this.jobFinished(jobParameters, false);
                } catch (Throwable th) {
                    PlatformJobService.this.jobFinished(jobParameters, false);
                    throw th;
                }
            }
        });
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        Job jobO = JobManager.i(this).o(jobParameters.getJobId());
        if (jobO == null) {
            f67997a.c("Called onStopJob, job %d not found", Integer.valueOf(jobParameters.getJobId()));
            return false;
        }
        jobO.a();
        f67997a.c("Called onStopJob for %s", jobO);
        return false;
    }
}
