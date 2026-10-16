package androidx.core.app;

import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.JobIntentService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SafeJobServiceEngineImpl extends JobServiceEngine implements JobIntentService.CompatJobEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final JobIntentService f33812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f33813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    JobParameters f33814c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class WrapperWorkItem implements JobIntentService.GenericWorkItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final JobWorkItem f33815a;

        WrapperWorkItem(JobWorkItem jobWorkItem) {
            this.f33815a = jobWorkItem;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void b() {
            synchronized (SafeJobServiceEngineImpl.this.f33813b) {
                JobParameters jobParameters = SafeJobServiceEngineImpl.this.f33814c;
                if (jobParameters != null) {
                    try {
                        jobParameters.completeWork(this.f33815a);
                    } catch (IllegalArgumentException | SecurityException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.f33815a.getIntent();
        }
    }

    SafeJobServiceEngineImpl(JobIntentService jobIntentService) {
        super(jobIntentService);
        this.f33813b = new Object();
        this.f33812a = jobIntentService;
    }

    @Override // androidx.core.app.JobIntentService.CompatJobEngine
    public IBinder a() {
        return getBinder();
    }

    @Override // androidx.core.app.JobIntentService.CompatJobEngine
    public JobIntentService.GenericWorkItem b() {
        JobWorkItem jobWorkItemDequeueWork;
        synchronized (this.f33813b) {
            JobParameters jobParameters = this.f33814c;
            if (jobParameters == null) {
                return null;
            }
            try {
                jobWorkItemDequeueWork = jobParameters.dequeueWork();
            } catch (SecurityException e3) {
                e3.printStackTrace();
                jobWorkItemDequeueWork = null;
            }
            if (jobWorkItemDequeueWork == null) {
                return null;
            }
            jobWorkItemDequeueWork.getIntent().setExtrasClassLoader(this.f33812a.getClassLoader());
            return new WrapperWorkItem(jobWorkItemDequeueWork);
        }
    }

    @Override // android.app.job.JobServiceEngine
    public boolean onStartJob(JobParameters jobParameters) {
        this.f33814c = jobParameters;
        this.f33812a.e(false);
        return true;
    }

    @Override // android.app.job.JobServiceEngine
    public boolean onStopJob(JobParameters jobParameters) {
        boolean zB = this.f33812a.b();
        synchronized (this.f33813b) {
            this.f33814c = null;
        }
        return zB;
    }
}
