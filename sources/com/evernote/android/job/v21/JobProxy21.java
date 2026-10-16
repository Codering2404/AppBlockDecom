package com.evernote.android.job.v21;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobProxyIllegalStateException;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobUtil;
import com.facebook.GraphResponse;
import com.facebook.login.LoginLogger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JobProxy21 implements JobProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f67994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final JobCat f67995b;

    /* JADX INFO: renamed from: com.evernote.android.job.v21.JobProxy21$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67996a;

        static {
            int[] iArr = new int[JobRequest.NetworkType.values().length];
            f67996a = iArr;
            try {
                iArr[JobRequest.NetworkType.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67996a[JobRequest.NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67996a[JobRequest.NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67996a[JobRequest.NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67996a[JobRequest.NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public JobProxy21(Context context) {
        this(context, "JobProxy21");
    }

    protected static String m(int i3) {
        return i3 == 1 ? GraphResponse.SUCCESS_KEY : LoginLogger.EVENT_EXTRAS_FAILURE;
    }

    @Override // com.evernote.android.job.JobProxy
    public void a(JobRequest jobRequest) {
        long jM = jobRequest.m();
        long jL = jobRequest.l();
        int iL = l(i(g(jobRequest, true), jM, jL).build());
        if (iL == -123) {
            iL = l(i(g(jobRequest, false), jM, jL).build());
        }
        this.f67995b.c("Schedule periodic jobInfo %s, %s, interval %s, flex %s", m(iL), jobRequest, JobUtil.d(jM), JobUtil.d(jL));
    }

    @Override // com.evernote.android.job.JobProxy
    public boolean b(JobRequest jobRequest) {
        try {
            List<JobInfo> allPendingJobs = j().getAllPendingJobs();
            if (allPendingJobs != null && !allPendingJobs.isEmpty()) {
                Iterator<JobInfo> it = allPendingJobs.iterator();
                while (it.hasNext()) {
                    if (k(it.next(), jobRequest)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e3) {
            this.f67995b.f(e3);
            return false;
        }
    }

    @Override // com.evernote.android.job.JobProxy
    public void c(int i3) {
        try {
            j().cancel(i3);
        } catch (Exception e3) {
            this.f67995b.f(e3);
        }
        TransientBundleCompat.a(this.f67994a, i3, null);
    }

    @Override // com.evernote.android.job.JobProxy
    public void d(JobRequest jobRequest) {
        long jP = JobProxy.Common.p(jobRequest);
        long jL = JobProxy.Common.l(jobRequest);
        int iL = l(h(g(jobRequest, true), jP, jL).build());
        if (iL == -123) {
            iL = l(h(g(jobRequest, false), jP, jL).build());
        }
        this.f67995b.c("Schedule periodic (flex support) jobInfo %s, %s, start %s, end %s, flex %s", m(iL), jobRequest, JobUtil.d(jP), JobUtil.d(jL), JobUtil.d(jobRequest.l()));
    }

    @Override // com.evernote.android.job.JobProxy
    public void e(JobRequest jobRequest) {
        long jO = JobProxy.Common.o(jobRequest);
        long jK = JobProxy.Common.k(jobRequest, true);
        int iL = l(h(g(jobRequest, true), jO, jK).build());
        if (iL == -123) {
            iL = l(h(g(jobRequest, false), jO, jK).build());
        }
        this.f67995b.c("Schedule one-off jobInfo %s, %s, start %s, end %s (from now), reschedule count %d", m(iL), jobRequest, JobUtil.d(jO), JobUtil.d(JobProxy.Common.k(jobRequest, false)), Integer.valueOf(JobProxy.Common.n(jobRequest)));
    }

    protected int f(JobRequest.NetworkType networkType) {
        int i3 = AnonymousClass1.f67996a[networkType.ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3 || i3 == 4) {
            return 2;
        }
        if (i3 == 5) {
            return 1;
        }
        throw new IllegalStateException("not implemented");
    }

    protected JobInfo.Builder g(JobRequest jobRequest, boolean z2) {
        return n(jobRequest, new JobInfo.Builder(jobRequest.o(), new ComponentName(this.f67994a, (Class<?>) PlatformJobService.class)).setRequiresCharging(jobRequest.F()).setRequiresDeviceIdle(jobRequest.G()).setRequiredNetworkType(f(jobRequest.C())).setPersisted(z2 && !jobRequest.A() && JobUtil.a(this.f67994a)));
    }

    protected JobInfo.Builder h(JobInfo.Builder builder, long j3, long j4) {
        return builder.setMinimumLatency(j3).setOverrideDeadline(j4);
    }

    protected JobInfo.Builder i(JobInfo.Builder builder, long j3, long j4) {
        return builder.setPeriodic(j3);
    }

    protected final JobScheduler j() {
        return (JobScheduler) this.f67994a.getSystemService("jobscheduler");
    }

    protected boolean k(JobInfo jobInfo, JobRequest jobRequest) {
        if (jobInfo == null || jobInfo.getId() != jobRequest.o()) {
            return false;
        }
        return !jobRequest.A() || TransientBundleCompat.b(this.f67994a, jobRequest.o());
    }

    protected final int l(JobInfo jobInfo) {
        JobScheduler jobSchedulerJ = j();
        if (jobSchedulerJ == null) {
            throw new JobProxyIllegalStateException("JobScheduler is null");
        }
        try {
            return jobSchedulerJ.schedule(jobInfo);
        } catch (IllegalArgumentException e3) {
            this.f67995b.f(e3);
            String message = e3.getMessage();
            if (message != null && message.contains("RECEIVE_BOOT_COMPLETED")) {
                return -123;
            }
            if (message == null || !message.contains("No such service ComponentInfo")) {
                throw e3;
            }
            throw new JobProxyIllegalStateException(e3);
        } catch (NullPointerException e4) {
            this.f67995b.f(e4);
            throw new JobProxyIllegalStateException(e4);
        }
    }

    protected JobInfo.Builder n(JobRequest jobRequest, JobInfo.Builder builder) {
        if (jobRequest.A()) {
            TransientBundleCompat.c(this.f67994a, jobRequest);
        }
        return builder;
    }

    protected JobProxy21(Context context, String str) {
        this.f67994a = context;
        this.f67995b = new JobCat(str);
    }
}
