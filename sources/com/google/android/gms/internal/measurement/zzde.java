package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzde implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        Bundle bundleF = null;
        String strQ = null;
        boolean zX = false;
        long J = 0;
        long J2 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                J = SafeParcelReader.J(parcel, iE);
            } else if (iW == 2) {
                J2 = SafeParcelReader.J(parcel, iE);
            } else if (iW == 3) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW == 7) {
                bundleF = SafeParcelReader.f(parcel, iE);
            } else if (iW != 8) {
                SafeParcelReader.N(parcel, iE);
            } else {
                strQ = SafeParcelReader.q(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzdd(J, J2, zX, bundleF, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzdd[i3];
    }
}
