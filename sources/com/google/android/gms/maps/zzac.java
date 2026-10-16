package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzac implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        CameraPosition cameraPosition = null;
        Float fD = null;
        Float fD2 = null;
        LatLngBounds latLngBounds = null;
        Integer numH = null;
        String strQ = null;
        byte bZ = -1;
        byte bZ2 = -1;
        byte bZ3 = -1;
        byte bZ4 = -1;
        byte bZ5 = -1;
        byte bZ6 = -1;
        byte bZ7 = -1;
        byte bZ8 = -1;
        byte bZ9 = -1;
        byte bZ10 = -1;
        byte bZ11 = -1;
        byte bZ12 = -1;
        int iG = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    bZ = SafeParcelReader.z(parcel, iE);
                    break;
                case 3:
                    bZ2 = SafeParcelReader.z(parcel, iE);
                    break;
                case 4:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) SafeParcelReader.p(parcel, iE, CameraPosition.CREATOR);
                    break;
                case 6:
                    bZ3 = SafeParcelReader.z(parcel, iE);
                    break;
                case 7:
                    bZ4 = SafeParcelReader.z(parcel, iE);
                    break;
                case 8:
                    bZ5 = SafeParcelReader.z(parcel, iE);
                    break;
                case 9:
                    bZ6 = SafeParcelReader.z(parcel, iE);
                    break;
                case 10:
                    bZ7 = SafeParcelReader.z(parcel, iE);
                    break;
                case 11:
                    bZ8 = SafeParcelReader.z(parcel, iE);
                    break;
                case 12:
                    bZ9 = SafeParcelReader.z(parcel, iE);
                    break;
                case 13:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 14:
                    bZ10 = SafeParcelReader.z(parcel, iE);
                    break;
                case 15:
                    bZ11 = SafeParcelReader.z(parcel, iE);
                    break;
                case 16:
                    fD = SafeParcelReader.D(parcel, iE);
                    break;
                case 17:
                    fD2 = SafeParcelReader.D(parcel, iE);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) SafeParcelReader.p(parcel, iE, LatLngBounds.CREATOR);
                    break;
                case 19:
                    bZ12 = SafeParcelReader.z(parcel, iE);
                    break;
                case 20:
                    numH = SafeParcelReader.H(parcel, iE);
                    break;
                case 21:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GoogleMapOptions(bZ, bZ2, iG, cameraPosition, bZ3, bZ4, bZ5, bZ6, bZ7, bZ8, bZ9, bZ10, bZ11, fD, fD2, latLngBounds, bZ12, numH, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new GoogleMapOptions[i3];
    }
}
