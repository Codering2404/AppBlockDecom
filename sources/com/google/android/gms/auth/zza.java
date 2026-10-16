package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        int iG = 0;
        int iG2 = 0;
        int iG3 = 0;
        long J = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 3:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 5:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 6:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new AccountChangeEvent(iG, J, strQ, iG2, iG3, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new AccountChangeEvent[i3];
    }
}
