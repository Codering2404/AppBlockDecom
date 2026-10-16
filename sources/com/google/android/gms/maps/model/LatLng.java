package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LatLng extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new zzj();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f73163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f73164b;

    public LatLng(double d3, double d4) {
        if (d4 < -180.0d || d4 >= 180.0d) {
            this.f73164b = ((((d4 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f73164b = d4;
        }
        this.f73163a = Math.max(-90.0d, Math.min(90.0d, d3));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f73163a) == Double.doubleToLongBits(latLng.f73163a) && Double.doubleToLongBits(this.f73164b) == Double.doubleToLongBits(latLng.f73164b);
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f73163a);
        long j3 = jDoubleToLongBits ^ (jDoubleToLongBits >>> 32);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f73164b);
        return ((((int) j3) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "lat/lng: (" + this.f73163a + "," + this.f73164b + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        double d3 = this.f73163a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.n(parcel, 2, d3);
        SafeParcelWriter.n(parcel, 3, this.f73164b);
        SafeParcelWriter.b(parcel, iA);
    }
}
