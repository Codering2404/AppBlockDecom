package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.glance.session.ecY.lisODU;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Rpc {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f71369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static PendingIntent f71370i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Executor f71371j = new Executor() { // from class: com.google.android.gms.cloudmessaging.zzy
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f71372k = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f71374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzw f71375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScheduledExecutorService f71376d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Messenger f71378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzd f71379g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SimpleArrayMap f71373a = new SimpleArrayMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Messenger f71377e = new Messenger(new zzae(this, Looper.getMainLooper()));

    public Rpc(Context context) {
        this.f71374b = context;
        this.f71375c = new zzw(context);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f71376d = scheduledThreadPoolExecutor;
    }

    static /* synthetic */ Task e(Bundle bundle) {
        return m(bundle) ? Tasks.forResult(null) : Tasks.forResult(bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.tasks.Task i(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.Rpc.i(android.os.Bundle):com.google.android.gms.tasks.Task");
    }

    private static synchronized String j() {
        int i3;
        i3 = f71369h;
        f71369h = i3 + 1;
        return Integer.toString(i3);
    }

    private final void l(String str, Bundle bundle) {
        synchronized (this.f71373a) {
            try {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.f71373a.remove(str);
                if (taskCompletionSource != null) {
                    taskCompletionSource.setResult(bundle);
                    return;
                }
                Log.w("Rpc", "Missing callback for " + str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static boolean m(Bundle bundle) {
        return bundle != null && bundle.containsKey("google.messenger");
    }

    public Task a() {
        return this.f71375c.a() >= 241100000 ? zzv.b(this.f71374b).d(5, Bundle.EMPTY).continueWith(f71371j, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzab
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Intent intent = (Intent) ((Bundle) task.getResult()).getParcelable("notification_data");
                if (intent != null) {
                    return new CloudMessage(intent);
                }
                return null;
            }
        }) : Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
    }

    public Task b(CloudMessage cloudMessage) {
        if (this.f71375c.a() < 233700000) {
            return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putString("google.message_id", cloudMessage.N());
        Integer numO = cloudMessage.O();
        if (numO != null) {
            bundle.putInt("google.product_id", numO.intValue());
        }
        return zzv.b(this.f71374b).c(3, bundle);
    }

    public Task c(final Bundle bundle) {
        return this.f71375c.a() < 12000000 ? this.f71375c.b() != 0 ? i(bundle).continueWithTask(f71371j, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzz
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                return this.f71429a.f(bundle, task);
            }
        }) : Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE")) : zzv.b(this.f71374b).d(1, bundle).continueWith(f71371j, new Continuation() { // from class: com.google.android.gms.cloudmessaging.zzaa
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) throws IOException {
                if (task.isSuccessful()) {
                    return (Bundle) task.getResult();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(task.getException())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", task.getException());
            }
        });
    }

    public Task d(boolean z2) {
        if (this.f71375c.a() < 241100000) {
            return Tasks.forException(new IOException("SERVICE_NOT_AVAILABLE"));
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proxy_retention", z2);
        return zzv.b(this.f71374b).c(4, bundle);
    }

    final /* synthetic */ Task f(Bundle bundle, Task task) {
        return (task.isSuccessful() && m((Bundle) task.getResult())) ? i(bundle).onSuccessTask(f71371j, new SuccessContinuation() { // from class: com.google.android.gms.cloudmessaging.zzx
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return Rpc.e((Bundle) obj);
            }
        }) : task;
    }

    final /* synthetic */ void h(String str, ScheduledFuture scheduledFuture, Task task) {
        synchronized (this.f71373a) {
            this.f71373a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    static /* bridge */ /* synthetic */ void g(Rpc rpc, Message message) {
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof Intent) {
                Intent intent = (Intent) obj;
                intent.setExtrasClassLoader(new zzc());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof zzd) {
                        rpc.f71379g = (zzd) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        rpc.f71378f = (Messenger) parcelableExtra;
                    }
                }
                Intent intent2 = (Intent) message.obj;
                String action = intent2.getAction();
                if (!Objects.equals(action, "com.google.android.c2dm.intent.REGISTRATION")) {
                    if (Log.isLoggable(lisODU.wAkzPSoTJQHnxxQ, 3)) {
                        String strValueOf = String.valueOf(action);
                        Log.d(lisODU.wAkzPSoTJQHnxxQ, jTYhJgqLBN.YZphHQ.concat(strValueOf));
                        return;
                    }
                    return;
                }
                String stringExtra = intent2.getStringExtra("registration_id");
                if (stringExtra == null) {
                    stringExtra = intent2.getStringExtra("unregistered");
                }
                if (stringExtra != null) {
                    Matcher matcher = f71372k.matcher(stringExtra);
                    if (!matcher.matches()) {
                        if (Log.isLoggable(lisODU.wAkzPSoTJQHnxxQ, 3)) {
                            Log.d(lisODU.wAkzPSoTJQHnxxQ, "Unexpected response string: ".concat(stringExtra));
                            return;
                        }
                        return;
                    }
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    if (strGroup != null) {
                        Bundle extras = intent2.getExtras();
                        extras.putString("registration_id", strGroup2);
                        rpc.l(strGroup, extras);
                        return;
                    }
                    return;
                }
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    Log.w(lisODU.wAkzPSoTJQHnxxQ, "Unexpected response, no error or registration id ".concat(String.valueOf(intent2.getExtras())));
                    return;
                }
                if (Log.isLoggable(lisODU.wAkzPSoTJQHnxxQ, 3)) {
                    Log.d(lisODU.wAkzPSoTJQHnxxQ, "Received InstanceID error ".concat(stringExtra2));
                }
                if (!stringExtra2.startsWith("|")) {
                    synchronized (rpc.f71373a) {
                        for (int i3 = 0; i3 < rpc.f71373a.size(); i3++) {
                            try {
                                rpc.l((String) rpc.f71373a.f(i3), intent2.getExtras());
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    return;
                }
                String[] strArrSplit = stringExtra2.split("\\|");
                if (strArrSplit.length <= 2 || !Objects.equals(strArrSplit[1], "ID")) {
                    Log.w(lisODU.wAkzPSoTJQHnxxQ, "Unexpected structured response ".concat(stringExtra2));
                    return;
                }
                String str = strArrSplit[2];
                String strSubstring = strArrSplit[3];
                if (strSubstring.startsWith(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
                    strSubstring = strSubstring.substring(1);
                }
                rpc.l(str, intent2.putExtra("error", strSubstring).getExtras());
                return;
            }
        }
        Log.w(lisODU.wAkzPSoTJQHnxxQ, "Dropping invalid message");
    }

    private static synchronized void k(Context context, Intent intent) {
        try {
            if (f71370i == null) {
                Intent intent2 = new Intent();
                intent2.setPackage(sKeKFMqmvNzY.fPUltgrPbbf);
                f71370i = PendingIntent.getBroadcast(context, 0, intent2, com.google.android.gms.internal.cloudmessaging.zza.zza);
            }
            intent.putExtra("app", f71370i);
        } catch (Throwable th) {
            throw th;
        }
    }
}
