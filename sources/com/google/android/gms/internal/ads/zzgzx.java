package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzx {
    static long zza(double d3) {
        zzgtj.zzb(zzb(d3), "not a normal value");
        int exponent = Math.getExponent(d3);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d3) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits + jDoubleToRawLongBits : jDoubleToRawLongBits | 4503599627370496L;
    }

    static boolean zzb(double d3) {
        return Math.getExponent(d3) <= 1023;
    }
}
