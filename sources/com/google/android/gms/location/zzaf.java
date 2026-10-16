package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        WorkSource workSource = new WorkSource();
        com.google.android.gms.internal.location.zze zzeVar = null;
        boolean zX = false;
        int iG = 0;
        int iG2 = 0;
        boolean zX2 = false;
        long J = -1;
        float fC = 0.0f;
        int iG3 = Integer.MAX_VALUE;
        long J2 = Long.MAX_VALUE;
        long J3 = Long.MAX_VALUE;
        long J4 = 0;
        long J5 = 600000;
        long J6 = 3600000;
        int iG4 = 102;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    J6 = SafeParcelReader.J(parcel, iE);
                    break;
                case 3:
                    J5 = SafeParcelReader.J(parcel, iE);
                    break;
                case 4:
                case 14:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 5:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 6:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 7:
                    fC = SafeParcelReader.C(parcel, iE);
                    break;
                case 8:
                    J4 = SafeParcelReader.J(parcel, iE);
                    break;
                case 9:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 10:
                    J3 = SafeParcelReader.J(parcel, iE);
                    break;
                case 11:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 12:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 13:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 15:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.p(parcel, iE, WorkSource.CREATOR);
                    break;
                case 17:
                    zzeVar = (com.google.android.gms.internal.location.zze) SafeParcelReader.p(parcel, iE, com.google.android.gms.internal.location.zze.CREATOR);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new LocationRequest(iG4, J6, J5, J4, J2, J3, iG3, fC, zX, J, iG, iG2, zX2, workSource, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new LocationRequest[i3];
    }
}
