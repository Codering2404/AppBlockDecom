package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MathUtils {
    public static double a(double d3, double d4, double d5) {
        return d5 < d3 ? d3 : d5 > d4 ? d4 : d5;
    }

    public static int b(int i3, int i4, int i5) {
        return i5 < i3 ? i3 : i5 > i4 ? i4 : i5;
    }

    public static double c(double d3, double d4, double d5) {
        return ((1.0d - d5) * d3) + (d5 * d4);
    }

    public static double[] d(double[] dArr, double[][] dArr2) {
        double d3 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d4 = dArr3[0] * d3;
        double d5 = dArr[1];
        double d6 = d4 + (dArr3[1] * d5);
        double d7 = dArr[2];
        double d8 = d6 + (dArr3[2] * d7);
        double[] dArr4 = dArr2[1];
        double d9 = (dArr4[0] * d3) + (dArr4[1] * d5) + (dArr4[2] * d7);
        double[] dArr5 = dArr2[2];
        return new double[]{d8, d9, (d3 * dArr5[0]) + (d5 * dArr5[1]) + (d7 * dArr5[2])};
    }

    public static double e(double d3) {
        double d4 = d3 % 360.0d;
        return d4 < 0.0d ? d4 + 360.0d : d4;
    }

    public static int f(int i3) {
        int i4 = i3 % 360;
        return i4 < 0 ? i4 + 360 : i4;
    }

    public static int g(double d3) {
        if (d3 < 0.0d) {
            return -1;
        }
        return d3 == 0.0d ? 0 : 1;
    }
}
