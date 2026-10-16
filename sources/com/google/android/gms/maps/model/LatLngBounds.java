package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zzi();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LatLng f73165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LatLng f73166b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        Preconditions.n(latLng, "southwest must not be null.");
        Preconditions.n(latLng2, "northeast must not be null.");
        double d3 = latLng2.f73163a;
        double d4 = latLng.f73163a;
        Preconditions.c(d3 >= d4, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d4), Double.valueOf(latLng2.f73163a));
        this.f73165a = latLng;
        this.f73166b = latLng2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f73165a.equals(latLngBounds.f73165a) && this.f73166b.equals(latLngBounds.f73166b);
    }

    public int hashCode() {
        return Objects.c(this.f73165a, this.f73166b);
    }

    public String toString() {
        return Objects.d(this).a("southwest", this.f73165a).a("northeast", this.f73166b).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        LatLng latLng = this.f73165a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, latLng, i3, false);
        SafeParcelWriter.E(parcel, 3, this.f73166b, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
