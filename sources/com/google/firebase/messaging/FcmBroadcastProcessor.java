package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FcmBroadcastProcessor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f89378c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WithinAppServiceConnection f89379d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f89381b = new androidx.credentials.c();

    public FcmBroadcastProcessor(Context context) {
        this.f89380a = context;
    }

    public static /* synthetic */ Task a(Context context, Intent intent, boolean z2, Task task) {
        return (PlatformVersion.e() && ((Integer) task.getResult()).intValue() == 402) ? e(context, intent, z2).continueWith(new androidx.credentials.c(), new Continuation() { // from class: com.google.firebase.messaging.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return Integer.valueOf(RCHTTPStatusCodes.FORBIDDEN);
            }
        }) : task;
    }

    public static /* synthetic */ Integer c(Task task) {
        return -1;
    }

    private static Task e(Context context, Intent intent, boolean z2) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        WithinAppServiceConnection withinAppServiceConnectionF = f(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z2) {
            return withinAppServiceConnectionF.d(intent).continueWith(new androidx.credentials.c(), new Continuation() { // from class: com.google.firebase.messaging.f
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    return FcmBroadcastProcessor.c(task);
                }
            });
        }
        if (ServiceStarter.b().e(context)) {
            WakeLockHolder.e(context, withinAppServiceConnectionF, intent);
        } else {
            withinAppServiceConnectionF.d(intent);
        }
        return Tasks.forResult(-1);
    }

    private static WithinAppServiceConnection f(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (f89378c) {
            try {
                if (f89379d == null) {
                    f89379d = new WithinAppServiceConnection(context, str);
                }
                withinAppServiceConnection = f89379d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return withinAppServiceConnection;
    }

    public Task g(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return h(this.f89380a, intent);
    }

    public Task h(final Context context, final Intent intent) {
        boolean z2 = PlatformVersion.e() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z3 = (intent.getFlags() & 268435456) != 0;
        return (!z2 || z3) ? Tasks.call(this.f89381b, new Callable() { // from class: com.google.firebase.messaging.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Integer.valueOf(ServiceStarter.b().g(context, intent));
            }
        }).continueWithTask(this.f89381b, new Continuation() { // from class: com.google.firebase.messaging.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return FcmBroadcastProcessor.a(context, intent, z3, task);
            }
        }) : e(context, intent, z3);
    }
}
