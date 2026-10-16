package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzy implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        zzaf zzafVar = null;
        zzx zzxVar = null;
        com.google.firebase.auth.zze zzeVar = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                zzafVar = (zzaf) SafeParcelReader.p(parcel, iE, zzaf.CREATOR);
            } else if (iW == 2) {
                zzxVar = (zzx) SafeParcelReader.p(parcel, iE, zzx.CREATOR);
            } else if (iW != 3) {
                SafeParcelReader.N(parcel, iE);
            } else {
                zzeVar = (com.google.firebase.auth.zze) SafeParcelReader.p(parcel, iE, com.google.firebase.auth.zze.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzz(zzafVar, zzxVar, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i3) {
        return new zzz[i3];
    }
}
