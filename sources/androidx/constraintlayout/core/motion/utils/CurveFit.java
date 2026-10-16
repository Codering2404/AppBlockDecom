package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CurveFit {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Constant extends CurveFit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f31741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        double[] f31742b;

        Constant(double d3, double[] dArr) {
            this.f31741a = d3;
            this.f31742b = dArr;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double c(double d3, int i3) {
            return this.f31742b[i3];
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void d(double d3, double[] dArr) {
            double[] dArr2 = this.f31742b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void e(double d3, float[] fArr) {
            int i3 = 0;
            while (true) {
                double[] dArr = this.f31742b;
                if (i3 >= dArr.length) {
                    return;
                }
                fArr[i3] = (float) dArr[i3];
                i3++;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double f(double d3, int i3) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public void g(double d3, double[] dArr) {
            for (int i3 = 0; i3 < this.f31742b.length; i3++) {
                dArr[i3] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public double[] h() {
            return new double[]{this.f31741a};
        }
    }

    public static CurveFit a(int i3, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i3 = 2;
        }
        return i3 != 0 ? i3 != 2 ? new LinearCurveFit(dArr, dArr2) : new Constant(dArr[0], dArr2[0]) : new MonotonicCurveFit(dArr, dArr2);
    }

    public static CurveFit b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double c(double d3, int i3);

    public abstract void d(double d3, double[] dArr);

    public abstract void e(double d3, float[] fArr);

    public abstract double f(double d3, int i3);

    public abstract void g(double d3, double[] dArr);

    public abstract double[] h();
}
