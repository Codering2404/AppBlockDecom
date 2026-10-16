package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class WakeLockHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final long f89501a = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f89502b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WakeLock f89503c;

    private static void b(Context context) {
        if (f89503c == null) {
            WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f89503c = wakeLock;
            wakeLock.d(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Intent intent) {
        synchronized (f89502b) {
            try {
                if (f89503c != null && d(intent)) {
                    f(intent, false);
                    f89503c.c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static boolean d(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    static void e(Context context, WithinAppServiceConnection withinAppServiceConnection, final Intent intent) {
        synchronized (f89502b) {
            try {
                b(context);
                boolean zD = d(intent);
                f(intent, true);
                if (!zD) {
                    f89503c.a(f89501a);
                }
                withinAppServiceConnection.d(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.c0
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        WakeLockHolder.c(intent);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void f(Intent intent, boolean z2) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z2);
    }

    static ComponentName g(Context context, Intent intent) {
        synchronized (f89502b) {
            try {
                b(context);
                boolean zD = d(intent);
                f(intent, true);
                ComponentName componentNameStartService = context.startService(intent);
                if (componentNameStartService == null) {
                    return null;
                }
                if (!zD) {
                    f89503c.a(f89501a);
                }
                return componentNameStartService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
