package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        byte[] bArrG = null;
        String strQ = null;
        byte[] bArrG2 = null;
        byte[] bArrG3 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                bArrG = SafeParcelReader.g(parcel, iE);
            } else if (iW == 3) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 4) {
                bArrG2 = SafeParcelReader.g(parcel, iE);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                bArrG3 = SafeParcelReader.g(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new SignResponseData(bArrG, strQ, bArrG2, bArrG3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new SignResponseData[i3];
    }
}
