package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzt implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListS = null;
        ArrayList arrayListS2 = null;
        ArrayList arrayListS3 = null;
        ArrayList arrayListS4 = null;
        ArrayList arrayListS5 = null;
        int iG = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 3:
                    arrayListS2 = SafeParcelReader.s(parcel, iE);
                    break;
                case 4:
                    arrayListS3 = SafeParcelReader.s(parcel, iE);
                    break;
                case 5:
                    arrayListS4 = SafeParcelReader.s(parcel, iE);
                    break;
                case 6:
                    arrayListS5 = SafeParcelReader.s(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzs(iG, arrayListS, arrayListS2, arrayListS3, arrayListS4, arrayListS5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzs[i3];
    }
}
