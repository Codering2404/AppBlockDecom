package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        boolean zX5 = false;
        boolean zX6 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 2:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 3:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 4:
                    zX4 = SafeParcelReader.x(parcel, iE);
                    break;
                case 5:
                    zX5 = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    zX6 = SafeParcelReader.x(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new LocationSettingsStates(zX, zX2, zX3, zX4, zX5, zX6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new LocationSettingsStates[i3];
    }
}
