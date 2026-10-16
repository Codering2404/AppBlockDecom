package com.google.android.material.shape;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f81766a;

    public MarkerEdgeTreatment(float f3) {
        this.f81766a = f3 - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    boolean a() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void b(float f3, float f4, float f5, ShapePath shapePath) {
        float fSqrt = (float) ((((double) this.f81766a) * Math.sqrt(2.0d)) / 2.0d);
        float fSqrt2 = (float) Math.sqrt(Math.pow(this.f81766a, 2.0d) - Math.pow(fSqrt, 2.0d));
        shapePath.o(f4 - fSqrt, ((float) (-((((double) this.f81766a) * Math.sqrt(2.0d)) - ((double) this.f81766a)))) + fSqrt2);
        shapePath.m(f4, (float) (-((((double) this.f81766a) * Math.sqrt(2.0d)) - ((double) this.f81766a))));
        shapePath.m(f4 + fSqrt, ((float) (-((((double) this.f81766a) * Math.sqrt(2.0d)) - ((double) this.f81766a)))) + fSqrt2);
    }
}
