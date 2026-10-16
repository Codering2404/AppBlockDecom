package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        ConnectionResult connectionResult = null;
        int iG = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW == 2) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.p(parcel, iE, PendingIntent.CREATOR);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                connectionResult = (ConnectionResult) SafeParcelReader.p(parcel, iE, ConnectionResult.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new Status(iG, strQ, pendingIntent, connectionResult);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new Status[i3];
    }
}
