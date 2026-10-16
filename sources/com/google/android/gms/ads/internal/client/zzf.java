package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        zze zzeVar = null;
        IBinder iBinderF = null;
        int iG = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW == 2) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 3) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 4) {
                zzeVar = (zze) SafeParcelReader.p(parcel, iE, zze.CREATOR);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                iBinderF = SafeParcelReader.F(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zze(iG, strQ, strQ2, zzeVar, iBinderF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zze[i3];
    }
}
