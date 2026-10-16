package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class VisibleRegion extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new zzai();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LatLng f73268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LatLng f73269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LatLng f73270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LatLng f73271d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LatLngBounds f73272f;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f73268a = latLng;
        this.f73269b = latLng2;
        this.f73270c = latLng3;
        this.f73271d = latLng4;
        this.f73272f = latLngBounds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f73268a.equals(visibleRegion.f73268a) && this.f73269b.equals(visibleRegion.f73269b) && this.f73270c.equals(visibleRegion.f73270c) && this.f73271d.equals(visibleRegion.f73271d) && this.f73272f.equals(visibleRegion.f73272f);
    }

    public int hashCode() {
        return Objects.c(this.f73268a, this.f73269b, this.f73270c, this.f73271d, this.f73272f);
    }

    public String toString() {
        return Objects.d(this).a("nearLeft", this.f73268a).a("nearRight", this.f73269b).a("farLeft", this.f73270c).a("farRight", this.f73271d).a("latLngBounds", this.f73272f).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        LatLng latLng = this.f73268a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, latLng, i3, false);
        SafeParcelWriter.E(parcel, 3, this.f73269b, i3, false);
        SafeParcelWriter.E(parcel, 4, this.f73270c, i3, false);
        SafeParcelWriter.E(parcel, 5, this.f73271d, i3, false);
        SafeParcelWriter.E(parcel, 6, this.f73272f, i3, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
