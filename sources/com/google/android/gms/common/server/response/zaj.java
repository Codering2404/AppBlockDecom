package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        com.google.android.gms.common.server.converter.zaa zaaVar = null;
        int iG = 0;
        int iG2 = 0;
        boolean zX = false;
        int iG3 = 0;
        boolean zX2 = false;
        int iG4 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 3:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 4:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 5:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 8:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    zaaVar = (com.google.android.gms.common.server.converter.zaa) SafeParcelReader.p(parcel, iE, com.google.android.gms.common.server.converter.zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new FastJsonResponse.Field(iG, iG2, zX, iG3, zX2, strQ, iG4, strQ2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new FastJsonResponse.Field[i3];
    }
}
