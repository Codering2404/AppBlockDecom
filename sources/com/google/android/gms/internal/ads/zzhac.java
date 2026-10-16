package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhac {
    static long zza(String str, long j3) {
        if (j3 >= 0) {
            return j3;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 17);
        sb.append(str);
        sb.append(" (");
        sb.append(j3);
        sb.append(") must be >= 0");
        throw new IllegalArgumentException(sb.toString());
    }

    static void zzb(boolean z2) {
        if (!z2) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
