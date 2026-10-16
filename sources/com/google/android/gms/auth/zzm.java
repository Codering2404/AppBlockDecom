package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        Long lK = null;
        ArrayList arrayListS = null;
        String strQ2 = null;
        int iG = 0;
        boolean zX = false;
        boolean zX2 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    lK = SafeParcelReader.K(parcel, iE);
                    break;
                case 4:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 5:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 7:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new TokenData(iG, strQ, lK, zX, zX2, arrayListS, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new TokenData[i3];
    }
}
