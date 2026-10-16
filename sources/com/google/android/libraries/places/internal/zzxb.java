package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzxb {
    public static Object a(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str.concat(" must not be null"));
    }

    public static void b(boolean z2, String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void c(boolean z2, String str) {
        if (!z2) {
            throw new IllegalStateException(str);
        }
    }

    public static String d(String str) {
        if (!e(str.charAt(0))) {
            throw new IllegalArgumentException("identifier must start with an ASCII letter: ".concat(str));
        }
        for (int i3 = 1; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (!e(cCharAt) && ((cCharAt < '0' || cCharAt > '9') && cCharAt != '_')) {
                throw new IllegalArgumentException("identifier must contain only ASCII letters, digits or underscore: ".concat(str));
            }
        }
        return str;
    }

    private static boolean e(char c3) {
        if (c3 < 'a' || c3 > 'z') {
            return c3 >= 'A' && c3 <= 'Z';
        }
        return true;
    }
}
