package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class TopicsSyncTask implements Runnable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f89491g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Boolean f89492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Boolean f89493i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Metadata f89495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PowerManager.WakeLock f89496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TopicsSubscriber f89497d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f89498f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class ConnectivityChangeReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TopicsSyncTask f89499a;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.f89499a = topicsSyncTask;
        }

        public void a() {
            if (TopicsSyncTask.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            TopicsSyncTask.this.f89494a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            try {
                TopicsSyncTask topicsSyncTask = this.f89499a;
                if (topicsSyncTask == null) {
                    return;
                }
                if (topicsSyncTask.i()) {
                    if (TopicsSyncTask.j()) {
                        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                    }
                    this.f89499a.f89497d.k(this.f89499a, 0L);
                    context.unregisterReceiver(this);
                    this.f89499a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    TopicsSyncTask(TopicsSubscriber topicsSubscriber, Context context, Metadata metadata, long j3) {
        this.f89497d = topicsSubscriber;
        this.f89494a = context;
        this.f89498f = j3;
        this.f89495b = metadata;
        this.f89496c = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static String e(String str) {
        return "Missing Permission: " + str + ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    }

    private static boolean f(Context context) {
        boolean zBooleanValue;
        synchronized (f89491g) {
            try {
                Boolean bool = f89493i;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
                f89493i = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z2 = context.checkCallingOrSelfPermission(str) == 0;
        if (!z2 && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", e(str));
        }
        return z2;
    }

    private static boolean h(Context context) {
        boolean zBooleanValue;
        synchronized (f89491g) {
            try {
                Boolean bool = f89492h;
                Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
                f89492h = boolValueOf;
                zBooleanValue = boolValueOf.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean i() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.content.Context r0 = r2.f89494a     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch: java.lang.Throwable -> L12
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L12
            goto L15
        L12:
            r0 = move-exception
            goto L22
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1f
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            monitor-exit(r2)
            return r0
        L22:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSyncTask.i():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (h(this.f89494a)) {
            this.f89496c.acquire(Constants.f89373a);
        }
        try {
            try {
                try {
                    this.f89497d.l(true);
                    if (!this.f89495b.g()) {
                        this.f89497d.l(false);
                        if (h(this.f89494a)) {
                            try {
                                this.f89496c.release();
                                return;
                            } catch (RuntimeException unused) {
                                Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                                return;
                            }
                        }
                        return;
                    }
                    if (!f(this.f89494a) || i()) {
                        if (this.f89497d.o()) {
                            this.f89497d.l(false);
                        } else {
                            this.f89497d.p(this.f89498f);
                        }
                        if (h(this.f89494a)) {
                            this.f89496c.release();
                            return;
                        }
                        return;
                    }
                    new ConnectivityChangeReceiver(this).a();
                    if (h(this.f89494a)) {
                        try {
                            this.f89496c.release();
                        } catch (RuntimeException unused2) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                } catch (Throwable th) {
                    if (h(this.f89494a)) {
                        try {
                            this.f89496c.release();
                        } catch (RuntimeException unused3) {
                            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                Log.e("FirebaseMessaging", "Failed to sync topics. Won't retry sync. " + e3.getMessage());
                this.f89497d.l(false);
                if (h(this.f89494a)) {
                    this.f89496c.release();
                }
            }
        } catch (RuntimeException unused4) {
            Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
        }
    }
}
