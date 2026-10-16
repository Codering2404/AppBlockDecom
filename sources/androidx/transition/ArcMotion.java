package androidx.transition;

import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ArcMotion extends PathMotion {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f53344d = (float) Math.tan(Math.toRadians(35.0d));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f53345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f53346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f53347c;

    @Override // androidx.transition.PathMotion
    public Path a(float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        Path path = new Path();
        path.moveTo(f3, f4);
        float f10 = f5 - f3;
        float f11 = f6 - f4;
        float f12 = (f10 * f10) + (f11 * f11);
        float f13 = (f3 + f5) / 2.0f;
        float f14 = (f4 + f6) / 2.0f;
        float f15 = 0.25f * f12;
        boolean z2 = f4 > f6;
        if (Math.abs(f10) < Math.abs(f11)) {
            float fAbs = Math.abs(f12 / (f11 * 2.0f));
            if (z2) {
                f8 = fAbs + f6;
                f7 = f5;
            } else {
                f8 = fAbs + f4;
                f7 = f3;
            }
            f9 = this.f53346b;
        } else {
            float f16 = f12 / (f10 * 2.0f);
            if (z2) {
                f8 = f4;
                f7 = f16 + f3;
            } else {
                f7 = f5 - f16;
                f8 = f6;
            }
            f9 = this.f53345a;
        }
        float f17 = f15 * f9 * f9;
        float f18 = f13 - f7;
        float f19 = f14 - f8;
        float f20 = (f18 * f18) + (f19 * f19);
        float f21 = this.f53347c;
        float f22 = f15 * f21 * f21;
        if (f20 >= f17) {
            f17 = f20 > f22 ? f22 : 0.0f;
        }
        if (f17 != 0.0f) {
            float fSqrt = (float) Math.sqrt(f17 / f20);
            f7 = ((f7 - f13) * fSqrt) + f13;
            f8 = f14 + (fSqrt * (f8 - f14));
        }
        path.cubicTo((f3 + f7) / 2.0f, (f4 + f8) / 2.0f, (f7 + f5) / 2.0f, (f8 + f6) / 2.0f, f5, f6);
        return path;
    }
}
