package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbm implements Parcelable.Creator<zzbj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbj createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                arrayListU = SafeParcelReader.u(parcel, iE, PhoneMultiFactorInfo.CREATOR);
            } else if (iW != 2) {
                SafeParcelReader.N(parcel, iE);
            } else {
                arrayListU2 = SafeParcelReader.u(parcel, iE, TotpMultiFactorInfo.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzbj(arrayListU, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbj[] newArray(int i3) {
        return new zzbj[i3];
    }
}
