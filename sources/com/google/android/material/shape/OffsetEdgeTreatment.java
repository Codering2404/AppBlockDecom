package com.google.android.material.shape;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class OffsetEdgeTreatment extends EdgeTreatment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EdgeTreatment f81817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f81818b;

    public OffsetEdgeTreatment(EdgeTreatment edgeTreatment, float f3) {
        this.f81817a = edgeTreatment;
        this.f81818b = f3;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    boolean a() {
        return this.f81817a.a();
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void b(float f3, float f4, float f5, ShapePath shapePath) {
        this.f81817a.b(f3, f4 - this.f81818b, f5, shapePath);
    }
}
