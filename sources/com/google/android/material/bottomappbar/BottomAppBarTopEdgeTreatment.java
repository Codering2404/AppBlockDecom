package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f80130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f80131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f80132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f80133d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f80134f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f80135g;

    @Override // com.google.android.material.shape.EdgeTreatment
    public void b(float f3, float f4, float f5, ShapePath shapePath) {
        float f6;
        float f7;
        float f8 = this.f80132c;
        if (f8 == 0.0f) {
            shapePath.m(f3, 0.0f);
            return;
        }
        float f9 = ((this.f80131b * 2.0f) + f8) / 2.0f;
        float f10 = f5 * this.f80130a;
        float f11 = f4 + this.f80134f;
        float f12 = (this.f80133d * f5) + ((1.0f - f5) * f9);
        if (f12 / f9 >= 1.0f) {
            shapePath.m(f3, 0.0f);
            return;
        }
        float f13 = this.f80135g;
        float f14 = f13 * f5;
        boolean z2 = f13 == -1.0f || Math.abs((f13 * 2.0f) - f8) < 0.1f;
        if (z2) {
            f6 = f12;
            f7 = 0.0f;
        } else {
            f7 = 1.75f;
            f6 = 0.0f;
        }
        float f15 = f9 + f10;
        float f16 = f6 + f10;
        float fSqrt = (float) Math.sqrt((f15 * f15) - (f16 * f16));
        float f17 = f11 - fSqrt;
        float f18 = f11 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f16));
        float f19 = (90.0f - degrees) + f7;
        shapePath.m(f17, 0.0f);
        float f20 = f17 - f10;
        float f21 = f17 + f10;
        float f22 = f10 * 2.0f;
        shapePath.a(f20, 0.0f, f21, f22, 270.0f, degrees);
        if (z2) {
            shapePath.a(f11 - f9, (-f9) - f6, f11 + f9, f9 - f6, 180.0f - f19, (f19 * 2.0f) - 180.0f);
        } else {
            float f23 = this.f80131b;
            float f24 = f14 * 2.0f;
            float f25 = f23 + f24;
            float f26 = f11 - f9;
            shapePath.a(f26, -(f14 + f23), f25 + f26, f23 + f14, 180.0f - f19, ((f19 * 2.0f) - 180.0f) / 2.0f);
            float f27 = f11 + f9;
            float f28 = this.f80131b;
            shapePath.m(f27 - ((f28 / 2.0f) + f14), f28 + f14);
            float f29 = this.f80131b;
            shapePath.a(f27 - (f24 + f29), -(f14 + f29), f27, f29 + f14, 90.0f, f19 - 90.0f);
        }
        shapePath.a(f18 - f10, 0.0f, f18 + f10, f22, 270.0f - degrees, degrees);
        shapePath.m(f3, 0.0f);
    }

    float c() {
        return this.f80133d;
    }

    public float e() {
        return this.f80135g;
    }

    float g() {
        return this.f80131b;
    }

    float h() {
        return this.f80130a;
    }

    public float i() {
        return this.f80132c;
    }

    public float j() {
        return this.f80134f;
    }

    void k(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f80133d = f3;
    }

    public void m(float f3) {
        this.f80135g = f3;
    }

    void o(float f3) {
        this.f80131b = f3;
    }

    void p(float f3) {
        this.f80130a = f3;
    }

    public void q(float f3) {
        this.f80132c = f3;
    }

    void r(float f3) {
        this.f80134f = f3;
    }
}
