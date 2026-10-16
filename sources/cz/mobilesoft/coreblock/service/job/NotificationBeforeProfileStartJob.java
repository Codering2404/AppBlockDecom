package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class NotificationBeforeProfileStartJob extends Job {
    public static void x(long j3, long j4) {
        PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
        persistableBundleCompat.j("INTERVAL_ID", j3);
        JobExtKt.a(new JobRequest.Builder("TAG_BEFORE_PROFILE_START_JOB_" + j3).H(true).B(persistableBundleCompat).z(j4).w());
        Log.d(JobPlanner.class.getSimpleName(), "Job for before profile start scheduled to fire in " + j4 + " for interval " + j3);
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        long jE = params.a().e("INTERVAL_ID", -1L);
        Log.d(JobPlanner.class.getSimpleName(), "Job fired for before profile start for interval " + jE);
        if (jE != -1) {
            JobPlanner.b().c().e(c(), jE);
        }
        return Job.Result.SUCCESS;
    }
}
