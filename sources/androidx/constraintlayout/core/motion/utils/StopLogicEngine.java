package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class StopLogicEngine implements StopEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f31839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f31840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f31841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f31842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f31843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f31844f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f31845g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f31846h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f31847i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f31848j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f31849k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f31851m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f31852n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f31853o;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f31850l = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f31854p = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Decelerate implements StopEngine {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f31855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f31856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f31857c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f31858d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f31859e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f31860f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f31861g = false;

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float a() {
            return this.f31858d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public boolean b() {
            return this.f31861g;
        }

        public void c(float f3, float f4, float f5) {
            this.f31861g = false;
            this.f31855a = f4;
            this.f31856b = f5;
            this.f31860f = f3;
            float f6 = (f4 - f3) / (f5 / 2.0f);
            this.f31859e = f6;
            this.f31857c = (-f5) / f6;
        }

        public float d(float f3) {
            if (f3 > this.f31859e) {
                return 0.0f;
            }
            float f4 = this.f31856b + (this.f31857c * f3);
            this.f31858d = f4;
            return f4;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getInterpolation(float f3) {
            if (f3 > this.f31859e) {
                this.f31861g = true;
                return this.f31855a;
            }
            d(f3);
            return this.f31860f + ((this.f31856b + ((this.f31857c * f3) / 2.0f)) * f3);
        }
    }

    private float c(float f3) {
        this.f31854p = false;
        float f4 = this.f31842d;
        if (f3 <= f4) {
            float f5 = this.f31839a;
            return (f5 * f3) + ((((this.f31840b - f5) * f3) * f3) / (f4 * 2.0f));
        }
        int i3 = this.f31848j;
        if (i3 == 1) {
            return this.f31845g;
        }
        float f6 = f3 - f4;
        float f7 = this.f31843e;
        if (f6 < f7) {
            float f8 = this.f31845g;
            float f9 = this.f31840b;
            return f8 + (f9 * f6) + ((((this.f31841c - f9) * f6) * f6) / (f7 * 2.0f));
        }
        if (i3 == 2) {
            return this.f31846h;
        }
        float f10 = f6 - f7;
        float f11 = this.f31844f;
        if (f10 > f11) {
            this.f31854p = true;
            return this.f31847i;
        }
        float f12 = this.f31846h;
        float f13 = this.f31841c;
        return (f12 + (f13 * f10)) - (((f13 * f10) * f10) / (f11 * 2.0f));
    }

    private void f(float f3, float f4, float f5, float f6, float f7) {
        this.f31854p = false;
        this.f31847i = f4;
        if (f3 == 0.0f) {
            f3 = 1.0E-4f;
        }
        float f8 = f3 / f5;
        float f9 = (f8 * f3) / 2.0f;
        if (f3 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f4 - ((((-f3) / f5) * f3) / 2.0f)) * f5);
            if (fSqrt < f6) {
                this.f31849k = "backward accelerate, decelerate";
                this.f31848j = 2;
                this.f31839a = f3;
                this.f31840b = fSqrt;
                this.f31841c = 0.0f;
                float f10 = (fSqrt - f3) / f5;
                this.f31842d = f10;
                this.f31843e = fSqrt / f5;
                this.f31845g = ((f3 + fSqrt) * f10) / 2.0f;
                this.f31846h = f4;
                this.f31847i = f4;
                return;
            }
            this.f31849k = "backward accelerate cruse decelerate";
            this.f31848j = 3;
            this.f31839a = f3;
            this.f31840b = f6;
            this.f31841c = f6;
            float f11 = (f6 - f3) / f5;
            this.f31842d = f11;
            float f12 = f6 / f5;
            this.f31844f = f12;
            float f13 = ((f3 + f6) * f11) / 2.0f;
            float f14 = (f12 * f6) / 2.0f;
            this.f31843e = ((f4 - f13) - f14) / f6;
            this.f31845g = f13;
            this.f31846h = f4 - f14;
            this.f31847i = f4;
            return;
        }
        if (f9 >= f4) {
            this.f31849k = "hard stop";
            this.f31848j = 1;
            this.f31839a = f3;
            this.f31840b = 0.0f;
            this.f31845g = f4;
            this.f31842d = (2.0f * f4) / f3;
            return;
        }
        float f15 = f4 - f9;
        float f16 = f15 / f3;
        if (f16 + f8 < f7) {
            this.f31849k = "cruse decelerate";
            this.f31848j = 2;
            this.f31839a = f3;
            this.f31840b = f3;
            this.f31841c = 0.0f;
            this.f31845g = f15;
            this.f31846h = f4;
            this.f31842d = f16;
            this.f31843e = f8;
            return;
        }
        float fSqrt2 = (float) Math.sqrt((f5 * f4) + ((f3 * f3) / 2.0f));
        float f17 = (fSqrt2 - f3) / f5;
        this.f31842d = f17;
        float f18 = fSqrt2 / f5;
        this.f31843e = f18;
        if (fSqrt2 < f6) {
            this.f31849k = "accelerate decelerate";
            this.f31848j = 2;
            this.f31839a = f3;
            this.f31840b = fSqrt2;
            this.f31841c = 0.0f;
            this.f31842d = f17;
            this.f31843e = f18;
            this.f31845g = ((f3 + fSqrt2) * f17) / 2.0f;
            this.f31846h = f4;
            return;
        }
        this.f31849k = "accelerate cruse decelerate";
        this.f31848j = 3;
        this.f31839a = f3;
        this.f31840b = f6;
        this.f31841c = f6;
        float f19 = (f6 - f3) / f5;
        this.f31842d = f19;
        float f20 = f6 / f5;
        this.f31844f = f20;
        float f21 = ((f3 + f6) * f19) / 2.0f;
        float f22 = (f20 * f6) / 2.0f;
        this.f31843e = ((f4 - f21) - f22) / f6;
        this.f31845g = f21;
        this.f31846h = f4 - f22;
        this.f31847i = f4;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float a() {
        return this.f31850l ? -e(this.f31853o) : e(this.f31853o);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean b() {
        return a() < 1.0E-5f && Math.abs(this.f31847i - this.f31852n) < 1.0E-5f;
    }

    public void d(float f3, float f4, float f5, float f6, float f7, float f8) {
        this.f31854p = false;
        this.f31851m = f3;
        boolean z2 = f3 > f4;
        this.f31850l = z2;
        if (z2) {
            f(-f5, f3 - f4, f7, f8, f6);
        } else {
            f(f5, f4 - f3, f7, f8, f6);
        }
    }

    public float e(float f3) {
        float f4 = this.f31842d;
        if (f3 <= f4) {
            float f5 = this.f31839a;
            return f5 + (((this.f31840b - f5) * f3) / f4);
        }
        int i3 = this.f31848j;
        if (i3 == 1) {
            return 0.0f;
        }
        float f6 = f3 - f4;
        float f7 = this.f31843e;
        if (f6 < f7) {
            float f8 = this.f31840b;
            return f8 + (((this.f31841c - f8) * f6) / f7);
        }
        if (i3 == 2) {
            return 0.0f;
        }
        float f9 = f6 - f7;
        float f10 = this.f31844f;
        if (f9 >= f10) {
            return 0.0f;
        }
        float f11 = this.f31841c;
        return f11 - ((f9 * f11) / f10);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f3) {
        float fC = c(f3);
        this.f31852n = fC;
        this.f31853o = f3;
        return this.f31850l ? this.f31851m - fC : this.f31851m + fC;
    }
}
