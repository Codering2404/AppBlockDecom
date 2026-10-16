package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class StepCurve extends Easing {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    MonotonicCurveFit f31838d;

    StepCurve(String str) {
        this.f31745a = str;
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
        this.f31838d = d(Arrays.copyOf(dArr, i3 + 1));
    }

    private static MonotonicCurveFit d(double[] dArr) {
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
        MonotonicCurveFit monotonicCurveFit = new MonotonicCurveFit(dArr3, dArr2);
        System.out.println(" 0 " + monotonicCurveFit.c(0.0d, 0));
        System.out.println(" 1 " + monotonicCurveFit.c(1.0d, 0));
        return monotonicCurveFit;
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double a(double d3) {
        return this.f31838d.c(d3, 0);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double b(double d3) {
        return this.f31838d.f(d3, 0);
    }
}
