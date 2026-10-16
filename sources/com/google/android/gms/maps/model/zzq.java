package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayList = new ArrayList();
        float fC = 0.0f;
        ArrayList arrayListU = null;
        int iG = 0;
        int iG2 = 0;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        int iG3 = 0;
        float fC2 = 0.0f;
        ArrayList arrayListU2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    arrayListU2 = SafeParcelReader.u(parcel, iE, LatLng.CREATOR);
                    break;
                case 3:
                    SafeParcelReader.I(parcel, iE, arrayList, zzq.class.getClassLoader());
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
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 11:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 12:
                    arrayListU = SafeParcelReader.u(parcel, iE, PatternItem.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new PolygonOptions(arrayListU2, arrayList, fC, iG, iG2, fC2, zX, zX2, zX3, iG3, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new PolygonOptions[i3];
    }
}
