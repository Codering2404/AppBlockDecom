package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaa implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        StampStyle stampStyle = null;
        int iG = 0;
        int iG2 = 0;
        boolean zX = false;
        float fC = 0.0f;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                fC = SafeParcelReader.C(parcel, iE);
            } else if (iW == 3) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW == 4) {
                iG2 = SafeParcelReader.G(parcel, iE);
            } else if (iW == 5) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW != 6) {
                SafeParcelReader.N(parcel, iE);
            } else {
                stampStyle = (StampStyle) SafeParcelReader.p(parcel, iE, StampStyle.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new StrokeStyle(fC, iG, iG2, zX, stampStyle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new StrokeStyle[i3];
    }
}
