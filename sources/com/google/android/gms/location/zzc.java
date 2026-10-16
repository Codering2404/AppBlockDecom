package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        WorkSource workSource = null;
        String strQ = null;
        int[] iArrK = null;
        String strQ2 = null;
        String strQ3 = null;
        long J = 0;
        long J2 = 0;
        boolean zX = false;
        boolean zX2 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 2:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 3:
                    workSource = (WorkSource) SafeParcelReader.p(parcel, iE, WorkSource.CREATOR);
                    break;
                case 4:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    iArrK = SafeParcelReader.k(parcel, iE);
                    break;
                case 6:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 7:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 9:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzb(J, zX, workSource, strQ, iArrK, zX2, strQ2, J2, strQ3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzb[i3];
    }
}
