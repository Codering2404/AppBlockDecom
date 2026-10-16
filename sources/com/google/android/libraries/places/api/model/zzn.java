package com.google.android.libraries.places.api.model;

import com.google.android.gms.maps.model.LatLng;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzn extends CircularBounds {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LatLng f75374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f75375b;

    zzn(LatLng latLng, double d3) {
        if (latLng == null) {
            throw new NullPointerException("Null center");
        }
        this.f75374a = latLng;
        this.f75375b = d3;
    }

    @Override // com.google.android.libraries.places.api.model.CircularBounds
    public final LatLng c() {
        return this.f75374a;
    }

    @Override // com.google.android.libraries.places.api.model.CircularBounds
    public final double d() {
        return this.f75375b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CircularBounds) {
            CircularBounds circularBounds = (CircularBounds) obj;
            if (this.f75374a.equals(circularBounds.c()) && Double.doubleToLongBits(this.f75375b) == Double.doubleToLongBits(circularBounds.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f75374a.hashCode() ^ 1000003;
        double d3 = this.f75375b;
        return (iHashCode * 1000003) ^ ((int) (Double.doubleToLongBits(d3) ^ (Double.doubleToLongBits(d3) >>> 32)));
    }

    public final String toString() {
        String string = this.f75374a.toString();
        int length = string.length();
        double d3 = this.f75375b;
        StringBuilder sb = new StringBuilder(length + 31 + String.valueOf(d3).length() + 1);
        sb.append("CircularBounds{center=");
        sb.append(string);
        sb.append(", radius=");
        sb.append(d3);
        sb.append("}");
        return sb.toString();
    }
}
