package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Schlick extends Easing {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    double f31813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double f31814e;

    Schlick(String str) {
        this.f31745a = str;
        int iIndexOf = str.indexOf(40);
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        this.f31813d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
        int i3 = iIndexOf2 + 1;
        this.f31814e = Double.parseDouble(str.substring(i3, str.indexOf(44, i3)).trim());
    }

    private double d(double d3) {
        double d4 = this.f31814e;
        if (d3 < d4) {
            double d5 = this.f31813d;
            return ((d5 * d4) * d4) / ((((d4 - d3) * d5) + d3) * ((d5 * (d4 - d3)) + d3));
        }
        double d6 = this.f31813d;
        return (((d4 - 1.0d) * d6) * (d4 - 1.0d)) / (((((-d6) * (d4 - d3)) - d3) + 1.0d) * ((((-d6) * (d4 - d3)) - d3) + 1.0d));
    }

    private double e(double d3) {
        double d4 = this.f31814e;
        return d3 < d4 ? (d4 * d3) / (d3 + (this.f31813d * (d4 - d3))) : ((1.0d - d4) * (d3 - 1.0d)) / ((1.0d - d3) - (this.f31813d * (d4 - d3)));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double a(double d3) {
        return e(d3);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double b(double d3) {
        return d(d3);
    }
}
