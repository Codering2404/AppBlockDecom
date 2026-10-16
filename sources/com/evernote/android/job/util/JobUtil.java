package com.evernote.android.job.util;

import android.content.Context;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class JobUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f67966a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f67967b = TimeUnit.DAYS.toMillis(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final JobCat f67968c = new JobCat("JobUtil");

    public static boolean a(Context context) {
        return b(context, "android.permission.RECEIVE_BOOT_COMPLETED", 0);
    }

    private static boolean b(Context context, String str, int i3) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception e3) {
            f67968c.f(e3);
            return i3 < 1 && b(context.getApplicationContext(), str, i3 + 1);
        }
    }

    public static boolean c(Context context) {
        return b(context, "android.permission.WAKE_LOCK", 0);
    }

    public static String d(long j3) {
        ThreadLocal threadLocal = f67966a;
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) threadLocal.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
            threadLocal.set(simpleDateFormat);
        }
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String str = simpleDateFormat.format(new Date(j3));
        long j4 = j3 / f67967b;
        if (j4 == 1) {
            return str + " (+1 day)";
        }
        if (j4 <= 1) {
            return str;
        }
        return str + " (+" + j4 + " days)";
    }
}
