package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaq implements Parcelable.Creator<PhoneMultiFactorInfo> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneMultiFactorInfo createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        long J = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 2) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 3) {
                J = SafeParcelReader.J(parcel, iE);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                strQ3 = SafeParcelReader.q(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new PhoneMultiFactorInfo(strQ, strQ2, J, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneMultiFactorInfo[] newArray(int i3) {
        return new PhoneMultiFactorInfo[i3];
    }
}
