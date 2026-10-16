package com.google.android.libraries.places.internal;

import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzqv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f78486a;

    static {
        Method method = null;
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                method = cls.getMethod("get", String.class, String.class);
                cls.getMethod("getInt", String.class, Integer.TYPE);
                cls.getMethod("getLong", String.class, Long.TYPE);
                cls.getMethod("getBoolean", String.class, Boolean.TYPE);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } finally {
            f78486a = method;
        }
    }

    public static String a(String str, String str2) {
        try {
            return (String) f78486a.invoke(null, "tiktok_systrace", "false");
        } catch (Exception e3) {
            Log.e("SystemProperties", "get error", e3);
            return "false";
        }
    }
}
