package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzel implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        int iG = -1;
        int iG2 = 0;
        short sL = 0;
        int iG3 = 0;
        long J = 0;
        float fC = 0.0f;
        double dA = 0.0d;
        double dA2 = 0.0d;
        String strQ = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 2:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 3:
                    sL = SafeParcelReader.L(parcel, iE);
                    break;
                case 4:
                    dA = SafeParcelReader.A(parcel, iE);
                    break;
                case 5:
                    dA2 = SafeParcelReader.A(parcel, iE);
                    break;
                case 6:
                    fC = SafeParcelReader.C(parcel, iE);
                    break;
                case 7:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 8:
                    iG3 = SafeParcelReader.G(parcel, iE);
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
        return new zzek(strQ, iG2, sL, dA, dA2, fC, J, iG3, iG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzek[i3];
    }
}
