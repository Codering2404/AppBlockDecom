package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Oscillator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    double[] f31807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f31808d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    MonotonicCurveFit f31809e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f31810f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float[] f31805a = new float[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    double[] f31806b = new double[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    double f31811g = 6.283185307179586d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f31812h = false;

    public void a(double d3, float f3) {
        int length = this.f31805a.length + 1;
        int iBinarySearch = Arrays.binarySearch(this.f31806b, d3);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        this.f31806b = Arrays.copyOf(this.f31806b, length);
        this.f31805a = Arrays.copyOf(this.f31805a, length);
        this.f31807c = new double[length];
        double[] dArr = this.f31806b;
        System.arraycopy(dArr, iBinarySearch, dArr, iBinarySearch + 1, (length - iBinarySearch) - 1);
        this.f31806b[iBinarySearch] = d3;
        this.f31805a[iBinarySearch] = f3;
        this.f31812h = false;
    }

    double b(double d3) {
        if (d3 <= 0.0d) {
            return 0.0d;
        }
        if (d3 >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.f31806b, d3);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.f31805a;
        float f3 = fArr[iBinarySearch];
        int i3 = iBinarySearch - 1;
        float f4 = fArr[i3];
        double d4 = f3 - f4;
        double[] dArr = this.f31806b;
        double d5 = dArr[iBinarySearch];
        double d6 = dArr[i3];
        double d7 = d4 / (d5 - d6);
        return (d3 * d7) + (((double) f4) - (d7 * d6));
    }

    double c(double d3) {
        if (d3 <= 0.0d) {
            return 0.0d;
        }
        if (d3 >= 1.0d) {
            return 1.0d;
        }
        int iBinarySearch = Arrays.binarySearch(this.f31806b, d3);
        if (iBinarySearch < 0) {
            iBinarySearch = (-iBinarySearch) - 1;
        }
        float[] fArr = this.f31805a;
        float f3 = fArr[iBinarySearch];
        int i3 = iBinarySearch - 1;
        float f4 = fArr[i3];
        double d4 = f3 - f4;
        double[] dArr = this.f31806b;
        double d5 = dArr[iBinarySearch];
        double d6 = dArr[i3];
        double d7 = d4 / (d5 - d6);
        return this.f31807c[i3] + ((((double) f4) - (d7 * d6)) * (d3 - d6)) + ((d7 * ((d3 * d3) - (d6 * d6))) / 2.0d);
    }

    public double d(double d3, double d4, double d5) {
        double dC = d4 + c(d3);
        double dB = b(d3) + d5;
        switch (this.f31810f) {
            case 1:
                return 0.0d;
            case 2:
                return dB * 4.0d * Math.signum((((dC * 4.0d) + 3.0d) % 4.0d) - 2.0d);
            case 3:
                return dB * 2.0d;
            case 4:
                return (-dB) * 2.0d;
            case 5:
                double d6 = this.f31811g;
                return (-d6) * dB * Math.sin(d6 * dC);
            case 6:
                return dB * 4.0d * ((((dC * 4.0d) + 2.0d) % 4.0d) - 2.0d);
            case 7:
                return this.f31809e.f(dC % 1.0d, 0);
            default:
                double d7 = this.f31811g;
                return dB * d7 * Math.cos(d7 * dC);
        }
    }

    public double e(double d3, double d4) {
        double dAbs;
        double dC = c(d3) + d4;
        switch (this.f31810f) {
            case 1:
                return Math.signum(0.5d - (dC % 1.0d));
            case 2:
                dAbs = Math.abs((((dC * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((dC * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                dAbs = ((dC * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.f31811g * (d4 + dC));
            case 6:
                double dAbs2 = 1.0d - Math.abs(((dC * 4.0d) % 4.0d) - 2.0d);
                dAbs = dAbs2 * dAbs2;
                break;
            case 7:
                return this.f31809e.c(dC % 1.0d, 0);
            default:
                return Math.sin(this.f31811g * dC);
        }
        return 1.0d - dAbs;
    }

    public void f() {
        double d3 = 0.0d;
        int i3 = 0;
        while (true) {
            float[] fArr = this.f31805a;
            if (i3 >= fArr.length) {
                break;
            }
            d3 += (double) fArr[i3];
            i3++;
        }
        double d4 = 0.0d;
        int i4 = 1;
        while (true) {
            float[] fArr2 = this.f31805a;
            if (i4 >= fArr2.length) {
                break;
            }
            int i5 = i4 - 1;
            float f3 = (fArr2[i5] + fArr2[i4]) / 2.0f;
            double[] dArr = this.f31806b;
            d4 += (dArr[i4] - dArr[i5]) * ((double) f3);
            i4++;
        }
        int i6 = 0;
        while (true) {
            float[] fArr3 = this.f31805a;
            if (i6 >= fArr3.length) {
                break;
            }
            fArr3[i6] = fArr3[i6] * ((float) (d3 / d4));
            i6++;
        }
        this.f31807c[0] = 0.0d;
        int i7 = 1;
        while (true) {
            float[] fArr4 = this.f31805a;
            if (i7 >= fArr4.length) {
                this.f31812h = true;
                return;
            }
            int i8 = i7 - 1;
            float f4 = (fArr4[i8] + fArr4[i7]) / 2.0f;
            double[] dArr2 = this.f31806b;
            double d5 = dArr2[i7] - dArr2[i8];
            double[] dArr3 = this.f31807c;
            dArr3[i7] = dArr3[i8] + (d5 * ((double) f4));
            i7++;
        }
    }

    public void g(int i3, String str) {
        this.f31810f = i3;
        this.f31808d = str;
        if (str != null) {
            this.f31809e = MonotonicCurveFit.i(str);
        }
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.f31806b) + " period=" + Arrays.toString(this.f31805a);
    }
}
