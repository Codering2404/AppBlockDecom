package com.evernote.android.job.v21;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import com.evernote.android.job.JobRequest;
import com.evernote.android.job.PendingIntentUtil;
import com.evernote.android.job.util.JobCat;
import com.evernote.android.job.v14.PlatformAlarmServiceExact;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class TransientBundleCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final JobCat f68000a = new JobCat("TransientBundleCompat");

    public static void a(Context context, int i3, PendingIntent pendingIntent) {
        if (pendingIntent == null) {
            try {
                pendingIntent = PendingIntent.getService(context, i3, PlatformAlarmServiceExact.c(context, i3, null), PendingIntentUtil.a() | 536870912);
                if (pendingIntent == null) {
                    return;
                }
            } catch (Exception e3) {
                f68000a.f(e3);
                return;
            }
        }
        ((AlarmManager) context.getSystemService("alarm")).cancel(pendingIntent);
        pendingIntent.cancel();
    }

    public static boolean b(Context context, int i3) {
        return PendingIntent.getService(context, i3, PlatformAlarmServiceExact.c(context, i3, null), 536870912 | PendingIntentUtil.a()) != null;
    }

    public static void c(Context context, JobRequest jobRequest) {
        PendingIntent service = PendingIntent.getService(context, jobRequest.o(), PlatformAlarmServiceExact.c(context, jobRequest.o(), jobRequest.u()), 134217728 | PendingIntentUtil.a());
        ((AlarmManager) context.getSystemService("alarm")).setExact(1, System.currentTimeMillis() + TimeUnit.DAYS.toMillis(1000L), service);
    }

    public static boolean d(Context context, JobRequest jobRequest) {
        PendingIntent service = PendingIntent.getService(context, jobRequest.o(), PlatformAlarmServiceExact.c(context, jobRequest.o(), null), 536870912 | PendingIntentUtil.a());
        if (service == null) {
            return false;
        }
        try {
            f68000a.i("Delegating transient job %s to API 14", jobRequest);
            service.send();
            if (jobRequest.y()) {
                return true;
            }
            a(context, jobRequest.o(), service);
            return true;
        } catch (PendingIntent.CanceledException e3) {
            f68000a.f(e3);
            return false;
        }
    }
}
