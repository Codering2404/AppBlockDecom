package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbzu implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        IBinder iBinderF = null;
        IBinder iBinderF2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                iBinderF = SafeParcelReader.F(parcel, iE);
            } else if (iW != 2) {
                SafeParcelReader.N(parcel, iE);
            } else {
                iBinderF2 = SafeParcelReader.F(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzbzt(iBinderF, iBinderF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzbzt[i3];
    }
}
