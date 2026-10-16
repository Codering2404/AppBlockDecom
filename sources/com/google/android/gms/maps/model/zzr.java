package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        Cap cap = null;
        Cap cap2 = null;
        ArrayList arrayListU2 = null;
        ArrayList arrayListU3 = null;
        int iG = 0;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        int iG2 = 0;
        float fC = 0.0f;
        float fC2 = 0.0f;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    arrayListU = SafeParcelReader.u(parcel, iE, LatLng.CREATOR);
                    break;
                case 3:
                    fC = SafeParcelReader.C(parcel, iE);
                    break;
                case 4:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 5:
                    fC2 = SafeParcelReader.C(parcel, iE);
                    break;
                case 6:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 7:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 8:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    cap = (Cap) SafeParcelReader.p(parcel, iE, Cap.CREATOR);
                    break;
                case 10:
                    cap2 = (Cap) SafeParcelReader.p(parcel, iE, Cap.CREATOR);
                    break;
                case 11:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 12:
                    arrayListU2 = SafeParcelReader.u(parcel, iE, PatternItem.CREATOR);
                    break;
                case 13:
                    arrayListU3 = SafeParcelReader.u(parcel, iE, StyleSpan.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new PolylineOptions(arrayListU, fC, iG, fC2, zX, zX2, zX3, cap, cap2, iG2, arrayListU2, arrayListU3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new PolylineOptions[i3];
    }
}
