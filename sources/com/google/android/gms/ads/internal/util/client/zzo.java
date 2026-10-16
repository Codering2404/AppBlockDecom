package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.internal.ads.zzgty;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final zzgty f70191a = zzgty.zzc(4000);

    public static void a(String str) {
        if (j(3)) {
            if (str.length() <= 4000) {
                Log.d("Ads", str);
                return;
            }
            boolean z2 = true;
            for (String str2 : f70191a.zzd(str)) {
                if (z2) {
                    Log.d("Ads", str2);
                } else {
                    Log.d("Ads-cont", str2);
                }
                z2 = false;
            }
        }
    }

    public static void b(String str, Throwable th) {
        if (j(3)) {
            Log.d("Ads", str, th);
        }
    }

    public static void c(String str) {
        if (j(6)) {
            if (str == null || str.length() <= 4000) {
                Log.e("Ads", str);
                return;
            }
            boolean z2 = true;
            for (String str2 : f70191a.zzd(str)) {
                if (z2) {
                    Log.e("Ads", str2);
                } else {
                    Log.e("Ads-cont", str2);
                }
                z2 = false;
            }
        }
    }

    public static void d(String str, Throwable th) {
        if (j(6)) {
            Log.e("Ads", str, th);
        }
    }

    public static void e(String str) {
        if (j(4)) {
            if (str == null || str.length() <= 4000) {
                Log.i("Ads", str);
                return;
            }
            boolean z2 = true;
            for (String str2 : f70191a.zzd(str)) {
                if (z2) {
                    Log.i("Ads", str2);
                } else {
                    Log.i("Ads-cont", str2);
                }
                z2 = false;
            }
        }
    }

    public static void f(String str) {
        if (j(5)) {
            if (str == null || str.length() <= 4000) {
                Log.w("Ads", str);
                return;
            }
            boolean z2 = true;
            for (String str2 : f70191a.zzd(str)) {
                if (z2) {
                    Log.w("Ads", str2);
                } else {
                    Log.w("Ads-cont", str2);
                }
                z2 = false;
            }
        }
    }

    public static void g(String str, Throwable th) {
        if (j(5)) {
            Log.w("Ads", str, th);
        }
    }

    static String h(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(str.length() + 2 + String.valueOf(lineNumber).length());
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void i(String str, Throwable th) {
        if (j(5)) {
            if (th != null) {
                g(h(str), th);
            } else {
                f(h(str));
            }
        }
    }

    public static boolean j(int i3) {
        return i3 >= 5 || Log.isLoggable("Ads", i3);
    }
}
