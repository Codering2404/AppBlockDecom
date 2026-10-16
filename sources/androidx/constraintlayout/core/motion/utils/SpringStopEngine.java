package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SpringStopEngine implements StopEngine {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f31829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f31830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f31831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f31832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f31833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f31834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f31835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f31836j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    double f31827a = 0.5d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f31828b = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f31837k = 0;

    private void c(double d3) {
        if (d3 <= 0.0d) {
            return;
        }
        double d4 = this.f31829c;
        double d5 = this.f31827a;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d4 / ((double) this.f31835i)) * d3) * 4.0d)) + 1.0d);
        double d6 = d3 / ((double) iSqrt);
        int i3 = 0;
        while (i3 < iSqrt) {
            float f3 = this.f31833g;
            double d7 = this.f31830d;
            float f4 = this.f31834h;
            double d8 = d4;
            double d9 = ((-d4) * (((double) f3) - d7)) - (((double) f4) * d5);
            float f5 = this.f31835i;
            double d10 = d5;
            double d11 = ((double) f4) + (((d9 / ((double) f5)) * d6) / 2.0d);
            double d12 = ((((-((((double) f3) + ((d6 * d11) / 2.0d)) - d7)) * d8) - (d11 * d10)) / ((double) f5)) * d6;
            double d13 = ((double) f4) + (d12 / 2.0d);
            float f6 = f4 + ((float) d12);
            this.f31834h = f6;
            float f7 = f3 + ((float) (d13 * d6));
            this.f31833g = f7;
            int i4 = this.f31837k;
            if (i4 > 0) {
                if (f7 < 0.0f && (i4 & 1) == 1) {
                    this.f31833g = -f7;
                    this.f31834h = -f6;
                }
                float f8 = this.f31833g;
                if (f8 > 1.0f && (i4 & 2) == 2) {
                    this.f31833g = 2.0f - f8;
                    this.f31834h = -this.f31834h;
                }
            }
            i3++;
            d4 = d8;
            d5 = d10;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float a() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean b() {
        double d3 = ((double) this.f31833g) - this.f31830d;
        double d4 = this.f31829c;
        double d5 = this.f31834h;
        return Math.sqrt((((d5 * d5) * ((double) this.f31835i)) + ((d4 * d3) * d3)) / d4) <= ((double) this.f31836j);
    }

    public void d(float f3, float f4, float f5, float f6, float f7, float f8, float f9, int i3) {
        this.f31830d = f4;
        this.f31827a = f8;
        this.f31828b = false;
        this.f31833g = f3;
        this.f31831e = f5;
        this.f31829c = f7;
        this.f31835i = f6;
        this.f31836j = f9;
        this.f31837k = i3;
        this.f31832f = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f3) {
        c(f3 - this.f31832f);
        this.f31832f = f3;
        if (b()) {
            this.f31833g = (float) this.f31830d;
        }
        return this.f31833g;
    }
}
