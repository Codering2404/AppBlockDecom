package com.google.android.gms.common;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class GooglePlayServicesUtilLight {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f71459a = 12451000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f71461c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f71462d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final AtomicBoolean f71460b = new AtomicBoolean();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f71463e = new AtomicBoolean();

    public static void a(Context context) {
        if (f71460b.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
        } catch (SecurityException e3) {
            Log.d("GooglePlayServicesUtil", "Suppressing Security Exception %s in cancelAvailabilityErrorNotifications.", e3);
        }
    }

    public static void b(Context context, int i3) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int iJ = GoogleApiAvailabilityLight.h().j(context, i3);
        if (iJ != 0) {
            Intent intentD = GoogleApiAvailabilityLight.h().d(context, iJ, "e");
            StringBuilder sb = new StringBuilder(String.valueOf(iJ).length() + 46);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(iJ);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (intentD != null) {
                throw new GooglePlayServicesRepairableException(iJ, "Google Play Services not available", intentD);
            }
            throw new GooglePlayServicesNotAvailableException(iJ);
        }
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static String d(int i3) {
        return ConnectionResult.z0(i3);
    }

    public static Context e(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources f(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean g(Context context) {
        try {
            if (!f71462d) {
                try {
                    PackageInfo packageInfoF = Wrappers.a(context).f("com.google.android.gms", 134217792);
                    GoogleSignatureVerifier.a(context);
                    if (packageInfoF == null || GoogleSignatureVerifier.d(packageInfoF, false) || !GoogleSignatureVerifier.d(packageInfoF, true)) {
                        f71461c = false;
                    } else {
                        f71461c = true;
                    }
                    f71462d = true;
                } catch (PackageManager.NameNotFoundException e3) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e3);
                    f71462d = true;
                }
            }
            return f71461c || !DeviceProperties.e();
        } catch (Throwable th) {
            f71462d = true;
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int h(android.content.Context r10, int r11) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtilLight.h(android.content.Context, int):int");
    }

    public static boolean i(Context context, int i3) {
        if (i3 == 18) {
            return true;
        }
        if (i3 == 1) {
            return m(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean j(Context context) {
        Object systemService = context.getSystemService("user");
        Preconditions.m(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(applicationRestrictions.getString("restricted_profile"));
    }

    public static boolean k(int i3) {
        return i3 == 1 || i3 == 2 || i3 == 3 || i3 == 9;
    }

    public static boolean l(Context context, int i3, String str) {
        return UidVerifier.b(context, i3, str);
    }

    static boolean m(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        boolean zEquals = str.equals("com.google.android.gms");
        try {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
            applicationInfo = context.getPackageManager().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        return zEquals ? applicationInfo.enabled : applicationInfo.enabled && !j(context);
    }
}
