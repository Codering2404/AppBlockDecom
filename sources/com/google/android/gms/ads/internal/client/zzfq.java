package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfq implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        int iG = 0;
        int iG2 = 0;
        boolean zX = false;
        String strQ = null;
        zzm zzmVar = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 2) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW == 3) {
                zzmVar = (zzm) SafeParcelReader.p(parcel, iE, zzm.CREATOR);
            } else if (iW == 4) {
                iG2 = SafeParcelReader.G(parcel, iE);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                zX = SafeParcelReader.x(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzfp(strQ, iG, zzmVar, iG2, zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzfp[i3];
    }
}
