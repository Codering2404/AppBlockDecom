package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzon implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        byte[] bArrG = null;
        String strQ = null;
        Bundle bundleF = null;
        String strQ2 = null;
        long J = 0;
        long J2 = 0;
        int iG = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 2:
                    bArrG = SafeParcelReader.g(parcel, iE);
                    break;
                case 3:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    bundleF = SafeParcelReader.f(parcel, iE);
                    break;
                case 5:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 6:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 7:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzom(J, bArrG, strQ, bundleF, iG, J2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzom[i3];
    }
}
