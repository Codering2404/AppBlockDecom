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
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new zza();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LatLng f73121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f73122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f73123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f73124d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLng f73125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f73126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f73127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f73128d;

        public Builder a(float f3) {
            this.f73128d = f3;
            return this;
        }

        public CameraPosition b() {
            return new CameraPosition(this.f73125a, this.f73126b, this.f73127c, this.f73128d);
        }

        public Builder c(LatLng latLng) {
            this.f73125a = (LatLng) Preconditions.n(latLng, "location must not be null.");
            return this;
        }

        public Builder d(float f3) {
            this.f73127c = f3;
            return this;
        }

        public Builder e(float f3) {
            this.f73126b = f3;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f3, float f4, float f5) {
        Preconditions.n(latLng, "camera target must not be null.");
        boolean z2 = false;
        if (f4 >= 0.0f && f4 <= 90.0f) {
            z2 = true;
        }
        Preconditions.c(z2, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f4));
        this.f73121a = latLng;
        this.f73122b = f3;
        this.f73123c = f4 + 0.0f;
        this.f73124d = (((double) f5) <= 0.0d ? (f5 % 360.0f) + 360.0f : f5) % 360.0f;
    }

    public static Builder M() {
        return new Builder();
    }

    public static final CameraPosition N(LatLng latLng, float f3) {
        return new CameraPosition(latLng, f3, 0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f73121a.equals(cameraPosition.f73121a) && Float.floatToIntBits(this.f73122b) == Float.floatToIntBits(cameraPosition.f73122b) && Float.floatToIntBits(this.f73123c) == Float.floatToIntBits(cameraPosition.f73123c) && Float.floatToIntBits(this.f73124d) == Float.floatToIntBits(cameraPosition.f73124d);
    }

    public int hashCode() {
        return Objects.c(this.f73121a, Float.valueOf(this.f73122b), Float.valueOf(this.f73123c), Float.valueOf(this.f73124d));
    }

    public String toString() {
        return Objects.d(this).a("target", this.f73121a).a("zoom", Float.valueOf(this.f73122b)).a("tilt", Float.valueOf(this.f73123c)).a("bearing", Float.valueOf(this.f73124d)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        LatLng latLng = this.f73121a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, latLng, i3, false);
        SafeParcelWriter.q(parcel, 3, this.f73122b);
        SafeParcelWriter.q(parcel, 4, this.f73123c);
        SafeParcelWriter.q(parcel, 5, this.f73124d);
        SafeParcelWriter.b(parcel, iA);
    }
}
