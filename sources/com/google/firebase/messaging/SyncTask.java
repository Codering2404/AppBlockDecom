package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class SyncTask implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f89468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PowerManager.WakeLock f89469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FirebaseMessaging f89470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ExecutorService f89471d = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ConnectivityChangeReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SyncTask f89472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f89473b;

        public ConnectivityChangeReceiver(SyncTask syncTask) {
            this.f89472a = syncTask;
        }

        public void a() {
            if (SyncTask.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            SyncTask syncTask = this.f89472a;
            if (syncTask != null) {
                Context contextB = syncTask.b();
                this.f89473b = contextB;
                contextB.registerReceiver(this, intentFilter);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            SyncTask syncTask = this.f89472a;
            if (syncTask != null && syncTask.d()) {
                if (SyncTask.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.f89472a.f89470c.l(this.f89472a, 0L);
                Context context2 = this.f89473b;
                if (context2 != null) {
                    context2.unregisterReceiver(this);
                }
                this.f89472a = null;
            }
        }
    }

    public SyncTask(FirebaseMessaging firebaseMessaging, long j3) {
        this.f89470c = firebaseMessaging;
        this.f89468a = j3;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f89469b = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        return Log.isLoggable("FirebaseMessaging", 3);
    }

    Context b() {
        return this.f89470c.m();
    }

    boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    boolean e() throws IOException {
        try {
            if (this.f89470c.k() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e3) {
            if (!GmsRpc.h(e3.getMessage())) {
                if (e3.getMessage() != null) {
                    throw e3;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            Log.w("FirebaseMessaging", "Token retrieval failed: " + e3.getMessage() + ". Will retry token retrieval");
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ServiceStarter.b().e(b())) {
            this.f89469b.acquire();
        }
        try {
            try {
                this.f89470c.y(true);
                if (!this.f89470c.x()) {
                    this.f89470c.y(false);
                    if (!ServiceStarter.b().e(b())) {
                        return;
                    }
                } else if (!ServiceStarter.b().d(b()) || d()) {
                    if (e()) {
                        this.f89470c.y(false);
                    } else {
                        this.f89470c.C(this.f89468a);
                    }
                    if (!ServiceStarter.b().e(b())) {
                        return;
                    }
                } else {
                    new ConnectivityChangeReceiver(this).a();
                    if (!ServiceStarter.b().e(b())) {
                        return;
                    }
                }
                this.f89469b.release();
            } catch (IOException e3) {
                Log.e("FirebaseMessaging", "Topic sync or token retrieval failed on hard failure exceptions: " + e3.getMessage() + ". Won't retry the operation.");
                this.f89470c.y(false);
                if (ServiceStarter.b().e(b())) {
                    this.f89469b.release();
                }
            }
        } catch (Throwable th) {
            if (ServiceStarter.b().e(b())) {
                this.f89469b.release();
            }
            throw th;
        }
    }
}
