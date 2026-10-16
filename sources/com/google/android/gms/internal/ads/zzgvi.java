package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgvi {
    static void zza(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 != null) {
            return;
        }
        String string = obj.toString();
        StringBuilder sb = new StringBuilder(string.length() + 26);
        sb.append("null value in entry: ");
        sb.append(string);
        sb.append("=null");
        throw new NullPointerException(sb.toString());
    }

    static int zzb(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        StringBuilder sb = new StringBuilder(str.length() + 29 + String.valueOf(i3).length());
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i3);
        throw new IllegalArgumentException(sb.toString());
    }
}
