package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzai {
    static Object[] zza(Object[] objArr, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (objArr[i4] == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 9);
                sb.append("at index ");
                sb.append(i4);
                throw new NullPointerException(sb.toString());
            }
        }
        return objArr;
    }
}
