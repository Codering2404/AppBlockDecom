package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgyf {
    static Object[] zza(Object[] objArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            zzb(objArr[i4], i4);
        }
        return objArr;
    }

    static Object zzb(Object obj, int i3) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 9);
        sb.append("at index ");
        sb.append(i3);
        throw new NullPointerException(sb.toString());
    }
}
