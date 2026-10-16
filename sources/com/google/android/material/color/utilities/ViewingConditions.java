package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ViewingConditions {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ViewingConditions f80705k = a(50.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f80706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f80707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f80708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f80709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f80710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f80711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final double[] f80712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final double f80713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final double f80714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final double f80715j;

    private ViewingConditions(double d3, double d4, double d5, double d6, double d7, double d8, double[] dArr, double d9, double d10, double d11) {
        this.f80711f = d3;
        this.f80706a = d4;
        this.f80707b = d5;
        this.f80708c = d6;
        this.f80709d = d7;
        this.f80710e = d8;
        this.f80712g = dArr;
        this.f80713h = d9;
        this.f80714i = d10;
        this.f80715j = d11;
    }

    public static ViewingConditions a(double d3) {
        return l(ColorUtils.n(), (ColorUtils.p(50.0d) * 63.66197723675813d) / 100.0d, d3, 2.0d, false);
    }

    public static ViewingConditions l(double[] dArr, double d3, double d4, double d5, boolean z2) {
        double d6;
        double dExp;
        double dMax = Math.max(0.1d, d4);
        double[][] dArr2 = Cam16.f80590k;
        double d7 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d8 = dArr3[0] * d7;
        double d9 = dArr[1];
        double d10 = d8 + (dArr3[1] * d9);
        double d11 = dArr[2];
        double d12 = d10 + (dArr3[2] * d11);
        double[] dArr4 = dArr2[1];
        double d13 = (dArr4[0] * d7) + (dArr4[1] * d9) + (dArr4[2] * d11);
        double[] dArr5 = dArr2[2];
        double d14 = (d7 * dArr5[0]) + (d9 * dArr5[1]) + (d11 * dArr5[2]);
        double d15 = (d5 / 10.0d) + 0.8d;
        double dC = d15 >= 0.9d ? MathUtils.c(0.59d, 0.69d, (d15 - 0.9d) * 10.0d) : MathUtils.c(0.525d, 0.59d, (d15 - 0.8d) * 10.0d);
        if (z2) {
            d6 = 0.1d;
            dExp = 1.0d;
        } else {
            d6 = 0.1d;
            dExp = (1.0d - (Math.exp(((-d3) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d15;
        }
        double dA = MathUtils.a(0.0d, 1.0d, dExp);
        double[] dArr6 = {(((100.0d / d12) * dA) + 1.0d) - dA, (((100.0d / d13) * dA) + 1.0d) - dA, (((100.0d / d14) * dA) + 1.0d) - dA};
        double d16 = 5.0d * d3;
        double d17 = 1.0d / (d16 + 1.0d);
        double d18 = d17 * d17 * d17 * d17;
        double d19 = 1.0d - d18;
        double dCbrt = (d18 * d3) + (d19 * d6 * d19 * Math.cbrt(d16));
        double dP = ColorUtils.p(dMax) / dArr[1];
        double dSqrt = Math.sqrt(dP) + 1.48d;
        double dPow = 0.725d / Math.pow(dP, 0.2d);
        double[] dArr7 = {Math.pow(((dArr6[0] * dCbrt) * d12) / 100.0d, 0.42d), Math.pow(((dArr6[1] * dCbrt) * d13) / 100.0d, 0.42d), Math.pow(((dArr6[2] * dCbrt) * d14) / 100.0d, 0.42d)};
        double d20 = dArr7[0];
        double d21 = (d20 * 400.0d) / (d20 + 27.13d);
        double d22 = dArr7[1];
        double d23 = (d22 * 400.0d) / (d22 + 27.13d);
        double d24 = dArr7[2];
        double[] dArr8 = {d21, d23, (400.0d * d24) / (d24 + 27.13d)};
        return new ViewingConditions(dP, ((dArr8[0] * 2.0d) + dArr8[1] + (dArr8[2] * 0.05d)) * dPow, dPow, dPow, dC, d15, dArr6, dCbrt, Math.pow(dCbrt, 0.25d), dSqrt);
    }

    public double b() {
        return this.f80706a;
    }

    double c() {
        return this.f80709d;
    }

    double d() {
        return this.f80713h;
    }

    public double e() {
        return this.f80714i;
    }

    public double f() {
        return this.f80711f;
    }

    public double g() {
        return this.f80707b;
    }

    double h() {
        return this.f80710e;
    }

    double i() {
        return this.f80708c;
    }

    public double[] j() {
        return this.f80712g;
    }

    double k() {
        return this.f80715j;
    }
}
