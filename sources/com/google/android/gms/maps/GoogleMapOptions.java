package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzac();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final Integer f73045u = Integer.valueOf(Color.argb(255, 236, 233, 225));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Boolean f73046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f73047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f73048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CameraPosition f73049d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Boolean f73050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f73051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Boolean f73052h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Boolean f73053i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Boolean f73054j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Boolean f73055k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Boolean f73056l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Boolean f73057m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Boolean f73058n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Float f73059o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Float f73060p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private LatLngBounds f73061q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Boolean f73062r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Integer f73063s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f73064t;

    public GoogleMapOptions() {
        this.f73048c = -1;
        this.f73059o = null;
        this.f73060p = null;
        this.f73061q = null;
        this.f73063s = null;
        this.f73064t = null;
    }

    public static CameraPosition c3(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.f73074a);
        int i3 = R.styleable.f73080g;
        LatLng latLng = new LatLng(typedArrayObtainAttributes.hasValue(i3) ? typedArrayObtainAttributes.getFloat(i3, 0.0f) : 0.0f, typedArrayObtainAttributes.hasValue(R.styleable.f73081h) ? typedArrayObtainAttributes.getFloat(r0, 0.0f) : 0.0f);
        CameraPosition.Builder builderM = CameraPosition.M();
        builderM.c(latLng);
        int i4 = R.styleable.f73083j;
        if (typedArrayObtainAttributes.hasValue(i4)) {
            builderM.e(typedArrayObtainAttributes.getFloat(i4, 0.0f));
        }
        int i5 = R.styleable.f73077d;
        if (typedArrayObtainAttributes.hasValue(i5)) {
            builderM.a(typedArrayObtainAttributes.getFloat(i5, 0.0f));
        }
        int i6 = R.styleable.f73082i;
        if (typedArrayObtainAttributes.hasValue(i6)) {
            builderM.d(typedArrayObtainAttributes.getFloat(i6, 0.0f));
        }
        typedArrayObtainAttributes.recycle();
        return builderM.b();
    }

    public static LatLngBounds d3(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.f73074a);
        int i3 = R.styleable.f73086m;
        Float fValueOf = typedArrayObtainAttributes.hasValue(i3) ? Float.valueOf(typedArrayObtainAttributes.getFloat(i3, 0.0f)) : null;
        int i4 = R.styleable.f73087n;
        Float fValueOf2 = typedArrayObtainAttributes.hasValue(i4) ? Float.valueOf(typedArrayObtainAttributes.getFloat(i4, 0.0f)) : null;
        int i5 = R.styleable.f73084k;
        Float fValueOf3 = typedArrayObtainAttributes.hasValue(i5) ? Float.valueOf(typedArrayObtainAttributes.getFloat(i5, 0.0f)) : null;
        int i6 = R.styleable.f73085l;
        Float fValueOf4 = typedArrayObtainAttributes.hasValue(i6) ? Float.valueOf(typedArrayObtainAttributes.getFloat(i6, 0.0f)) : null;
        typedArrayObtainAttributes.recycle();
        if (fValueOf == null || fValueOf2 == null || fValueOf3 == null || fValueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(fValueOf.floatValue(), fValueOf2.floatValue()), new LatLng(fValueOf3.floatValue(), fValueOf4.floatValue()));
    }

    public static GoogleMapOptions j0(Context context, AttributeSet attributeSet) {
        String string;
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.f73074a);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        int i3 = R.styleable.f73090q;
        if (typedArrayObtainAttributes.hasValue(i3)) {
            googleMapOptions.R2(typedArrayObtainAttributes.getInt(i3, -1));
        }
        int i4 = R.styleable.A;
        if (typedArrayObtainAttributes.hasValue(i4)) {
            googleMapOptions.Z2(typedArrayObtainAttributes.getBoolean(i4, false));
        }
        int i5 = R.styleable.f73099z;
        if (typedArrayObtainAttributes.hasValue(i5)) {
            googleMapOptions.Y2(typedArrayObtainAttributes.getBoolean(i5, false));
        }
        int i6 = R.styleable.f73091r;
        if (typedArrayObtainAttributes.hasValue(i6)) {
            googleMapOptions.g0(typedArrayObtainAttributes.getBoolean(i6, true));
        }
        int i7 = R.styleable.f73093t;
        if (typedArrayObtainAttributes.hasValue(i7)) {
            googleMapOptions.U2(typedArrayObtainAttributes.getBoolean(i7, true));
        }
        int i8 = R.styleable.f73095v;
        if (typedArrayObtainAttributes.hasValue(i8)) {
            googleMapOptions.W2(typedArrayObtainAttributes.getBoolean(i8, true));
        }
        int i9 = R.styleable.f73094u;
        if (typedArrayObtainAttributes.hasValue(i9)) {
            googleMapOptions.V2(typedArrayObtainAttributes.getBoolean(i9, true));
        }
        int i10 = R.styleable.f73096w;
        if (typedArrayObtainAttributes.hasValue(i10)) {
            googleMapOptions.X2(typedArrayObtainAttributes.getBoolean(i10, true));
        }
        int i11 = R.styleable.f73098y;
        if (typedArrayObtainAttributes.hasValue(i11)) {
            googleMapOptions.b3(typedArrayObtainAttributes.getBoolean(i11, true));
        }
        int i12 = R.styleable.f73097x;
        if (typedArrayObtainAttributes.hasValue(i12)) {
            googleMapOptions.a3(typedArrayObtainAttributes.getBoolean(i12, true));
        }
        int i13 = R.styleable.f73088o;
        if (typedArrayObtainAttributes.hasValue(i13)) {
            googleMapOptions.O2(typedArrayObtainAttributes.getBoolean(i13, false));
        }
        int i14 = R.styleable.f73092s;
        if (typedArrayObtainAttributes.hasValue(i14)) {
            googleMapOptions.Q2(typedArrayObtainAttributes.getBoolean(i14, true));
        }
        int i15 = R.styleable.f73075b;
        if (typedArrayObtainAttributes.hasValue(i15)) {
            googleMapOptions.M(typedArrayObtainAttributes.getBoolean(i15, false));
        }
        int i16 = R.styleable.f73079f;
        if (typedArrayObtainAttributes.hasValue(i16)) {
            googleMapOptions.T2(typedArrayObtainAttributes.getFloat(i16, Float.NEGATIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(i16)) {
            googleMapOptions.S2(typedArrayObtainAttributes.getFloat(R.styleable.f73078e, Float.POSITIVE_INFINITY));
        }
        int i17 = R.styleable.f73076c;
        if (typedArrayObtainAttributes.hasValue(i17)) {
            googleMapOptions.N(Integer.valueOf(typedArrayObtainAttributes.getColor(i17, f73045u.intValue())));
        }
        int i18 = R.styleable.f73089p;
        if (typedArrayObtainAttributes.hasValue(i18) && (string = typedArrayObtainAttributes.getString(i18)) != null && !string.isEmpty()) {
            googleMapOptions.P2(string);
        }
        googleMapOptions.N2(d3(context, attributeSet));
        googleMapOptions.O(c3(context, attributeSet));
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    public String J2() {
        return this.f73064t;
    }

    public int K2() {
        return this.f73048c;
    }

    public Float L2() {
        return this.f73060p;
    }

    public GoogleMapOptions M(boolean z2) {
        this.f73058n = Boolean.valueOf(z2);
        return this;
    }

    public Float M2() {
        return this.f73059o;
    }

    public GoogleMapOptions N(Integer num) {
        this.f73063s = num;
        return this;
    }

    public GoogleMapOptions N2(LatLngBounds latLngBounds) {
        this.f73061q = latLngBounds;
        return this;
    }

    public GoogleMapOptions O(CameraPosition cameraPosition) {
        this.f73049d = cameraPosition;
        return this;
    }

    public GoogleMapOptions O2(boolean z2) {
        this.f73056l = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions P2(String str) {
        this.f73064t = str;
        return this;
    }

    public GoogleMapOptions Q2(boolean z2) {
        this.f73057m = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions R2(int i3) {
        this.f73048c = i3;
        return this;
    }

    public GoogleMapOptions S2(float f3) {
        this.f73060p = Float.valueOf(f3);
        return this;
    }

    public GoogleMapOptions T2(float f3) {
        this.f73059o = Float.valueOf(f3);
        return this;
    }

    public GoogleMapOptions U2(boolean z2) {
        this.f73055k = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions V2(boolean z2) {
        this.f73052h = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions W2(boolean z2) {
        this.f73062r = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions X2(boolean z2) {
        this.f73054j = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions Y2(boolean z2) {
        this.f73047b = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions Z2(boolean z2) {
        this.f73046a = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions a3(boolean z2) {
        this.f73050f = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions b3(boolean z2) {
        this.f73053i = Boolean.valueOf(z2);
        return this;
    }

    public GoogleMapOptions g0(boolean z2) {
        this.f73051g = Boolean.valueOf(z2);
        return this;
    }

    public LatLngBounds h1() {
        return this.f73061q;
    }

    public String toString() {
        return Objects.d(this).a("MapType", Integer.valueOf(this.f73048c)).a("LiteMode", this.f73056l).a("Camera", this.f73049d).a("CompassEnabled", this.f73051g).a("ZoomControlsEnabled", this.f73050f).a("ScrollGesturesEnabled", this.f73052h).a("ZoomGesturesEnabled", this.f73053i).a("TiltGesturesEnabled", this.f73054j).a("RotateGesturesEnabled", this.f73055k).a("ScrollGesturesEnabledDuringRotateOrZoom", this.f73062r).a("MapToolbarEnabled", this.f73057m).a("AmbientEnabled", this.f73058n).a("MinZoomPreference", this.f73059o).a("MaxZoomPreference", this.f73060p).a("BackgroundColor", this.f73063s).a("LatLngBoundsForCameraTarget", this.f73061q).a("ZOrderOnTop", this.f73046a).a("UseViewLifecycleInFragment", this.f73047b).toString();
    }

    public Integer w0() {
        return this.f73063s;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.k(parcel, 2, com.google.android.gms.maps.internal.zza.a(this.f73046a));
        SafeParcelWriter.k(parcel, 3, com.google.android.gms.maps.internal.zza.a(this.f73047b));
        SafeParcelWriter.u(parcel, 4, K2());
        SafeParcelWriter.E(parcel, 5, z0(), i3, false);
        SafeParcelWriter.k(parcel, 6, com.google.android.gms.maps.internal.zza.a(this.f73050f));
        SafeParcelWriter.k(parcel, 7, com.google.android.gms.maps.internal.zza.a(this.f73051g));
        SafeParcelWriter.k(parcel, 8, com.google.android.gms.maps.internal.zza.a(this.f73052h));
        SafeParcelWriter.k(parcel, 9, com.google.android.gms.maps.internal.zza.a(this.f73053i));
        SafeParcelWriter.k(parcel, 10, com.google.android.gms.maps.internal.zza.a(this.f73054j));
        SafeParcelWriter.k(parcel, 11, com.google.android.gms.maps.internal.zza.a(this.f73055k));
        SafeParcelWriter.k(parcel, 12, com.google.android.gms.maps.internal.zza.a(this.f73056l));
        SafeParcelWriter.k(parcel, 14, com.google.android.gms.maps.internal.zza.a(this.f73057m));
        SafeParcelWriter.k(parcel, 15, com.google.android.gms.maps.internal.zza.a(this.f73058n));
        SafeParcelWriter.s(parcel, 16, M2(), false);
        SafeParcelWriter.s(parcel, 17, L2(), false);
        SafeParcelWriter.E(parcel, 18, h1(), i3, false);
        SafeParcelWriter.k(parcel, 19, com.google.android.gms.maps.internal.zza.a(this.f73062r));
        SafeParcelWriter.x(parcel, 20, w0(), false);
        SafeParcelWriter.G(parcel, 21, J2(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    public CameraPosition z0() {
        return this.f73049d;
    }

    GoogleMapOptions(byte b3, byte b4, int i3, CameraPosition cameraPosition, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, byte b12, byte b13, Float f3, Float f4, LatLngBounds latLngBounds, byte b14, Integer num, String str) {
        this.f73048c = -1;
        this.f73059o = null;
        this.f73060p = null;
        this.f73061q = null;
        this.f73063s = null;
        this.f73064t = null;
        this.f73046a = com.google.android.gms.maps.internal.zza.b(b3);
        this.f73047b = com.google.android.gms.maps.internal.zza.b(b4);
        this.f73048c = i3;
        this.f73049d = cameraPosition;
        this.f73050f = com.google.android.gms.maps.internal.zza.b(b5);
        this.f73051g = com.google.android.gms.maps.internal.zza.b(b6);
        this.f73052h = com.google.android.gms.maps.internal.zza.b(b7);
        this.f73053i = com.google.android.gms.maps.internal.zza.b(b8);
        this.f73054j = com.google.android.gms.maps.internal.zza.b(b9);
        this.f73055k = com.google.android.gms.maps.internal.zza.b(b10);
        this.f73056l = com.google.android.gms.maps.internal.zza.b(b11);
        this.f73057m = com.google.android.gms.maps.internal.zza.b(b12);
        this.f73058n = com.google.android.gms.maps.internal.zza.b(b13);
        this.f73059o = f3;
        this.f73060p = f4;
        this.f73061q = latLngBounds;
        this.f73062r = com.google.android.gms.maps.internal.zza.b(b14);
        this.f73063s = num;
        this.f73064t = str;
    }
}
