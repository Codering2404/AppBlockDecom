package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class StrictModeStartJob extends Job {
    public static void x() {
        JobExtKt.a(new JobRequest.Builder("STRICT_MODE_STARTED_NOW").H(true).I().w());
        Log.d(JobPlanner.class.getSimpleName(), "Job scheduled to fire right due to strict mode start");
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        JobPlanner.b().c().f(c());
        return Job.Result.SUCCESS;
    }
}
