package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
abstract class LookupTableInterpolator implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f39829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f39830b;

    protected LookupTableInterpolator(float[] fArr) {
        this.f39829a = fArr;
        this.f39830b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f39829a;
        int iMin = Math.min((int) ((fArr.length - 1) * f3), fArr.length - 2);
        float f4 = this.f39830b;
        float f5 = (f3 - (iMin * f4)) / f4;
        float[] fArr2 = this.f39829a;
        float f6 = fArr2[iMin];
        return f6 + (f5 * (fArr2[iMin + 1] - f6));
    }
}
