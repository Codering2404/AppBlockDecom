package com.evernote.android.job;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.evernote.android.job.gcm.JobProxyGcm;
import com.evernote.android.job.v14.JobProxy14;
import com.evernote.android.job.v14.PlatformAlarmReceiver;
import com.evernote.android.job.v14.PlatformAlarmService;
import com.evernote.android.job.v14.PlatformAlarmServiceExact;
import com.evernote.android.job.v19.JobProxy19;
import com.evernote.android.job.v21.JobProxy21;
import com.evernote.android.job.v21.PlatformJobService;
import com.evernote.android.job.v24.JobProxy24;
import com.evernote.android.job.v26.JobProxy26;
import com.evernote.android.job.work.JobProxyWorkManager;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum JobApi {
    WORK_MANAGER(true, false, true),
    V_26(true, false, true),
    V_24(true, false, false),
    V_21(true, true, false),
    V_19(true, true, true),
    V_14(false, true, true),
    GCM(true, false, true);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile JobProxy f67839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f67840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f67841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f67842d;

    /* JADX INFO: renamed from: com.evernote.android.job.JobApi$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67843a;

        static {
            int[] iArr = new int[JobApi.values().length];
            f67843a = iArr;
            try {
                iArr[JobApi.WORK_MANAGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67843a[JobApi.V_26.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67843a[JobApi.V_21.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67843a[JobApi.V_24.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67843a[JobApi.V_19.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f67843a[JobApi.V_14.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f67843a[JobApi.GCM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    JobApi(boolean z2, boolean z3, boolean z4) {
        this.f67840b = z2;
        this.f67841c = z3;
        this.f67842d = z4;
    }

    private JobProxy b(Context context) {
        switch (AnonymousClass1.f67843a[ordinal()]) {
            case 1:
                return new JobProxyWorkManager(context);
            case 2:
                return new JobProxy26(context);
            case 3:
                return new JobProxy21(context);
            case 4:
                return new JobProxy24(context);
            case 5:
                return new JobProxy19(context);
            case 6:
                return new JobProxy14(context);
            case 7:
                return new JobProxyGcm(context);
            default:
                throw new IllegalStateException("not implemented");
        }
    }

    public static JobApi c(Context context) {
        JobApi jobApi = WORK_MANAGER;
        if (jobApi.j(context) && JobConfig.f(jobApi)) {
            return jobApi;
        }
        JobApi jobApi2 = V_26;
        if (jobApi2.j(context) && JobConfig.f(jobApi2)) {
            return jobApi2;
        }
        JobApi jobApi3 = V_24;
        if (jobApi3.j(context) && JobConfig.f(jobApi3)) {
            return jobApi3;
        }
        JobApi jobApi4 = V_21;
        if (jobApi4.j(context) && JobConfig.f(jobApi4)) {
            return jobApi4;
        }
        JobApi jobApi5 = GCM;
        if (jobApi5.j(context) && JobConfig.f(jobApi5)) {
            return jobApi5;
        }
        JobApi jobApi6 = V_19;
        if (jobApi6.j(context) && JobConfig.f(jobApi6)) {
            return jobApi6;
        }
        JobApi jobApi7 = V_14;
        if (JobConfig.f(jobApi7)) {
            return jobApi7;
        }
        throw new IllegalStateException("All supported APIs are disabled");
    }

    private boolean f(Context context, Class cls) {
        try {
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(new Intent(context, (Class<?>) cls), 0);
            if (listQueryBroadcastReceivers != null) {
                if (!listQueryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private boolean h(Context context, Class cls) {
        try {
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context, (Class<?>) cls), 0);
            if (listQueryIntentServices != null) {
                if (!listQueryIntentServices.isEmpty()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean i(Context context, Class cls, String str) {
        try {
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context, (Class<?>) cls), 0);
            if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
                Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
                while (it.hasNext()) {
                    ServiceInfo serviceInfo = it.next().serviceInfo;
                    if (serviceInfo != null && str.equals(serviceInfo.permission)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    synchronized JobProxy d(Context context) {
        try {
            if (this.f67839a == null) {
                this.f67839a = b(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f67839a;
    }

    public synchronized void e() {
        this.f67839a = null;
    }

    boolean g() {
        return this.f67841c;
    }

    public boolean j(Context context) {
        switch (AnonymousClass1.f67843a[ordinal()]) {
            case 1:
                return WorkManagerAvailableHelper.a();
            case 2:
                return h(context, PlatformJobService.class);
            case 3:
            case 4:
                return i(context, PlatformJobService.class, "android.permission.BIND_JOB_SERVICE");
            case 5:
                return h(context, PlatformAlarmService.class) && f(context, PlatformAlarmReceiver.class);
            case 6:
                return JobConfig.h() || (h(context, PlatformAlarmService.class) && h(context, PlatformAlarmServiceExact.class) && f(context, PlatformAlarmReceiver.class));
            case 7:
                try {
                    return GcmAvailableHelper.c(context);
                } catch (Exception unused) {
                    return false;
                }
            default:
                throw new IllegalStateException("not implemented");
        }
    }

    boolean k() {
        return this.f67840b;
    }
}
