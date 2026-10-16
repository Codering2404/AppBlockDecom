package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        int iG = 0;
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        Bundle bundleF = null;
        String strQ5 = null;
        long J = 0;
        long J2 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 4:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 6:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    bundleF = SafeParcelReader.f(parcel, iE);
                    break;
                case 8:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 10:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 11:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzbhb(strQ, J, strQ2, strQ3, strQ4, bundleF, zX, J2, strQ5, iG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzbhb[i3];
    }
}
