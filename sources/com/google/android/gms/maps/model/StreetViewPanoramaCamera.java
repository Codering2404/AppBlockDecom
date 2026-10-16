package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new zzu();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f73227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f73228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f73229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StreetViewPanoramaOrientation f73230d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    public StreetViewPanoramaCamera(float f3, float f4, float f5) {
        boolean z2 = false;
        if (f4 >= -90.0f && f4 <= 90.0f) {
            z2 = true;
        }
        Preconditions.b(z2, "Tilt needs to be between -90 and 90 inclusive: " + f4);
        this.f73227a = ((double) f3) <= 0.0d ? 0.0f : f3;
        this.f73228b = 0.0f + f4;
        this.f73229c = (((double) f5) <= 0.0d ? (f5 % 360.0f) + 360.0f : f5) % 360.0f;
        StreetViewPanoramaOrientation.Builder builder = new StreetViewPanoramaOrientation.Builder();
        builder.c(f4);
        builder.a(f5);
        this.f73230d = builder.b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f73227a) == Float.floatToIntBits(streetViewPanoramaCamera.f73227a) && Float.floatToIntBits(this.f73228b) == Float.floatToIntBits(streetViewPanoramaCamera.f73228b) && Float.floatToIntBits(this.f73229c) == Float.floatToIntBits(streetViewPanoramaCamera.f73229c);
    }

    public int hashCode() {
        return Objects.c(Float.valueOf(this.f73227a), Float.valueOf(this.f73228b), Float.valueOf(this.f73229c));
    }

    public String toString() {
        return Objects.d(this).a("zoom", Float.valueOf(this.f73227a)).a("tilt", Float.valueOf(this.f73228b)).a("bearing", Float.valueOf(this.f73229c)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        float f3 = this.f73227a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.q(parcel, 2, f3);
        SafeParcelWriter.q(parcel, 3, this.f73228b);
        SafeParcelWriter.q(parcel, 4, this.f73229c);
        SafeParcelWriter.b(parcel, iA);
    }
}
