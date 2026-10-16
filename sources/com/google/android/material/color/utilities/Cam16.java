package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Cam16 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final double[][] f80590k = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final double[][] f80591l = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f80592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f80593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f80594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f80595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f80596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f80597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final double f80598g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final double f80599h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final double f80600i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final double[] f80601j = {0.0d, 0.0d, 0.0d};

    private Cam16(double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11) {
        this.f80592a = d3;
        this.f80593b = d4;
        this.f80594c = d5;
        this.f80595d = d6;
        this.f80596e = d7;
        this.f80597f = d8;
        this.f80598g = d9;
        this.f80599h = d10;
        this.f80600i = d11;
    }

    public static Cam16 a(int i3) {
        return b(i3, ViewingConditions.f80705k);
    }

    static Cam16 b(int i3, ViewingConditions viewingConditions) {
        double dJ = ColorUtils.j((16711680 & i3) >> 16);
        double dJ2 = ColorUtils.j((65280 & i3) >> 8);
        double dJ3 = ColorUtils.j(i3 & 255);
        return c((0.41233895d * dJ) + (0.35762064d * dJ2) + (0.18051042d * dJ3), (0.2126d * dJ) + (0.7152d * dJ2) + (0.0722d * dJ3), (dJ * 0.01932141d) + (dJ2 * 0.11916382d) + (dJ3 * 0.95034478d), viewingConditions);
    }

    static Cam16 c(double d3, double d4, double d5, ViewingConditions viewingConditions) {
        double[][] dArr = f80590k;
        double[] dArr2 = dArr[0];
        double d6 = (dArr2[0] * d3) + (dArr2[1] * d4) + (dArr2[2] * d5);
        double[] dArr3 = dArr[1];
        double d7 = (dArr3[0] * d3) + (dArr3[1] * d4) + (dArr3[2] * d5);
        double[] dArr4 = dArr[2];
        double d8 = (dArr4[0] * d3) + (dArr4[1] * d4) + (dArr4[2] * d5);
        double d9 = viewingConditions.j()[0] * d6;
        double d10 = viewingConditions.j()[1] * d7;
        double d11 = viewingConditions.j()[2] * d8;
        double dPow = Math.pow((viewingConditions.d() * Math.abs(d9)) / 100.0d, 0.42d);
        double dPow2 = Math.pow((viewingConditions.d() * Math.abs(d10)) / 100.0d, 0.42d);
        double dPow3 = Math.pow((viewingConditions.d() * Math.abs(d11)) / 100.0d, 0.42d);
        double dSignum = ((Math.signum(d9) * 400.0d) * dPow) / (dPow + 27.13d);
        double dSignum2 = ((Math.signum(d10) * 400.0d) * dPow2) / (dPow2 + 27.13d);
        double dSignum3 = ((Math.signum(d11) * 400.0d) * dPow3) / (dPow3 + 27.13d);
        double d12 = (((dSignum * 11.0d) + ((-12.0d) * dSignum2)) + dSignum3) / 11.0d;
        double d13 = ((dSignum + dSignum2) - (dSignum3 * 2.0d)) / 9.0d;
        double d14 = dSignum2 * 20.0d;
        double d15 = (((dSignum * 20.0d) + d14) + (21.0d * dSignum3)) / 20.0d;
        double d16 = (((dSignum * 40.0d) + d14) + dSignum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d13, d12));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d17 = degrees;
        double radians = Math.toRadians(d17);
        double dPow4 = Math.pow((d16 * viewingConditions.g()) / viewingConditions.b(), viewingConditions.c() * viewingConditions.k()) * 100.0d;
        double d18 = dPow4 / 100.0d;
        double dC = (4.0d / viewingConditions.c()) * Math.sqrt(d18) * (viewingConditions.b() + 4.0d) * viewingConditions.e();
        double dPow5 = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.f()), 0.73d) * Math.pow(((((((Math.cos(Math.toRadians(d17 < 20.14d ? d17 + 360.0d : d17) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * viewingConditions.h()) * viewingConditions.i()) * Math.hypot(d12, d13)) / (d15 + 0.305d), 0.9d);
        double dSqrt = dPow5 * Math.sqrt(d18);
        double dE = dSqrt * viewingConditions.e();
        double dSqrt2 = Math.sqrt((dPow5 * viewingConditions.c()) / (viewingConditions.b() + 4.0d)) * 50.0d;
        double d19 = (1.7000000000000002d * dPow4) / ((0.007d * dPow4) + 1.0d);
        double dLog1p = Math.log1p(0.0228d * dE) * 43.859649122807014d;
        return new Cam16(d17, dSqrt, dPow4, dC, dE, dSqrt2, d19, dLog1p * Math.cos(radians), dLog1p * Math.sin(radians));
    }

    public double d() {
        return this.f80593b;
    }

    public double e() {
        return this.f80592a;
    }

    public double f() {
        return this.f80594c;
    }

    double[] g(ViewingConditions viewingConditions, double[] dArr) {
        double dPow = Math.pow(((d() == 0.0d || f() == 0.0d) ? 0.0d : d() / Math.sqrt(f() / 100.0d)) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.f()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(e());
        double dCos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d;
        double dB = viewingConditions.b() * Math.pow(f() / 100.0d, (1.0d / viewingConditions.c()) / viewingConditions.k());
        double dH = dCos * 3846.153846153846d * viewingConditions.h() * viewingConditions.i();
        double dG = dB / viewingConditions.g();
        double dSin = Math.sin(radians);
        double dCos2 = Math.cos(radians);
        double d3 = (((0.305d + dG) * 23.0d) * dPow) / (((dH * 23.0d) + ((11.0d * dPow) * dCos2)) + ((dPow * 108.0d) * dSin));
        double d4 = dCos2 * d3;
        double d5 = d3 * dSin;
        double d6 = dG * 460.0d;
        double d7 = (((451.0d * d4) + d6) + (288.0d * d5)) / 1403.0d;
        double d8 = ((d6 - (891.0d * d4)) - (261.0d * d5)) / 1403.0d;
        double d9 = ((d6 - (d4 * 220.0d)) - (d5 * 6300.0d)) / 1403.0d;
        double dSignum = Math.signum(d7) * (100.0d / viewingConditions.d()) * Math.pow(Math.max(0.0d, (Math.abs(d7) * 27.13d) / (400.0d - Math.abs(d7))), 2.380952380952381d);
        double dSignum2 = Math.signum(d8) * (100.0d / viewingConditions.d()) * Math.pow(Math.max(0.0d, (Math.abs(d8) * 27.13d) / (400.0d - Math.abs(d8))), 2.380952380952381d);
        double dSignum3 = Math.signum(d9) * (100.0d / viewingConditions.d()) * Math.pow(Math.max(0.0d, (Math.abs(d9) * 27.13d) / (400.0d - Math.abs(d9))), 2.380952380952381d);
        double d10 = dSignum / viewingConditions.j()[0];
        double d11 = dSignum2 / viewingConditions.j()[1];
        double d12 = dSignum3 / viewingConditions.j()[2];
        double[][] dArr2 = f80591l;
        double[] dArr3 = dArr2[0];
        double d13 = (dArr3[0] * d10) + (dArr3[1] * d11) + (dArr3[2] * d12);
        double[] dArr4 = dArr2[1];
        double d14 = (dArr4[0] * d10) + (dArr4[1] * d11) + (dArr4[2] * d12);
        double[] dArr5 = dArr2[2];
        double d15 = (d10 * dArr5[0]) + (d11 * dArr5[1]) + (d12 * dArr5[2]);
        if (dArr == null) {
            return new double[]{d13, d14, d15};
        }
        dArr[0] = d13;
        dArr[1] = d14;
        dArr[2] = d15;
        return dArr;
    }
}
