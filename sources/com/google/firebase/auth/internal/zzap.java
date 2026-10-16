package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzap implements Parcelable.Creator<zzam> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzam createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        zzaf zzafVar = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 2) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 3) {
                arrayListU = SafeParcelReader.u(parcel, iE, PhoneMultiFactorInfo.CREATOR);
            } else if (iW == 4) {
                arrayListU2 = SafeParcelReader.u(parcel, iE, TotpMultiFactorInfo.CREATOR);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                zzafVar = (zzaf) SafeParcelReader.p(parcel, iE, zzaf.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzam(strQ, strQ2, arrayListU, arrayListU2, zzafVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzam[] newArray(int i3) {
        return new zzam[i3];
    }
}
