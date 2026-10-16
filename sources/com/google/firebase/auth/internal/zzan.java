package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzan implements Parcelable.Creator<zzal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        zzam zzamVar = null;
        String strQ = null;
        com.google.firebase.auth.zze zzeVar = null;
        zzaf zzafVar = null;
        ArrayList arrayListU2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    arrayListU = SafeParcelReader.u(parcel, iE, PhoneMultiFactorInfo.CREATOR);
                    break;
                case 2:
                    zzamVar = (zzam) SafeParcelReader.p(parcel, iE, zzam.CREATOR);
                    break;
                case 3:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    zzeVar = (com.google.firebase.auth.zze) SafeParcelReader.p(parcel, iE, com.google.firebase.auth.zze.CREATOR);
                    break;
                case 5:
                    zzafVar = (zzaf) SafeParcelReader.p(parcel, iE, zzaf.CREATOR);
                    break;
                case 6:
                    arrayListU2 = SafeParcelReader.u(parcel, iE, TotpMultiFactorInfo.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzal(arrayListU, zzamVar, strQ, zzeVar, zzafVar, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzal[] newArray(int i3) {
        return new zzal[i3];
    }
}
