package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.Adler32;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JobInfoScheduler implements WorkScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f69475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EventStore f69476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SchedulerConfig f69477c;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.f69475a = context;
        this.f69476b = eventStore;
        this.f69477c = schedulerConfig;
    }

    private boolean d(JobScheduler jobScheduler, int i3, int i4) {
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JobInfo next = it.next();
            int i5 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i3) {
                if (i5 >= i4) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void a(TransportContext transportContext, int i3) {
        b(transportContext, i3, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void b(TransportContext transportContext, int i3, boolean z2) {
        ComponentName componentName = new ComponentName(this.f69475a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f69475a.getSystemService("jobscheduler");
        int iC = c(transportContext);
        if (!z2 && d(jobScheduler, iC, i3)) {
            Logging.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long jZ0 = this.f69476b.Z0(transportContext);
        JobInfo.Builder builderC = this.f69477c.c(new JobInfo.Builder(iC, componentName), transportContext.d(), jZ0, i3);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i3);
        persistableBundle.putString("backendName", transportContext.b());
        persistableBundle.putInt("priority", PriorityMapping.a(transportContext.d()));
        if (transportContext.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        builderC.setExtras(persistableBundle);
        Logging.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(iC), Long.valueOf(this.f69477c.g(transportContext.d(), jZ0, i3)), Long.valueOf(jZ0), Integer.valueOf(i3));
        jobScheduler.schedule(builderC.build());
    }

    int c(TransportContext transportContext) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f69475a.getPackageName().getBytes(Charset.forName(Utf8Charset.NAME)));
        adler32.update(transportContext.b().getBytes(Charset.forName(Utf8Charset.NAME)));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.a(transportContext.d())).array());
        if (transportContext.c() != null) {
            adler32.update(transportContext.c());
        }
        return (int) adler32.getValue();
    }
}
