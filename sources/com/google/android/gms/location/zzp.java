package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.location.zzek;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzp implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        int iG = 0;
        String strQ = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                arrayListU = SafeParcelReader.u(parcel, iE, zzek.CREATOR);
            } else if (iW == 2) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                strQ = SafeParcelReader.q(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GeofencingRequest(arrayListU, iG, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new GeofencingRequest[i3];
    }
}
