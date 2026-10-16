package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class VelocityMatrix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f31897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float f31898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    float f31899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f31900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f31901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f31902f;

    public void a(float f3, float f4, int i3, int i4, float[] fArr) {
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = (f4 - 0.5f) * 2.0f;
        float f9 = f5 + this.f31899c;
        float f10 = f6 + this.f31900d;
        float f11 = f9 + (this.f31897a * f7);
        float f12 = f10 + (this.f31898b * f8);
        float radians = (float) Math.toRadians(this.f31902f);
        float radians2 = (float) Math.toRadians(this.f31901e);
        double d3 = radians;
        double d4 = i4 * f8;
        float fSin = f11 + (((float) ((((double) ((-i3) * f7)) * Math.sin(d3)) - (Math.cos(d3) * d4))) * radians2);
        float fCos = f12 + (radians2 * ((float) ((((double) (i3 * f7)) * Math.cos(d3)) - (d4 * Math.sin(d3)))));
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    public void b() {
        this.f31901e = 0.0f;
        this.f31900d = 0.0f;
        this.f31899c = 0.0f;
        this.f31898b = 0.0f;
        this.f31897a = 0.0f;
    }

    public void c(KeyCycleOscillator keyCycleOscillator, float f3) {
        if (keyCycleOscillator != null) {
            this.f31901e = keyCycleOscillator.b(f3);
        }
    }

    public void d(SplineSet splineSet, float f3) {
        if (splineSet != null) {
            this.f31901e = splineSet.b(f3);
            this.f31902f = splineSet.a(f3);
        }
    }

    public void e(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f3) {
        if (keyCycleOscillator != null) {
            this.f31897a = keyCycleOscillator.b(f3);
        }
        if (keyCycleOscillator2 != null) {
            this.f31898b = keyCycleOscillator2.b(f3);
        }
    }

    public void f(SplineSet splineSet, SplineSet splineSet2, float f3) {
        if (splineSet != null) {
            this.f31897a = splineSet.b(f3);
        }
        if (splineSet2 != null) {
            this.f31898b = splineSet2.b(f3);
        }
    }

    public void g(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f3) {
        if (keyCycleOscillator != null) {
            this.f31899c = keyCycleOscillator.b(f3);
        }
        if (keyCycleOscillator2 != null) {
            this.f31900d = keyCycleOscillator2.b(f3);
        }
    }

    public void h(SplineSet splineSet, SplineSet splineSet2, float f3) {
        if (splineSet != null) {
            this.f31899c = splineSet.b(f3);
        }
        if (splineSet2 != null) {
            this.f31900d = splineSet2.b(f3);
        }
    }
}
