package androidx.vectordrawable.graphics.drawable;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PathInterpolatorCompat implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f53639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f53640b;

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        if (f3 <= 0.0f) {
            return 0.0f;
        }
        if (f3 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f53639a.length - 1;
        int i3 = 0;
        while (length - i3 > 1) {
            int i4 = (i3 + length) / 2;
            if (f3 < this.f53639a[i4]) {
                length = i4;
            } else {
                i3 = i4;
            }
        }
        float[] fArr = this.f53639a;
        float f4 = fArr[length];
        float f5 = fArr[i3];
        float f6 = f4 - f5;
        if (f6 == 0.0f) {
            return this.f53640b[i3];
        }
        float f7 = (f3 - f5) / f6;
        float[] fArr2 = this.f53640b;
        float f8 = fArr2[i3];
        return f8 + (f7 * (fArr2[length] - f8));
    }
}
