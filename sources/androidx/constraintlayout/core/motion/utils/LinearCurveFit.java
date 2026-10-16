package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LinearCurveFit extends CurveFit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double[] f31795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double[][] f31796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f31797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f31798d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    double[] f31799e;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        this.f31797c = Double.NaN;
        int length = dArr2[0].length;
        this.f31799e = new double[length];
        this.f31795a = dArr;
        this.f31796b = dArr2;
        if (length <= 2) {
            return;
        }
        int i3 = 0;
        double d3 = 0.0d;
        while (true) {
            double d4 = d3;
            if (i3 >= dArr.length) {
                this.f31797c = 0.0d;
                return;
            }
            double d5 = dArr2[i3][0];
            if (i3 > 0) {
                Math.hypot(d5 - d3, d5 - d4);
            }
            i3++;
            d3 = d5;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double c(double d3, int i3) {
        double d4;
        double d5;
        double dF;
        double[] dArr = this.f31795a;
        int length = dArr.length;
        int i4 = 0;
        if (this.f31798d) {
            double d6 = dArr[0];
            if (d3 <= d6) {
                d4 = this.f31796b[0][i3];
                d5 = d3 - d6;
                dF = f(d6, i3);
            } else {
                int i5 = length - 1;
                double d7 = dArr[i5];
                if (d3 >= d7) {
                    d4 = this.f31796b[i5][i3];
                    d5 = d3 - d7;
                    dF = f(d7, i3);
                }
            }
            return d4 + (d5 * dF);
        }
        if (d3 <= dArr[0]) {
            return this.f31796b[0][i3];
        }
        int i6 = length - 1;
        if (d3 >= dArr[i6]) {
            return this.f31796b[i6][i3];
        }
        while (i4 < length - 1) {
            double[] dArr2 = this.f31795a;
            double d8 = dArr2[i4];
            if (d3 == d8) {
                return this.f31796b[i4][i3];
            }
            int i7 = i4 + 1;
            double d9 = dArr2[i7];
            if (d3 < d9) {
                double d10 = (d3 - d8) / (d9 - d8);
                double[][] dArr3 = this.f31796b;
                return (dArr3[i4][i3] * (1.0d - d10)) + (dArr3[i7][i3] * d10);
            }
            i4 = i7;
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void d(double d3, double[] dArr) {
        double[] dArr2 = this.f31795a;
        int length = dArr2.length;
        int i3 = 0;
        int length2 = this.f31796b[0].length;
        if (this.f31798d) {
            double d4 = dArr2[0];
            if (d3 <= d4) {
                g(d4, this.f31799e);
                for (int i4 = 0; i4 < length2; i4++) {
                    dArr[i4] = this.f31796b[0][i4] + ((d3 - this.f31795a[0]) * this.f31799e[i4]);
                }
                return;
            }
            int i5 = length - 1;
            double d5 = dArr2[i5];
            if (d3 >= d5) {
                g(d5, this.f31799e);
                while (i3 < length2) {
                    dArr[i3] = this.f31796b[i5][i3] + ((d3 - this.f31795a[i5]) * this.f31799e[i3]);
                    i3++;
                }
                return;
            }
        } else {
            if (d3 <= dArr2[0]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    dArr[i6] = this.f31796b[0][i6];
                }
                return;
            }
            int i7 = length - 1;
            if (d3 >= dArr2[i7]) {
                while (i3 < length2) {
                    dArr[i3] = this.f31796b[i7][i3];
                    i3++;
                }
                return;
            }
        }
        int i8 = 0;
        while (i8 < length - 1) {
            if (d3 == this.f31795a[i8]) {
                for (int i9 = 0; i9 < length2; i9++) {
                    dArr[i9] = this.f31796b[i8][i9];
                }
            }
            double[] dArr3 = this.f31795a;
            int i10 = i8 + 1;
            double d6 = dArr3[i10];
            if (d3 < d6) {
                double d7 = dArr3[i8];
                double d8 = (d3 - d7) / (d6 - d7);
                while (i3 < length2) {
                    double[][] dArr4 = this.f31796b;
                    dArr[i3] = (dArr4[i8][i3] * (1.0d - d8)) + (dArr4[i10][i3] * d8);
                    i3++;
                }
                return;
            }
            i8 = i10;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void e(double d3, float[] fArr) {
        double[] dArr = this.f31795a;
        int length = dArr.length;
        int i3 = 0;
        int length2 = this.f31796b[0].length;
        if (this.f31798d) {
            double d4 = dArr[0];
            if (d3 <= d4) {
                g(d4, this.f31799e);
                for (int i4 = 0; i4 < length2; i4++) {
                    fArr[i4] = (float) (this.f31796b[0][i4] + ((d3 - this.f31795a[0]) * this.f31799e[i4]));
                }
                return;
            }
            int i5 = length - 1;
            double d5 = dArr[i5];
            if (d3 >= d5) {
                g(d5, this.f31799e);
                while (i3 < length2) {
                    fArr[i3] = (float) (this.f31796b[i5][i3] + ((d3 - this.f31795a[i5]) * this.f31799e[i3]));
                    i3++;
                }
                return;
            }
        } else {
            if (d3 <= dArr[0]) {
                for (int i6 = 0; i6 < length2; i6++) {
                    fArr[i6] = (float) this.f31796b[0][i6];
                }
                return;
            }
            int i7 = length - 1;
            if (d3 >= dArr[i7]) {
                while (i3 < length2) {
                    fArr[i3] = (float) this.f31796b[i7][i3];
                    i3++;
                }
                return;
            }
        }
        int i8 = 0;
        while (i8 < length - 1) {
            if (d3 == this.f31795a[i8]) {
                for (int i9 = 0; i9 < length2; i9++) {
                    fArr[i9] = (float) this.f31796b[i8][i9];
                }
            }
            double[] dArr2 = this.f31795a;
            int i10 = i8 + 1;
            double d6 = dArr2[i10];
            if (d3 < d6) {
                double d7 = dArr2[i8];
                double d8 = (d3 - d7) / (d6 - d7);
                while (i3 < length2) {
                    double[][] dArr3 = this.f31796b;
                    fArr[i3] = (float) ((dArr3[i8][i3] * (1.0d - d8)) + (dArr3[i10][i3] * d8));
                    i3++;
                }
                return;
            }
            i8 = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a A[PHI: r3
      0x000a: PHI (r3v4 double) = (r3v0 double), (r3v2 double) binds: [B:3:0x0008, B:6:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public double f(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.f31795a
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto Lc
        La:
            r8 = r3
            goto L15
        Lc:
            int r3 = r1 + (-1)
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L15
            goto La
        L15:
            int r0 = r1 + (-1)
            if (r2 >= r0) goto L35
            double[] r0 = r7.f31795a
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L33
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.f31796b
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r8 = r8[r10]
            double r8 = r8 - r0
            double r8 = r8 / r4
            return r8
        L33:
            r2 = r3
            goto L15
        L35:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.f(double, int):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000f A[PHI: r4
      0x000f: PHI (r4v5 double) = (r4v0 double), (r4v2 double) binds: [B:3:0x000d, B:6:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(double r11, double[] r13) {
        /*
            r10 = this;
            double[] r0 = r10.f31795a
            int r1 = r0.length
            double[][] r2 = r10.f31796b
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 > 0) goto L11
        Lf:
            r11 = r4
            goto L1a
        L11:
            int r4 = r1 + (-1)
            r4 = r0[r4]
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 < 0) goto L1a
            goto Lf
        L1a:
            r0 = r3
        L1b:
            int r4 = r1 + (-1)
            if (r0 >= r4) goto L41
            double[] r4 = r10.f31795a
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r8 > 0) goto L3f
            r11 = r4[r0]
            double r6 = r6 - r11
        L2c:
            if (r3 >= r2) goto L41
            double[][] r11 = r10.f31796b
            r12 = r11[r0]
            r8 = r12[r3]
            r11 = r11[r5]
            r11 = r11[r3]
            double r11 = r11 - r8
            double r11 = r11 / r6
            r13[r3] = r11
            int r3 = r3 + 1
            goto L2c
        L3f:
            r0 = r5
            goto L1b
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.LinearCurveFit.g(double, double[]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] h() {
        return this.f31795a;
    }
}
