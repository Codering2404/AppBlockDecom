package com.google.android.gms.auth.blockstore;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = "com.google.android.gms.auth.blockstore.DEFAULT_BYTES_DATA_KEY";
        boolean zX = false;
        byte[] bArrG = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                bArrG = SafeParcelReader.g(parcel, iE);
            } else if (iW == 2) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW != 3) {
                SafeParcelReader.N(parcel, iE);
            } else {
                strQ = SafeParcelReader.q(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new StoreBytesData(bArrG, zX, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new StoreBytesData[i3];
    }
}
