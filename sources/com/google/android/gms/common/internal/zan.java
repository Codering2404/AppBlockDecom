package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zan implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        int iG = -1;
        int iG2 = 0;
        int iG3 = 0;
        int iG4 = 0;
        int iG5 = 0;
        String strQ = null;
        String strQ2 = null;
        long J = 0;
        long J2 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 3:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 4:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 5:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 6:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    iG5 = SafeParcelReader.G(parcel, iE);
                    break;
                case 9:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new MethodInvocation(iG2, iG3, iG4, J, J2, strQ, strQ2, iG5, iG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new MethodInvocation[i3];
    }
}
