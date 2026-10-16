package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzah implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        float fC = 0.0f;
        float fC2 = 0.0f;
        boolean zX = true;
        boolean zX2 = false;
        IBinder iBinderF = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 2) {
                iBinderF = SafeParcelReader.F(parcel, iE);
            } else if (iW == 3) {
                zX2 = SafeParcelReader.x(parcel, iE);
            } else if (iW == 4) {
                fC = SafeParcelReader.C(parcel, iE);
            } else if (iW == 5) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW != 6) {
                SafeParcelReader.N(parcel, iE);
            } else {
                fC2 = SafeParcelReader.C(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new TileOverlayOptions(iBinderF, zX2, fC, zX, fC2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new TileOverlayOptions[i3];
    }
}
