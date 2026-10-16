package com.google.android.material.shape;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f81915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f81916b;

    @Override // com.google.android.material.shape.EdgeTreatment
    public void b(float f3, float f4, float f5, ShapePath shapePath) {
        if (!this.f81916b) {
            float f6 = this.f81915a;
            shapePath.n(f4 - (f6 * f5), 0.0f, f4, (-f6) * f5);
            shapePath.n(f4 + (this.f81915a * f5), 0.0f, f3, 0.0f);
        } else {
            shapePath.m(f4 - (this.f81915a * f5), 0.0f);
            float f7 = this.f81915a;
            shapePath.n(f4, f7 * f5, (f7 * f5) + f4, 0.0f);
            shapePath.m(f3, 0.0f);
        }
    }
}
