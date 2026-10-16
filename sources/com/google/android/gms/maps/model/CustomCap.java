package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class CustomCap extends Cap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BitmapDescriptor f73143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f73144g;

    /* JADX WARN: Illegal instructions before constructor call */
    public CustomCap(BitmapDescriptor bitmapDescriptor, float f3) {
        BitmapDescriptor bitmapDescriptor2 = (BitmapDescriptor) Preconditions.n(bitmapDescriptor, "bitmapDescriptor must not be null");
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("refWidth must be positive");
        }
        super(bitmapDescriptor2, f3);
        this.f73143f = bitmapDescriptor;
        this.f73144g = f3;
    }

    @Override // com.google.android.gms.maps.model.Cap
    public String toString() {
        return "[CustomCap: bitmapDescriptor=" + String.valueOf(this.f73143f) + " refWidth=" + this.f73144g + "]";
    }
}
