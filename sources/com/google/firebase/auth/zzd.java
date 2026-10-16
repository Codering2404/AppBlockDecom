package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzd implements Parcelable.Creator<zze> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        zzajb zzajbVar = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 2:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    zzajbVar = (zzajb) SafeParcelReader.p(parcel, iE, zzajb.CREATOR);
                    break;
                case 5:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 6:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    strQ6 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zze(strQ, strQ2, strQ3, zzajbVar, strQ4, strQ5, strQ6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze[] newArray(int i3) {
        return new zze[i3];
    }
}
