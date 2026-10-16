package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.GooglePlayServicesUtilLight;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DeviceProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f72270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f72271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f72272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Boolean f72273d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Boolean f72274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Boolean f72275f;

    public static boolean a(Context context) {
        return k(context.getPackageManager());
    }

    public static boolean b(Context context) {
        if (f72275f == null) {
            boolean z2 = false;
            if (PlatformVersion.h() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z2 = true;
            }
            f72275f = Boolean.valueOf(z2);
        }
        return f72275f.booleanValue();
    }

    public static boolean c(Context context) {
        if (f72272c == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z2 = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z2 = true;
            }
            f72272c = Boolean.valueOf(z2);
        }
        return f72272c.booleanValue();
    }

    public static boolean d(Context context) {
        return i(context);
    }

    public static boolean e() {
        int i3 = GooglePlayServicesUtilLight.f71459a;
        return "user".equals(Build.TYPE);
    }

    public static boolean f(Context context) {
        return h(context.getPackageManager());
    }

    public static boolean g(Context context) {
        if (f(context) && !PlatformVersion.d()) {
            return true;
        }
        if (i(context)) {
            return !PlatformVersion.e() || PlatformVersion.h();
        }
        return false;
    }

    public static boolean h(PackageManager packageManager) {
        if (f72270a == null) {
            f72270a = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f72270a.booleanValue();
    }

    public static boolean i(Context context) {
        if (f72271b == null) {
            f72271b = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f72271b.booleanValue();
    }

    public static boolean j(Context context) {
        if (f72273d == null) {
            f72273d = Boolean.valueOf(PlatformVersion.e() ? context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") : context.getPackageManager().hasSystemFeature("android.hardware.type.iot"));
        }
        return f72273d.booleanValue();
    }

    public static boolean k(PackageManager packageManager) {
        if (f72274e == null) {
            boolean z2 = false;
            if (PlatformVersion.e() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z2 = true;
            }
            f72274e = Boolean.valueOf(z2);
        }
        return f72274e.booleanValue();
    }
}
