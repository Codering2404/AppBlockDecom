package com.google.android.material.internal;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ManufacturerUtils {
    private static String a() {
        String str = Build.MANUFACTURER;
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    public static boolean b() {
        return c() || e();
    }

    public static boolean c() {
        return a().equals("lge");
    }

    public static boolean d() {
        return a().equals("meizu");
    }

    public static boolean e() {
        return a().equals("samsung");
    }
}
