package com.applovin.impl;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class oc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f62232a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f62233b = true;

    private static String a(String str, Throwable th) {
        String strA = a(th);
        if (TextUtils.isEmpty(strA)) {
            return str;
        }
        return str + "\n  " + strA.replace("\n", "\n  ") + '\n';
    }

    public static void b(String str, String str2, Throwable th) {
        c(str, a(str2, th));
    }

    public static void c(String str, String str2, Throwable th) {
        d(str, a(str2, th));
    }

    public static void d(String str, String str2) {
        if (f62232a <= 2) {
            Log.w(str, str2);
        }
    }

    private static boolean b(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void c(String str, String str2) {
        if (f62232a <= 1) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        b(str, a(str2, th));
    }

    public static void b(String str, String str2) {
        if (f62232a <= 3) {
            Log.e(str, str2);
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return null;
        }
        if (b(th)) {
            return "UnknownHostException (no network)";
        }
        if (!f62233b) {
            return th.getMessage();
        }
        return Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    public static void a(String str, String str2) {
        if (f62232a == 0) {
            Log.d(str, str2);
        }
    }
}
