package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = "";
        GoogleSignInAccount googleSignInAccount = null;
        String strQ2 = "";
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 4) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 7) {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.p(parcel, iE, GoogleSignInAccount.CREATOR);
            } else if (iW != 8) {
                SafeParcelReader.N(parcel, iE);
            } else {
                strQ2 = SafeParcelReader.q(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new SignInAccount(strQ, googleSignInAccount, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new SignInAccount[i3];
    }
}
