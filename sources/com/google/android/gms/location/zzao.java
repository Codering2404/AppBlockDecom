package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzao implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        int iG = 0;
        int iG2 = 0;
        int iG3 = 0;
        int iG4 = 0;
        int iG5 = 0;
        int iG6 = 0;
        int iG7 = 0;
        boolean zX = false;
        int iG8 = 0;
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
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 4:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 5:
                    iG5 = SafeParcelReader.G(parcel, iE);
                    break;
                case 6:
                    iG6 = SafeParcelReader.G(parcel, iE);
                    break;
                case 7:
                    iG7 = SafeParcelReader.G(parcel, iE);
                    break;
                case 8:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    iG8 = SafeParcelReader.G(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new SleepClassifyEvent(iG, iG2, iG3, iG4, iG5, iG6, iG7, zX, iG8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new SleepClassifyEvent[i3];
    }
}
