package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f73134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f73135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f73136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f73137d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f73138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f73139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f73140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f73141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List f73142j;

    public CircleOptions() {
        this.f73134a = null;
        this.f73135b = 0.0d;
        this.f73136c = 10.0f;
        this.f73137d = -16777216;
        this.f73138f = 0;
        this.f73139g = 0.0f;
        this.f73140h = true;
        this.f73141i = false;
        this.f73142j = null;
    }

    public float J2() {
        return this.f73136c;
    }

    public float K2() {
        return this.f73139g;
    }

    public boolean L2() {
        return this.f73141i;
    }

    public CircleOptions M(LatLng latLng) {
        Preconditions.n(latLng, "center must not be null.");
        this.f73134a = latLng;
        return this;
    }

    public boolean M2() {
        return this.f73140h;
    }

    public CircleOptions N(boolean z2) {
        this.f73141i = z2;
        return this;
    }

    public CircleOptions N2(double d3) {
        this.f73135b = d3;
        return this;
    }

    public CircleOptions O(int i3) {
        this.f73138f = i3;
        return this;
    }

    public CircleOptions O2(int i3) {
        this.f73137d = i3;
        return this;
    }

    public CircleOptions P2(List list) {
        this.f73142j = list;
        return this;
    }

    public CircleOptions Q2(float f3) {
        this.f73136c = f3;
        return this;
    }

    public CircleOptions R2(boolean z2) {
        this.f73140h = z2;
        return this;
    }

    public CircleOptions S2(float f3) {
        this.f73139g = f3;
        return this;
    }

    public LatLng g0() {
        return this.f73134a;
    }

    public List h1() {
        return this.f73142j;
    }

    public int j0() {
        return this.f73138f;
    }

    public double w0() {
        return this.f73135b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, g0(), i3, false);
        SafeParcelWriter.n(parcel, 3, w0());
        SafeParcelWriter.q(parcel, 4, J2());
        SafeParcelWriter.u(parcel, 5, z0());
        SafeParcelWriter.u(parcel, 6, j0());
        SafeParcelWriter.q(parcel, 7, K2());
        SafeParcelWriter.g(parcel, 8, M2());
        SafeParcelWriter.g(parcel, 9, L2());
        SafeParcelWriter.K(parcel, 10, h1(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public int z0() {
        return this.f73137d;
    }

    CircleOptions(LatLng latLng, double d3, float f3, int i3, int i4, float f4, boolean z2, boolean z3, List list) {
        this.f73134a = latLng;
        this.f73135b = d3;
        this.f73136c = f3;
        this.f73137d = i3;
        this.f73138f = i4;
        this.f73139g = f4;
        this.f73140h = z2;
        this.f73141i = z3;
        this.f73142j = list;
    }
}
