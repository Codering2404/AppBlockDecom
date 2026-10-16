package com.google.android.material.color.utilities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Contrast {
    public static double a(double d3, double d4) {
        if (d3 >= 0.0d && d3 <= 100.0d) {
            double dP = ColorUtils.p(d3);
            double d5 = ((dP + 5.0d) / d4) - 5.0d;
            if (d5 >= 0.0d && d5 <= 100.0d) {
                double dF = f(dP, d5);
                double dAbs = Math.abs(dF - d4);
                if (dF < d4 && dAbs > 0.04d) {
                    return -1.0d;
                }
                double dL = ColorUtils.l(d5) - 0.4d;
                if (dL >= 0.0d && dL <= 100.0d) {
                    return dL;
                }
            }
        }
        return -1.0d;
    }

    public static double b(double d3, double d4) {
        return Math.max(0.0d, a(d3, d4));
    }

    public static double c(double d3, double d4) {
        if (d3 >= 0.0d && d3 <= 100.0d) {
            double dP = ColorUtils.p(d3);
            double d5 = ((dP + 5.0d) * d4) - 5.0d;
            if (d5 >= 0.0d && d5 <= 100.0d) {
                double dF = f(d5, dP);
                double dAbs = Math.abs(dF - d4);
                if (dF < d4 && dAbs > 0.04d) {
                    return -1.0d;
                }
                double dL = ColorUtils.l(d5) + 0.4d;
                if (dL >= 0.0d && dL <= 100.0d) {
                    return dL;
                }
            }
        }
        return -1.0d;
    }

    public static double d(double d3, double d4) {
        double dC = c(d3, d4);
        if (dC < 0.0d) {
            return 100.0d;
        }
        return dC;
    }

    public static double e(double d3, double d4) {
        return f(ColorUtils.p(d3), ColorUtils.p(d4));
    }

    public static double f(double d3, double d4) {
        double dMax = Math.max(d3, d4);
        if (dMax != d4) {
            d3 = d4;
        }
        return (dMax + 5.0d) / (d3 + 5.0d);
    }
}
