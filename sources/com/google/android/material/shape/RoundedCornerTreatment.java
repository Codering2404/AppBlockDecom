package com.google.android.material.shape;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RoundedCornerTreatment extends CornerTreatment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    float f81820a = -1.0f;

    @Override // com.google.android.material.shape.CornerTreatment
    public void b(ShapePath shapePath, float f3, float f4, float f5) {
        shapePath.p(0.0f, f5 * f4, 180.0f, 180.0f - f3);
        float f6 = f5 * 2.0f * f4;
        shapePath.a(0.0f, 0.0f, f6, f6, 180.0f, f3);
    }
}
