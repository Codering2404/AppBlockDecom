package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            if (SafeParcelReader.w(iE) != 1) {
                SafeParcelReader.N(parcel, iE);
            } else {
                pendingIntent = (PendingIntent) SafeParcelReader.p(parcel, iE, PendingIntent.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new SaveAccountLinkingTokenResult(pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new SaveAccountLinkingTokenResult[i3];
    }
}
