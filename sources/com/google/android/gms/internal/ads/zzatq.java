package com.google.android.gms.internal.ads;

import android.util.Log;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzatq {
    public static final String zza = "Volley";
    public static final boolean zzb = Log.isLoggable("Volley", 2);
    private static final String zzc = zzatq.class.getName();

    public static void zza(String str, Object... objArr) {
        if (zzb) {
            Log.v(zza, zze(str, objArr));
        }
    }

    public static void zzb(String str, Object... objArr) {
        Log.d(zza, zze(str, objArr));
    }

    public static void zzc(String str, Object... objArr) {
        Log.e(zza, zze(str, objArr));
    }

    public static void zzd(Throwable th, String str, Object... objArr) {
        Log.e(zza, zze(str, objArr), th);
    }

    private static String zze(String str, Object... objArr) {
        String string;
        String str2 = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i3 = 2;
        while (true) {
            if (i3 >= stackTrace.length) {
                string = "<unknown>";
                break;
            }
            if (!stackTrace[i3].getClassName().equals(zzc)) {
                String className = stackTrace[i3].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i3].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(strSubstring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(strSubstring2);
                sb.append(".");
                sb.append(methodName);
                string = sb.toString();
                break;
            }
            i3++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), string, str2);
    }
}
