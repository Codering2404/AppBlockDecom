package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        LatLng latLng = null;
        ArrayList arrayListU = null;
        int iG = 0;
        int iG2 = 0;
        boolean zX = false;
        boolean zX2 = false;
        float fC = 0.0f;
        float fC2 = 0.0f;
        double dA = 0.0d;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.p(parcel, iE, LatLng.CREATOR);
                    break;
                case 3:
                    dA = SafeParcelReader.A(parcel, iE);
                    break;
                case 4:
                    fC = SafeParcelReader.C(parcel, iE);
                    break;
                case 5:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 6:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 7:
                    fC2 = SafeParcelReader.C(parcel, iE);
                    break;
                case 8:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 10:
                    arrayListU = SafeParcelReader.u(parcel, iE, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new CircleOptions(latLng, dA, fC, iG, iG2, fC2, zX, zX2, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new CircleOptions[i3];
    }
}
