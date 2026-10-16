package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class DynamicColor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f80609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function f80610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function f80611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f80612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function f80613e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function f80614f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ContrastCurve f80615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function f80616h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function f80617i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HashMap f80618j;

    public DynamicColor(String str, Function function, Function function2, boolean z2, Function function3, Function function4, ContrastCurve contrastCurve, Function function5) {
        this.f80618j = new HashMap();
        this.f80609a = str;
        this.f80610b = function;
        this.f80611c = function2;
        this.f80612d = z2;
        this.f80613e = function3;
        this.f80614f = function4;
        this.f80615g = contrastCurve;
        this.f80616h = function5;
        this.f80617i = null;
    }

    public static double a(double d3) {
        if (!h(d3) || g(d3)) {
            return d3;
        }
        return 49.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static double b(double r10, double r12) {
        /*
            double r0 = com.google.android.material.color.utilities.Contrast.d(r10, r12)
            double r2 = com.google.android.material.color.utilities.Contrast.b(r10, r12)
            double r4 = com.google.android.material.color.utilities.Contrast.e(r0, r10)
            double r6 = com.google.android.material.color.utilities.Contrast.e(r2, r10)
            boolean r10 = h(r10)
            if (r10 == 0) goto L3b
            double r10 = r4 - r6
            double r10 = java.lang.Math.abs(r10)
            r8 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 >= 0) goto L2f
            int r10 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r10 >= 0) goto L2f
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L2f
            r10 = 1
            goto L30
        L2f:
            r10 = 0
        L30:
            int r11 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r11 >= 0) goto L44
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 >= 0) goto L44
            if (r10 == 0) goto L45
            goto L44
        L3b:
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L45
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 < 0) goto L44
            goto L45
        L44:
            return r0
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.b(double, double):double");
    }

    public static DynamicColor c(String str, Function function, Function function2) {
        return new DynamicColor(str, function, function2, false, null, null, null, null);
    }

    public static boolean g(double d3) {
        return Math.round(d3) <= 49;
    }

    public static boolean h(double d3) {
        return Math.round(d3) < 60;
    }

    public int d(DynamicScheme dynamicScheme) {
        int iH = e(dynamicScheme).h();
        Function function = this.f80617i;
        if (function == null) {
            return iH;
        }
        return (MathUtils.b(0, 255, (int) Math.round(((Double) function.apply(dynamicScheme)).doubleValue() * 255.0d)) << 24) | (iH & 16777215);
    }

    public Hct e(DynamicScheme dynamicScheme) {
        Hct hct = (Hct) this.f80618j.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hctE = ((TonalPalette) this.f80610b.apply(dynamicScheme)).e(f(dynamicScheme));
        if (this.f80618j.size() > 4) {
            this.f80618j.clear();
        }
        this.f80618j.put(dynamicScheme, hctE);
        return hctE;
    }

    public double f(DynamicScheme dynamicScheme) {
        double d3;
        double dMax;
        double dMin;
        boolean z2 = false;
        boolean z3 = dynamicScheme.f80623e < 0.0d;
        Function function = this.f80616h;
        if (function == null) {
            boolean z4 = z3;
            double dDoubleValue = ((Double) this.f80611c.apply(dynamicScheme)).doubleValue();
            Function function2 = this.f80613e;
            if (function2 == null) {
                return dDoubleValue;
            }
            double dF = ((DynamicColor) function2.apply(dynamicScheme)).f(dynamicScheme);
            double dA = this.f80615g.a(dynamicScheme.f80623e);
            if (Contrast.e(dF, dDoubleValue) < dA) {
                dDoubleValue = b(dF, dA);
            }
            if (z4) {
                dDoubleValue = b(dF, dA);
            }
            if (!this.f80612d || 50.0d > dDoubleValue || dDoubleValue >= 60.0d) {
                d3 = dDoubleValue;
            } else {
                d3 = 49.0d;
                if (Contrast.e(49.0d, dF) < dA) {
                    d3 = 60.0d;
                }
            }
            if (this.f80614f != null) {
                double dF2 = ((DynamicColor) this.f80613e.apply(dynamicScheme)).f(dynamicScheme);
                double dF3 = ((DynamicColor) this.f80614f.apply(dynamicScheme)).f(dynamicScheme);
                double dMax2 = Math.max(dF2, dF3);
                double dMin2 = Math.min(dF2, dF3);
                if (Contrast.e(dMax2, d3) < dA || Contrast.e(dMin2, d3) < dA) {
                    double dC = Contrast.c(dMax2, dA);
                    double dA2 = Contrast.a(dMin2, dA);
                    ArrayList arrayList = new ArrayList();
                    if (dC != -1.0d) {
                        arrayList.add(Double.valueOf(dC));
                    }
                    if (dA2 != -1.0d) {
                        arrayList.add(Double.valueOf(dA2));
                    }
                    if (h(dF2) || h(dF3)) {
                        if (dC == -1.0d) {
                            return 100.0d;
                        }
                        return dC;
                    }
                    if (arrayList.size() == 1) {
                        return ((Double) arrayList.get(0)).doubleValue();
                    }
                    if (dA2 == -1.0d) {
                        return 0.0d;
                    }
                    return dA2;
                }
            }
            return d3;
        }
        ToneDeltaPair toneDeltaPair = (ToneDeltaPair) function.apply(dynamicScheme);
        DynamicColor dynamicColorC = toneDeltaPair.c();
        DynamicColor dynamicColorD = toneDeltaPair.d();
        double dA3 = toneDeltaPair.a();
        TonePolarity tonePolarityB = toneDeltaPair.b();
        boolean zE = toneDeltaPair.e();
        double dF4 = ((DynamicColor) this.f80613e.apply(dynamicScheme)).f(dynamicScheme);
        if (tonePolarityB == TonePolarity.NEARER || ((tonePolarityB == TonePolarity.LIGHTER && !dynamicScheme.f80622d) || (tonePolarityB == TonePolarity.DARKER && dynamicScheme.f80622d))) {
            z2 = true;
        }
        DynamicColor dynamicColor = z2 ? dynamicColorC : dynamicColorD;
        DynamicColor dynamicColor2 = z2 ? dynamicColorD : dynamicColorC;
        boolean zEquals = this.f80609a.equals(dynamicColor.f80609a);
        double d4 = dynamicScheme.f80622d ? 1.0d : -1.0d;
        double dA4 = dynamicColor.f80615g.a(dynamicScheme.f80623e);
        double dA5 = dynamicColor2.f80615g.a(dynamicScheme.f80623e);
        double dDoubleValue2 = ((Double) dynamicColor.f80611c.apply(dynamicScheme)).doubleValue();
        if (Contrast.e(dF4, dDoubleValue2) < dA4) {
            dDoubleValue2 = b(dF4, dA4);
        }
        boolean z5 = z3;
        double dDoubleValue3 = ((Double) dynamicColor2.f80611c.apply(dynamicScheme)).doubleValue();
        if (Contrast.e(dF4, dDoubleValue3) < dA5) {
            dDoubleValue3 = b(dF4, dA5);
        }
        if (z5) {
            dDoubleValue2 = b(dF4, dA4);
            dDoubleValue3 = b(dF4, dA5);
        }
        if ((dDoubleValue3 - dDoubleValue2) * d4 < dA3) {
            double d5 = dA3 * d4;
            double dA6 = MathUtils.a(0.0d, 100.0d, dDoubleValue2 + d5);
            if ((dA6 - dDoubleValue2) * d4 < dA3) {
                dDoubleValue2 = MathUtils.a(0.0d, 100.0d, dA6 - d5);
            }
            dDoubleValue3 = dA6;
        }
        if (50.0d > dDoubleValue2 || dDoubleValue2 >= 60.0d) {
            if (50.0d > dDoubleValue3 || dDoubleValue3 >= 60.0d) {
                dMax = dDoubleValue3;
            } else if (!zE) {
                dMax = d4 > 0.0d ? 60.0d : 49.0d;
            } else if (d4 > 0.0d) {
                dMax = Math.max(dDoubleValue3, (dA3 * d4) + 60.0d);
                dDoubleValue2 = 60.0d;
            } else {
                dMin = Math.min(dDoubleValue3, (dA3 * d4) + 49.0d);
                dMax = dMin;
                dDoubleValue2 = 49.0d;
            }
        } else if (d4 > 0.0d) {
            dMax = Math.max(dDoubleValue3, (dA3 * d4) + 60.0d);
            dDoubleValue2 = 60.0d;
        } else {
            dMin = Math.min(dDoubleValue3, (dA3 * d4) + 49.0d);
            dMax = dMin;
            dDoubleValue2 = 49.0d;
        }
        return zEquals ? dDoubleValue2 : dMax;
    }

    public DynamicColor(String str, Function function, Function function2, boolean z2, Function function3, Function function4, ContrastCurve contrastCurve, Function function5, Function function6) {
        this.f80618j = new HashMap();
        this.f80609a = str;
        this.f80610b = function;
        this.f80611c = function2;
        this.f80612d = z2;
        this.f80613e = function3;
        this.f80614f = function4;
        this.f80615g = contrastCurve;
        this.f80616h = function5;
        this.f80617i = function6;
    }
}
