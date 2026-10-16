package androidx.transition;

import android.animation.TypeEvaluator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FloatArrayEvaluator implements TypeEvaluator<float[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f53410a;

    FloatArrayEvaluator(float[] fArr) {
        this.f53410a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public float[] evaluate(float f3, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f53410a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i3 = 0; i3 < fArr3.length; i3++) {
            float f4 = fArr[i3];
            fArr3[i3] = f4 + ((fArr2[i3] - f4) * f3);
        }
        return fArr3;
    }
}
