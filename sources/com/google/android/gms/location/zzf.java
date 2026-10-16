package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        long J = 0;
        int iG = 0;
        int iG2 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW == 2) {
                iG2 = SafeParcelReader.G(parcel, iE);
            } else if (iW != 3) {
                SafeParcelReader.N(parcel, iE);
            } else {
                J = SafeParcelReader.J(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new ActivityTransitionEvent(iG, iG2, J);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new ActivityTransitionEvent[i3];
    }
}
