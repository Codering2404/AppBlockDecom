package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzao implements Parcelable.Creator<PhoneAuthCredential> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthCredential createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 2) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 4) {
                strQ3 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 5) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW != 6) {
                SafeParcelReader.N(parcel, iE);
            } else {
                strQ4 = SafeParcelReader.q(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new PhoneAuthCredential(strQ, strQ2, strQ3, zX, strQ4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PhoneAuthCredential[] newArray(int i3) {
        return new PhoneAuthCredential[i3];
    }
}
