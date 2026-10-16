package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzs implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        int iG = 0;
        boolean zX2 = false;
        boolean zX3 = false;
        int iG2 = 0;
        int iG3 = 0;
        long J = 0;
        long J2 = 0;
        long J3 = 0;
        long J4 = 0;
        long J5 = 0;
        long J6 = 0;
        long J7 = 0;
        String strQ = "";
        String strQ2 = strQ;
        String strQ3 = strQ2;
        String strQ4 = strQ3;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        String strQ8 = null;
        String strQ9 = null;
        String strQ10 = null;
        Boolean boolY = null;
        ArrayList arrayListS = null;
        String strQ11 = null;
        String strQ12 = null;
        int iG4 = 100;
        boolean zX4 = true;
        boolean zX5 = true;
        long J8 = -2147483648L;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    strQ6 = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    strQ7 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    strQ8 = SafeParcelReader.q(parcel, iE);
                    break;
                case 6:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 7:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 8:
                    strQ9 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    zX4 = SafeParcelReader.x(parcel, iE);
                    break;
                case 10:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 11:
                    J8 = SafeParcelReader.J(parcel, iE);
                    break;
                case 12:
                    strQ10 = SafeParcelReader.q(parcel, iE);
                    break;
                case 13:
                case 17:
                case 19:
                case 20:
                case 24:
                case 33:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 14:
                    J3 = SafeParcelReader.J(parcel, iE);
                    break;
                case 15:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 16:
                    zX5 = SafeParcelReader.x(parcel, iE);
                    break;
                case 18:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 21:
                    boolY = SafeParcelReader.y(parcel, iE);
                    break;
                case 22:
                    J4 = SafeParcelReader.J(parcel, iE);
                    break;
                case 23:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 25:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 26:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 27:
                    strQ11 = SafeParcelReader.q(parcel, iE);
                    break;
                case 28:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 29:
                    J5 = SafeParcelReader.J(parcel, iE);
                    break;
                case 30:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 31:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 32:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 34:
                    J6 = SafeParcelReader.J(parcel, iE);
                    break;
                case 35:
                    strQ12 = SafeParcelReader.q(parcel, iE);
                    break;
                case 36:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 37:
                    J7 = SafeParcelReader.J(parcel, iE);
                    break;
                case 38:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzr(strQ5, strQ6, strQ7, strQ8, J, J2, strQ9, zX4, zX, J8, strQ10, J3, iG, zX5, zX2, boolY, J4, arrayListS, strQ, strQ2, strQ11, zX3, J5, iG4, strQ3, iG2, J6, strQ12, strQ4, J7, iG3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzr[i3];
    }
}
