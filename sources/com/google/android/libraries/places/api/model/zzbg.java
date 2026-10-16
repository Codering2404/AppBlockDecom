package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbg extends PlaceLikelihood {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Place f75255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f75256b;

    zzbg(Place place, double d3) {
        if (place == null) {
            throw new NullPointerException("Null place");
        }
        this.f75255a = place;
        this.f75256b = d3;
    }

    @Override // com.google.android.libraries.places.api.model.PlaceLikelihood
    public final double c() {
        return this.f75256b;
    }

    @Override // com.google.android.libraries.places.api.model.PlaceLikelihood
    public final Place d() {
        return this.f75255a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PlaceLikelihood) {
            PlaceLikelihood placeLikelihood = (PlaceLikelihood) obj;
            if (this.f75255a.equals(placeLikelihood.d()) && Double.doubleToLongBits(this.f75256b) == Double.doubleToLongBits(placeLikelihood.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f75255a.hashCode() ^ 1000003;
        double d3 = this.f75256b;
        return (iHashCode * 1000003) ^ ((int) (Double.doubleToLongBits(d3) ^ (Double.doubleToLongBits(d3) >>> 32)));
    }

    public final String toString() {
        String string = this.f75255a.toString();
        int length = string.length();
        double d3 = this.f75256b;
        StringBuilder sb = new StringBuilder(length + 35 + String.valueOf(d3).length() + 1);
        sb.append("PlaceLikelihood{place=");
        sb.append(string);
        sb.append(", likelihood=");
        sb.append(d3);
        sb.append("}");
        return sb.toString();
    }
}
