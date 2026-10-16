package com.google.android.datatransport.runtime.logging;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Logging {
    public static void a(String str, String str2, Object obj) {
        String strD = d(str);
        if (Log.isLoggable(strD, 3)) {
            Log.d(strD, String.format(str2, obj));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        String strD = d(str);
        if (Log.isLoggable(strD, 3)) {
            Log.d(strD, String.format(str2, objArr));
        }
    }

    public static void c(String str, String str2, Throwable th) {
        String strD = d(str);
        if (Log.isLoggable(strD, 6)) {
            Log.e(strD, str2, th);
        }
    }

    private static String d(String str) {
        return "TRuntime." + str;
    }

    public static void e(String str, String str2, Object obj) {
        String strD = d(str);
        if (Log.isLoggable(strD, 4)) {
            Log.i(strD, String.format(str2, obj));
        }
    }

    public static void f(String str, String str2, Object obj) {
        String strD = d(str);
        if (Log.isLoggable(strD, 5)) {
            Log.w(strD, String.format(str2, obj));
        }
    }
}
