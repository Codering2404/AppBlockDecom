package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zaf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String[] strArrR = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundleF = null;
        int iG = 0;
        int iG2 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                strArrR = SafeParcelReader.r(parcel, iE);
            } else if (iW == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.t(parcel, iE, CursorWindow.CREATOR);
            } else if (iW == 3) {
                iG2 = SafeParcelReader.G(parcel, iE);
            } else if (iW == 4) {
                bundleF = SafeParcelReader.f(parcel, iE);
            } else if (iW != 1000) {
                SafeParcelReader.N(parcel, iE);
            } else {
                iG = SafeParcelReader.G(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        DataHolder dataHolder = new DataHolder(iG, strArrR, cursorWindowArr, iG2, bundleF);
        dataHolder.w0();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new DataHolder[i3];
    }
}
