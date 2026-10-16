package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcdl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListS = null;
        ArrayList arrayListS2 = null;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 5:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 6:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 7:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 8:
                    zX4 = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    arrayListS2 = SafeParcelReader.s(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzcdk(strQ, strQ2, zX, zX2, arrayListS, zX3, zX4, arrayListS2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzcdk[i3];
    }
}
