package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new zzx();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f73236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f73237b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f73238a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f73239b;

        public Builder a(float f3) {
            this.f73238a = f3;
            return this;
        }

        public StreetViewPanoramaOrientation b() {
            return new StreetViewPanoramaOrientation(this.f73239b, this.f73238a);
        }

        public Builder c(float f3) {
            this.f73239b = f3;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f3, float f4) {
        boolean z2 = false;
        if (f3 >= -90.0f && f3 <= 90.0f) {
            z2 = true;
        }
        Preconditions.b(z2, "Tilt needs to be between -90 and 90 inclusive: " + f3);
        this.f73236a = f3 + 0.0f;
        this.f73237b = (((double) f4) <= 0.0d ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f73236a) == Float.floatToIntBits(streetViewPanoramaOrientation.f73236a) && Float.floatToIntBits(this.f73237b) == Float.floatToIntBits(streetViewPanoramaOrientation.f73237b);
    }

    public int hashCode() {
        return Objects.c(Float.valueOf(this.f73236a), Float.valueOf(this.f73237b));
    }

    public String toString() {
        return Objects.d(this).a("tilt", Float.valueOf(this.f73236a)).a("bearing", Float.valueOf(this.f73237b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        float f3 = this.f73236a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.q(parcel, 2, f3);
        SafeParcelWriter.q(parcel, 3, this.f73237b);
        SafeParcelWriter.b(parcel, iA);
    }
}
