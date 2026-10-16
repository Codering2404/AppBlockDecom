package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzai implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        zzpl zzplVar = null;
        String strQ3 = null;
        zzbg zzbgVar = null;
        zzbg zzbgVar2 = null;
        zzbg zzbgVar3 = null;
        long J = 0;
        long J2 = 0;
        long J3 = 0;
        boolean zX = false;
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
                    zzplVar = (zzpl) SafeParcelReader.p(parcel, iE, zzpl.CREATOR);
                    break;
                case 5:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 6:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 7:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    zzbgVar = (zzbg) SafeParcelReader.p(parcel, iE, zzbg.CREATOR);
                    break;
                case 9:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 10:
                    zzbgVar2 = (zzbg) SafeParcelReader.p(parcel, iE, zzbg.CREATOR);
                    break;
                case 11:
                    J3 = SafeParcelReader.J(parcel, iE);
                    break;
                case 12:
                    zzbgVar3 = (zzbg) SafeParcelReader.p(parcel, iE, zzbg.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzah(strQ, strQ2, zzplVar, J, zX, strQ3, zzbgVar, J2, zzbgVar2, J3, zzbgVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzah[i3];
    }
}
