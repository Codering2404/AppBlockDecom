package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        ArrayList arrayListU = null;
        zze zzeVar = null;
        int iG = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW == 3) {
                strQ = SafeParcelReader.q(parcel, iE);
            } else if (iW == 4) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 6) {
                strQ3 = SafeParcelReader.q(parcel, iE);
            } else if (iW == 7) {
                zzeVar = (zze) SafeParcelReader.p(parcel, iE, zze.CREATOR);
            } else if (iW != 8) {
                SafeParcelReader.N(parcel, iE);
            } else {
                arrayListU = SafeParcelReader.u(parcel, iE, Feature.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zze(iG, strQ, strQ2, strQ3, arrayListU, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zze[i3];
    }
}
