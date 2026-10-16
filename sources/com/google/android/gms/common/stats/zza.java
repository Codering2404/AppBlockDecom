package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zza implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        int iG = 0;
        int iG2 = 0;
        int iG3 = 0;
        int iG4 = 0;
        boolean zX = false;
        String strQ = null;
        ArrayList arrayListS = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        String strQ5 = null;
        long J = 0;
        long J2 = 0;
        long J3 = 0;
        float fC = 0.0f;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 4:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 6:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 8:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 10:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 11:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 12:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 13:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 14:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 15:
                    fC = SafeParcelReader.C(parcel, iE);
                    break;
                case 16:
                    J3 = SafeParcelReader.J(parcel, iE);
                    break;
                case 17:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 18:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new WakeLockEvent(iG, J, iG2, strQ, iG3, arrayListS, strQ2, J2, iG4, strQ3, strQ4, fC, J3, strQ5, zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new WakeLockEvent[i3];
    }
}
