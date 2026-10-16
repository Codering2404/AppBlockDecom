package com.google.common.math;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class DoubleUtils {
    static double a(double d3) {
        Preconditions.d(!Double.isNaN(d3));
        return Math.max(d3, 0.0d);
    }

    static long b(double d3) {
        Preconditions.e(c(d3), "not a normal value");
        int exponent = Math.getExponent(d3);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d3) & 4503599627370495L;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | 4503599627370496L;
    }

    static boolean c(double d3) {
        return Math.getExponent(d3) <= 1023;
    }

    static boolean d(double d3) {
        return Math.getExponent(d3) >= -1022;
    }

    static double e(double d3) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d3) & 4503599627370495L) | 4607182418800017408L);
    }
}
