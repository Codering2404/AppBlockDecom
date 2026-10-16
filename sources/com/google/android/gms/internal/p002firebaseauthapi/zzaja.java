package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaja implements Parcelable.Creator<zzajb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajb createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        String strQ9 = null;
        String strQ10 = null;
        String strQ11 = null;
        String strQ12 = null;
        String strQ13 = null;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    strQ3 = SafeParcelReader.q(parcel, iE);
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
                case 8:
                    strQ7 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    strQ8 = SafeParcelReader.q(parcel, iE);
                    break;
                case 10:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 11:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 12:
                    strQ9 = SafeParcelReader.q(parcel, iE);
                    break;
                case 13:
                    strQ10 = SafeParcelReader.q(parcel, iE);
                    break;
                case 14:
                    strQ11 = SafeParcelReader.q(parcel, iE);
                    break;
                case 15:
                    strQ12 = SafeParcelReader.q(parcel, iE);
                    break;
                case 16:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 17:
                    strQ13 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzajb(strQ, strQ2, strQ3, strQ4, strQ5, strQ6, strQ7, strQ8, zX, zX2, strQ9, strQ10, strQ11, strQ12, zX3, strQ13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzajb[] newArray(int i3) {
        return new zzajb[i3];
    }
}
