package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzae implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        com.google.android.gms.internal.location.zze zzeVar = null;
        boolean zX = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW != 2) {
                SafeParcelReader.N(parcel, iE);
            } else {
                zzeVar = (com.google.android.gms.internal.location.zze) SafeParcelReader.p(parcel, iE, com.google.android.gms.internal.location.zze.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzad(zX, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzad[i3];
    }
}
