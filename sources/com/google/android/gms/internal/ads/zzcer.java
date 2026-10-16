package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcer implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        com.google.android.gms.ads.internal.client.zzr zzrVar = null;
        com.google.android.gms.ads.internal.client.zzm zzmVar = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 2) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 3) {
                zzrVar = (com.google.android.gms.ads.internal.client.zzr) SafeParcelReader.p(parcel, iE, com.google.android.gms.ads.internal.client.zzr.CREATOR);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                zzmVar = (com.google.android.gms.ads.internal.client.zzm) SafeParcelReader.p(parcel, iE, com.google.android.gms.ads.internal.client.zzm.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzceq(strQ, strQ2, zzrVar, zzmVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzceq[i3];
    }
}
