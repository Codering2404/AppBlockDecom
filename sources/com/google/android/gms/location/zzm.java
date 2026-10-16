package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        float fC = 0.0f;
        float fC2 = 0.0f;
        float fC3 = 0.0f;
        float fC4 = 0.0f;
        byte bZ = 0;
        long J = 0;
        float[] fArrJ = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW != 1) {
                switch (iW) {
                    case 4:
                        fC = SafeParcelReader.C(parcel, iE);
                        break;
                    case 5:
                        fC2 = SafeParcelReader.C(parcel, iE);
                        break;
                    case 6:
                        J = SafeParcelReader.J(parcel, iE);
                        break;
                    case 7:
                        bZ = SafeParcelReader.z(parcel, iE);
                        break;
                    case 8:
                        fC3 = SafeParcelReader.C(parcel, iE);
                        break;
                    case 9:
                        fC4 = SafeParcelReader.C(parcel, iE);
                        break;
                    default:
                        SafeParcelReader.N(parcel, iE);
                        break;
                }
            } else {
                fArrJ = SafeParcelReader.j(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new DeviceOrientation(fArrJ, fC, fC2, J, bZ, fC3, fC4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new DeviceOrientation[i3];
    }
}
