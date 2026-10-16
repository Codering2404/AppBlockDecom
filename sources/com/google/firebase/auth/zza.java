package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zza implements Parcelable.Creator<ActionCodeSettings> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActionCodeSettings createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        boolean zX = false;
        boolean zX2 = false;
        int iG = 0;
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
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 8:
                    strQ6 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 10:
                    strQ7 = SafeParcelReader.q(parcel, iE);
                    break;
                case 11:
                    strQ8 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new ActionCodeSettings(strQ, strQ2, strQ3, strQ4, zX, strQ5, zX2, strQ6, iG, strQ7, strQ8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ActionCodeSettings[] newArray(int i3) {
        return new ActionCodeSettings[i3];
    }
}
