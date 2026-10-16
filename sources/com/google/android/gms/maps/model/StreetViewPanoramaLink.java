package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class StreetViewPanoramaLink extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new zzv();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f73231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f73232b;

    public StreetViewPanoramaLink(String str, float f3) {
        this.f73231a = str;
        this.f73232b = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f73231a.equals(streetViewPanoramaLink.f73231a) && Float.floatToIntBits(this.f73232b) == Float.floatToIntBits(streetViewPanoramaLink.f73232b);
    }

    public int hashCode() {
        return Objects.c(this.f73231a, Float.valueOf(this.f73232b));
    }

    public String toString() {
        return Objects.d(this).a("panoId", this.f73231a).a("bearing", Float.valueOf(this.f73232b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String str = this.f73231a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.G(parcel, 2, str, false);
        SafeParcelWriter.q(parcel, 3, this.f73232b);
        SafeParcelWriter.b(parcel, iA);
    }
}
