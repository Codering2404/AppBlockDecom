package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzy implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        int iG = 0;
        int iG2 = 0;
        boolean zX = false;
        boolean zX2 = false;
        String strQ = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 3) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW == 4) {
                iG2 = SafeParcelReader.G(parcel, iE);
            } else if (iW == 5) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW != 6) {
                SafeParcelReader.N(parcel, iE);
            } else {
                zX2 = SafeParcelReader.x(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new VersionInfoParcel(strQ, iG, iG2, zX, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new VersionInfoParcel[i3];
    }
}
