package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzab implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        zzal[] zzalVarArr = null;
        long J = 0;
        int iG = 1;
        int iG2 = 1;
        int iG3 = 1000;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 3:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 4:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 5:
                    zzalVarArr = (zzal[]) SafeParcelReader.t(parcel, iE, zzal.CREATOR);
                    break;
                case 6:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new LocationAvailability(iG3, iG, iG2, J, zzalVarArr, zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new LocationAvailability[i3];
    }
}
