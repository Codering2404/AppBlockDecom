package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MonotonicCurveFit extends CurveFit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double[] f31800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double[][] f31801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double[][] f31802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f31803d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double[] f31804e;

    public MonotonicCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.f31804e = new double[length2];
        int i3 = length - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, i3, length2);
        double[][] dArr4 = (double[][]) Array.newInstance((Class<?>) cls, length, length2);
        for (int i4 = 0; i4 < length2; i4++) {
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i5 + 1;
                double d3 = dArr[i6] - dArr[i5];
                double[] dArr5 = dArr3[i5];
                double d4 = (dArr2[i6][i4] - dArr2[i5][i4]) / d3;
                dArr5[i4] = d4;
                if (i5 == 0) {
                    dArr4[i5][i4] = d4;
                } else {
                    dArr4[i5][i4] = (dArr3[i5 - 1][i4] + d4) * 0.5d;
                }
                i5 = i6;
            }
            dArr4[i3][i4] = dArr3[length - 2][i4];
        }
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < length2; i8++) {
                double d5 = dArr3[i7][i8];
                if (d5 == 0.0d) {
                    dArr4[i7][i8] = 0.0d;
                    dArr4[i7 + 1][i8] = 0.0d;
                } else {
                    double d6 = dArr4[i7][i8] / d5;
                    int i9 = i7 + 1;
                    double d7 = dArr4[i9][i8] / d5;
                    double dHypot = Math.hypot(d6, d7);
                    if (dHypot > 9.0d) {
                        double d8 = 3.0d / dHypot;
                        double[] dArr6 = dArr4[i7];
                        double[] dArr7 = dArr3[i7];
                        dArr6[i8] = d6 * d8 * dArr7[i8];
                        dArr4[i9][i8] = d8 * d7 * dArr7[i8];
                    }
                }
            }
        }
        this.f31800a = dArr;
        this.f31801b = dArr2;
        this.f31802c = dArr4;
    }

    public static MonotonicCurveFit i(String str) {
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i3 = 0;
        while (iIndexOf2 != -1) {
            dArr[i3] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i3++;
        }
        dArr[i3] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        return j(Arrays.copyOf(dArr, i3 + 1));
    }

    private static MonotonicCurveFit j(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d3 = 1.0d / ((double) length2);
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i3 = 0; i3 < dArr.length; i3++) {
            double d4 = dArr[i3];
            int i4 = i3 + length2;
            dArr2[i4][0] = d4;
            double d5 = ((double) i3) * d3;
            dArr3[i4] = d5;
            if (i3 > 0) {
                int i5 = (length2 * 2) + i3;
                dArr2[i5][0] = d4 + 1.0d;
                dArr3[i5] = d5 + 1.0d;
                int i6 = i3 - 1;
                dArr2[i6][0] = (d4 - 1.0d) - d3;
                dArr3[i6] = (d5 - 1.0d) - d3;
            }
        }
        return new MonotonicCurveFit(dArr3, dArr2);
    }

    private static double k(double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d4 * d4;
        double d10 = d4 * 6.0d;
        double d11 = (((((-6.0d) * d9) * d6) + (d10 * d6)) + ((6.0d * d9) * d5)) - (d10 * d5);
        double d12 = 3.0d * d3;
        return ((((d11 + ((d12 * d8) * d9)) + ((d12 * d7) * d9)) - (((2.0d * d3) * d8) * d4)) - (((4.0d * d3) * d7) * d4)) + (d3 * d7);
    }

    private static double l(double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d4 * d4;
        double d10 = d9 * d4;
        double d11 = 3.0d * d9;
        double d12 = ((((((-2.0d) * d10) * d6) + (d11 * d6)) + ((d10 * 2.0d) * d5)) - (d11 * d5)) + d5;
        double d13 = d3 * d8;
        double d14 = d3 * d7;
        return ((((d12 + (d13 * d10)) + (d10 * d14)) - (d13 * d9)) - (((d3 * 2.0d) * d7) * d9)) + (d14 * d4);
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double c(double d3, int i3) {
        double d4;
        double d5;
        double dF;
        double[] dArr = this.f31800a;
        int length = dArr.length;
        int i4 = 0;
        if (this.f31803d) {
            double d6 = dArr[0];
            if (d3 <= d6) {
                d4 = this.f31801b[0][i3];
                d5 = d3 - d6;
                dF = f(d6, i3);
            } else {
                int i5 = length - 1;
                double d7 = dArr[i5];
                if (d3 >= d7) {
                    d4 = this.f31801b[i5][i3];
                    d5 = d3 - d7;
                    dF = f(d7, i3);
                }
            }
            return d4 + (d5 * dF);
        }
        if (d3 <= dArr[0]) {
            return this.f31801b[0][i3];
        }
        int i6 = length - 1;
        if (d3 >= dArr[i6]) {
            return this.f31801b[i6][i3];
        }
        while (i4 < length - 1) {
            double[] dArr2 = this.f31800a;
            double d8 = dArr2[i4];
            if (d3 == d8) {
                return this.f31801b[i4][i3];
            }
            int i7 = i4 + 1;
            double d9 = dArr2[i7];
            if (d3 < d9) {
                double d10 = d9 - d8;
                double d11 = (d3 - d8) / d10;
                double[][] dArr3 = this.f31801b;
                double d12 = dArr3[i4][i3];
                double d13 = dArr3[i7][i3];
                double[][] dArr4 = this.f31802c;
                return l(d10, d11, d12, d13, dArr4[i4][i3], dArr4[i7][i3]);
            }
            i4 = i7;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void d(double d3, double[] dArr) {
        double[] dArr2 = this.f31800a;
        int length = dArr2.length;
        int i3 = 0;
        int length2 = this.f31801b[0].length;
        if (this.f31803d) {
            double d4 = dArr2[0];
            if (d3 <= d4) {
                g(d4, this.f31804e);
                for (int i4 = 0; i4 < length2; i4++) {
                    dArr[i4] = this.f31801b[0][i4] + ((d3 - this.f31800a[0]) * this.f31804e[i4]);
                }
                return;
            }
            int i5 = length - 1;
            double d5 = dArr2[i5];
            if (d3 >= d5) {
                g(d5, this.f31804e);
                while (i3 < length2) {
                    dArr[i3] = this.f31801b[i5][i3] + ((d3 - this.f31800a[i5]) * this.f31804e[i3]);
                    i3++;
                }
                return;
            }
        } else {
            if (d3 <= dArr2[0]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = this.f31801b[0][i6];
                }
                return;
            }
            int i7 = length - 1;
            if (d3 >= dArr2[i7]) {
                while (i3 < length2) {
                    dArr[i3] = this.f31801b[i7][i3];
                    i3++;
                }
                return;
            }
        }
        int i8 = 0;
        while (i8 < length - 1) {
            if (d3 == this.f31800a[i8]) {
                for (int i9 = 0; i9 < length2; i9++) {
                    dArr[i9] = this.f31801b[i8][i9];
                }
            }
            double[] dArr3 = this.f31800a;
            int i10 = i8 + 1;
            double d6 = dArr3[i10];
            if (d3 < d6) {
                double d7 = dArr3[i8];
                double d8 = d6 - d7;
                double d9 = (d3 - d7) / d8;
                while (i3 < length2) {
                    double[][] dArr4 = this.f31801b;
                    double d10 = dArr4[i8][i3];
                    double d11 = dArr4[i10][i3];
                    double[][] dArr5 = this.f31802c;
                    dArr[i3] = l(d8, d9, d10, d11, dArr5[i8][i3], dArr5[i10][i3]);
                    i3++;
                }
                return;
            }
            i8 = i10;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void e(double d3, float[] fArr) {
        double[] dArr = this.f31800a;
        int length = dArr.length;
        int i3 = 0;
        int length2 = this.f31801b[0].length;
        if (this.f31803d) {
            double d4 = dArr[0];
            if (d3 <= d4) {
                g(d4, this.f31804e);
                for (int i4 = 0; i4 < length2; i4++) {
                    fArr[i4] = (float) (this.f31801b[0][i4] + ((d3 - this.f31800a[0]) * this.f31804e[i4]));
                }
                return;
            }
            int i5 = length - 1;
            double d5 = dArr[i5];
            if (d3 >= d5) {
                g(d5, this.f31804e);
                while (i3 < length2) {
                    fArr[i3] = (float) (this.f31801b[i5][i3] + ((d3 - this.f31800a[i5]) * this.f31804e[i3]));
                    i3++;
                }
                return;
            }
        } else {
            if (d3 <= dArr[0]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) this.f31801b[0][i6];
                }
                return;
            }
            int i7 = length - 1;
            if (d3 >= dArr[i7]) {
                while (i3 < length2) {
                    fArr[i3] = (float) this.f31801b[i7][i3];
                    i3++;
                }
                return;
            }
        }
        int i8 = 0;
        while (i8 < length - 1) {
            if (d3 == this.f31800a[i8]) {
                for (int i9 = 0; i9 < length2; i9++) {
                    fArr[i9] = (float) this.f31801b[i8][i9];
                }
            }
            double[] dArr2 = this.f31800a;
            int i10 = i8 + 1;
            double d6 = dArr2[i10];
            if (d3 < d6) {
                double d7 = dArr2[i8];
                double d8 = d6 - d7;
                double d9 = (d3 - d7) / d8;
                while (i3 < length2) {
                    double[][] dArr3 = this.f31801b;
                    double d10 = dArr3[i8][i3];
                    double d11 = dArr3[i10][i3];
                    double[][] dArr4 = this.f31802c;
                    fArr[i3] = (float) l(d8, d9, d10, d11, dArr4[i8][i3], dArr4[i10][i3]);
                    i3++;
                }
                return;
            }
            i8 = i10;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double f(double d3, int i3) {
        double[] dArr = this.f31800a;
        int length = dArr.length;
        int i4 = 0;
        double d4 = dArr[0];
        if (d3 >= d4) {
            d4 = dArr[length - 1];
            if (d3 < d4) {
                d4 = d3;
            }
        }
        while (i4 < length - 1) {
            double[] dArr2 = this.f31800a;
            int i5 = i4 + 1;
            double d5 = dArr2[i5];
            if (d4 <= d5) {
                double d6 = dArr2[i4];
                double d7 = d5 - d6;
                double d8 = (d4 - d6) / d7;
                double[][] dArr3 = this.f31801b;
                double d9 = dArr3[i4][i3];
                double d10 = dArr3[i5][i3];
                double[][] dArr4 = this.f31802c;
                return k(d7, d8, d9, d10, dArr4[i4][i3], dArr4[i5][i3]) / d7;
            }
            i4 = i5;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void g(double d3, double[] dArr) {
        double[] dArr2 = this.f31800a;
        int length = dArr2.length;
        int length2 = this.f31801b[0].length;
        double d4 = dArr2[0];
        if (d3 > d4) {
            d4 = dArr2[length - 1];
            if (d3 < d4) {
                d4 = d3;
            }
        }
        int i3 = 0;
        while (i3 < length - 1) {
            double[] dArr3 = this.f31800a;
            int i4 = i3 + 1;
            double d5 = dArr3[i4];
            if (d4 <= d5) {
                double d6 = dArr3[i3];
                double d7 = d5 - d6;
                double d8 = (d4 - d6) / d7;
                for (int i5 = 0; i5 < length2; i5++) {
                    double[][] dArr4 = this.f31801b;
                    double d9 = dArr4[i3][i5];
                    double d10 = dArr4[i4][i5];
                    double[][] dArr5 = this.f31802c;
                    dArr[i5] = k(d7, d8, d9, d10, dArr5[i3][i5], dArr5[i4][i5]) / d7;
                }
                return;
            }
            i3 = i4;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] h() {
        return this.f31800a;
    }
}
