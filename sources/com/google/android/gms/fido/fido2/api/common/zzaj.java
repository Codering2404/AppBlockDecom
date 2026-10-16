package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.fido.zzgx;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        int iG = 0;
        byte[] bArrG = null;
        byte[] bArrG2 = null;
        byte[] bArrG3 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                bArrG = SafeParcelReader.g(parcel, iE);
            } else if (iW == 2) {
                bArrG2 = SafeParcelReader.g(parcel, iE);
            } else if (iW == 3) {
                bArrG3 = SafeParcelReader.g(parcel, iE);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                iG = SafeParcelReader.G(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzai(bArrG == null ? null : zzgx.zzl(bArrG, 0, bArrG.length), bArrG2 == null ? null : zzgx.zzl(bArrG2, 0, bArrG2.length), bArrG3 != null ? zzgx.zzl(bArrG3, 0, bArrG3.length) : null, iG);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzai[i3];
    }
}
