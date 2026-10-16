package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzwy extends RuntimeException {
    private zzwy(String str, String str2) {
        super(str);
    }

    public static zzwy a(String str, String str2, int i3, int i4) {
        return new zzwy(e(str, str2, i3, i4), str2);
    }

    public static zzwy b(String str, String str2, int i3) {
        return new zzwy(e(str, str2, i3, i3 + 1), str2);
    }

    public static zzwy c(String str, String str2, int i3) {
        return new zzwy(e(str, str2, i3, -1), str2);
    }

    public static zzwy d(String str, String str2) {
        return new zzwy(str, str2);
    }

    private static String e(String str, String str2, int i3, int i4) {
        if (i4 < 0) {
            i4 = str2.length();
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append(": ");
        if (i3 > 8) {
            sb.append("...");
            sb.append((CharSequence) str2, i3 - 5, i3);
        } else {
            sb.append((CharSequence) str2, 0, i3);
        }
        sb.append('[');
        sb.append(str2.substring(i3, i4));
        sb.append(']');
        if (str2.length() - i4 > 8) {
            sb.append((CharSequence) str2, i4, i4 + 5);
            sb.append("...");
        } else {
            sb.append((CharSequence) str2, i4, str2.length());
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this;
    }
}
