package com.evernote.android.job;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.support.PersistableBundleCompat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DailyJob extends Job {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final JobCat f67801k = new JobCat("DailyJob");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f67802l = TimeUnit.DAYS.toMillis(1);

    /* JADX INFO: renamed from: com.evernote.android.job.DailyJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JobRequest.Builder f67803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f67804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f67805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ JobRequest.JobScheduledCallback f67806d;

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f67806d.a(DailyJob.y(this.f67803a, this.f67804b, this.f67805c), this.f67803a.f67901b, null);
            } catch (Exception e3) {
                this.f67806d.a(-1, this.f67803a.f67901b, e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum DailyJobResult {
        SUCCESS,
        CANCEL
    }

    public static int y(JobRequest.Builder builder, long j3, long j4) {
        return z(builder, true, j3, j4, false);
    }

    private static int z(JobRequest.Builder builder, boolean z2, long j3, long j4, boolean z3) {
        long j5 = f67802l;
        if (j3 >= j5 || j4 >= j5 || j3 < 0 || j4 < 0) {
            throw new IllegalArgumentException("startMs or endMs should be less than one day (in milliseconds)");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(JobConfig.a().currentTimeMillis());
        int i3 = calendar.get(11);
        int i4 = calendar.get(12);
        long millis = TimeUnit.SECONDS.toMillis(60 - calendar.get(13));
        TimeUnit timeUnit = TimeUnit.MINUTES;
        long millis2 = millis + timeUnit.toMillis(60 - i4);
        TimeUnit timeUnit2 = TimeUnit.HOURS;
        long millis3 = ((millis2 + timeUnit2.toMillis((24 - i3) % 24)) - timeUnit2.toMillis(1L)) - timeUnit.toMillis(1L);
        TimeUnit timeUnit3 = TimeUnit.DAYS;
        long millis4 = ((millis3 + timeUnit3.toMillis(1L)) + j3) % timeUnit3.toMillis(1L);
        if (z3 && millis4 < timeUnit2.toMillis(12L)) {
            millis4 += timeUnit3.toMillis(1L);
        }
        if (j3 > j4) {
            j4 += timeUnit3.toMillis(1L);
        }
        long j6 = (j4 - j3) + millis4;
        PersistableBundleCompat persistableBundleCompat = new PersistableBundleCompat();
        persistableBundleCompat.j("EXTRA_START_MS", j3);
        persistableBundleCompat.j("EXTRA_END_MS", j4);
        builder.v(persistableBundleCompat);
        if (z2) {
            JobManager jobManagerV = JobManager.v();
            for (JobRequest jobRequest : new HashSet(jobManagerV.k(builder.f67901b))) {
                if (!jobRequest.w() || jobRequest.s() != 1) {
                    jobManagerV.d(jobRequest.o());
                }
            }
        }
        JobRequest jobRequestW = builder.A(Math.max(1L, millis4), Math.max(1L, j6)).w();
        if (z2 && (jobRequestW.w() || jobRequestW.y() || jobRequestW.A())) {
            throw new IllegalArgumentException("Daily jobs cannot be exact, periodic or transient");
        }
        return jobRequestW.J();
    }

    @Override // com.evernote.android.job.Job
    protected final Job.Result t(Job.Params params) {
        DailyJobResult dailyJobResultX;
        PersistableBundleCompat persistableBundleCompatA = params.a();
        boolean zC = persistableBundleCompatA.c("EXTRA_ONCE", false);
        if (!zC && (!persistableBundleCompatA.a("EXTRA_START_MS") || !persistableBundleCompatA.a("EXTRA_END_MS"))) {
            f67801k.d("Daily job doesn't contain start and end time");
            return Job.Result.FAILURE;
        }
        DailyJobResult dailyJobResult = null;
        try {
            if (p(true)) {
                dailyJobResultX = x(params);
            } else {
                DailyJobResult dailyJobResult2 = DailyJobResult.SUCCESS;
                f67801k.h("Daily job requirements not met, reschedule for the next day");
                dailyJobResultX = dailyJobResult2;
            }
            if (dailyJobResultX == null) {
                dailyJobResultX = DailyJobResult.SUCCESS;
                f67801k.d("Daily job result was null");
            }
            if (!zC) {
                JobRequest jobRequestC = params.c();
                if (dailyJobResultX == DailyJobResult.SUCCESS) {
                    f67801k.i("Rescheduling daily job %s", jobRequestC);
                    try {
                        JobRequest.Builder builderD = jobRequestC.d();
                        long jE = persistableBundleCompatA.e("EXTRA_START_MS", 0L);
                        long j3 = f67802l;
                        JobRequest jobRequestS = JobManager.v().s(z(builderD, false, jE % j3, persistableBundleCompatA.e("EXTRA_END_MS", 0L) % j3, true));
                        if (jobRequestS != null) {
                            jobRequestS.O(false, true);
                        }
                    } catch (PermissionException unused) {
                        return Job.Result.FAILURE;
                    }
                } else {
                    f67801k.i("Cancel daily job %s", jobRequestC);
                }
            }
            return Job.Result.SUCCESS;
        } catch (Throwable th) {
            if (0 == 0) {
                dailyJobResult = DailyJobResult.SUCCESS;
                f67801k.d("Daily job result was null");
            }
            if (!zC) {
                JobRequest jobRequestC2 = params.c();
                if (dailyJobResult == DailyJobResult.SUCCESS) {
                    f67801k.i("Rescheduling daily job %s", jobRequestC2);
                    try {
                        JobRequest.Builder builderD2 = jobRequestC2.d();
                        long jE2 = persistableBundleCompatA.e("EXTRA_START_MS", 0L);
                        long j4 = f67802l;
                        JobRequest jobRequestS2 = JobManager.v().s(z(builderD2, false, jE2 % j4, persistableBundleCompatA.e("EXTRA_END_MS", 0L) % j4, true));
                        if (jobRequestS2 != null) {
                            jobRequestS2.O(false, true);
                        }
                    } catch (PermissionException unused2) {
                        return Job.Result.FAILURE;
                    }
                } else {
                    f67801k.i("Cancel daily job %s", jobRequestC2);
                }
            }
            throw th;
        }
    }

    protected abstract DailyJobResult x(Job.Params params);
}
