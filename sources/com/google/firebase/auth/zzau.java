package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzau implements Parcelable.Creator<UserProfileChangeRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ UserProfileChangeRequest createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        boolean zX = false;
        boolean zX2 = false;
        String strQ2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 3) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 4) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                zX2 = SafeParcelReader.x(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new UserProfileChangeRequest(strQ, strQ2, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ UserProfileChangeRequest[] newArray(int i3) {
        return new UserProfileChangeRequest[i3];
    }
}
