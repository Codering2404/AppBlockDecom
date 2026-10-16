package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class MarkerOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzl();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f73170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f73171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f73172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BitmapDescriptor f73173d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f73174f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f73175g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f73176h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f73177i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f73178j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f73179k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f73180l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f73181m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f73182n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f73183o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f73184p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f73185q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f73186r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f73187s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f73188t;

    public MarkerOptions() {
        this.f73174f = 0.5f;
        this.f73175g = 1.0f;
        this.f73177i = true;
        this.f73178j = false;
        this.f73179k = 0.0f;
        this.f73180l = 0.5f;
        this.f73181m = 0.0f;
        this.f73182n = 1.0f;
        this.f73184p = 0;
    }

    public float J2() {
        return this.f73181m;
    }

    public LatLng K2() {
        return this.f73170a;
    }

    public float L2() {
        return this.f73179k;
    }

    public MarkerOptions M(float f3) {
        this.f73182n = f3;
        return this;
    }

    public String M2() {
        return this.f73172c;
    }

    public MarkerOptions N(float f3, float f4) {
        this.f73174f = f3;
        this.f73175g = f4;
        return this;
    }

    public String N2() {
        return this.f73171b;
    }

    public MarkerOptions O(boolean z2) {
        this.f73176h = z2;
        return this;
    }

    public float O2() {
        return this.f73183o;
    }

    public MarkerOptions P2(BitmapDescriptor bitmapDescriptor) {
        this.f73173d = bitmapDescriptor;
        return this;
    }

    public MarkerOptions Q2(float f3, float f4) {
        this.f73180l = f3;
        this.f73181m = f4;
        return this;
    }

    public boolean R2() {
        return this.f73176h;
    }

    public boolean S2() {
        return this.f73178j;
    }

    public boolean T2() {
        return this.f73177i;
    }

    public MarkerOptions U2(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        this.f73170a = latLng;
        return this;
    }

    public MarkerOptions V2(float f3) {
        this.f73179k = f3;
        return this;
    }

    public MarkerOptions W2(String str) {
        this.f73172c = str;
        return this;
    }

    public MarkerOptions X2(String str) {
        this.f73171b = str;
        return this;
    }

    public MarkerOptions Y2(boolean z2) {
        this.f73177i = z2;
        return this;
    }

    public MarkerOptions Z2(float f3) {
        this.f73183o = f3;
        return this;
    }

    public final int a3() {
        return this.f73186r;
    }

    public final MarkerOptions b3(int i3) {
        this.f73186r = 1;
        return this;
    }

    public MarkerOptions g0(boolean z2) {
        this.f73178j = z2;
        return this;
    }

    public float h1() {
        return this.f73180l;
    }

    public float j0() {
        return this.f73182n;
    }

    public float w0() {
        return this.f73174f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, K2(), i3, false);
        SafeParcelWriter.G(parcel, 3, N2(), false);
        SafeParcelWriter.G(parcel, 4, M2(), false);
        BitmapDescriptor bitmapDescriptor = this.f73173d;
        SafeParcelWriter.t(parcel, 5, bitmapDescriptor == null ? null : bitmapDescriptor.a().asBinder(), false);
        SafeParcelWriter.q(parcel, 6, w0());
        SafeParcelWriter.q(parcel, 7, z0());
        SafeParcelWriter.g(parcel, 8, R2());
        SafeParcelWriter.g(parcel, 9, T2());
        SafeParcelWriter.g(parcel, 10, S2());
        SafeParcelWriter.q(parcel, 11, L2());
        SafeParcelWriter.q(parcel, 12, h1());
        SafeParcelWriter.q(parcel, 13, J2());
        SafeParcelWriter.q(parcel, 14, j0());
        SafeParcelWriter.q(parcel, 15, O2());
        SafeParcelWriter.u(parcel, 17, this.f73184p);
        SafeParcelWriter.t(parcel, 18, ObjectWrapper.i5(this.f73185q).asBinder(), false);
        SafeParcelWriter.u(parcel, 19, this.f73186r);
        SafeParcelWriter.G(parcel, 20, this.f73187s, false);
        SafeParcelWriter.q(parcel, 21, this.f73188t);
        SafeParcelWriter.b(parcel, iA);
    }

    public float z0() {
        return this.f73175g;
    }

    MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f3, float f4, boolean z2, boolean z3, boolean z4, float f5, float f6, float f7, float f8, float f9, int i3, IBinder iBinder2, int i4, String str3, float f10) {
        this.f73174f = 0.5f;
        this.f73175g = 1.0f;
        this.f73177i = true;
        this.f73178j = false;
        this.f73179k = 0.0f;
        this.f73180l = 0.5f;
        this.f73181m = 0.0f;
        this.f73182n = 1.0f;
        this.f73184p = 0;
        this.f73170a = latLng;
        this.f73171b = str;
        this.f73172c = str2;
        if (iBinder == null) {
            this.f73173d = null;
        } else {
            this.f73173d = new BitmapDescriptor(IObjectWrapper.Stub.x3(iBinder));
        }
        this.f73174f = f3;
        this.f73175g = f4;
        this.f73176h = z2;
        this.f73177i = z3;
        this.f73178j = z4;
        this.f73179k = f5;
        this.f73180l = f6;
        this.f73181m = f7;
        this.f73182n = f8;
        this.f73183o = f9;
        this.f73186r = i4;
        this.f73184p = i3;
        IObjectWrapper iObjectWrapperX3 = IObjectWrapper.Stub.x3(iBinder2);
        this.f73185q = iObjectWrapperX3 != null ? (View) ObjectWrapper.h5(iObjectWrapperX3) : null;
        this.f73187s = str3;
        this.f73188t = f10;
    }
}
