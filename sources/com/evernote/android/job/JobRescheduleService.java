package com.evernote.android.job;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import androidx.core.app.JobIntentService;
import androidx.core.app.SafeJobIntentService;
import com.evernote.android.job.util.JobCat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class JobRescheduleService extends SafeJobIntentService {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final JobCat f67926k = new JobCat("JobRescheduleService", false);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static CountDownLatch f67927l;

    static void l(Context context) {
        try {
            JobIntentService.d(context, JobRescheduleService.class, 2147480000, new Intent());
            f67927l = new CountDownLatch(1);
        } catch (Exception e3) {
            f67926k.f(e3);
        }
    }

    @Override // androidx.core.app.JobIntentService
    protected void h(Intent intent) {
        CountDownLatch countDownLatch;
        try {
            JobCat jobCat = f67926k;
            jobCat.b("Reschedule service started");
            SystemClock.sleep(JobConfig.d());
            if (g()) {
                jobCat.j("Job was stopped during delay, aborting onHandleWork");
                if (countDownLatch != null) {
                    return;
                } else {
                    return;
                }
            }
            try {
                JobManager jobManagerI = JobManager.i(this);
                Set setJ = jobManagerI.j(null, true, true);
                int iK = k(jobManagerI, setJ);
                if (g()) {
                    jobCat.j("Job was stopped during rescheduling, aborting onHandleWork");
                    CountDownLatch countDownLatch2 = f67927l;
                    if (countDownLatch2 != null) {
                        countDownLatch2.countDown();
                        return;
                    }
                    return;
                }
                jobCat.c("Reschedule %d jobs of %d jobs", Integer.valueOf(iK), Integer.valueOf(setJ.size()));
                CountDownLatch countDownLatch3 = f67927l;
                if (countDownLatch3 != null) {
                    countDownLatch3.countDown();
                }
            } catch (Exception unused) {
                if (f67927l != null) {
                    f67927l.countDown();
                }
            }
        } finally {
            countDownLatch = f67927l;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    int k(JobManager jobManager, Collection collection) {
        Iterator it = collection.iterator();
        int i3 = 0;
        boolean z2 = false;
        while (it.hasNext()) {
            JobRequest jobRequest = (JobRequest) it.next();
            if (g()) {
                f67926k.j("Job was stopped, aborting rescheduling");
                return i3;
            }
            if (jobRequest.z() ? jobManager.o(jobRequest.o()) == null : !jobManager.r(jobRequest.n()).b(jobRequest)) {
                try {
                    jobRequest.b().w().J();
                } catch (Exception e3) {
                    if (!z2) {
                        f67926k.f(e3);
                        z2 = true;
                    }
                }
                i3++;
            }
        }
        return i3;
    }
}
