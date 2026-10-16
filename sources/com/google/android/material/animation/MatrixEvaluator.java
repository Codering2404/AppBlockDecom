package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MatrixEvaluator implements TypeEvaluator<Matrix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f79859a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f79860b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f79861c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f3, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f79859a);
        matrix2.getValues(this.f79860b);
        for (int i3 = 0; i3 < 9; i3++) {
            float[] fArr = this.f79860b;
            float f4 = fArr[i3];
            float f5 = this.f79859a[i3];
            fArr[i3] = f5 + ((f4 - f5) * f3);
        }
        this.f79861c.setValues(this.f79860b);
        return this.f79861c;
    }
}
