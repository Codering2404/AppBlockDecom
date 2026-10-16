package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        WorkSource workSource = new WorkSource();
        com.google.android.gms.internal.location.zze zzeVar = null;
        int iG = 0;
        boolean zX = false;
        int iG2 = 0;
        long J = Long.MAX_VALUE;
        long J2 = Long.MAX_VALUE;
        int iG3 = 102;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 2:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 3:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 4:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 5:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    workSource = (WorkSource) SafeParcelReader.p(parcel, iE, WorkSource.CREATOR);
                    break;
                case 7:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 8:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 9:
                    zzeVar = (com.google.android.gms.internal.location.zze) SafeParcelReader.p(parcel, iE, com.google.android.gms.internal.location.zze.CREATOR);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new CurrentLocationRequest(J, iG, iG3, J2, zX, iG2, workSource, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new CurrentLocationRequest[i3];
    }
}
