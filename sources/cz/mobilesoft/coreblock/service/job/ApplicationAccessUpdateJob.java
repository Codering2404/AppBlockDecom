package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;
import cz.mobilesoft.coreblock.util.UsageAccessHelper;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class ApplicationAccessUpdateJob extends Job {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f123155k = TimeUnit.HOURS.toMillis(12);

    public static void x() {
        if (!JobManager.v().m("TAG_APPLICATION_ACCESS_UPDATE").isEmpty()) {
            Log.d(JobPlanner.class.getSimpleName(), "Job already scheduled to update application access, skipping");
            return;
        }
        JobRequest.Builder builder = new JobRequest.Builder("TAG_APPLICATION_ACCESS_UPDATE");
        long j3 = f123155k;
        JobExtKt.a(builder.C(j3).H(true).w());
        Log.d(JobPlanner.class.getSimpleName(), "Job scheduled to update application access periodically after " + j3 + " ms");
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        UsageAccessHelper.q(c().getApplicationContext());
        return Job.Result.SUCCESS;
    }
}
