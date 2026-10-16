package com.google.android.gms.internal.gtm;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfx {
    private static final Method zza;
    private static final Method zzb;

    static {
        Method declaredMethod;
        Method declaredMethod2 = null;
        try {
            declaredMethod = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", JobInfo.class, String.class, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            if (Log.isLoggable("JobSchedulerCompat", 6)) {
                Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
            }
            declaredMethod = null;
        }
        zza = declaredMethod;
        try {
            declaredMethod2 = UserHandle.class.getDeclaredMethod("myUserId", null);
        } catch (NoSuchMethodException unused2) {
            if (Log.isLoggable("JobSchedulerCompat", 6)) {
                Log.e("JobSchedulerCompat", "No myUserId method available");
            }
        }
        zzb = declaredMethod2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zza(android.content.Context r3, android.app.job.JobInfo r4, java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r5 = "jobscheduler"
            java.lang.Object r5 = r3.getSystemService(r5)
            android.app.job.JobScheduler r5 = (android.app.job.JobScheduler) r5
            r5.getClass()
            java.lang.reflect.Method r6 = com.google.android.gms.internal.gtm.zzfx.zza
            if (r6 == 0) goto L6d
            java.lang.String r6 = "android.permission.UPDATE_DEVICE_STATS"
            int r3 = r3.checkSelfPermission(r6)
            if (r3 == 0) goto L18
            goto L6d
        L18:
            java.lang.reflect.Method r3 = com.google.android.gms.internal.gtm.zzfx.zzb
            r6 = 0
            if (r3 == 0) goto L31
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            r1 = 0
            java.lang.Object r3 = r3.invoke(r0, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            if (r3 == 0) goto L31
            int r3 = r3.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L2d java.lang.IllegalAccessException -> L2f
            goto L42
        L2d:
            r3 = move-exception
            goto L33
        L2f:
            r3 = move-exception
            goto L33
        L31:
            r3 = r6
            goto L42
        L33:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L31
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r3)
            goto L31
        L42:
            java.lang.String r0 = "DispatchAlarm"
            r1 = 0
            java.lang.String r1 = androidx.media3.common.JBEE.bfIdKSjLOVjG.wvDgIgrZeQDu
            java.lang.reflect.Method r2 = com.google.android.gms.internal.gtm.zzfx.zza
            if (r2 == 0) goto L68
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L60 java.lang.IllegalAccessException -> L62
            java.lang.Object[] r3 = new java.lang.Object[]{r4, r1, r3, r0}     // Catch: java.lang.reflect.InvocationTargetException -> L60 java.lang.IllegalAccessException -> L62
            java.lang.Object r3 = r2.invoke(r5, r3)     // Catch: java.lang.reflect.InvocationTargetException -> L60 java.lang.IllegalAccessException -> L62
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.reflect.InvocationTargetException -> L60 java.lang.IllegalAccessException -> L62
            if (r3 == 0) goto L6c
            int r6 = r3.intValue()     // Catch: java.lang.reflect.InvocationTargetException -> L60 java.lang.IllegalAccessException -> L62
            goto L6c
        L60:
            r3 = move-exception
            goto L63
        L62:
            r3 = move-exception
        L63:
            java.lang.String r6 = "error calling scheduleAsPackage"
            android.util.Log.e(r0, r6, r3)
        L68:
            int r6 = r5.schedule(r4)
        L6c:
            return r6
        L6d:
            int r3 = r5.schedule(r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfx.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
