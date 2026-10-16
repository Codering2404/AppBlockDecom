package com.google.android.gms.analytics;

import com.google.android.gms.internal.gtm.zzfc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd {
    public static String a(int i3) {
        return l("cd", i3);
    }

    public static String b(int i3) {
        return l("cd", i3);
    }

    public static String c(int i3) {
        return l("cm", i3);
    }

    public static String d(int i3) {
        return l("cm", i3);
    }

    public static String e(int i3) {
        return l("&il", i3);
    }

    public static String f(int i3) {
        return l("il", i3);
    }

    public static String g(int i3) {
        return l("pi", i3);
    }

    public static String h(int i3) {
        return l("&pr", i3);
    }

    public static String i(int i3) {
        return l("pr", i3);
    }

    public static String j(int i3) {
        return l("&promo", i3);
    }

    public static String k(int i3) {
        return l("promo", i3);
    }

    private static String l(String str, int i3) {
        if (i3 <= 0) {
            zzfc.zzb("index out of range for prefix", str);
            return "";
        }
        return str + i3;
    }
}
