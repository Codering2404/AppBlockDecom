package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahu implements Parcelable.Creator<zzahv> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahv createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        Long lK = null;
        String strQ3 = null;
        Long lK2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 3) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 4) {
                lK = SafeParcelReader.K(parcel, iE);
            } else if (iW == 5) {
                strQ3 = SafeParcelReader.q(parcel, iE);
            } else if (iW != 6) {
                SafeParcelReader.N(parcel, iE);
            } else {
                lK2 = SafeParcelReader.K(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzahv(strQ, strQ2, lK, strQ3, lK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzahv[] newArray(int i3) {
        return new zzahv[i3];
    }
}
