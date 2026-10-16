package com.evernote.android.job;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import com.evernote.android.job.gcm.JobProxyGcm;
import com.evernote.android.job.util.JobCat;
import com.google.android.gms.common.GoogleApiAvailability;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class GcmAvailableHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f67811b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f67813d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JobCat f67810a = new JobCat("GcmAvailableHelper");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f67812c = -1;

    static {
        boolean z2;
        try {
            Class.forName("com.google.android.gms.gcm.GcmNetworkManager");
            z2 = true;
        } catch (Throwable unused) {
            z2 = false;
        }
        f67811b = z2;
    }

    private static String a() {
        return JobProxyGcm.class.getPackage().getName() + ".PlatformGcmService";
    }

    private static boolean b(List list) {
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ResolveInfo resolveInfo = (ResolveInfo) it.next();
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null && "com.google.android.gms.permission.BIND_NETWORK_TASK_SERVICE".equals(serviceInfo.permission) && resolveInfo.serviceInfo.exported) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        try {
            if (!f67813d) {
                f67813d = true;
                e(context, f67811b);
            }
            if (f67811b && GoogleApiAvailability.q().i(context) == 0) {
                if (d(context) == 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static int d(Context context) {
        if (f67812c < 0) {
            synchronized (JobApi.class) {
                try {
                    if (f67812c < 0) {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(context, a()));
                        if (!b(context.getPackageManager().queryIntentServices(intent, 0))) {
                            f67812c = 1;
                            return 1;
                        }
                        Intent intent2 = new Intent("com.google.android.gms.gcm.ACTION_TASK_READY");
                        intent2.setPackage(context.getPackageName());
                        if (!b(context.getPackageManager().queryIntentServices(intent2, 0))) {
                            f67812c = 1;
                            return 1;
                        }
                        f67812c = 0;
                    }
                } finally {
                }
            }
        }
        return f67812c;
    }

    private static void e(Context context, boolean z2) {
        try {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, a());
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
            if (componentEnabledSetting != 0) {
                if (componentEnabledSetting == 1) {
                    if (z2) {
                        return;
                    }
                    packageManager.setComponentEnabledSetting(componentName, 2, 1);
                    f67810a.h("GCM service disabled");
                    return;
                }
                if (componentEnabledSetting != 2) {
                    return;
                }
            }
            if (z2) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
                f67810a.h("GCM service enabled");
            }
        } catch (Throwable unused) {
        }
    }
}
