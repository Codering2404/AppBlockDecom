package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class GroundOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new zzg();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BitmapDescriptor f73148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLng f73149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f73150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f73151d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LatLngBounds f73152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f73153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f73154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f73155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f73156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f73157k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f73158l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f73159m;

    public GroundOverlayOptions() {
        this.f73155i = true;
        this.f73156j = 0.0f;
        this.f73157k = 0.5f;
        this.f73158l = 0.5f;
        this.f73159m = false;
    }

    private final GroundOverlayOptions W2(LatLng latLng, float f3, float f4) {
        this.f73149b = latLng;
        this.f73150c = f3;
        this.f73151d = f4;
        return this;
    }

    public LatLng J2() {
        return this.f73149b;
    }

    public float K2() {
        return this.f73156j;
    }

    public float L2() {
        return this.f73150c;
    }

    public GroundOverlayOptions M(float f3, float f4) {
        this.f73157k = f3;
        this.f73158l = f4;
        return this;
    }

    public float M2() {
        return this.f73154h;
    }

    public GroundOverlayOptions N(float f3) {
        this.f73153g = ((f3 % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public GroundOverlayOptions N2(BitmapDescriptor bitmapDescriptor) {
        Preconditions.n(bitmapDescriptor, "imageDescriptor must not be null");
        this.f73148a = bitmapDescriptor;
        return this;
    }

    public GroundOverlayOptions O(boolean z2) {
        this.f73159m = z2;
        return this;
    }

    public boolean O2() {
        return this.f73159m;
    }

    public boolean P2() {
        return this.f73155i;
    }

    public GroundOverlayOptions Q2(LatLng latLng, float f3) {
        Preconditions.r(this.f73152f == null, "Position has already been set using positionFromBounds");
        Preconditions.b(latLng != null, "Location must be specified");
        Preconditions.b(f3 >= 0.0f, "Width must be non-negative");
        W2(latLng, f3, -1.0f);
        return this;
    }

    public GroundOverlayOptions R2(LatLng latLng, float f3, float f4) {
        Preconditions.r(this.f73152f == null, "Position has already been set using positionFromBounds");
        Preconditions.b(latLng != null, "Location must be specified");
        Preconditions.b(f3 >= 0.0f, "Width must be non-negative");
        Preconditions.b(f4 >= 0.0f, "Height must be non-negative");
        W2(latLng, f3, f4);
        return this;
    }

    public GroundOverlayOptions S2(LatLngBounds latLngBounds) {
        LatLng latLng = this.f73149b;
        Preconditions.r(latLng == null, "Position has already been set using position: ".concat(String.valueOf(latLng)));
        this.f73152f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions T2(float f3) {
        boolean z2 = false;
        if (f3 >= 0.0f && f3 <= 1.0f) {
            z2 = true;
        }
        Preconditions.b(z2, "Transparency must be in the range [0..1]");
        this.f73156j = f3;
        return this;
    }

    public GroundOverlayOptions U2(boolean z2) {
        this.f73155i = z2;
        return this;
    }

    public GroundOverlayOptions V2(float f3) {
        this.f73154h = f3;
        return this;
    }

    public float g0() {
        return this.f73157k;
    }

    public float h1() {
        return this.f73151d;
    }

    public float j0() {
        return this.f73158l;
    }

    public float w0() {
        return this.f73153g;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.t(parcel, 2, this.f73148a.a().asBinder(), false);
        SafeParcelWriter.E(parcel, 3, J2(), i3, false);
        SafeParcelWriter.q(parcel, 4, L2());
        SafeParcelWriter.q(parcel, 5, h1());
        SafeParcelWriter.E(parcel, 6, z0(), i3, false);
        SafeParcelWriter.q(parcel, 7, w0());
        SafeParcelWriter.q(parcel, 8, M2());
        SafeParcelWriter.g(parcel, 9, P2());
        SafeParcelWriter.q(parcel, 10, K2());
        SafeParcelWriter.q(parcel, 11, g0());
        SafeParcelWriter.q(parcel, 12, j0());
        SafeParcelWriter.g(parcel, 13, O2());
        SafeParcelWriter.b(parcel, iA);
    }

    public LatLngBounds z0() {
        return this.f73152f;
    }

    GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f3, float f4, LatLngBounds latLngBounds, float f5, float f6, boolean z2, float f7, float f8, float f9, boolean z3) {
        this.f73155i = true;
        this.f73156j = 0.0f;
        this.f73157k = 0.5f;
        this.f73158l = 0.5f;
        this.f73159m = false;
        this.f73148a = new BitmapDescriptor(IObjectWrapper.Stub.x3(iBinder));
        this.f73149b = latLng;
        this.f73150c = f3;
        this.f73151d = f4;
        this.f73152f = latLngBounds;
        this.f73153g = f5;
        this.f73154h = f6;
        this.f73155i = z2;
        this.f73156j = f7;
        this.f73157k = f8;
        this.f73158l = f9;
        this.f73159m = z3;
    }
}
