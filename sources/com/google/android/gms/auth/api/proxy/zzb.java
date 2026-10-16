package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        PendingIntent pendingIntent = null;
        Bundle bundleF = null;
        byte[] bArrG = null;
        int iG = 0;
        int iG2 = 0;
        int iG3 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                iG2 = SafeParcelReader.G(parcel, iE);
            } else if (iW == 2) {
                pendingIntent = (PendingIntent) SafeParcelReader.p(parcel, iE, PendingIntent.CREATOR);
            } else if (iW == 3) {
                iG3 = SafeParcelReader.G(parcel, iE);
            } else if (iW == 4) {
                bundleF = SafeParcelReader.f(parcel, iE);
            } else if (iW == 5) {
                bArrG = SafeParcelReader.g(parcel, iE);
            } else if (iW != 1000) {
                SafeParcelReader.N(parcel, iE);
            } else {
                iG = SafeParcelReader.G(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new ProxyResponse(iG, iG2, pendingIntent, iG3, bundleF, bArrG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new ProxyResponse[i3];
    }
}
