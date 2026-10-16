package com.google.android.libraries.places.api.model;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbm extends RectangularBounds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LatLng f75265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LatLng f75266b;

    zzbm(LatLng latLng, LatLng latLng2) {
        if (latLng == null) {
            throw new NullPointerException("Null southwest");
        }
        this.f75265a = latLng;
        if (latLng2 == null) {
            throw new NullPointerException("Null northeast");
        }
        this.f75266b = latLng2;
    }

    @Override // com.google.android.libraries.places.api.model.RectangularBounds
    public final LatLng c() {
        return this.f75266b;
    }

    @Override // com.google.android.libraries.places.api.model.RectangularBounds
    public final LatLng d() {
        return this.f75265a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RectangularBounds) {
            RectangularBounds rectangularBounds = (RectangularBounds) obj;
            if (this.f75265a.equals(rectangularBounds.d()) && this.f75266b.equals(rectangularBounds.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f75265a.hashCode() ^ 1000003) * 1000003) ^ this.f75266b.hashCode();
    }

    public final String toString() {
        String string = this.f75265a.toString();
        int length = string.length();
        String string2 = this.f75266b.toString();
        StringBuilder sb = new StringBuilder(length + 40 + string2.length() + 1);
        sb.append("RectangularBounds{southwest=");
        sb.append(string);
        sb.append(", northeast=");
        sb.append(string2);
        sb.append("}");
        return sb.toString();
    }
}
