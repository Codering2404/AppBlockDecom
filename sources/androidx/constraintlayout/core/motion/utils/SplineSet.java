package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SplineSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected CurveFit f31815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int[] f31816b = new int[10];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float[] f31817c = new float[10];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f31819e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CoreSpline extends SplineSet {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f31820f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f31821g;

        CoreSpline(String str, long j3) {
            this.f31820f = str;
            this.f31821g = j3;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void f(TypedValues typedValues, float f3) {
            typedValues.c(typedValues.a(this.f31820f), a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CustomSet extends SplineSet {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        KeyFrameArray.CustomArray f31822f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float[] f31823g;

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void e(int i3, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void h(int i3) {
            int iB = this.f31822f.b();
            int iB2 = this.f31822f.c(0).b();
            double[] dArr = new double[iB];
            this.f31823g = new float[iB2];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iB, iB2);
            for (int i4 = 0; i4 < iB; i4++) {
                int iA = this.f31822f.a(i4);
                CustomAttribute customAttributeC = this.f31822f.c(i4);
                dArr[i4] = ((double) iA) * 0.01d;
                customAttributeC.a(this.f31823g);
                int i5 = 0;
                while (true) {
                    if (i5 < this.f31823g.length) {
                        dArr2[i4][i5] = r6[i5];
                        i5++;
                    }
                }
            }
            this.f31815a = CurveFit.a(i3, dArr, dArr2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CustomSpline extends SplineSet {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f31824f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        KeyFrameArray.CustomVar f31825g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float[] f31826h;

        public CustomSpline(String str, KeyFrameArray.CustomVar customVar) {
            this.f31824f = str.split(",")[1];
            this.f31825g = customVar;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void e(int i3, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void f(TypedValues typedValues, float f3) {
            j((MotionWidget) typedValues, f3);
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void h(int i3) {
            int iE = this.f31825g.e();
            int iM = this.f31825g.f(0).m();
            double[] dArr = new double[iE];
            this.f31826h = new float[iM];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iE, iM);
            for (int i4 = 0; i4 < iE; i4++) {
                int iC = this.f31825g.c(i4);
                CustomVariable customVariableF = this.f31825g.f(i4);
                dArr[i4] = ((double) iC) * 0.01d;
                customVariableF.k(this.f31826h);
                int i5 = 0;
                while (true) {
                    if (i5 < this.f31826h.length) {
                        dArr2[i4][i5] = r6[i5];
                        i5++;
                    }
                }
            }
            this.f31815a = CurveFit.a(i3, dArr, dArr2);
        }

        public void i(int i3, CustomVariable customVariable) {
            this.f31825g.a(i3, customVariable);
        }

        public void j(MotionWidget motionWidget, float f3) {
            this.f31815a.e(f3, this.f31826h);
            this.f31825g.f(0).q(motionWidget, this.f31826h);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Sort {
        static void a(int[] iArr, float[] fArr, int i3, int i4) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i4;
            iArr2[1] = i3;
            int i5 = 2;
            while (i5 > 0) {
                int i6 = iArr2[i5 - 1];
                int i7 = i5 - 2;
                int i8 = iArr2[i7];
                if (i6 < i8) {
                    int iB = b(iArr, fArr, i6, i8);
                    iArr2[i7] = iB - 1;
                    iArr2[i5 - 1] = i6;
                    int i9 = i5 + 1;
                    iArr2[i5] = i8;
                    i5 += 2;
                    iArr2[i9] = iB + 1;
                } else {
                    i5 = i7;
                }
            }
        }

        private static int b(int[] iArr, float[] fArr, int i3, int i4) {
            int i5 = iArr[i4];
            int i6 = i3;
            while (i3 < i4) {
                if (iArr[i3] <= i5) {
                    c(iArr, fArr, i6, i3);
                    i6++;
                }
                i3++;
            }
            c(iArr, fArr, i6, i4);
            return i6;
        }

        private static void c(int[] iArr, float[] fArr, int i3, int i4) {
            int i5 = iArr[i3];
            iArr[i3] = iArr[i4];
            iArr[i4] = i5;
            float f3 = fArr[i3];
            fArr[i3] = fArr[i4];
            fArr[i4] = f3;
        }
    }

    public static SplineSet c(String str, KeyFrameArray.CustomVar customVar) {
        return new CustomSpline(str, customVar);
    }

    public static SplineSet d(String str, long j3) {
        return new CoreSpline(str, j3);
    }

    public float a(float f3) {
        return (float) this.f31815a.c(f3, 0);
    }

    public float b(float f3) {
        return (float) this.f31815a.f(f3, 0);
    }

    public void e(int i3, float f3) {
        int[] iArr = this.f31816b;
        if (iArr.length < this.f31818d + 1) {
            this.f31816b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f31817c;
            this.f31817c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f31816b;
        int i4 = this.f31818d;
        iArr2[i4] = i3;
        this.f31817c[i4] = f3;
        this.f31818d = i4 + 1;
    }

    public void f(TypedValues typedValues, float f3) {
        typedValues.c(TypedValues.AttributesType.a(this.f31819e), a(f3));
    }

    public void g(String str) {
        this.f31819e = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(int r10) {
        /*
            r9 = this;
            int r0 = r9.f31818d
            if (r0 != 0) goto L5
            return
        L5:
            int[] r1 = r9.f31816b
            float[] r2 = r9.f31817c
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            androidx.constraintlayout.core.motion.utils.SplineSet.Sort.a(r1, r2, r4, r0)
            r0 = r3
            r1 = r0
        L11:
            int r2 = r9.f31818d
            if (r0 >= r2) goto L24
            int[] r2 = r9.f31816b
            int r5 = r0 + (-1)
            r5 = r2[r5]
            r2 = r2[r0]
            if (r5 == r2) goto L21
            int r1 = r1 + 1
        L21:
            int r0 = r0 + 1
            goto L11
        L24:
            double[] r0 = new double[r1]
            r2 = 2
            int[] r2 = new int[r2]
            r2[r3] = r3
            r2[r4] = r1
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r2)
            double[][] r1 = (double[][]) r1
            r2 = r4
            r3 = r2
        L37:
            int r5 = r9.f31818d
            if (r2 >= r5) goto L63
            if (r2 <= 0) goto L48
            int[] r5 = r9.f31816b
            r6 = r5[r2]
            int r7 = r2 + (-1)
            r5 = r5[r7]
            if (r6 != r5) goto L48
            goto L60
        L48:
            int[] r5 = r9.f31816b
            r5 = r5[r2]
            double r5 = (double) r5
            r7 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r5 = r5 * r7
            r0[r3] = r5
            r5 = r1[r3]
            float[] r6 = r9.f31817c
            r6 = r6[r2]
            double r6 = (double) r6
            r5[r4] = r6
            int r3 = r3 + 1
        L60:
            int r2 = r2 + 1
            goto L37
        L63:
            androidx.constraintlayout.core.motion.utils.CurveFit r10 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r10, r0, r1)
            r9.f31815a = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.SplineSet.h(int):void");
    }

    public String toString() {
        String str = this.f31819e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i3 = 0; i3 < this.f31818d; i3++) {
            str = str + "[" + this.f31816b[i3] + " , " + decimalFormat.format(this.f31817c[i3]) + "] ";
        }
        return str;
    }
}
