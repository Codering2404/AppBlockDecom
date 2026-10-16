package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        float fC = 0.0f;
        float fC2 = 0.0f;
        LatLng latLng = null;
        float fC3 = 0.0f;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                latLng = (LatLng) SafeParcelReader.p(parcel, iE, LatLng.CREATOR);
            } else if (iW == 3) {
                fC = SafeParcelReader.C(parcel, iE);
            } else if (iW == 4) {
                fC3 = SafeParcelReader.C(parcel, iE);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                fC2 = SafeParcelReader.C(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new CameraPosition(latLng, fC, fC3, fC2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new CameraPosition[i3];
    }
}
