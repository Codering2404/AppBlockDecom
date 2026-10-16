package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ServiceStarter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ServiceStarter f89452e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f89453a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f89454b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f89455c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue f89456d = new ArrayDeque();

    private ServiceStarter() {
    }

    private int a(Context context, Intent intent) {
        ComponentName componentNameStartService;
        String strF = f(context, intent);
        if (strF != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Restricting intent to a specific service: " + strF);
            }
            intent.setClassName(context.getPackageName(), strF);
        }
        try {
            if (e(context)) {
                componentNameStartService = WakeLockHolder.g(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
                Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService != null) {
                return -1;
            }
            Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (IllegalStateException e3) {
            Log.e("FirebaseMessaging", "Failed to start service while in background: " + e3);
            return 402;
        } catch (SecurityException e4) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e4);
            return RCHTTPStatusCodes.UNAUTHORIZED;
        }
    }

    static synchronized ServiceStarter b() {
        try {
            if (f89452e == null) {
                f89452e = new ServiceStarter();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f89452e;
    }

    private synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        try {
            String str2 = this.f89453a;
            if (str2 != null) {
                return str2;
            }
            ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
            if (resolveInfoResolveService != null && (serviceInfo = resolveInfoResolveService.serviceInfo) != null) {
                if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                    if (str.startsWith(".")) {
                        this.f89453a = context.getPackageName() + serviceInfo.name;
                    } else {
                        this.f89453a = serviceInfo.name;
                    }
                    return this.f89453a;
                }
                Log.e("FirebaseMessaging", "Error resolving target intent service, skipping classname enforcement. Resolved service was: " + serviceInfo.packageName + "/" + serviceInfo.name);
                return null;
            }
            Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    Intent c() {
        return (Intent) this.f89456d.poll();
    }

    boolean d(Context context) {
        if (this.f89455c == null) {
            this.f89455c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f89454b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f89455c.booleanValue();
    }

    boolean e(Context context) {
        if (this.f89454b == null) {
            this.f89454b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f89454b.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f89454b.booleanValue();
    }

    public int g(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        this.f89456d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
