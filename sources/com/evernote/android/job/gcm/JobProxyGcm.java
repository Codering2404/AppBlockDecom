package com.evernote.android.job.gcm;

import android.content.Context;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobProxyIllegalStateException;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobUtil;
import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.OneoffTask;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JobProxyGcm implements JobProxy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final JobCat f67953c = new JobCat("JobProxyGcm");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f67954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final GcmNetworkManager f67955b;

    /* JADX INFO: renamed from: com.evernote.android.job.gcm.JobProxyGcm$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67956a;

        static {
            int[] iArr = new int[JobRequest.NetworkType.values().length];
            f67956a = iArr;
            try {
                iArr[JobRequest.NetworkType.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67956a[JobRequest.NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67956a[JobRequest.NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67956a[JobRequest.NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public JobProxyGcm(Context context) {
        this.f67954a = context;
        this.f67955b = GcmNetworkManager.getInstance(context);
    }

    private void j(Task task) {
        try {
            this.f67955b.schedule(task);
        } catch (IllegalArgumentException e3) {
            if (e3.getMessage() != null && e3.getMessage().startsWith("The GcmTaskService class you provided")) {
                throw new JobProxyIllegalStateException(e3);
            }
            throw e3;
        }
    }

    @Override // com.evernote.android.job.JobProxy
    public void a(JobRequest jobRequest) {
        j(i(new PeriodicTask.Builder(), jobRequest).setPeriod(jobRequest.m() / 1000).setFlex(jobRequest.l() / 1000).build());
        f67953c.c("Scheduled PeriodicTask, %s, interval %s, flex %s", jobRequest, JobUtil.d(jobRequest.m()), JobUtil.d(jobRequest.l()));
    }

    @Override // com.evernote.android.job.JobProxy
    public boolean b(JobRequest jobRequest) {
        return true;
    }

    @Override // com.evernote.android.job.JobProxy
    public void c(int i3) {
        try {
            this.f67955b.cancelTask(g(i3), PlatformGcmService.class);
        } catch (IllegalArgumentException e3) {
            if (e3.getMessage() != null && e3.getMessage().startsWith("The GcmTaskService class you provided")) {
                throw new JobProxyIllegalStateException(e3);
            }
            throw e3;
        }
    }

    @Override // com.evernote.android.job.JobProxy
    public void d(JobRequest jobRequest) {
        JobCat jobCat = f67953c;
        jobCat.j("plantPeriodicFlexSupport called although flex is supported");
        long jP = JobProxy.Common.p(jobRequest);
        long jL = JobProxy.Common.l(jobRequest);
        j(i(new OneoffTask.Builder(), jobRequest).setExecutionWindow(jP / 1000, jL / 1000).build());
        jobCat.c("Scheduled periodic (flex support), %s, start %s, end %s, flex %s", jobRequest, JobUtil.d(jP), JobUtil.d(jL), JobUtil.d(jobRequest.l()));
    }

    @Override // com.evernote.android.job.JobProxy
    public void e(JobRequest jobRequest) {
        long jO = JobProxy.Common.o(jobRequest);
        long j3 = jO / 1000;
        long j4 = JobProxy.Common.j(jobRequest);
        j(i(new OneoffTask.Builder(), jobRequest).setExecutionWindow(j3, Math.max(j4 / 1000, 1 + j3)).build());
        f67953c.c("Scheduled OneoffTask, %s, start %s, end %s (from now), reschedule count %d", jobRequest, JobUtil.d(jO), JobUtil.d(j4), Integer.valueOf(JobProxy.Common.n(jobRequest)));
    }

    protected int f(JobRequest.NetworkType networkType) {
        int i3 = AnonymousClass1.f67956a[networkType.ordinal()];
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 0;
        }
        if (i3 == 3 || i3 == 4) {
            return 1;
        }
        throw new IllegalStateException("not implemented");
    }

    protected String g(int i3) {
        return String.valueOf(i3);
    }

    protected String h(JobRequest jobRequest) {
        return g(jobRequest.o());
    }

    protected Task.Builder i(Task.Builder builder, JobRequest jobRequest) {
        builder.setTag(h(jobRequest)).setService(PlatformGcmService.class).setUpdateCurrent(true).setRequiredNetwork(f(jobRequest.C())).setPersisted(JobUtil.a(this.f67954a)).setRequiresCharging(jobRequest.F()).setExtras(jobRequest.u());
        return builder;
    }
}
