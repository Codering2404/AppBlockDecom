package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class StreetViewPanoramaLocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new zzw();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StreetViewPanoramaLink[] f73233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LatLng f73234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f73235c;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f73233a = streetViewPanoramaLinkArr;
        this.f73234b = latLng;
        this.f73235c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f73235c.equals(streetViewPanoramaLocation.f73235c) && this.f73234b.equals(streetViewPanoramaLocation.f73234b);
    }

    public int hashCode() {
        return Objects.c(this.f73234b, this.f73235c);
    }

    public String toString() {
        return Objects.d(this).a("panoId", this.f73235c).a("position", this.f73234b.toString()).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = this.f73233a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.J(parcel, 2, streetViewPanoramaLinkArr, i3, false);
        SafeParcelWriter.E(parcel, 3, this.f73234b, i3, false);
        SafeParcelWriter.G(parcel, 4, this.f73235c, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
