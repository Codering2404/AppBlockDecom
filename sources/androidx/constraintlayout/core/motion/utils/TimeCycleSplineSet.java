package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import java.lang.reflect.Array;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class TimeCycleSplineSet {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected static float f31862k = 6.2831855f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected CurveFit f31863a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f31867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f31868f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected long f31871i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f31864b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int[] f31865c = new int[10];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float[][] f31866d = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 10, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected float[] f31869g = new float[3];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected boolean f31870h = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected float f31872j = Float.NaN;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class CustomSet extends TimeCycleSplineSet {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        KeyFrameArray.CustomArray f31873l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        KeyFrameArray.FloatArray f31874m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        float[] f31875n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        float[] f31876o;

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void b(int i3, float f3, float f4, int i4, float f5) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void e(int i3) {
            int iB = this.f31873l.b();
            int iB2 = this.f31873l.c(0).b();
            double[] dArr = new double[iB];
            int i4 = iB2 + 2;
            this.f31875n = new float[i4];
            this.f31876o = new float[iB2];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iB, i4);
            for (int i5 = 0; i5 < iB; i5++) {
                int iA = this.f31873l.a(i5);
                CustomAttribute customAttributeC = this.f31873l.c(i5);
                float[] fArrC = this.f31874m.c(i5);
                dArr[i5] = ((double) iA) * 0.01d;
                customAttributeC.a(this.f31875n);
                int i6 = 0;
                while (true) {
                    if (i6 < this.f31875n.length) {
                        dArr2[i5][i6] = r8[i6];
                        i6++;
                    }
                }
                double[] dArr3 = dArr2[i5];
                dArr3[iB2] = fArrC[0];
                dArr3[iB2 + 1] = fArrC[1];
            }
            this.f31863a = CurveFit.a(i3, dArr, dArr2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    public static class CustomVarSet extends TimeCycleSplineSet {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        KeyFrameArray.CustomVar f31877l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        KeyFrameArray.FloatArray f31878m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        float[] f31879n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        float[] f31880o;

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void b(int i3, float f3, float f4, int i4, float f5) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void e(int i3) {
            int iE = this.f31877l.e();
            int iM = this.f31877l.f(0).m();
            double[] dArr = new double[iE];
            int i4 = iM + 2;
            this.f31879n = new float[i4];
            this.f31880o = new float[iM];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, iE, i4);
            for (int i5 = 0; i5 < iE; i5++) {
                int iC = this.f31877l.c(i5);
                CustomVariable customVariableF = this.f31877l.f(i5);
                float[] fArrC = this.f31878m.c(i5);
                dArr[i5] = ((double) iC) * 0.01d;
                customVariableF.k(this.f31879n);
                int i6 = 0;
                while (true) {
                    if (i6 < this.f31879n.length) {
                        dArr2[i5][i6] = r8[i6];
                        i6++;
                    }
                }
                double[] dArr3 = dArr2[i5];
                dArr3[iM] = fArrC[0];
                dArr3[iM + 1] = fArrC[1];
            }
            this.f31863a = CurveFit.a(i3, dArr, dArr2);
        }

        public void f(int i3, CustomVariable customVariable, float f3, int i4, float f4) {
            this.f31877l.a(i3, customVariable);
            this.f31878m.a(i3, new float[]{f3, f4});
            this.f31864b = Math.max(this.f31864b, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    protected static class Sort {
        static void a(int[] iArr, float[][] fArr, int i3, int i4) {
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

        private static int b(int[] iArr, float[][] fArr, int i3, int i4) {
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

        private static void c(int[] iArr, float[][] fArr, int i3, int i4) {
            int i5 = iArr[i3];
            iArr[i3] = iArr[i4];
            iArr[i4] = i5;
            float[] fArr2 = fArr[i3];
            fArr[i3] = fArr[i4];
            fArr[i4] = fArr2;
        }
    }

    protected float a(float f3) {
        float fAbs;
        switch (this.f31864b) {
            case 1:
                return Math.signum(f3 * f31862k);
            case 2:
                fAbs = Math.abs(f3);
                break;
            case 3:
                return (((f3 * 2.0f) + 1.0f) % 2.0f) - 1.0f;
            case 4:
                fAbs = ((f3 * 2.0f) + 1.0f) % 2.0f;
                break;
            case 5:
                return (float) Math.cos(f3 * f31862k);
            case 6:
                float fAbs2 = 1.0f - Math.abs(((f3 * 4.0f) % 4.0f) - 2.0f);
                fAbs = fAbs2 * fAbs2;
                break;
            default:
                return (float) Math.sin(f3 * f31862k);
        }
        return 1.0f - fAbs;
    }

    public void b(int i3, float f3, float f4, int i4, float f5) {
        int[] iArr = this.f31865c;
        int i5 = this.f31867e;
        iArr[i5] = i3;
        float[] fArr = this.f31866d[i5];
        fArr[0] = f3;
        fArr[1] = f4;
        fArr[2] = f5;
        this.f31864b = Math.max(this.f31864b, i4);
        this.f31867e++;
    }

    protected void c(long j3) {
        this.f31871i = j3;
    }

    public void d(String str) {
        this.f31868f = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(int r12) {
        /*
            r11 = this;
            int r0 = r11.f31867e
            if (r0 != 0) goto L1d
            java.io.PrintStream r12 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error no points added to "
            r0.append(r1)
            java.lang.String r1 = r11.f31868f
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.println(r0)
            return
        L1d:
            int[] r1 = r11.f31865c
            float[][] r2 = r11.f31866d
            r3 = 1
            int r0 = r0 - r3
            r4 = 0
            androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet.Sort.a(r1, r2, r4, r0)
            r0 = r3
            r1 = r4
        L29:
            int[] r2 = r11.f31865c
            int r5 = r2.length
            if (r0 >= r5) goto L3b
            r5 = r2[r0]
            int r6 = r0 + (-1)
            r2 = r2[r6]
            if (r5 == r2) goto L38
            int r1 = r1 + 1
        L38:
            int r0 = r0 + 1
            goto L29
        L3b:
            if (r1 != 0) goto L3e
            r1 = r3
        L3e:
            double[] r0 = new double[r1]
            r2 = 2
            int[] r5 = new int[r2]
            r6 = 3
            r5[r3] = r6
            r5[r4] = r1
            java.lang.Class r1 = java.lang.Double.TYPE
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r5)
            double[][] r1 = (double[][]) r1
            r5 = r4
            r6 = r5
        L52:
            int r7 = r11.f31867e
            if (r5 >= r7) goto L8a
            if (r5 <= 0) goto L63
            int[] r7 = r11.f31865c
            r8 = r7[r5]
            int r9 = r5 + (-1)
            r7 = r7[r9]
            if (r8 != r7) goto L63
            goto L87
        L63:
            int[] r7 = r11.f31865c
            r7 = r7[r5]
            double r7 = (double) r7
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            double r7 = r7 * r9
            r0[r6] = r7
            r7 = r1[r6]
            float[][] r8 = r11.f31866d
            r8 = r8[r5]
            r9 = r8[r4]
            double r9 = (double) r9
            r7[r4] = r9
            r9 = r8[r3]
            double r9 = (double) r9
            r7[r3] = r9
            r8 = r8[r2]
            double r8 = (double) r8
            r7[r2] = r8
            int r6 = r6 + 1
        L87:
            int r5 = r5 + 1
            goto L52
        L8a:
            androidx.constraintlayout.core.motion.utils.CurveFit r12 = androidx.constraintlayout.core.motion.utils.CurveFit.a(r12, r0, r1)
            r11.f31863a = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet.e(int):void");
    }

    public String toString() {
        String str = this.f31868f;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i3 = 0; i3 < this.f31867e; i3++) {
            str = str + "[" + this.f31865c[i3] + " , " + decimalFormat.format(this.f31866d[i3]) + YgVrd.glcvYWvy;
        }
        return str;
    }
}
