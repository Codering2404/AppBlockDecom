package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzai implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                latLng = (LatLng) SafeParcelReader.p(parcel, iE, LatLng.CREATOR);
            } else if (iW == 3) {
                latLng2 = (LatLng) SafeParcelReader.p(parcel, iE, LatLng.CREATOR);
            } else if (iW == 4) {
                latLng3 = (LatLng) SafeParcelReader.p(parcel, iE, LatLng.CREATOR);
            } else if (iW == 5) {
                latLng4 = (LatLng) SafeParcelReader.p(parcel, iE, LatLng.CREATOR);
            } else if (iW != 6) {
                SafeParcelReader.N(parcel, iE);
            } else {
                latLngBounds = (LatLngBounds) SafeParcelReader.p(parcel, iE, LatLngBounds.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new VisibleRegion(latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new VisibleRegion[i3];
    }
}
