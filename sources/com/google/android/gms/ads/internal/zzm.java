package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzm implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        int iG = 0;
        boolean zX4 = false;
        boolean zX5 = false;
        boolean zX6 = false;
        float fC = 0.0f;
        String strQ = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 3:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 4:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    fC = SafeParcelReader.C(parcel, iE);
                    break;
                case 7:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 8:
                    zX4 = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    zX5 = SafeParcelReader.x(parcel, iE);
                    break;
                case 10:
                    zX6 = SafeParcelReader.x(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzl(zX, zX2, strQ, zX3, fC, iG, zX4, zX5, zX6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzl[i3];
    }
}
