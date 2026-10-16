package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        String strQ = null;
        LatLng latLng = null;
        Integer numH = null;
        StreetViewSource streetViewSource = null;
        byte bZ = 0;
        byte bZ2 = 0;
        byte bZ3 = 0;
        byte bZ4 = 0;
        byte bZ5 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) SafeParcelReader.p(parcel, iE, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    latLng = (LatLng) SafeParcelReader.p(parcel, iE, LatLng.CREATOR);
                    break;
                case 5:
                    numH = SafeParcelReader.H(parcel, iE);
                    break;
                case 6:
                    bZ = SafeParcelReader.z(parcel, iE);
                    break;
                case 7:
                    bZ2 = SafeParcelReader.z(parcel, iE);
                    break;
                case 8:
                    bZ3 = SafeParcelReader.z(parcel, iE);
                    break;
                case 9:
                    bZ4 = SafeParcelReader.z(parcel, iE);
                    break;
                case 10:
                    bZ5 = SafeParcelReader.z(parcel, iE);
                    break;
                case 11:
                    streetViewSource = (StreetViewSource) SafeParcelReader.p(parcel, iE, StreetViewSource.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, strQ, latLng, numH, bZ, bZ2, bZ3, bZ4, bZ5, streetViewSource);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new StreetViewPanoramaOptions[i3];
    }
}
