package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        int iG = 0;
        int iG2 = 0;
        boolean zX = false;
        int iG3 = 0;
        int iG4 = 0;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        boolean zX5 = false;
        boolean zX6 = false;
        boolean zX7 = false;
        boolean zX8 = false;
        boolean zX9 = false;
        boolean zX10 = false;
        String strQ = null;
        zzr[] zzrVarArr = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 4:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 5:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 7:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 8:
                    zzrVarArr = (zzr[]) SafeParcelReader.t(parcel, iE, zzr.CREATOR);
                    break;
                case 9:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 10:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 11:
                    zX4 = SafeParcelReader.x(parcel, iE);
                    break;
                case 12:
                    zX5 = SafeParcelReader.x(parcel, iE);
                    break;
                case 13:
                    zX6 = SafeParcelReader.x(parcel, iE);
                    break;
                case 14:
                    zX7 = SafeParcelReader.x(parcel, iE);
                    break;
                case 15:
                    zX8 = SafeParcelReader.x(parcel, iE);
                    break;
                case 16:
                    zX9 = SafeParcelReader.x(parcel, iE);
                    break;
                case 17:
                    zX10 = SafeParcelReader.x(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzr(strQ, iG, iG2, zX, iG3, iG4, zzrVarArr, zX2, zX3, zX4, zX5, zX6, zX7, zX8, zX9, zX10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzr[i3];
    }
}
