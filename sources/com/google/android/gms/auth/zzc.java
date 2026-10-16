package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        int iG = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW != 2) {
                SafeParcelReader.N(parcel, iE);
            } else {
                arrayListU = SafeParcelReader.u(parcel, iE, AccountChangeEvent.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new AccountChangeEventsResponse(iG, arrayListU);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new AccountChangeEventsResponse[i3];
    }
}
