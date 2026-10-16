package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        HashSet hashSet = new HashSet();
        int iG = 0;
        ArrayList arrayListU = null;
        zzs zzsVar = null;
        int iG2 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                iG = SafeParcelReader.G(parcel, iE);
                hashSet.add(1);
            } else if (iW == 2) {
                arrayListU = SafeParcelReader.u(parcel, iE, zzu.CREATOR);
                hashSet.add(2);
            } else if (iW == 3) {
                iG2 = SafeParcelReader.G(parcel, iE);
                hashSet.add(3);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                zzsVar = (zzs) SafeParcelReader.p(parcel, iE, zzs.CREATOR);
                hashSet.add(4);
            }
        }
        if (parcel.dataPosition() == iO) {
            return new zzo(hashSet, iG, arrayListU, iG2, zzsVar);
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + iO, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzo[i3];
    }
}
