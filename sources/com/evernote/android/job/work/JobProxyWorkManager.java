package com.evernote.android.job.work;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.evernote.android.job.JobProxy;
import com.evernote.android.job.JobProxyIllegalStateException;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.util.JobCat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class JobProxyWorkManager implements JobProxy {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final JobCat f68003b = new JobCat("JobProxyWork");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f68004a;

    /* JADX INFO: renamed from: com.evernote.android.job.work.JobProxyWorkManager$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f68005a;

        static {
            int[] iArr = new int[JobRequest.NetworkType.values().length];
            f68005a = iArr;
            try {
                iArr[JobRequest.NetworkType.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68005a[JobRequest.NetworkType.METERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f68005a[JobRequest.NetworkType.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f68005a[JobRequest.NetworkType.UNMETERED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f68005a[JobRequest.NetworkType.NOT_ROAMING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public JobProxyWorkManager(Context context) {
        this.f68004a = context;
    }

    private static Constraints f(JobRequest jobRequest) {
        Constraints.Builder builderB = new Constraints.Builder().c(jobRequest.E()).d(jobRequest.F()).f(jobRequest.H()).b(k(jobRequest.C()));
        builderB.e(jobRequest.G());
        return builderB.a();
    }

    static String g(int i3) {
        return "android-job-" + i3;
    }

    static int h(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.startsWith("android-job-")) {
                return Integer.parseInt(str.substring(12));
            }
        }
        return -1;
    }

    private WorkManager i() {
        WorkManager workManagerH;
        try {
            workManagerH = WorkManager.h(this.f68004a);
        } catch (Throwable unused) {
            workManagerH = null;
        }
        if (workManagerH == null) {
            try {
                WorkManager.l(this.f68004a, new Configuration.Builder().a());
                workManagerH = WorkManager.h(this.f68004a);
            } catch (Throwable unused2) {
            }
            f68003b.k("WorkManager getInstance() returned null, now: %s", workManagerH);
        }
        return workManagerH;
    }

    private List j(String str) {
        WorkManager workManagerI = i();
        if (workManagerI == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            return (List) workManagerI.j(str).get(5L, TimeUnit.SECONDS);
        } catch (Exception unused) {
            return Collections.EMPTY_LIST;
        }
    }

    private static NetworkType k(JobRequest.NetworkType networkType) {
        int i3 = AnonymousClass1.f68005a[networkType.ordinal()];
        if (i3 == 1) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i3 == 2) {
            return NetworkType.METERED;
        }
        if (i3 == 3) {
            return NetworkType.CONNECTED;
        }
        if (i3 == 4) {
            return NetworkType.UNMETERED;
        }
        if (i3 == 5) {
            return NetworkType.NOT_ROAMING;
        }
        throw new IllegalStateException("Not implemented");
    }

    @Override // com.evernote.android.job.JobProxy
    public void a(JobRequest jobRequest) {
        long jM = jobRequest.m();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        PeriodicWorkRequest periodicWorkRequest = (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(PlatformWorker.class, jM, timeUnit, jobRequest.l(), timeUnit).i(f(jobRequest))).a(g(jobRequest.o()))).b();
        WorkManager workManagerI = i();
        if (workManagerI == null) {
            throw new JobProxyIllegalStateException("WorkManager is null");
        }
        workManagerI.c(periodicWorkRequest);
    }

    @Override // com.evernote.android.job.JobProxy
    public boolean b(JobRequest jobRequest) {
        List listJ = j(g(jobRequest.o()));
        return (listJ == null || listJ.isEmpty() || ((WorkInfo) listJ.get(0)).a() != WorkInfo.State.ENQUEUED) ? false : true;
    }

    @Override // com.evernote.android.job.JobProxy
    public void c(int i3) {
        WorkManager workManagerI = i();
        if (workManagerI == null) {
            return;
        }
        workManagerI.a(g(i3));
        TransientBundleHolder.a(i3);
    }

    @Override // com.evernote.android.job.JobProxy
    public void d(JobRequest jobRequest) {
        f68003b.j("plantPeriodicFlexSupport called although flex is supported");
        a(jobRequest);
    }

    @Override // com.evernote.android.job.JobProxy
    public void e(JobRequest jobRequest) {
        if (jobRequest.A()) {
            TransientBundleHolder.c(jobRequest.o(), jobRequest.u());
        }
        OneTimeWorkRequest oneTimeWorkRequest = (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(PlatformWorker.class).k(jobRequest.s(), TimeUnit.MILLISECONDS)).i(f(jobRequest))).a(g(jobRequest.o()))).b();
        WorkManager workManagerI = i();
        if (workManagerI == null) {
            throw new JobProxyIllegalStateException("WorkManager is null");
        }
        workManagerI.c(oneTimeWorkRequest);
    }
}
