package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Easing {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static Easing f31743b = new Easing();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String[] f31744c = {"standard", "accelerate", "decelerate", "linear"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f31745a = "identity";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CubicEasing extends Easing {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static double f31746h = 0.01d;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static double f31747i = 1.0E-4d;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        double f31748d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        double f31749e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        double f31750f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        double f31751g;

        CubicEasing(String str) {
            this.f31745a = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f31748d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i3 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i3);
            this.f31749e = Double.parseDouble(str.substring(i3, iIndexOf3).trim());
            int i4 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i4);
            this.f31750f = Double.parseDouble(str.substring(i4, iIndexOf4).trim());
            int i5 = iIndexOf4 + 1;
            this.f31751g = Double.parseDouble(str.substring(i5, str.indexOf(41, i5)).trim());
        }

        private double d(double d3) {
            double d4 = 1.0d - d3;
            double d5 = 3.0d * d4;
            return (this.f31748d * d4 * d5 * d3) + (this.f31750f * d5 * d3 * d3) + (d3 * d3 * d3);
        }

        private double e(double d3) {
            double d4 = 1.0d - d3;
            double d5 = 3.0d * d4;
            return (this.f31749e * d4 * d5 * d3) + (this.f31751g * d5 * d3 * d3) + (d3 * d3 * d3);
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double a(double d3) {
            if (d3 <= 0.0d) {
                return 0.0d;
            }
            if (d3 >= 1.0d) {
                return 1.0d;
            }
            double d4 = 0.5d;
            double d5 = 0.5d;
            while (d4 > f31746h) {
                d4 *= 0.5d;
                d5 = d(d5) < d3 ? d5 + d4 : d5 - d4;
            }
            double d6 = d5 - d4;
            double d7 = d(d6);
            double d8 = d5 + d4;
            double d9 = d(d8);
            double dE = e(d6);
            return (((e(d8) - dE) * (d3 - d7)) / (d9 - d7)) + dE;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public double b(double d3) {
            double d4 = 0.5d;
            double d5 = 0.5d;
            while (d4 > f31747i) {
                d4 *= 0.5d;
                d5 = d(d5) < d3 ? d5 + d4 : d5 - d4;
            }
            double d6 = d5 - d4;
            double d7 = d5 + d4;
            return (e(d7) - e(d6)) / (d(d7) - d(d6));
        }
    }

    public static Easing c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new CubicEasing(str);
        }
        if (str.startsWith("spline")) {
            return new StepCurve(str);
        }
        if (str.startsWith("Schlick")) {
            return new Schlick(str);
        }
        switch (str) {
            case "accelerate":
                return new CubicEasing("cubic(0.4, 0.05, 0.8, 0.7)");
            case "decelerate":
                return new CubicEasing("cubic(0.0, 0.0, 0.2, 0.95)");
            case "anticipate":
                return new CubicEasing("cubic(0.36, 0, 0.66, -0.56)");
            case "linear":
                return new CubicEasing("cubic(1, 1, 0, 0)");
            case "overshoot":
                return new CubicEasing("cubic(0.34, 1.56, 0.64, 1)");
            case "standard":
                return new CubicEasing("cubic(0.4, 0.0, 0.2, 1)");
            default:
                System.err.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f31744c));
                return f31743b;
        }
    }

    public double b(double d3) {
        return 1.0d;
    }

    public String toString() {
        return this.f31745a;
    }

    public double a(double d3) {
        return d3;
    }
}
