package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ColorUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final double[][] f80602a = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final double[][] f80603b = {new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final double[] f80604c = {95.047d, 100.0d, 108.883d};

    public static int a(double[] dArr) {
        return c(e(dArr[0]), e(dArr[1]), e(dArr[2]));
    }

    public static int b(double d3) {
        int iE = e(p(d3));
        return c(iE, iE, iE);
    }

    public static int c(int i3, int i4, int i5) {
        return ((i3 & 255) << 16) | (-16777216) | ((i4 & 255) << 8) | (i5 & 255);
    }

    public static int d(int i3) {
        return i3 & 255;
    }

    public static int e(double d3) {
        double d4 = d3 / 100.0d;
        return MathUtils.b(0, 255, (int) Math.round((d4 <= 0.0031308d ? d4 * 12.92d : (Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d));
    }

    public static int f(int i3) {
        return (i3 >> 8) & 255;
    }

    static double g(double d3) {
        return d3 > 0.008856451679035631d ? Math.pow(d3, 0.3333333333333333d) : ((d3 * 903.2962962962963d) + 16.0d) / 116.0d;
    }

    public static double[] h(int i3) {
        double dJ = j(m(i3));
        double dJ2 = j(f(i3));
        double dJ3 = j(d(i3));
        double[][] dArr = f80602a;
        double[] dArr2 = dArr[0];
        double d3 = (dArr2[0] * dJ) + (dArr2[1] * dJ2) + (dArr2[2] * dJ3);
        double[] dArr3 = dArr[1];
        double d4 = (dArr3[0] * dJ) + (dArr3[1] * dJ2) + (dArr3[2] * dJ3);
        double[] dArr4 = dArr[2];
        double d5 = (dArr4[0] * dJ) + (dArr4[1] * dJ2) + (dArr4[2] * dJ3);
        double[] dArr5 = f80604c;
        double d6 = d3 / dArr5[0];
        double d7 = d4 / dArr5[1];
        double d8 = d5 / dArr5[2];
        double dG = g(d6);
        double dG2 = g(d7);
        return new double[]{(116.0d * dG2) - 16.0d, (dG - dG2) * 500.0d, (dG2 - g(d8)) * 200.0d};
    }

    static double i(double d3) {
        double d4 = d3 * d3 * d3;
        return d4 > 0.008856451679035631d ? d4 : ((d3 * 116.0d) - 16.0d) / 903.2962962962963d;
    }

    public static double j(int i3) {
        double d3 = ((double) i3) / 255.0d;
        return (d3 <= 0.040449936d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d)) * 100.0d;
    }

    public static double k(int i3) {
        return (g(o(i3)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static double l(double d3) {
        return (g(d3 / 100.0d) * 116.0d) - 16.0d;
    }

    public static int m(int i3) {
        return (i3 >> 16) & 255;
    }

    public static double[] n() {
        return f80604c;
    }

    public static double[] o(int i3) {
        return MathUtils.d(new double[]{j(m(i3)), j(f(i3)), j(d(i3))}, f80602a);
    }

    public static double p(double d3) {
        return i((d3 + 16.0d) / 116.0d) * 100.0d;
    }
}
