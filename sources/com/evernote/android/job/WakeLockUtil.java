package com.evernote.android.job;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.util.JobUtil;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class WakeLockUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JobCat f67949a = new JobCat("WakeLockUtil");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SparseArray f67950b = new SparseArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f67951c = 1;

    static PowerManager.WakeLock a(Context context, String str, long j3) {
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, str);
        wakeLockNewWakeLock.setReferenceCounted(false);
        if (b(context, wakeLockNewWakeLock, j3)) {
            return wakeLockNewWakeLock;
        }
        return null;
    }

    static boolean b(Context context, PowerManager.WakeLock wakeLock, long j3) {
        if (wakeLock == null || wakeLock.isHeld() || !JobUtil.c(context)) {
            return false;
        }
        try {
            wakeLock.acquire(j3);
            return true;
        } catch (Exception e3) {
            f67949a.f(e3);
            return false;
        }
    }

    public static boolean c(Intent intent) {
        int intExtra;
        if (intent == null || (intExtra = intent.getIntExtra("com.evernote.android.job.wakelockid", 0)) == 0) {
            return false;
        }
        SparseArray sparseArray = f67950b;
        synchronized (sparseArray) {
            d((PowerManager.WakeLock) sparseArray.get(intExtra));
            sparseArray.remove(intExtra);
        }
        return true;
    }

    static void d(PowerManager.WakeLock wakeLock) {
        if (wakeLock != null) {
            try {
                if (wakeLock.isHeld()) {
                    wakeLock.release();
                }
            } catch (Exception e3) {
                f67949a.f(e3);
            }
        }
    }

    public static ComponentName e(Context context, Intent intent) {
        SparseArray sparseArray = f67950b;
        synchronized (sparseArray) {
            try {
                int i3 = f67951c;
                int i4 = i3 + 1;
                f67951c = i4;
                if (i4 <= 0) {
                    f67951c = 1;
                }
                intent.putExtra("com.evernote.android.job.wakelockid", i3);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                PowerManager.WakeLock wakeLockA = a(context, "wake:" + componentNameStartService.flattenToShortString(), TimeUnit.MINUTES.toMillis(3L));
                if (wakeLockA != null) {
                    sparseArray.put(i3, wakeLockA);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
