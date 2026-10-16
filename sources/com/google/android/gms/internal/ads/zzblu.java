package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzblu implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        int iG = 0;
        boolean zX = false;
        int iG2 = 0;
        boolean zX2 = false;
        int iG3 = 0;
        boolean zX3 = false;
        int iG4 = 0;
        int iG5 = 0;
        boolean zX4 = false;
        int iG6 = 0;
        com.google.android.gms.ads.internal.client.zzfw zzfwVar = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 3:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 4:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 5:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 6:
                    zzfwVar = (com.google.android.gms.ads.internal.client.zzfw) SafeParcelReader.p(parcel, iE, com.google.android.gms.ads.internal.client.zzfw.CREATOR);
                    break;
                case 7:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 8:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 9:
                    iG5 = SafeParcelReader.G(parcel, iE);
                    break;
                case 10:
                    zX4 = SafeParcelReader.x(parcel, iE);
                    break;
                case 11:
                    iG6 = SafeParcelReader.G(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzblt(iG, zX, iG2, zX2, iG3, zzfwVar, zX3, iG4, iG5, zX4, iG6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzblt[i3];
    }
}
