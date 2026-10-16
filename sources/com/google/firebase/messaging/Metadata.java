package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class Metadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f89414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f89415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f89416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f89417e = 0;

    Metadata(Context context) {
        this.f89413a = context;
    }

    static String c(FirebaseApp firebaseApp) {
        String strD = firebaseApp.p().d();
        if (strD != null) {
            return strD;
        }
        String strC = firebaseApp.p().c();
        if (!strC.startsWith("1:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(com.revenuecat.purchases.common.Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.f89413a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("FirebaseMessaging", "Failed to find package " + e3);
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo packageInfoF = f(this.f89413a.getPackageName());
        if (packageInfoF != null) {
            this.f89414b = Integer.toString(packageInfoF.versionCode);
            this.f89415c = packageInfoF.versionName;
        }
    }

    synchronized String a() {
        try {
            if (this.f89414b == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f89414b;
    }

    synchronized String b() {
        try {
            if (this.f89415c == null) {
                h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f89415c;
    }

    synchronized int d() {
        PackageInfo packageInfoF;
        try {
            if (this.f89416d == 0 && (packageInfoF = f("com.google.android.gms")) != null) {
                this.f89416d = packageInfoF.versionCode;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f89416d;
    }

    synchronized int e() {
        int i3 = this.f89417e;
        if (i3 != 0) {
            return i3;
        }
        PackageManager packageManager = this.f89413a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.e()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.f89417e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.f89417e = 2;
            return 2;
        }
        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.e()) {
            this.f89417e = 2;
        } else {
            this.f89417e = 1;
        }
        return this.f89417e;
    }

    boolean g() {
        return e() != 0;
    }
}
