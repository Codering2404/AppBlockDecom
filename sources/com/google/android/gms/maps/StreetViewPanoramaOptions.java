package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new zzaq();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StreetViewPanoramaCamera f73102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f73103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LatLng f73104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f73105d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Boolean f73106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f73107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Boolean f73108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Boolean f73109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Boolean f73110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private StreetViewSource f73111k;

    public StreetViewPanoramaOptions() {
        Boolean bool = Boolean.TRUE;
        this.f73106f = bool;
        this.f73107g = bool;
        this.f73108h = bool;
        this.f73109i = bool;
        this.f73111k = StreetViewSource.f73240b;
    }

    public String M() {
        return this.f73103b;
    }

    public LatLng N() {
        return this.f73104c;
    }

    public Integer O() {
        return this.f73105d;
    }

    public StreetViewSource g0() {
        return this.f73111k;
    }

    public StreetViewPanoramaCamera j0() {
        return this.f73102a;
    }

    public String toString() {
        return Objects.d(this).a("PanoramaId", this.f73103b).a("Position", this.f73104c).a("Radius", this.f73105d).a("Source", this.f73111k).a("StreetViewPanoramaCamera", this.f73102a).a("UserNavigationEnabled", this.f73106f).a("ZoomGesturesEnabled", this.f73107g).a("PanningGesturesEnabled", this.f73108h).a("StreetNamesEnabled", this.f73109i).a("UseViewLifecycleInFragment", this.f73110j).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, j0(), i3, false);
        SafeParcelWriter.G(parcel, 3, M(), false);
        SafeParcelWriter.E(parcel, 4, N(), i3, false);
        SafeParcelWriter.x(parcel, 5, O(), false);
        SafeParcelWriter.k(parcel, 6, com.google.android.gms.maps.internal.zza.a(this.f73106f));
        SafeParcelWriter.k(parcel, 7, com.google.android.gms.maps.internal.zza.a(this.f73107g));
        SafeParcelWriter.k(parcel, 8, com.google.android.gms.maps.internal.zza.a(this.f73108h));
        SafeParcelWriter.k(parcel, 9, com.google.android.gms.maps.internal.zza.a(this.f73109i));
        SafeParcelWriter.k(parcel, 10, com.google.android.gms.maps.internal.zza.a(this.f73110j));
        SafeParcelWriter.E(parcel, 11, g0(), i3, false);
        SafeParcelWriter.b(parcel, iA);
    }

    StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b3, byte b4, byte b5, byte b6, byte b7, StreetViewSource streetViewSource) {
        Boolean bool = Boolean.TRUE;
        this.f73106f = bool;
        this.f73107g = bool;
        this.f73108h = bool;
        this.f73109i = bool;
        this.f73111k = StreetViewSource.f73240b;
        this.f73102a = streetViewPanoramaCamera;
        this.f73104c = latLng;
        this.f73105d = num;
        this.f73103b = str;
        this.f73106f = com.google.android.gms.maps.internal.zza.b(b3);
        this.f73107g = com.google.android.gms.maps.internal.zza.b(b4);
        this.f73108h = com.google.android.gms.maps.internal.zza.b(b5);
        this.f73109i = com.google.android.gms.maps.internal.zza.b(b6);
        this.f73110j = com.google.android.gms.maps.internal.zza.b(b7);
        this.f73111k = streetViewSource;
    }
}
