package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class PointOfInterest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new zzp();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LatLng f73198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f73199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f73200c;

    public PointOfInterest(LatLng latLng, String str, String str2) {
        this.f73198a = latLng;
        this.f73199b = str;
        this.f73200c = str2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        LatLng latLng = this.f73198a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.E(parcel, 2, latLng, i3, false);
        SafeParcelWriter.G(parcel, 3, this.f73199b, false);
        SafeParcelWriter.G(parcel, 4, this.f73200c, false);
        SafeParcelWriter.b(parcel, iA);
    }
}
