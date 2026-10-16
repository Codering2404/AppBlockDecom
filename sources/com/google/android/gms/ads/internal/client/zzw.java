package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzw implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        zze zzeVar = null;
        Bundle bundleF = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        long J = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 2:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 3:
                    zzeVar = (zze) SafeParcelReader.p(parcel, iE, zze.CREATOR);
                    break;
                case 4:
                    bundleF = SafeParcelReader.f(parcel, iE);
                    break;
                case 5:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 6:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzv(strQ, J, zzeVar, bundleF, strQ2, strQ3, strQ4, strQ5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzv[i3];
    }
}
