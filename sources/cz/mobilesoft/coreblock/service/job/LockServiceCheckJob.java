package cz.mobilesoft.coreblock.service.job;

import android.util.Log;
import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.superwall.sdk.billing.BillingClientUseCaseKt;
import cz.mobilesoft.coreblock.util.helperextension.JobExtKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class LockServiceCheckJob extends Job {
    public static void x() {
        JobExtKt.a(new JobRequest.Builder("LOCK_SERVICE_CHECK_NOW").H(true).I().w());
    }

    public static void y() {
        JobExtKt.a(new JobRequest.Builder("LOCK_SERVICE_CHECK").C(BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS).H(true).w());
        Log.d(JobPlanner.class.getSimpleName(), "Job scheduled to check and restart lockservice after 900000 ms");
    }

    @Override // com.evernote.android.job.Job
    protected Job.Result t(Job.Params params) {
        JobPlanner.b().c().h(c(), params.d());
        return Job.Result.SUCCESS;
    }
}
