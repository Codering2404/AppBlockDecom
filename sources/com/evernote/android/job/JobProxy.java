package com.evernote.android.job;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.evernote.android.job.util.JobCat;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface JobProxy {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Common {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final Object f67877e = new Object();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f67878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f67879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final JobCat f67880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JobManager f67881d;

        public Common(Context context, JobCat jobCat, int i3) {
            JobManager jobManagerI;
            this.f67878a = context;
            this.f67879b = i3;
            this.f67880c = jobCat;
            try {
                jobManagerI = JobManager.i(context);
            } catch (JobManagerCreateException e3) {
                this.f67880c.f(e3);
                jobManagerI = null;
            }
            this.f67881d = jobManagerI;
        }

        private static long a(long j3, boolean z2) {
            if (z2) {
                return j3;
            }
            return Long.MAX_VALUE;
        }

        private static long b(long j3, long j4) {
            long j5 = j3 + j4;
            return a(j5, ((j4 ^ j3) < 0) | ((j3 ^ j5) >= 0));
        }

        private static long c(long j3, long j4) {
            int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j3) + Long.numberOfLeadingZeros(j4) + Long.numberOfLeadingZeros(~j4);
            if (iNumberOfLeadingZeros > 65) {
                return j3 * j4;
            }
            long jA = a(a(j3 * j4, iNumberOfLeadingZeros >= 64), (j3 >= 0) | (j4 != Long.MIN_VALUE));
            return a(jA, j3 == 0 || jA / j3 == j4);
        }

        static void d(Context context, int i3) {
            for (JobApi jobApi : JobApi.values()) {
                if (jobApi.j(context)) {
                    try {
                        jobApi.d(context).c(i3);
                    } catch (Exception unused) {
                    }
                }
            }
        }

        private void e(boolean z2) {
            if (z2) {
                d(this.f67878a, this.f67879b);
            }
        }

        public static boolean f(Intent intent) {
            return WakeLockUtil.c(intent);
        }

        public static long h(JobRequest jobRequest) {
            return b(o(jobRequest), (j(jobRequest) - o(jobRequest)) / 2);
        }

        public static long i(JobRequest jobRequest) {
            return b(p(jobRequest), (l(jobRequest) - p(jobRequest)) / 2);
        }

        public static long j(JobRequest jobRequest) {
            return k(jobRequest, false);
        }

        public static long k(JobRequest jobRequest, boolean z2) {
            long jG = jobRequest.k() > 0 ? jobRequest.g(true) : jobRequest.i();
            return (z2 && jobRequest.D() && jobRequest.v()) ? c(jG, 100L) : jG;
        }

        public static long l(JobRequest jobRequest) {
            return jobRequest.m();
        }

        public static int n(JobRequest jobRequest) {
            return jobRequest.k();
        }

        public static long o(JobRequest jobRequest) {
            return jobRequest.k() > 0 ? jobRequest.g(false) : jobRequest.s();
        }

        public static long p(JobRequest jobRequest) {
            return Math.max(1L, jobRequest.m() - jobRequest.l());
        }

        public static ComponentName r(Context context, Intent intent) {
            return WakeLockUtil.e(context, intent);
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x0146 A[Catch: all -> 0x00ad, TryCatch #2 {all -> 0x00ad, blocks: (B:13:0x0094, B:15:0x00a8, B:23:0x00b8, B:24:0x00ba, B:26:0x00c2, B:40:0x00f9, B:54:0x013f, B:56:0x0146, B:57:0x0154), top: B:80:0x0094 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.evernote.android.job.Job.Result g(com.evernote.android.job.JobRequest r7, android.os.Bundle r8) {
            /*
                Method dump skipped, instruction units count: 448
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.evernote.android.job.JobProxy.Common.g(com.evernote.android.job.JobRequest, android.os.Bundle):com.evernote.android.job.Job$Result");
        }

        public void q(JobRequest jobRequest) {
            this.f67881d.q().j(jobRequest);
        }

        public JobRequest m(boolean z2, boolean z3) {
            synchronized (f67877e) {
                try {
                    JobManager jobManager = this.f67881d;
                    if (jobManager == null) {
                        return null;
                    }
                    boolean z4 = true;
                    JobRequest jobRequestT = jobManager.t(this.f67879b, true);
                    Job jobO = this.f67881d.o(this.f67879b);
                    if (jobRequestT == null || !jobRequestT.y()) {
                        z4 = false;
                    }
                    if (jobO != null && !jobO.h()) {
                        this.f67880c.c("Job %d is already running, %s", Integer.valueOf(this.f67879b), jobRequestT);
                        return null;
                    }
                    if (jobO != null && !z4) {
                        this.f67880c.c("Job %d already finished, %s", Integer.valueOf(this.f67879b), jobRequestT);
                        e(z2);
                        return null;
                    }
                    if (jobO != null && System.currentTimeMillis() - jobO.d() < 2000) {
                        this.f67880c.c("Job %d is periodic and just finished, %s", Integer.valueOf(this.f67879b), jobRequestT);
                        return null;
                    }
                    if (jobRequestT != null && jobRequestT.z()) {
                        this.f67880c.c(MHoiDDglUlPJC.DHqhQv, Integer.valueOf(this.f67879b), jobRequestT);
                        return null;
                    }
                    if (jobRequestT != null && this.f67881d.q().h(jobRequestT)) {
                        this.f67880c.c("Request %d is in the queue to start, %s", Integer.valueOf(this.f67879b), jobRequestT);
                        return null;
                    }
                    if (jobRequestT == null) {
                        this.f67880c.c("Request for ID %d was null", Integer.valueOf(this.f67879b));
                        e(z2);
                        return null;
                    }
                    if (z3) {
                        q(jobRequestT);
                    }
                    return jobRequestT;
                } finally {
                }
            }
        }
    }

    void a(JobRequest jobRequest);

    boolean b(JobRequest jobRequest);

    void c(int i3);

    void d(JobRequest jobRequest);

    void e(JobRequest jobRequest);
}
