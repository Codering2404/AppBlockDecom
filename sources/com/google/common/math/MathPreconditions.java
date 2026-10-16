package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class MathPreconditions {
    static void a(boolean z2, double d3, RoundingMode roundingMode) {
        if (z2) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d3 + " and rounding mode " + roundingMode);
    }

    static void b(boolean z2, String str, int i3, int i4) {
        if (z2) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i3 + ", " + i4 + ")");
    }

    static void c(boolean z2, String str, long j3, long j4) {
        if (z2) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j3 + ", " + j4 + ")");
    }

    static double d(String str, double d3) {
        if (d3 >= 0.0d) {
            return d3;
        }
        throw new IllegalArgumentException(str + " (" + d3 + ") must be >= 0");
    }

    static int e(String str, int i3) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " (" + i3 + ") must be >= 0");
    }

    static long f(String str, long j3) {
        if (j3 >= 0) {
            return j3;
        }
        throw new IllegalArgumentException(str + " (" + j3 + ") must be >= 0");
    }

    static int g(String str, int i3) {
        if (i3 > 0) {
            return i3;
        }
        throw new IllegalArgumentException(str + " (" + i3 + ") must be > 0");
    }

    static void h(boolean z2) {
        if (!z2) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
