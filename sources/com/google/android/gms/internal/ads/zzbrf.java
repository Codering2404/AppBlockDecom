package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbrf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        long J = 0;
        boolean zX = false;
        int iG = 0;
        boolean zX2 = false;
        String strQ = null;
        byte[] bArrG = null;
        String[] strArrR = null;
        String[] strArrR2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 4:
                    bArrG = SafeParcelReader.g(parcel, iE);
                    break;
                case 5:
                    strArrR = SafeParcelReader.r(parcel, iE);
                    break;
                case 6:
                    strArrR2 = SafeParcelReader.r(parcel, iE);
                    break;
                case 7:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 8:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzbre(zX, strQ, iG, bArrG, strArrR, strArrR2, zX2, J);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzbre[i3];
    }
}
