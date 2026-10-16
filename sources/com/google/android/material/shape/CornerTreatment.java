package com.google.android.material.shape;

import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class CornerTreatment {
    public void b(ShapePath shapePath, float f3, float f4, float f5) {
        a(f3, f4, shapePath);
    }

    public void c(ShapePath shapePath, float f3, float f4, RectF rectF, CornerSize cornerSize) {
        b(shapePath, f3, f4, cornerSize.a(rectF));
    }

    public void a(float f3, float f4, ShapePath shapePath) {
    }
}
